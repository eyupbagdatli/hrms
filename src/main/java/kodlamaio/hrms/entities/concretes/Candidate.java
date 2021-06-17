package kodlamaio.hrms.entities.concretes;

import java.time.LocalDate;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="candidates")
@PrimaryKeyJoinColumn(name="id",referencedColumnName = "id")
public class Candidate extends User {
	

	
	@NotBlank(message="İsim alanını boş bırakmayınız")
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank(message="Soyad alanını boş bırakmayınız")
	@Column(name="last_name")
	private String lastName;
	
	@NotBlank(message="Kimlik numarası alanını boş bırakmayınız")
	@Size(min=11 ,max=11,message="Kimlik numarası 11 haneli olmalıdır")
	@Column(name="identity_number")
	private String nationalityId;
	
	@NotBlank(message="Doğum tarihi alanını boş bırakmayınız")
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;
	


}
