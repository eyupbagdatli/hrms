package kodlamaio.hrms.business.concretes;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerCheckService;
import kodlamaio.hrms.entities.concretes.Employer;
@Service
public class EmployerCheckManager implements EmployerCheckService{

	@Override
	public boolean checkForDomain(Employer employer) {
		String[] employerWebsite = employer.getWebAddress().split("www.",2);
		String website = employerWebsite[1];
		
		String[] employerEmail = employer.getEmailAddress().split("@");
		String employerDomain = employerEmail[1];
		
		if (employerDomain.equals(website)) {
			return true;
		}
		return false;
	}


}
