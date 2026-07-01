package estadoDePedidoTestCase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ecommerce.CatalogoDeProductos;
import ecommerce.Pedido;
import estadoDePedido.Entregado;
import estadoDePedido.OperacionInvalidaException;

public class EntregadoTest {

	Entregado entregado; 
	CatalogoDeProductos componente1;
	Pedido pedido1;
	
	
	
	@BeforeEach 
	public void setUp() {
		
		entregado = new Entregado();
		pedido1 = mock(Pedido.class);
		componente1 = mock(CatalogoDeProductos.class);
		
	}
	
	@Test
	public void testAgregarItem() {
		
		try {
		    entregado.agregarItem(pedido1, componente1);
		    fail("Se esperaba OperacionInvalidaException pero el método no lanzó nada.");
		} catch (OperacionInvalidaException ex) {
			 assertEquals("No se puede agregar un item en entregado", ex.getMessage());
		}
	}
	
	@Test
	public void testQuitarItem() {
		
		try {
		    entregado.quitarItem(pedido1, componente1);
		    fail("Se esperaba OperacionInvalidaException pero el método no lanzó nada.");
		} catch (OperacionInvalidaException ex) {
			 assertEquals("No se puede quitar un item en entregado", ex.getMessage());
		}
	}
	
	@Test
	public void testPreparar() {
		
		try {
			entregado.preparar(pedido1);
		    fail("Se esperaba OperacionInvalidaException pero el método no lanzó nada.");
		} catch (OperacionInvalidaException ex) {
			 assertEquals("No se puede preparar un pedido en entregado", ex.getMessage());
		}
	}

	@Test
	public void testEnviar() {
		
		try {
			entregado.enviar(pedido1);
		    fail("Se esperaba OperacionInvalidaException pero el método no lanzó nada.");
		} catch (OperacionInvalidaException ex) {
			 assertEquals("No se puede enviar un pedido en entregado", ex.getMessage());
		}
	}
	
	@Test
	public void testEntregar() {
		
		try {
			entregado.entregar(pedido1);
		    fail("Se esperaba OperacionInvalidaException pero el método no lanzó nada.");
		} catch (OperacionInvalidaException ex) {
			 assertEquals("No se puede entregar un pedido en entregado", ex.getMessage());
		}
		
	}
	
	@Test
	public void testCancelarPedido() {
		
		try {
			entregado.cancelarPedido(pedido1);
		    fail("Se esperaba OperacionInvalidaException pero el método no lanzó nada.");
		} catch (OperacionInvalidaException ex) {
			 assertEquals("No se puede cancelar un pedido en entregado", ex.getMessage());
		}
		
	}
	
	@Test
	public void testConfirmarPedido() {
		
		try {
			entregado.confirmarPedido(pedido1);
		    fail("Se esperaba OperacionInvalidaException pero el método no lanzó nada.");
		} catch (OperacionInvalidaException ex) {
			 assertEquals("No se puede confirmar un pedido en entregado", ex.getMessage());
		}
		
	}
}
