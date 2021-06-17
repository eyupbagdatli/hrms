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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="educations")
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="school_name")
	@NotBlank(message="Boş bırakmayınız")
	private String schoolName;
	
	@Column(name="starting_date")
	private LocalDate startingDate;
    
	@Column(name="school_deparment")
    @NotBlank(message="Boş bırakmayınız")
	private String  schoolDepartment;
    
	@Column(name="enging_date")
	private LocalDate endingDate;
	
	@Column(name="creating_date")
	private LocalDate creatingDate;
	
	
	@ManyToOne
	@JoinColumn(name="resume_id",referencedColumnName = "id")
	private Resume resume;
	
	@ManyToOne
	@JoinColumn(name="graduate_id",referencedColumnName = "id")
	private Graduate graduate;
	
	
}
