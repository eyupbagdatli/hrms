package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TechnologyDto {
	
    private int id;
	private int resumeId;
	private LocalDate creatingDate;
	private String description;

}
