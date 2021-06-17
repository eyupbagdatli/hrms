package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleCheckService;
import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;
@Service
public class JobTitleManager implements JobTitleService {
    
	private JobTitleDao jobTitleDao;
	private JobTitleCheckService jobTitleCheckService;
	@Autowired
	public JobTitleManager(JobTitleCheckService jobTitleCheckService,JobTitleDao jobTitleDao) {
		super();
		this.jobTitleCheckService = jobTitleCheckService;
	    this.jobTitleDao=jobTitleDao;
	   
	}

	@Override
	public DataResult<List<JobTitle>> getAll() {
		return new SuccessDataResult<List<JobTitle>>("Data Listelendi(JobTitle)");
		
	}

	@Override
	public Result add(JobTitle jobTitle) {
		
		if(!jobTitleCheckService.checkJobTitle(jobTitle.getTitle())) {
			return new ErrorResult("bu isim daha önce kullanılmıştır");
		}else {
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult("İşlem başarılı");
		}
	}
	
}
