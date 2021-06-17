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
import kodlamaio.hrms.entities.dtos.JobAdvertisementAddDto;

@Service
public class JobAdvertisementManager implements JobAdvertisementService {

	
	private JobAdvertisementDao jobAdvertisementDao;
	private DtoConverterService dtoConverterService;
	
	


	@Autowired
	public JobAdvertisementManager(JobAdvertisementDao jobAdvertisementDao,DtoConverterService dtoConverterService) {
		super();
		this.jobAdvertisementDao = jobAdvertisementDao;
		this.dtoConverterService = dtoConverterService;
	}

	
		
	
	
	@Override
	public DataResult<List<JobAdvertisementAddDto>> getAll() {
		
		return new SuccessDataResult<List<JobAdvertisementAddDto>>(dtoConverterService.dtoConverter(jobAdvertisementDao.findAll(), JobAdvertisementAddDto.class)) ;
		
	}

	@Override
	public Result add(JobAdvertisementAddDto jobAdvertisementAddDto) {

              this.jobAdvertisementDao.save((JobAdvertisement) dtoConverterService.dtoClassConverter(jobAdvertisementAddDto, JobAdvertisement.class)); 
              return new SuccessResult("İş ilanı açıldı");
              
	}



	@Override
	public DataResult<List<JobAdvertisementAddDto>> findByIsActive() {
     
		 return new SuccessDataResult<List<JobAdvertisementAddDto>>
		 
		 (dtoConverterService.dtoConverter(jobAdvertisementDao.findByIsActive(true), JobAdvertisementAddDto.class),"Akitf iş ilanları listelendi");
		 
		
	}

	@Override
	public DataResult<List<JobAdvertisementAddDto>> findByIsActiveOrderByApplicationDeadline() {
	return new SuccessDataResult<List<JobAdvertisementAddDto>>
	 
	(this.dtoConverterService.dtoConverter
			 
			(this.jobAdvertisementDao.findByIsActiveOrderByApplicationDeadline(true),JobAdvertisementAddDto.class),"Aktif iş ilanları tarhire göre listelendi.");	
	}

	@Override
	public DataResult<List<JobAdvertisementAddDto>> findByIsActiveAndEmployer_CompanyName(String companyName) {
		
		return new SuccessDataResult<List<JobAdvertisementAddDto>>
		(this.dtoConverterService.dtoConverter(this.jobAdvertisementDao.findByIsActiveAndEmployer_CompanyName(true, companyName),JobAdvertisementAddDto.class),"iş verenin ilanları listelendi");
	}

}
