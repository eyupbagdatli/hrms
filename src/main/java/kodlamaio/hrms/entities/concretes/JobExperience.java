package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_experiences")
public class JobExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="company_name")
	@NotBlank(message="Şirket ismi boş bırakılamaz")
	private String companyName;
	
	
	@Column(name="starting_date")
    private LocalDate startingDate;
	
	@Column(name="ending_date")
	private LocalDate endingDate;

    @Column(name="creating_date")
    private LocalDate creatingDate;
    
    @JsonProperty(access=Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name="resume_id")
    private Resume resume;
    
    @ManyToOne
    @JoinColumn(name="job_title_id",referencedColumnName = "id")
    private JobTitle jobTitle;
    
    
    

}
