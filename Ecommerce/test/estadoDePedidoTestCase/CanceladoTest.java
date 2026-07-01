package estadoDePedidoTestCase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ecommerce.CatalogoDeProductos;
import ecommerce.Pedido;
import estadoDePedido.Cancelado;
import estadoDePedido.OperacionInvalidaException;

public class CanceladoTest {

	Cancelado cancelado; 
	CatalogoDeProductos componente1;
	Pedido pedido1;
	
	
	
	@BeforeEach 
	public void setUp() {
		
		cancelado = new Cancelado();
		pedido1 = mock(Pedido.class);
		componente1 = mock(CatalogoDeProductos.class);
		
	}
	
	@Test
	public void testAgregarItem() {
		
		try {
		    cancelado.agregarItem(pedido1, componente1);
		    fail("Se esperaba OperacionInvalidaException pero el método no lanzó nada.");
		} catch (OperacionInvalidaException ex) {
			 assertEquals("No se puede agregar un item en cancelado", ex.getMessage());
		}
	}
	
	@Test
	public void testQuitarItem() {
		
		try {
		    cancelado.quitarItem(pedido1, componente1);
		    fail("Se esperaba OperacionInvalidaException pero el método no lanzó nada.");
		} catch (OperacionInvalidaException ex) {
			 assertEquals("No se puede quitar un item en cancelado", ex.getMessage());
		}
	}
	
	@Test
	public void testPreparar() {
		
		try {
		    cancelado.preparar(pedido1);
		    fail("Se esperaba OperacionInvalidaException pero el método no lanzó nada.");
		} catch (OperacionInvalidaException ex) {
			 assertEquals("No se puede preparar un pedido en cancelado", ex.getMessage());
		}
	}

	@Test
	public void testEnviar() {
		
		try {
		    cancelado.enviar(pedido1);
		    fail("Se esperaba OperacionInvalidaException pero el método no lanzó nada.");
		} catch (OperacionInvalidaException ex) {
			 assertEquals("No se puede enviar un pedido en cancelado", ex.getMessage());
		}
	}
	
	@Test
	public void testEntregar() {
		
		try {
		    cancelado.entregar(pedido1);
		    fail("Se esperaba OperacionInvalidaException pero el método no lanzó nada.");
		} catch (OperacionInvalidaException ex) {
			 assertEquals("No se puede entregar un pedido en cancelado", ex.getMessage());
		}
		
	}
	
	@Test
	public void testCancelarPedido() {
		
		try {
		    cancelado.cancelarPedido(pedido1);
		    fail("Se esperaba OperacionInvalidaException pero el método no lanzó nada.");
		} catch (OperacionInvalidaException ex) {
			 assertEquals("No se puede cancelar un pedido en cancelado", ex.getMessage());
		}
		
	}
	
	@Test
	public void testConfirmarPedido() {
		
		try {
		    cancelado.confirmarPedido(pedido1);
		    fail("Se esperaba OperacionInvalidaException pero el método no lanzó nada.");
		} catch (OperacionInvalidaException ex) {
			 assertEquals("No se puede confirmar un pedido en cancelado", ex.getMessage());
		}
		
	}
	
	
}


