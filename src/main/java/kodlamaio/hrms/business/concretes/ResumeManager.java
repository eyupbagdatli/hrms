package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import kodlamaio.hrms.business.abstracts.ResumeService;
import kodlamaio.hrms.core.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ResumeDao;
import kodlamaio.hrms.entities.concretes.Resume;
import kodlamaio.hrms.entities.dtos.ResumeAddDto;
import kodlamaio.hrms.entities.dtos.ResumeReadDto;
@Service
public class ResumeManager implements ResumeService{

	
	private ResumeDao resumeDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public ResumeManager(ResumeDao resumeDao, DtoConverterService dtoConverterService) {
		super();
		this.resumeDao = resumeDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(ResumeAddDto resumeAddDto) {
		
		resumeDao.save((Resume)dtoConverterService.dtoClassConverter(resumeAddDto, Resume.class));
		return new SuccessResult("CV Eklendi");
	}

	@Override
	public DataResult<List<ResumeReadDto>> getAll() {
		   
		return new SuccessDataResult<List<ResumeReadDto>>(dtoConverterService.dtoConverter(resumeDao.findAll(), ResumeReadDto.class),"CV listelendi");
	}

	@Override
	public DataResult<List<ResumeReadDto>> findAllByCandidateId(int id) {
		  
		return new SuccessDataResult<List<ResumeReadDto>>(dtoConverterService.dtoConverter(resumeDao.findAllByCandidateId(id),ResumeReadDto.class));
		
	}

	

}
