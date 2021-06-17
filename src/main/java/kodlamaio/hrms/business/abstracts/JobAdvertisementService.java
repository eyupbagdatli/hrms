package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.dtos.JobAdvertisementAddDto;


public interface JobAdvertisementService {
	
	DataResult<List<JobAdvertisementAddDto>>  getAll();
	Result add(JobAdvertisementAddDto jobAdvertisementAddDto);
	
	
	
	DataResult<List<JobAdvertisementAddDto>> findByIsActive();
	DataResult<List<JobAdvertisementAddDto>>  findByIsActiveOrderByApplicationDeadline();
	DataResult<List<JobAdvertisementAddDto>> findByIsActiveAndEmployer_CompanyName(String companyName);


}
