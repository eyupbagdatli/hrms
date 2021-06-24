package kodlamaio.hrms.api.contrellers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.ResumeAddDto;
import kodlamaio.hrms.entities.dtos.ResumeReadDto;
@CrossOrigin
@RestController
@RequestMapping("api/resumes/")
public class ResumeContreller {

	private ResumeService resumeService;
	@Autowired
	public ResumeContreller(ResumeService resumeService) {
		super();
		this.resumeService = resumeService;
	}
	
	@PostMapping("add")
	public Result add(@RequestBody ResumeAddDto resumeAddDto) {
		return this.resumeService.add(resumeAddDto);
	}
	@GetMapping("getall")
	public  DataResult<List<ResumeReadDto>> getAll(){
		return this.resumeService.getAll();
		
	}
 	@GetMapping("findAllByCandidateId")
    public DataResult<List<ResumeReadDto>> findAllByCandidateId(int id){
 		
 		return this.resumeService.findAllByCandidateId(id);
 	}
 
} 
