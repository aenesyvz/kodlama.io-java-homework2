package google.abstracts;

import core.abstracts.AdapterService;

public interface GoogleService extends AdapterService{
	void sendVerificationEmail(String email);
	boolean verifyAccount(String email);
}
