package business.concretes;

import java.util.ArrayList;
import java.util.List;

import business.abstracts.MailVerificationService;

public class MailVerificationManager implements MailVerificationService{
	List<String> verificatedMails = new ArrayList<String>();

	@Override
	public void sendMail(String mail) {
		// TODO Auto-generated method stub
		System.out.println(mail + "adresinize do�rulama mail yolland�");
	}

	@Override
	public void verifyMail(String email) {
		// TODO Auto-generated method stub
		verificatedMails.add(email);
	}

	@Override
	public boolean isVerificated(String email) {
		// TODO Auto-generated method stub
		if(verificatedMails.contains(email)) {
			return true;
		}
		return false;
	}
	
}
