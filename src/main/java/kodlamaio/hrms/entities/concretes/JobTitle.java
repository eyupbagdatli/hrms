package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_titles")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdvertisement","jobExperiences"})
public class JobTitle {
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	@NotBlank(message="Boş bırakmayınız")
	private String title;
	
	@JsonIgnore
	@OneToMany(mappedBy="jobTitle")
	private List<JobAdvertisement> jobAdvertisement;
	

	

	

}
