package kodlamaio.hrms.business.concretes;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserCheckService;

import kodlamaio.hrms.dataAccess.abstracts.UserDao;

import kodlamaio.hrms.entities.concretes.User;
@Service
public class UserCheckManager implements UserCheckService{

	
	private UserDao userDao;
	@Autowired
	public UserCheckManager(UserDao userDao) {
		super();
		this.userDao=userDao;
		
	}
	@Override
	public boolean verificationEmail(String emailAddress) { //Daha önce kullanılmış mail kontrolü
		List<User>  candidateEmail = userDao.findByEmailAddress(emailAddress);
		if(candidateEmail.isEmpty()) {
			return true;
		}	
		return false;
		}
	

	@Override
	public boolean confirmationEmail(User user) { //Mail onaylama 
		
		return true;
	}
	

}
