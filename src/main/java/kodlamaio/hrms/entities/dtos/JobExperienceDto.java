package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobExperienceDto {

    private int id;
    private int jobTitleId;
    private int resumeId;
    private String companyName;
    private LocalDate startingDate;
	private LocalDate endingDate;
	private LocalDate creatingDate;
	
}
