package google.concretes;

import google.abstracts.GoogleService;

public class GoogleManager implements GoogleService{

	@Override
	public void sendVerificationEmail(String email) {
		// TODO Auto-generated method stub
		System.out.println(email + "e-posta adresinize doğrulama maili gönderilmiştir.");
	}

	@Override
	public boolean verifyAccount(String email) {
		// TODO Auto-generated method stub
		System.out.println(email + "adresiniz doğrulandı.");
		return true;
	}

}
