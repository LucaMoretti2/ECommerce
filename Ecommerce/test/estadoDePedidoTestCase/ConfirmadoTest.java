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
import estadoDePedido.Confirmado;
import estadoDePedido.EnPreparacion;
import estadoDePedido.OperacionInvalidaException;

public class ConfirmadoTest {

	Confirmado confirmado; 
	CatalogoDeProductos componente1;
	Pedido pedido1;
	
	
	
	@BeforeEach 
	public void setUp() {
		
		confirmado = new Confirmado();
		pedido1 = mock(Pedido.class);
		componente1 = mock(CatalogoDeProductos.class);
		
	}
	
	@Test
	public void testAgregarItem() {
		
		try {
		    confirmado.agregarItem(pedido1, componente1);
		    fail("Se esperaba OperacionInvalidaException pero el método no lanzó nada.");
		} catch (OperacionInvalidaException ex) {
			 assertEquals("No se puede agregar un item en confirmado", ex.getMessage());
		}
	}
	
	@Test
	public void testQuitarItem() {
		
		try {
		    confirmado.quitarItem(pedido1, componente1);
		    fail("Se esperaba OperacionInvalidaException pero el método no lanzó nada.");
		} catch (OperacionInvalidaException ex) {
			 assertEquals("No se puede quitar un item en confirmado", ex.getMessage());
		}
	}
	
	@Test
	public void testPreparar() {
		
		confirmado.preparar(pedido1);
		
		verify(pedido1, times(1)).decrementarStock();
		verify(pedido1, times(1)).setEstado(isA(EnPreparacion.class));
	}

	@Test
	public void testEnviar() {
		
		try {
		    confirmado.enviar(pedido1);
		    fail("Se esperaba OperacionInvalidaException pero el método no lanzó nada.");
		} catch (OperacionInvalidaException ex) {
			 assertEquals("No se puede enviar un pedido en confirmado", ex.getMessage());
		}
	}
	
	@Test
	public void testEntregar() {
		
		try {
		    confirmado.entregar(pedido1);
		    fail("Se esperaba OperacionInvalidaException pero el método no lanzó nada.");
		} catch (OperacionInvalidaException ex) {
			 assertEquals("No se puede entregar un pedido en confirmado", ex.getMessage());
		}
		
	}
	
	@Test
	public void testCancelarPedido() {
		
		confirmado.cancelarPedido(pedido1);
		
		verify(pedido1, times(1)).setEstado(isA(Cancelado.class));
		
	}
	
	@Test
	public void testConfirmarPedido() {
		
		try {
		    confirmado.confirmarPedido(pedido1);
		    fail("Se esperaba OperacionInvalidaException pero el método no lanzó nada.");
		} catch (OperacionInvalidaException ex) {
			 assertEquals("No se puede confirmar un pedido en confirmado", ex.getMessage());
		}
		
	}
}
