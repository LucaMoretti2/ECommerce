package ecommerceTestCase;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import ecommerce.*;
import reporte.*;


public class ProductoTestCase {

	Producto producto;
	
	
	@BeforeEach
	void setUp(){
		producto = new Producto(212, "Auriculares", "Sony", "Electrodomesticos", 100f,
			2.5f, 10f, 0); // 100 precio, 2.5 peso, 10f descuento 
	}
	
	@Test
	void testGetSKU() {
		assertEquals(producto.getSKU(), 212);
	}
	
	@Test
	void testGetNombre() {
		assertEquals(producto.getNombre(), "Auriculares");
	}
	
	@Test
	void testGetMarca() {
		assertEquals(producto.getMarca(), "Sony");
	}
	
	@Test
	void testGetPrecio() {
		assertEquals(producto.getPrecio(), 100f);
	}
	
	@Test
	void testSetPrecio() {
		
		producto.setPrecio(25f);
		assertEquals(producto.getPrecio(), 25f);
	}
	
	@Test
	void testGetPeso() {
		
		assertEquals(producto.getPeso(), 2.5f);
	}
	
	@Test
	void testGetDescuento() {
		
		assertEquals(producto.getDescuento(), 10f);
	}
	
	@Test
	void testSetDescuento() {
		
		producto.setDescuento(30f);
		assertEquals(producto.getDescuento(), 30f);
	}
	
	@Test
	void testGetStock() {
		
		assertEquals(producto.getStock(), 0);
	}
	
	@Test
	void testGetPrecioFinal() {
		assertEquals(producto.getPrecioFinal(),90f);
	}
	
	@Test
	void testValidarProductoCuandoTieneLosAtributosObligatoriosYNoHayDinamicos() {
		assertTrue(producto.validar(null));
	}
	
	@Test
	void testValidarProductoCuandoNoTieneLosAtributosObligatorios() {
		Producto productoInvalido = new Producto(212, "", "Sony", "Electrodomesticos", 60.5f,
				2.5f, 10f, 1);
		
		assertTrue(productoInvalido.validar(null));
	}
	
	
	@Test
	void testValidarProductoConAtributosDinamico() {
		String[] requeridos = {"Alto", "Ancho"};
		
		producto.agregarAtributoDinamico("Alto", "20cm");
	    producto.agregarAtributoDinamico("Ancho", "15cm");
	    
	    assertTrue(producto.validar(requeridos));
	}
	
	@Test
	void testIncrementarStockAumentaEnUnoElStock() {
		
		int stockAntesDeIncrementar = producto.getStock();
		
		producto.incrementarStock();
		assertEquals(producto.getStock(),stockAntesDeIncrementar + 1);
	}
	
	@Test
	void testDecrementarStockDisminuyeEnUnoElStock(){
		
		int stockAntesDeDecrementar = producto.getStock();
		
		producto.decrementarStock();
		assertEquals(producto.getStock(),stockAntesDeDecrementar - 1);
	}	
	
	@Test
	void testAgregarAtributoDinamico(){
		
		producto.agregarAtributoDinamico("Alto", 20.10);
		assertEquals(20.10,producto.getAtributoDinamico("Alto"));
		
	}	
	
	@Test
	void testTieneStockDisponible() {
		
		producto.incrementarStock();
		assertTrue(producto.tieneStockDisponible());
		
	}
	
	@Test
	void testNoTieneStockDisponible() {
		
		assertFalse(producto.tieneStockDisponible());
		
	}
	
	@Test 
	void aceptarVisitor() {
		
		ReporteVisitor visitorMock = mock(ReporteVisitor.class);
		producto.aceptar(visitorMock);
		verify(visitorMock, times(1)).visitarProducto(producto);
	}
}
