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

	Paquete paquete1;
	Paquete paquete2;
	Producto producto;
	CatalogoDeProductos componente1;
	CatalogoDeProductos componente2;
	
	
	@BeforeEach
	void setUp() {
		paquete1 = new Paquete("Combo electrodomesticos", "Estufas, microondas, ventiladores", "Electronica", 10.0f);
		paquete2 = new Paquete("Combo electronica", "Auriculares, Celular, Cargador", "Electronica", 0.0f);
		componente1 = mock(CatalogoDeProductos.class);
		componente2 = mock(CatalogoDeProductos.class);
	}
	
	@Test
	void testAgregarProducto() {
		
		paquete1.agregarProducto(componente1);
		assertEquals(1, paquete1.getProductos().size());
	}
	
	@Test
	void testQuitarProducto() {
		
		paquete1.agregarProducto(componente1);
		paquete1.quitarProducto(componente1);
		assertEquals(0, paquete1.getProductos().size());
	}
	
	@Test
	void testGetPrecio() {
		
		when(componente1.getPrecio()).thenReturn(1000.0f);
	    when(componente2.getPrecio()).thenReturn(1000.0f);
		
		paquete2.agregarProducto(componente1);
		paquete2.agregarProducto(componente2);
		
		assertEquals(2000f, paquete2.getPrecioFinal());
		
	}
	
	@Test
	void testGetPrecioFinal() {
		
		when(componente1.getPrecio()).thenReturn(1000.0f);
	    when(componente2.getPrecio()).thenReturn(1000.0f);
		
		paquete1.agregarProducto(componente1);
		paquete1.agregarProducto(componente2);
		
		assertEquals(1800f, paquete1.getPrecioFinal());
		
	}
	
	@Test
	void testIncrementarStock() {
		
		paquete1.agregarProducto(componente1);
	    paquete1.agregarProducto(componente2);
	   
	    paquete1.incrementarStock();

	    verify(componente1, times(1)).incrementarStock();
	    verify(componente2, times(1)).incrementarStock();
	}
	
	
	@Test
	void testDecrementarStockDisminuyeEnUnoElStock(){
		
		paquete1.agregarProducto(componente1);
	    paquete1.agregarProducto(componente2);
	   
	    paquete1.decrementarStock();

	    verify(componente1, times(1)).decrementarStock();
	    verify(componente2, times(1)).decrementarStock();
	}
	
	@Test
	void testGetPeso() {
		
		when(componente1.getPeso()).thenReturn(550f);
	    when(componente2.getPeso()).thenReturn(400f);
		
		paquete1.agregarProducto(componente1);
		paquete1.agregarProducto(componente2);
		
		assertEquals(950f, paquete1.getPeso());
	}
	
	@Test
	void testTieneStockDisponible() {
		
		when(componente1.tieneStockDisponible()).thenReturn(true);
	    when(componente2.tieneStockDisponible()).thenReturn(true);
		
		paquete1.agregarProducto(componente1);
		paquete1.agregarProducto(componente2);
		
		assertEquals(true, paquete1.tieneStockDisponible());
	
	}
	
	@Test
	void testNoTieneStockDisponible() {
		
		when(componente1.tieneStockDisponible()).thenReturn(false);
	    when(componente2.tieneStockDisponible()).thenReturn(false);
		
		paquete1.agregarProducto(componente1);
		paquete1.agregarProducto(componente2);
		
		assertEquals(false, paquete1.tieneStockDisponible());
	
	}
	
	@Test
	void testGetStock() {
		
		when(componente1.getStock()).thenReturn(4);
	    when(componente2.getStock()).thenReturn(5);
		
		paquete1.agregarProducto(componente1);
		paquete1.agregarProducto(componente2);
		
		assertEquals(9, paquete1.getStock());
	
	}
	
	@Test 
	void aceptarVisitor() {
		
		ReporteVisitor visitorMock = mock(ReporteVisitor.class);
		paquete1.aceptar(visitorMock);
		verify(visitorMock, times(1)).visitarPaquete(paquete1);
	}
	
	@Test
	void testGetProductos() {
		
		paquete1.agregarProducto(componente1);
		paquete1.agregarProducto(componente2);
		
		List<CatalogoDeProductos> listaEsperada = new ArrayList<>();
		listaEsperada.add(componente1);
		listaEsperada.add(componente2);

	    
	    assertIterableEquals(listaEsperada, paquete1.getProductos());
	
	}
	
	
}
