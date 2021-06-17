package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDto {

   
	
	private String firstName;
	private String lastName;
	private String nationalityId;
	private LocalDate dateOfBirth;
}
