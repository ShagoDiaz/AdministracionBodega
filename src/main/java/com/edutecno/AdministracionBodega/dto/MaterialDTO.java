package com.edutecno.AdministracionBodega.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MaterialDTO {

	private Integer precio;
	private String nombre;
	private BodegaDTO bodega;
	private String fecha;

}
