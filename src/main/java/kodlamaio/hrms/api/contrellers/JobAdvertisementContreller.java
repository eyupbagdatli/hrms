package kodlamaio.hrms.api.contrellers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;

import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@RestController
@RequestMapping("api/jobAdvertisements/")
public class JobAdvertisementContreller {

	private JobAdvertisementService jobAdvertisementService;
	
	public JobAdvertisementContreller() {
		super();
}
	
	@Autowired
	public JobAdvertisementContreller(JobAdvertisementService jobAdvertisementService) {
		super();
		this.jobAdvertisementService = jobAdvertisementService;
	}


	@GetMapping("findByIsActive")
	 public DataResult<List<JobAdvertisementDto>> findByIsActive(){
		
		return this.jobAdvertisementService.findByIsActive();
		
	}	
	
	@GetMapping("findByIsActiveAndEmployer_CompanyName")
	public DataResult<List<JobAdvertisementDto>> findByIsActiveAndEmployer_CompanyName(String companyName){
		
		return this.jobAdvertisementService.findByIsActiveAndEmployer_CompanyName(companyName);
		
	} 
	
	
	
	@GetMapping("findByIsActiveOrderByAplicationDeadLine")
	public DataResult<List<JobAdvertisementDto>> findByIsActiveOrderByAplicationDeadline() {
		
		return this.jobAdvertisementService.findByIsActiveOrderByAplicationDeadline();
		}

	
	
	
}
