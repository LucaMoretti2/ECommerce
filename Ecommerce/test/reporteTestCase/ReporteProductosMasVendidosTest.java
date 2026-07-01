package reporteTestCase;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ecommerce.CatalogoDeProductos;
import ecommerce.Paquete;
import ecommerce.Producto;
import reporte.ReporteProductosMasVendidos;
import reporte.ReporteTextoPlano;

class ReporteProductosMasVendidosTest {

	List<CatalogoDeProductos> productos;
	Producto producto;
	Paquete paquete;
	ReporteProductosMasVendidos reporte;
	ReporteTextoPlano reporteTextoPlano;
	
	@BeforeEach
	void setUp() {
		productos = new ArrayList<>();
		producto = new Producto(212, "Auriculares", "Sony", "Electrodomesticos", 100f,
								2.5f, 0f, 0); 
		paquete = new Paquete("Auriculares x2", "Trae dos auriculares man", "Tecnologia", 0.0f);
		paquete.agregarProducto(producto);
		paquete.agregarProducto(producto);
		reporte = new ReporteProductosMasVendidos();
		reporteTextoPlano = new ReporteTextoPlano();
	}
	
	@Test
	void testReporteAlVisitarProducto1AumentaSuListaDeProductosMasVendidos() {
		reporte.visitarProducto(producto);
		assertEquals(reporte.getProductosMasVendidos().size(), 1);
	}
	
	@Test
	void testReporteAlVisitarPaqueteAumentaSuListaDeProductosMasVendidos() {
		reporte.visitarPaquete(paquete);
		assertEquals(reporte.getProductosMasVendidos().size(), 1);
	}
	
	@Test
	void testReporteExportaAUnExportadorSusProductosMasVendidos() {
		reporte.visitarProducto(producto);
		assertEquals(reporte.exportar(reporteTextoPlano),"Nombre Ventas Precio\n"
														+ "Auriculares 0 100.0\n" );
	}
	
	@Test
	void testReporteOrdenaALosProductos() {
		producto.incrementarCantidadVendida();
		reporte.visitarProducto(producto);
		reporte.visitarPaquete(paquete);
		assertEquals(reporte.exportar(reporteTextoPlano),"Nombre Ventas Precio\n"
														+ "Auriculares 1 100.0\n"
														+ "Auriculares x2 0 200.0\n");
	}
}
