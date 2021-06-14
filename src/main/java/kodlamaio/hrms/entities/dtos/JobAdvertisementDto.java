package kodlamaio.hrms.entities.dtos;

import java.util.Date;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class JobAdvertisementDto {



	private String numberOfPosition;
	private Date creationDate;
	private Date applicationDeadline;
	private String employerCompanyName;
	private String jobTitleTitle;
	
	
	
}
