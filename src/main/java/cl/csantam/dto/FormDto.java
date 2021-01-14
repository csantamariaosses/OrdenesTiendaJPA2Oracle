package cl.csantam.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class FormDto {
	private Integer store;
	private Integer estado;
	private String  fechaDesde;
	private String fechaHasta;
}
