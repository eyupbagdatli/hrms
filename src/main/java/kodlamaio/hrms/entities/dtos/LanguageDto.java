package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LanguageDto {

	private int id;
	
	private LocalDate creatingDate;
	private String level;
	private String languageName;
	private int resumeId;
}
