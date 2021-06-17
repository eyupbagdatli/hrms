package kodlamaio.hrms.api.contrellers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.EducationDto;

@RestController
@RequestMapping("api/educations/")
public class EducationContreller {

	private EducationService educationService;
    @Autowired
	public EducationContreller(EducationService educationService) {
		super();
		this.educationService = educationService;
	}
    
    @PostMapping("add")
	Result add(@RequestBody EducationDto EducationDto) {
    	return this.educationService.add(EducationDto);
    	
    }
	
    @GetMapping("getall")
    public DataResult<List<EducationDto>> getAll(){
    	return this.educationService.getAll();
    	
    }
    
    @GetMapping("findAllByResumeIdOrderByEndingDateDesc")
	public DataResult<List<EducationDto>> findAllByResumeIdOrderByEndingDateDesc(int id){
    	
    	return this.educationService.findAllByResumeIdOrderByEndingDateDesc(id);
    	}
}
