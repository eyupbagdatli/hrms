package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleCheckService;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities.concretes.JobTitle;
@Service
public class JobTitleCheckManager implements JobTitleCheckService {

	private JobTitleDao jobTitleDao;
	@Autowired
	public JobTitleCheckManager(JobTitleDao jobTitleDao) {
		super();
		this.jobTitleDao = jobTitleDao;
	}

	@Override
	public boolean checkJobTitle(String name) {
		List<JobTitle> jobTitleName=jobTitleDao.findAllByTitle(name);
     	if(jobTitleName.isEmpty()) {
		return true;
		}
		return false;
	}

}
