package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.GraduateService;
import kodlamaio.hrms.core.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.GraduateDao;
import kodlamaio.hrms.entities.concretes.Graduate;
import kodlamaio.hrms.entities.dtos.GraduateDto;
@Service
public class GraduateManager implements GraduateService {

	private GraduateDao graduateDao;
	private DtoConverterService dtoConverterService;
	
	
	
	@Autowired
	public GraduateManager(GraduateDao graduateDao, DtoConverterService dtoConverterService) {
		super();
		this.graduateDao = graduateDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public DataResult<List<GraduateDto>> getAll() {
		
		return new SuccessDataResult<List<GraduateDto>>(dtoConverterService.dtoConverter(graduateDao.findAll(),GraduateDto.class ),"Data listelendi");
		
	}

	@Override
	public Result add(GraduateDto graduateDto) {

         graduateDao.save((Graduate)dtoConverterService.dtoClassConverter(graduateDto, Graduate.class));
         return new SuccessResult("Mezuniyet bilgileri eklendi");
	}

}
