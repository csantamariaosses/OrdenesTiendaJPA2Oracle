package cl.csantam.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
@Table( name = "orders" ) 
public class Order implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@Column( name = "order_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer Id;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler" })
	@ManyToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name="customer_id")
    private Customer customer;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler" })
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn(name="order_status")
    private Estado estado;
	
	@Column(name = "ORDER_DATE")
    Date orderDate;
	
	private String  required_date;
	private String  shipped_date;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler" })
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn(name="store_id")
    private Store store;
	
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler" })
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn(name="staff_id")
    private Staff staff;
	
}
