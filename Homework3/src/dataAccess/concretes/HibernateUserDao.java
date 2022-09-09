package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class HibernateUserDao implements UserDao{

	List<User> users = new ArrayList<User>();
	
	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		users.add(user);
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getEmail(String email) {
		// TODO Auto-generated method stub
		for (User user : users) {
			if(user.getEmail() == email) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean getPassword(String password) {
		// TODO Auto-generated method stub
		for (User user : users) {
			if(user.getPassword() == password) {
				return true;
			}
		}
		return false;
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
