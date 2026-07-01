package estadoDePedidoTestCase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ecommerce.CatalogoDeProductos;
import ecommerce.Pedido;
import estadoDePedido.Borrador;
import estadoDePedido.Cancelado;
import estadoDePedido.Confirmado;
import estadoDePedido.OperacionInvalidaException;


public class BorradorTest {
	
	Borrador borrador; 
	CatalogoDeProductos componente1;
	Pedido pedido1;
	
	
	
	@BeforeEach 
	public void setUp() {
		
		borrador = new Borrador();
		pedido1 = mock(Pedido.class);
		componente1 = mock(CatalogoDeProductos.class);
		
	}
	
	@Test
	public void testAgregarItem() {
		
		borrador.agregarItem(pedido1, componente1);
		
		verify(pedido1, times(1)).agregarProducto(componente1);
	}
	
	@Test
	public void testQuitarItem() {
		
		borrador.agregarItem(pedido1, componente1);
		borrador.quitarItem(pedido1, componente1);
		
		verify(pedido1, times(1)).quitarProducto(componente1);
	}
	
	@Test
	public void testCancelarPedido() {
		
		borrador.cancelarPedido(pedido1);
		
		verify(pedido1, times(1)).setEstado(isA(Cancelado.class));
	}

	@Test
	public void testConfirmarPedido() {
		
		borrador.confirmarPedido(pedido1);
		
		verify(pedido1, times(1)).setEstado(isA(Confirmado.class));
	}
	
	@Test
	public void testPreparar() {
		
		try {
		    borrador.preparar(pedido1);
		    fail("Se esperaba OperacionInvalidaException pero el método no lanzó nada.");
		} catch (OperacionInvalidaException ex) {
			 assertEquals("No se puede preparar un pedido en borrador", ex.getMessage());
		}
		
	}
	
	@Test
	public void testEnviar() {
		
		try {
		    borrador.enviar(pedido1);
		    fail("Se esperaba OperacionInvalidaException pero el método no lanzó nada.");
		} catch (OperacionInvalidaException ex) {
			 assertEquals("No se puede enviar un pedido en borrador", ex.getMessage());
		}
		
	}
	
	@Test
	public void testEntregar() {
		
		try {
		    borrador.entregar(pedido1);
		    fail("Se esperaba OperacionInvalidaException pero el método no lanzó nada.");
		} catch (OperacionInvalidaException ex) {
			 assertEquals("No se puede entregar un pedido en borrador", ex.getMessage());
		}
		
	}
	
	
}
