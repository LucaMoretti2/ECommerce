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
import estadoDePedido.Cancelado;
import estadoDePedido.EnPreparacion;
import estadoDePedido.OperacionInvalidaException;
import estadoDePedido.Enviado;

public class EnPreparacionTest {

	EnPreparacion preparacion; 
	CatalogoDeProductos componente1;
	Pedido pedido1;
	
	
	
	@BeforeEach 
	public void setUp() {
		
		preparacion = new EnPreparacion();
		pedido1 = mock(Pedido.class);
		componente1 = mock(CatalogoDeProductos.class);
		
	}
	
	@Test
	public void testAgregarItem() {
		
		try {
			preparacion.agregarItem(pedido1, componente1);
		    fail("Se esperaba OperacionInvalidaException pero el método no lanzó nada.");
		} catch (OperacionInvalidaException ex) {
			 assertEquals("No se puede agregar un item en preparacion", ex.getMessage());
		}
	}
	
	@Test
	public void testQuitarItem() {
		
		try {
			preparacion.quitarItem(pedido1, componente1);
		    fail("Se esperaba OperacionInvalidaException pero el método no lanzó nada.");
		} catch (OperacionInvalidaException ex) {
			 assertEquals("No se puede quitar un item en preparacion", ex.getMessage());
		}
	}
	
	@Test
	public void testPreparar() {
		
		try {
			preparacion.preparar(pedido1);
		    fail("Se esperaba OperacionInvalidaException pero el método no lanzó nada.");
		} catch (OperacionInvalidaException ex) {
			 assertEquals("No se puede preparar un pedido en preparacion", ex.getMessage());
		}
	}

	@Test
	public void testEnviar() {
		
		preparacion.enviar(pedido1);
		
		verify(pedido1, times(1)).setEstado(isA(Enviado.class));
	}
	
	@Test
	public void testEntregar() {
		
		try {
			preparacion.entregar(pedido1);
		    fail("Se esperaba OperacionInvalidaException pero el método no lanzó nada.");
		} catch (OperacionInvalidaException ex) {
			 assertEquals("No se puede entregar un pedido en preparacion", ex.getMessage());
		}
		
	}
	
	@Test
	public void testCancelarPedido() {
		
		preparacion.cancelarPedido(pedido1);
		
		verify(pedido1, times(1)).incrementarStock();
		verify(pedido1, times(1)).generarNotaCreditoProductos();
		verify(pedido1, times(1)).generarNotaCreditoEnvio();
		verify(pedido1, times(1)).setEstado(isA(Cancelado.class));
		
	}
	
	@Test
	public void testConfirmarPedido() {
		
		try {
			preparacion.confirmarPedido(pedido1);
		    fail("Se esperaba OperacionInvalidaException pero el método no lanzó nada.");
		} catch (OperacionInvalidaException ex) {
			 assertEquals("No se puede confirmar un pedido en preparacion", ex.getMessage());
		}
		
	}
}
