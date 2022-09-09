package business.concretes;

import business.abstracts.MailVerificationService;
import business.abstracts.UserCheckService;
import business.abstracts.UserService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService{

	private UserCheckService userCheckService;
	private MailVerificationService mailVerificationService;
	private UserDao userDao;
	
	public UserManager(UserCheckService userCheckService, MailVerificationService mailVerificationService,
			UserDao userDao) {
		super();
		this.userCheckService = userCheckService;
		this.mailVerificationService = mailVerificationService;
		this.userDao = userDao;
	}

	@Override
	public void signUp(User user) {
		// TODO Auto-generated method stub
		if(userCheckService.isValid(user)) {
				if(mailVerificationService.isVerificated(user.getEmail())) {
					System.out.println("Bu email adresinizle kay�tl� oldu�unuz hesap zaten var!");
					return;
				}
			System.out.println(user.getFirstName() + " adl� ki�i sisteme eklendi!");
			mailVerificationService.sendMail(user.getEmail());
			userDao.add(user);
		}else {
			System.out.println("Girmi� oldu�unuz bilgileri kontrol ediniz!");
		}
		
	}

	@Override
	public void signIn(User user) {
		// TODO Auto-generated method stub
		mailVerificationService.verifyMail(user.getEmail());
		
		if(userDao.getEmail(user.getEmail()) && userDao.getPassword(user.getPassword()) && 
				mailVerificationService.isVerificated(user.getEmail())) {
			System.out.println("Giri� ba�ar�l�");
		}else {
			System.out.println("Giri� ba�ar�s�z");
		}
	}

}
