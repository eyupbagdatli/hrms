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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="educations")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","graduate"})
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotBlank(message="Boş bırakmayınız")
	@Column(name="school_name")
	private String schoolName;
	
	@Column(name="starting_date")
	private LocalDate startingDate;
    
    @NotBlank(message="Boş bırakmayınız")
	@Column(name="school_department")
    private String  schoolDepartment;
    
	@Column(name="ending_date")
	private LocalDate endingDate;
	
	@Column(name="creating_date")
	private LocalDate creatingDate;
	
	
	@JsonProperty(access = Access.WRITE_ONLY)
	@ManyToOne(targetEntity = Resume.class)
	@JoinColumn(name="resume_id",referencedColumnName = "id")
	private Resume resume;
	

	@ManyToOne(targetEntity = Graduate.class)
	@JoinColumn(name="graduate_id",referencedColumnName = "id")
	private Graduate graduate;
	
	
}
