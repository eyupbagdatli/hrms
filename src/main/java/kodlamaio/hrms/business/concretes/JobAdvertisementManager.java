package kodlamaio.hrms.business.concretes;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementService;

import kodlamaio.hrms.core.dtoConverter.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisement;
import kodlamaio.hrms.entities.dtos.JobAdvertisementDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	
	private JobAdvertisementDao jobAdvertisementDao;
	private DtoConverterService DtoConverterService;
	
	
	
	
	
	public JobAdvertisementManager() {
		super();
	}





	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao,DtoConverterService dtoConverterService) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		DtoConverterService = dtoConverterService;
	}

	
		
	
	
	@Override
	public DataResult<List<JobAdvertisement>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisement>>(this.jobAdvertisementDao.findAll());
		
	}

	@Override
	public Result add(JobAdvertisement jobAdvertisement) {

              this.jobAdvertisementDao.save(jobAdvertisement);
              return new SuccessResult("İş ilanı açıldı");
              
	}



	@Override
	public DataResult<List<JobAdvertisementDto>> findByIsActive() {
     
		 return new SuccessDataResult<List<JobAdvertisementDto>>
		 
		 (DtoConverterService.dtoConverter(jobAdvertisementDao.findByIsActive(true), JobAdvertisementDto.class),"Akitf iş ilanları listelendi");
		 
		
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> findByIsActiveOrderByAplicationDeadline() {
	return new SuccessDataResult<List<JobAdvertisementDto>>
	 
	(this.DtoConverterService.dtoConverter
			 
			(this.jobAdvertisementDao.findByIsActiveOrderByAplicationDeadline(true),JobAdvertisementDto.class),"Aktif iş ilanları tarhire göre listelendi");	
	}

	@Override
	public DataResult<List<JobAdvertisementDto>> findByIsActiveAndEmployer_CompanyName(String companyName) {
		
		return new SuccessDataResult<List<JobAdvertisementDto>>
		(this.DtoConverterService.dtoConverter(this.jobAdvertisementDao.findByIsActiveAndEmployer_CompanyName(true, companyName),JobAdvertisementDto.class),"iş verenin ilanları listelendi");
	}

}
