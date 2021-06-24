package kodlamaio.hrms.api.contrellers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.JobAdvertisementAddDto;
@CrossOrigin
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
	
	@PostMapping("add")
	public Result add(@RequestBody JobAdvertisementAddDto jobAdvertisementAddDto) {
		return this.jobAdvertisementService.add(jobAdvertisementAddDto);
	}  
	@GetMapping("getall")
	public DataResult<List<JobAdvertisementAddDto>> getAll(){
		return this.jobAdvertisementService.getAll();
	}

	@GetMapping("findByIsActive")
	 public DataResult<List<JobAdvertisementAddDto>> findByIsActive(){
		
		return this.jobAdvertisementService.findByIsActive();
		
	}	
	
	@GetMapping("findByIsActiveAndEmployer_CompanyName")
	public DataResult<List<JobAdvertisementAddDto>> findByIsActiveAndEmployer_CompanyName(String companyName){
		
		return this.jobAdvertisementService.findByIsActiveAndEmployer_CompanyName(companyName);
		
	} 
	
	
	
	@GetMapping("findByIsActiveOrderByAplicationDeadLine")
	public DataResult<List<JobAdvertisementAddDto>> findByIsActiveOrderByAplicationDeadline() {
		
		return this.jobAdvertisementService.findByIsActiveOrderByApplicationDeadline();
		}

	
	
	
}
