package reporteTestCase;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ecommerce.CatalogoDeProductos;
import ecommerce.Producto;
import reporte.ReporteTextoPlano;

class ReporteTextoPlanoTest {
	
	ReporteTextoPlano reporte;
	List<CatalogoDeProductos> productos;
	CatalogoDeProductos producto1;
	CatalogoDeProductos producto2;
	
	@BeforeEach
	void setUp() {
		reporte = new ReporteTextoPlano();
		productos = new ArrayList<>();
		producto1 = new Producto(212, "Auriculares", "Sony", "Electrodomesticos", 100f,
				2.5f, 0f, 1);
		producto2 = new Producto(212, "Television", "Sony", "Electrodomesticos", 100000f,
				2.5f, 0f, 0);
		productos.add(producto1);
		productos.add(producto2);
	}
	
	@Test
	void testReporteTextoPlanoGeneraElReporte() {
		assertEquals(reporte.exportar(productos), "Nombre Ventas Precio\n"
												+ "Auriculares 0 100.0\n"
												+ "Television 0 100000.0\n");
	}

}
