package reporte;


import java.util.List;

import ecommerce.CatalogoDeProductos;
import ecommerce.Paquete;
import ecommerce.Producto;

public class ReporteProductosMasVendidos implements ReporteVisitor {
	
	List<CatalogoDeProductos> productosMasVendidos;
	

	@Override
	public void visitarProducto(Producto producto) {
		productosMasVendidos.add(producto);

	}

	@Override
	public void visitarPaquete(Paquete paquete) {
		productosMasVendidos.add(paquete);
		
	}
	
	public List<CatalogoDeProductos> getProductosMasVendidos(){
		return productosMasVendidos;
	}

}
