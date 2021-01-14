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
@Table( name = "stores" ) 
public class Store {
	@Id
	@Column( name = "store_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	private String  store_name;
	private String  phone;
	private String  email;
	private String  street;
	private String  city;
	private String  state;
	private String  zip_code;
	
}
