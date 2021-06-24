package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CandidateCheckService;
import kodlamaio.hrms.business.abstracts.CandidateService;
import kodlamaio.hrms.business.abstracts.UserCheckService;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CandidateDao;
import kodlamaio.hrms.entities.concretes.Candidate;
@Service
public class CandidateManager implements CandidateService {

	private UserCheckService userCheckService;
	private CandidateCheckService candidateCheckService;
	private CandidateDao candidateDao;

	
	@Autowired
	public CandidateManager(UserCheckService userCheckService,CandidateCheckService candidateCheckService, CandidateDao candidateDao) {
		super();
		this.userCheckService=userCheckService;
		this.candidateCheckService=candidateCheckService;
		this.candidateDao=candidateDao;
	   
	}


	@Override
	public DataResult<List<Candidate>> getAll() {
		return new SuccessDataResult<List<Candidate>>(this.candidateDao.findAll(),"Data Listelendi(Candidate)");
	}
	
	
	@Override
	public Result add(Candidate candidate) {
		
		if (!userCheckService.verificationEmail(candidate.getEmailAddress())) {
			    return new ErrorResult("Email adresiniz daha önce kullanılmış");
		}
		else if(!candidateCheckService.verificationNationalityId(candidate.getNationalityId())) {
			   return new ErrorResult("Bu kimlik numarası daha önce kullanılmış");
		}
		else if(!userCheckService.confirmationEmail(candidate)) {
			   return new ErrorResult("Email onayı sağlanamadı");
		}
		else {	  
		    this.candidateDao.save(candidate);
			   return new SuccessResult("iş arayan eklendi");
		}
	  }
	}
