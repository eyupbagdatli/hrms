package kodlamaio.hrms.core.adapter;

import kodlamaio.hrms.entities.concretes.Candidate;

public interface MernisService {
	
	boolean checkIfRealPerson(Candidate candidate);

}
