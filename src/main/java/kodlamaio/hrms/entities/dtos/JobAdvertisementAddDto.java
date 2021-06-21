package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class JobAdvertisementAddDto {

    @JsonIgnore
    private int id;
	private String numberOfPosition;
	private LocalDate creationDate;
	private LocalDate applicationDeadline;
	private int  employerId;
	private int jobTitleId;
	private String jobDescription;
	private String minSalary;
	private String maxSalary;
	private boolean isActive;
	private int cityId;
	
	
	
}
