import business.concretes.MailVerificationManager;
import business.concretes.UserCheckManager;
import business.concretes.UserManager;
import dataAccess.concretes.HibernateUserDao;
import entities.concretes.User;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user1 = new User(1,"Alper Enes","Yavuz","alper@gmail.com","123456");
		User user2 = new User(2,"Resul","Durlu","resul","568493");
		User user3 = new User(3,"Burak","Eskisemerci","burak@gmail.com","2334");
		
		UserManager userManager = new UserManager(new UserCheckManager(), new MailVerificationManager(), new HibernateUserDao());
		userManager.signUp(user1);
		System.out.println("*********************************");
		userManager.signIn(user2);
		System.out.println("*********************************");
		userManager.signIn(user1);
		System.out.println("*********************************");
		userManager.signUp(user2);
		System.out.println("*********************************");
		userManager.signUp(user3);
		System.out.println("*********************************");
		userManager.signUp(user1);
	}

}
