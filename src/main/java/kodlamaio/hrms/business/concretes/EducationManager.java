package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationService;
import kodlamaio.hrms.core.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationDao;
import kodlamaio.hrms.entities.concretes.Education;
import kodlamaio.hrms.entities.dtos.EducationDto;
@Service
public class EducationManager implements EducationService{

	private EducationDao educationDao;
	private DtoConverterService dtoConverterService;
	
	
	@Autowired
	public EducationManager(EducationDao educationDao, DtoConverterService dtoConverterService) {
		super();
		this.educationDao = educationDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(EducationDto EducationDto) {
		
		educationDao.save((Education) dtoConverterService.dtoClassConverter(EducationDto, Education.class));
		return new SuccessResult("Eğitim bilgileri eklendi");
		
	}

	@Override
	public DataResult<List<EducationDto>> getAll() {
    return new SuccessDataResult<List<EducationDto>>(dtoConverterService.dtoConverter(educationDao.findAll(),EducationDto.class));
	}

	@Override
	public DataResult<List<EducationDto>> findAllByResumeIdOrderByEndingDateDesc(int id) {
		return new SuccessDataResult<List<EducationDto>>(dtoConverterService.dtoConverter(educationDao.findAllByResumeIdOrderByEndingDateDesc(id), EducationDto.class));
		
	}

}
