package reporte;

import java.util.List;

import ecommerce.CatalogoDeProductos;

public class ReporteTextoPlano implements ExportadorReporte {

	public String exportar(List<CatalogoDeProductos> productos) {
		String resultado = "Nombre Ventas Precio";
		for(CatalogoDeProductos p: productos) {
			resultado += p.getNombre() + p.getCantidadVendida() + p.getPrecioFinal();
		}
		return resultado;
	}
}
