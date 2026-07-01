package estadoDePedidoTestCase;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ecommerce.CatalogoDeProductos;
import ecommerce.Pedido;
import estadoDePedido.Cancelado;
import estadoDePedido.Entregado;
import estadoDePedido.Enviado;
import estadoDePedido.OperacionInvalidaException;

public class EnviadoTest {

	Enviado enviado; 
	CatalogoDeProductos componente1;
	Pedido pedido1;
	
	
	
	@BeforeEach 
	public void setUp() {
		
		enviado = new Enviado();
		pedido1 = mock(Pedido.class);
		componente1 = mock(CatalogoDeProductos.class);
		
	}
	
	@Test
	public void testAgregarItem() {
		
		try {
			enviado.agregarItem(pedido1, componente1);
		    fail("Se esperaba OperacionInvalidaException pero el método no lanzó nada.");
		} catch (OperacionInvalidaException ex) {
			 assertEquals("No se puede agregar un item en enviado", ex.getMessage());
		}
	}
	
	@Test
	public void testQuitarItem() {
		
		try {
			enviado.quitarItem(pedido1, componente1);
		    fail("Se esperaba OperacionInvalidaException pero el método no lanzó nada.");
		} catch (OperacionInvalidaException ex) {
			 assertEquals("No se puede quitar un item en enviado", ex.getMessage());
		}
	}
	
	@Test
	public void testPreparar() {
		
		try {
			enviado.preparar(pedido1);
		    fail("Se esperaba OperacionInvalidaException pero el método no lanzó nada.");
		} catch (OperacionInvalidaException ex) {
			 assertEquals("No se puede preparar un pedido en enviado", ex.getMessage());
		}
	}

	@Test
	public void testEnviar() {
		
		try {
			enviado.enviar(pedido1);
		    fail("Se esperaba OperacionInvalidaException pero el método no lanzó nada.");
		} catch (OperacionInvalidaException ex) {
			 assertEquals("No se puede enviar un pedido en enviado", ex.getMessage());
		}
	}
	
	@Test
	public void testEntregar() {
	
	    List<CatalogoDeProductos> lista = new ArrayList<>();
	    lista.add(componente1);

	    when(pedido1.getProductos()).thenReturn(lista);

		enviado.entregar(pedido1);
		
		verify(componente1, times(1)).incrementarCantidadVendida();
		verify(pedido1, times(1)).setEstado(isA(Entregado.class));
		
	}
	
	@Test
	public void testCancelarPedido() {
		
		enviado.cancelarPedido(pedido1);
		
		verify(pedido1, times(1)).generarNotaCreditoProductos();
		verify(pedido1, times(1)).setEstado(isA(Cancelado.class));
		
	}
	
	@Test
	public void testConfirmarPedido() {
		
		try {
			enviado.confirmarPedido(pedido1);
		    fail("Se esperaba OperacionInvalidaException pero el método no lanzó nada.");
		} catch (OperacionInvalidaException ex) {
			 assertEquals("No se puede confirmar un pedido en enviado", ex.getMessage());
		}
		
	}
}
