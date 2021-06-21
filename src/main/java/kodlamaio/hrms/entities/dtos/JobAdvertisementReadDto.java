package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertisementReadDto {
    @JsonIgnore
	private int id;
	@JsonIgnore
	private int jobTitleId;
	private String jobTitleTitle; 
	 @JsonIgnore
	private int cityId;
	private String cityName;
	 @JsonIgnore
	private int employerId;
	private String employerCompanyName;
	private String employerWebAddress;
	private String employerPhoneNumber;
	private String employerEmail;
	
	private LocalDate applicationDeadline;
	private boolean isActive;
	private String jobDescription;
	private String minSalary;
	private String maxSalary;
	private String numberOfPosition;
}
