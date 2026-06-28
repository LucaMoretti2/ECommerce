package ecommerceTestCase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import ecommerce.*;
import reporte.ReporteVisitor;

public class PaqueteTestCase {

	Paquete paquete;
	Producto producto;
	CatalogoDeProductos componente1;
	CatalogoDeProductos componente2;
	
	
	@BeforeEach
	void setUp() {
		paquete = new Paquete("Combo electrodomesticos", "Estufas, microondas, ventiladores", "Electronica");
		componente1 = mock(CatalogoDeProductos.class);
		componente2 = mock(CatalogoDeProductos.class);
	}
	
	@Test
	void testAgregarProducto() {
		
		paquete.agregarProducto(componente1);
		assertEquals(1, paquete.getProductos().size());
	}
	
	@Test
	void testQuitarProducto() {
		
		paquete.agregarProducto(componente1);
		paquete.quitarProducto(componente1);
		assertEquals(0, paquete.getProductos().size());
	}
	
	@Test
	void testGetPrecioFinal() {
		
		when(componente1.getPrecio()).thenReturn(800.0f);
	    when(componente2.getPrecio()).thenReturn(800.0f);
		
		paquete.agregarProducto(componente1);
		paquete.agregarProducto(componente2);
		
		assertEquals(1600f, paquete.getPrecioFinal());
		
	}
	
	@Test
	void testIncrementarStock() {
		
		paquete.agregarProducto(componente1);
	    paquete.agregarProducto(componente2);
	   
	    paquete.incrementarStock();

	    verify(componente1, times(1)).incrementarStock();
	    verify(componente2, times(1)).incrementarStock();
	}
	
	
	@Test
	void testDecrementarStockDisminuyeEnUnoElStock(){
		
		paquete.agregarProducto(componente1);
	    paquete.agregarProducto(componente2);
	   
	    paquete.decrementarStock();

	    verify(componente1, times(1)).decrementarStock();
	    verify(componente2, times(1)).decrementarStock();
	}
	
	@Test
	void testGetPeso() {
		
		when(componente1.getPeso()).thenReturn(550f);
	    when(componente2.getPeso()).thenReturn(400f);
		
		paquete.agregarProducto(componente1);
		paquete.agregarProducto(componente2);
		
		assertEquals(950f, paquete.getPeso());
	}
	
	@Test
	void testTieneStockDisponible() {
		
		when(componente1.tieneStockDisponible()).thenReturn(true);
	    when(componente2.tieneStockDisponible()).thenReturn(true);
		
		paquete.agregarProducto(componente1);
		paquete.agregarProducto(componente2);
		
		assertEquals(true, paquete.tieneStockDisponible());
	
	}
	
	@Test
	void testNoTieneStockDisponible() {
		
		when(componente1.tieneStockDisponible()).thenReturn(false);
	    when(componente2.tieneStockDisponible()).thenReturn(false);
		
		paquete.agregarProducto(componente1);
		paquete.agregarProducto(componente2);
		
		assertEquals(false, paquete.tieneStockDisponible());
	
	}
	
	@Test
	void testGetStock() {
		
		when(componente1.getStock()).thenReturn(4);
	    when(componente2.getStock()).thenReturn(5);
		
		paquete.agregarProducto(componente1);
		paquete.agregarProducto(componente2);
		
		assertEquals(9, paquete.getStock());
	
	}
	
	@Test 
	void aceptarVisitor() {
		
		ReporteVisitor visitorMock = mock(ReporteVisitor.class);
		paquete.aceptar(visitorMock);
		verify(visitorMock, times(1)).visitarPaquete(paquete);
	}
	
	@Test
	void testGetProductos() {
		
		paquete.agregarProducto(componente1);
		paquete.agregarProducto(componente2);
		
		List<CatalogoDeProductos> listaEsperada = new ArrayList<>();
		listaEsperada.add(componente1);
		listaEsperada.add(componente2);

	    
	    assertIterableEquals(listaEsperada, paquete.getProductos());
	
	}
	
	
}
