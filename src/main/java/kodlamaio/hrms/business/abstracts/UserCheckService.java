package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concretes.User;

public interface UserCheckService {
	
	boolean verificationEmail(String emailAddress);
	boolean confirmationEmail(User user);
}
