package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerCheckService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.UserCheckService;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities.concretes.Employer;
@Service
public class EmployerManager implements EmployerService {
	
	private EmployerDao employerDao;
	private UserCheckService userCheckService;
	private EmployerCheckService employerCheckService;
	
   @Autowired
	public EmployerManager(EmployerDao employerDao,UserCheckService userCheckService,EmployerCheckService employerCheckService) {
		super();
		this.employerDao = employerDao;
		this.employerCheckService=employerCheckService;
		this.userCheckService=userCheckService;
		
	}

	@Override
	public DataResult<List<Employer>> getAll() {
		
		return new SuccessDataResult<List<Employer>> (this.employerDao.findAll(),"Data listelendi(Employer) ") ;
	}

	@Override
	public Result add(Employer employer) {
       
		if(employer.getCompanyName().isEmpty()||
				employer.getEmailAddress().isEmpty()||
				employer.getPassword().isEmpty()||
				employer.getPhoneNumber().isEmpty()||
				employer.getWebAddress().isEmpty()) {
			return new ErrorResult("Tüm alanları doldurunuz");
        }
		else if(userCheckService.verificationEmail(employer.getEmailAddress())) {
			return new ErrorResult("Bu e mail adresi daha önce kullanılmıştır.");
		}
		
		else if(employerCheckService.checkForDomain(employer)) {
			return new ErrorResult("E mail adresiniz domain ile uyuşmamaktadır");
		}
		else if(userCheckService.confirmationEmail(employer)) {
			return new ErrorResult("E mail onayını sağlayınız");
		}
		else{
		     this.employerDao.save(employer);
			return new SuccessResult("İşlem başarılı");
		}
		
		
}
}