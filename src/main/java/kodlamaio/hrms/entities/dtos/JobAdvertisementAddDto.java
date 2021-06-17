package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;





import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class JobAdvertisementAddDto {



	private String numberOfPosition;
	private LocalDate creationDate;
	private LocalDate applicationDeadline;
	private String employerCompanyName;
	private String jobTitleTitle;
	
	
	
}
