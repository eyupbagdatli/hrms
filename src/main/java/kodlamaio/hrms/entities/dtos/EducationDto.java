package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto {

	
    private int id;
	private int resumeId;
	private int graduateId;
	
	private String schoolName;
    private LocalDate startingDate;
    private String  schoolDepartment;
    private LocalDate endingDate;
	private LocalDate creatingDate;
	

	
}
