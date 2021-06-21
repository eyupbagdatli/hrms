package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeAddDto {



	
	private int id;
	
	private int candidateId;
	
	private String githubLink;
	
	private String linkedinLink;
	
	private String description;
	
	private LocalDate creatingDate;
	
	private String photo;
	
	
	
}
