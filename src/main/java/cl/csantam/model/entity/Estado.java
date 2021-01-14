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
@Table( name = "estado" ) 
public class Estado {
	
	@Id
	@Column( name = "estado_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	private String  estado_name;

}
