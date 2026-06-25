package reporte;

import ecommerce.Paquete;
import ecommerce.Producto;

public interface ReporteVisitor {

	void visitarProducto(Producto producto);
	void visitarPaquete(Paquete paquete);
}
