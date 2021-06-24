package kodlamaio.hrms.api.contrellers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobTitle;
@CrossOrigin
@RestController
@RequestMapping("api/jobs/")
public class JobTitleContreller {

	private JobTitleService jobTitleService;

	public JobTitleContreller(JobTitleService jobTitleService) {
		super();
		this.jobTitleService = jobTitleService;
	}
	
	@GetMapping("getall")
	public DataResult<List<JobTitle>> getAll(){
		
		return this.jobTitleService.getAll();
		
	}
	 @PostMapping("add")
	public Result add(@RequestBody JobTitle jobTitle) {
		 return this.jobTitleService.add(jobTitle);
		 
		 
	 }

	
	
}
