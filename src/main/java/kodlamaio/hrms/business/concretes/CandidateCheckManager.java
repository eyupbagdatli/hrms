package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCheckService;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
@Service
public class CandidateCheckManager implements CandidateCheckService {

	private CandidateDao candidateDao;
	@Autowired
	public CandidateCheckManager(CandidateDao candidateDao) {
		super();
		this.candidateDao = candidateDao;
	}

	@Override
	public boolean verificationNationalityId(String nationalityId) {
		List<Candidate> candidateNationalityId=candidateDao.findByNationalityId(nationalityId);
		if(candidateNationalityId.isEmpty()) {
			return true;
			
		}
		return false;
	}

}
