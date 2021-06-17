package kodlamaio.hrms.business.abstracts;

import java.util.List;



import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.ResumeAddDto;
import kodlamaio.hrms.entities.dtos.ResumeReadDto;

public interface ResumeService {
	
	Result add(ResumeAddDto resumeAddDto);
	
    DataResult<List<ResumeReadDto>> getAll();
    DataResult<List<ResumeReadDto>> findAllByCandidateId(int id);
   
    

}
