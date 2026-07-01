package notificacionesTestCase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ecommerce.*;
import ecommerce.Cliente;
import ecommerce.Pedido;
import envio.MetodoDeEnvio;
import estadoDePedido.Borrador;
import estadoDePedido.Confirmado;
import estadoDePedido.EnPreparacion;
import estadoDePedido.Entregado;
import estadoDePedido.Enviado;
import estadoDePedido.EstadoDePedido;
import notificacion.GeneradorDeFactura;

class GeneradorDeFacturaTestCase {

	GeneradorDeFactura generador;
	Cliente cliente;
	Pedido pedido;
	EstadoDePedido estadoDePedido;
	List<CatalogoDeProductos> productos;
	MetodoDeEnvio metodo;
	
	@BeforeEach
	void setUp() {
		cliente = mock(Cliente.class);
		estadoDePedido = mock(Borrador.class);
		productos = new ArrayList<>();
		pedido = new Pedido(estadoDePedido, productos, cliente, metodo);
		generador = new GeneradorDeFactura();
	}
	
	@Test
	void testActualizarGeneraFactura() {
		EstadoDePedido anterior = new Enviado();
		EstadoDePedido nuevo = new Entregado();
		generador.actualizar(pedido, anterior, nuevo);
		String factura = "Factura: " + pedido.getProductos() + "| Total: $" + pedido.getPrecio();
		assertTrue(pedido.getComprobantes().contains(factura));
	}
	
	@Test
	void testActualizarNoGeneraFacturaEnConfirmado() {
		EstadoDePedido anterior = new Borrador();
		EstadoDePedido nuevo = new Confirmado();
		generador.actualizar(pedido, anterior, nuevo);
		assertTrue(pedido.getComprobantes().isEmpty());
	}
	
	@Test
	void testActualizarNoGeneraFacturaEnEnviado() {
		EstadoDePedido anterior = new EnPreparacion();
		EstadoDePedido nuevo = new Enviado();
		generador.actualizar(pedido, anterior, nuevo);
		assertTrue(pedido.getComprobantes().isEmpty());

	}

	@Test
	void testGenerarFacturaDevuelveElFormatoCorrecto() {
		String factura = generador.generarFactura(pedido);

		String facturaEsperada = "Factura: " + pedido.getProductos() + "| Total: $" + pedido.getPrecio();
		assertEquals(facturaEsperada, factura);
	}
	
}
