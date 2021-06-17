package kodlamaio.hrms.api.contrellers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.JobExperienceDto;

@RestController
@RequestMapping("api/jobExperience/")
public class JobExperienceContreller {
	
	private JobExperienceService jobExperienceService;

	@Autowired
	public JobExperienceContreller(JobExperienceService jobExperienceService) {
		super();
		this.jobExperienceService = jobExperienceService;
	}
	
	@PostMapping("add")
	public Result add(@RequestBody JobExperienceDto jobExperienceDto) {
		
		return this.jobExperienceService.add(jobExperienceDto);
	}
	@GetMapping("getall")
	public DataResult<List<JobExperienceDto>> getAll(){
		return this.jobExperienceService.getAll();
	}
	@GetMapping("findAllByResumeIdOrderByEndingDateDesc")
	public DataResult<List<JobExperienceDto>> findAllByResumeIdOrderByEndingDateDesc(int id){
		
		return this.jobExperienceService.findAllByResumeIdOrderByEndingDateDesc(id);
	}

}
