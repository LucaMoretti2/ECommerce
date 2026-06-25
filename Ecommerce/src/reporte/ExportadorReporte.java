package reporte;

import java.util.List;

import ecommerce.CatalogoDeProductos;

public interface ExportadorReporte {
	
	String exportar(List<CatalogoDeProductos> productos);

}
