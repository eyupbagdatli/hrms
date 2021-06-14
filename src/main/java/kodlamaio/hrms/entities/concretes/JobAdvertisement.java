package kodlamaio.hrms.entities.concretes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="job_adverts")
public class JobAdvertisement {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="min_salary")
	private String minSalary;
	
	@Column(name="max_salary")
	private String maxSalary;
	
	@Column(name="job_decription")
	private String description;
	
	@Column(name="number__of_position")
	private String numberOfPosition;
	
	@Column(name="creation_date")
	private Date creationDate;
	
	@Column(name="application_deadline")
	private Date applicationDeadline;
	
	@Column(name="is_active")
	private boolean isActive;

	@ManyToOne
	@JoinColumn(name="employer_id",referencedColumnName = "id")
	private Employer employer;
	
	@ManyToOne
	@JoinColumn(name="jobt_title_id",referencedColumnName="id")
	private JobTitle jobTitle;
	
	@ManyToOne
	@JoinColumn(name="city_id",referencedColumnName="id")
	private City city;
	
	
	
	
	

}
