package business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import business.abstracts.UserCheckService;
import entities.concretes.User;

public class UserCheckManager implements UserCheckService{

	List<String> listOfEmail = new ArrayList<String>();
	@Override
	public boolean checkFirstName(User user) {
		// TODO Auto-generated method stub
		if(user.getEmail().length() < 2) {
			System.out.println("Ýsim alaný en az 2 karakterli olmalý.");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkLastName(User user) {
		// TODO Auto-generated method stub
		if(user.getLastName().length() < 2) {
			System.out.println("Ýsim alaný en az 2 karakterli olmalý.");
			return false;
		}
		return true;
	}

	@Override
	public boolean checkEmail(User user) {
		// TODO Auto-generated method stub
		String regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2})?$";
		Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

		if (user.getEmail().isEmpty()) {
			System.out.println("Email alaný boþ býrakýlamaz.");
			return false;
		} else {
			if (pattern.matcher(user.getEmail()).find() == false) {
				System.out.println("Girilen email adresi formata uygun deðil. Örnek: ornek@ornek.com");
				return false;
			}
		}
		return true;
	}

	@Override
	public boolean checkPassword(User user) {
		// TODO Auto-generated method stub
		if(user.getPassword().length() < 6) {
			System.out.println("Parolanýz en az 6 karakterli olmalý");
			return false;
		}
		return true;
	}

	@Override
	public boolean uniqueEmail(User user) {
		// TODO Auto-generated method stub
		if(listOfEmail.contains(user.getEmail())) {
			System.out.println("Daha önce bu mail adresiyle kayýt olmuþsunuz");
			return false;
		}
		return true;
	}

	@Override
	public boolean isValid(User user) {
		// TODO Auto-generated method stub
		if (checkFirstName(user) && checkLastName(user) && checkEmail(user) && checkPassword(user)
				&& uniqueEmail(user)) {
			return true;
		}
		return false;
	}

}
