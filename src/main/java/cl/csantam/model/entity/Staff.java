package cl.csantam.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
@Table( name = "staffs" ) 
public class Staff {
	@Id
	@Column( name = "staff_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	private String  first_name;
	private String  last_name;
	private String  email;
	private String  phone;
	private Integer active;
	private Integer store_id;
	private Integer manager_id;
}
