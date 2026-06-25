package reporte;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ecommerce.CatalogoDeProductos;
import ecommerce.Paquete;
import ecommerce.Producto;

public class ReporteProductosMasVendidos implements ReporteVisitor {
	
	List<CatalogoDeProductos> productosMasVendidos = new ArrayList<>();
	

	@Override
	public void visitarProducto(Producto producto) {
		productosMasVendidos.add(producto);

	}

	@Override
	public void visitarPaquete(Paquete paquete) {
		productosMasVendidos.add(paquete);
		
	}
	
	public List<CatalogoDeProductos> getProductosMasVendidos(){
		List<CatalogoDeProductos> ordenados = new ArrayList<>(productosMasVendidos);
	    Collections.sort(ordenados, (a, b) -> b.getCantidadVendida() - a.getCantidadVendida());
	    return ordenados;
	}

	public String exportar(ExportadorReporte exportador) {
        return exportador.exportar(getProductosMasVendidos());
    }
	
}
