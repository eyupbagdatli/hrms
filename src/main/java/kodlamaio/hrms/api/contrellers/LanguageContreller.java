package kodlamaio.hrms.api.contrellers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.LanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.LanguageDto;
@CrossOrigin
@RestController
@RequestMapping("api/languages/")
public class LanguageContreller {

	private LanguageService languageService;
    @Autowired
	public LanguageContreller(LanguageService languageService) {
		super();
		this.languageService = languageService;
	}
    
    @PostMapping("add")
    public 	Result add(@RequestBody LanguageDto languageDto) {
    	return this.languageService.add(languageDto);
    }
    @GetMapping("getall")
    public DataResult<List<LanguageDto>> getAll(){
    	return this.languageService.getAll();
    }
    
	
}
