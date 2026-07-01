package notificacionesTestCase;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ecommerce.CatalogoDeProductos;
import ecommerce.Cliente;
import ecommerce.Pedido;
import envio.MetodoDeEnvio;
import estadoDePedido.Borrador;
import estadoDePedido.Cancelado;
import estadoDePedido.Confirmado;
import estadoDePedido.EnPreparacion;
import estadoDePedido.EstadoDePedido;
import notificacion.Fidelizacion;
import notificacion.MailSender;

class FidelizacionTestCase {

	MailSender sender;
	Fidelizacion fidelizacion;
	Cliente cliente;
	Pedido pedido;
	EstadoDePedido estadoDePedido;
	List<CatalogoDeProductos> productos;
	MetodoDeEnvio metodo;
	
	@BeforeEach
	void setUp() {
		sender = mock(MailSender.class);
		cliente = mock(Cliente.class);
		when(cliente.getMail()).thenReturn("cliente@gmail.com");
		estadoDePedido = mock(Borrador.class);
		productos = new ArrayList<>();
		pedido = mock(Pedido.class);
		when(pedido.getCliente()).thenReturn(cliente);
		fidelizacion = new Fidelizacion(sender);
	}
	
	@Test
	void testCancelarElPedidoTeDaUnCupon() {
		EstadoDePedido anterior = new Confirmado();
		EstadoDePedido nuevo = new Cancelado();
		fidelizacion.actualizar(pedido, anterior, nuevo);
		verify(sender).enviarMail("cliente@gmail.com", "Te regalamos un cupon", fidelizacion.generarCupon(), null);
	}
	
	@Test
	void testCancelarElPedidoNoTeDaUnCupon() {
		EstadoDePedido anterior = new Confirmado();
		EstadoDePedido nuevo = new EnPreparacion();
		fidelizacion.actualizar(pedido, anterior, nuevo);
		verify(sender, never()).enviarMail("cliente@gmail.com", "Te regalamos un cupon", fidelizacion.generarCupon(), null);
	}

}
