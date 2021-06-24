package kodlamaio.hrms.api.contrellers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.TechnologyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.TechnologyDto;
@CrossOrigin
@RestController
@RequestMapping("api/technologies/")
public class TechnologyContreller {

	private TechnologyService technologyService;

	public TechnologyContreller(TechnologyService technologyService) {
		super();
		this.technologyService = technologyService;
	}
	
	@PostMapping("add")
	public Result add(@RequestBody TechnologyDto technologyDto) {
		return this.technologyService.add(technologyDto);
	}
	@GetMapping("getall")
	public 	DataResult<List<TechnologyDto>> getAll(){
		return this.technologyService.getAll();
	}
	
}
