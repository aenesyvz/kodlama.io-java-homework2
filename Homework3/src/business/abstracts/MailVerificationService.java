package business.abstracts;

public interface MailVerificationService {
	void sendMail(String mail);
	void verifyMail(String email);
	boolean isVerificated(String email);
}
