package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.entities.concretes.Employer;

public interface EmployerCheckService  {
	
	boolean checkForDomain(Employer employer);
	

}
