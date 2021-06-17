package kodlamaio.hrms.api.contrellers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.GraduateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.GraduateDto;

@RestController
@RequestMapping("api/graduates/")
public class GraduateContreller {
	
	private GraduateService graduateService;
     @Autowired
	public GraduateContreller(GraduateService graduateService) {
		super();
		this.graduateService = graduateService;
	}
     
     @PostMapping("add")
    public  Result add(@RequestBody GraduateDto graduateDto) {
    	 
    	 return this.graduateService.add(graduateDto);
    	 
     }
     
     @GetMapping("getall")
     public DataResult<List<GraduateDto>> getAll(){
    	 return this.graduateService.getAll();
     }
	

}
