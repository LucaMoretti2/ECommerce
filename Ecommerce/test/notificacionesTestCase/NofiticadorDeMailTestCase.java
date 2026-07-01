package notificacionesTestCase;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ecommerce.Cliente;
import ecommerce.Pedido;
import estadoDePedido.Borrador;
import estadoDePedido.Confirmado;
import estadoDePedido.EnPreparacion;
import estadoDePedido.Entregado;
import estadoDePedido.Enviado;
import estadoDePedido.EstadoDePedido;
import notificacion.MailSender;
import notificacion.NotificadorDeMail;

class NofiticadorDeMailTestCase {

	MailSender sender;
	NotificadorDeMail notificador;
	Cliente cliente;
	Pedido pedido;
	
	@BeforeEach
	void setUp() {
		sender = mock(MailSender.class);
		cliente = mock(Cliente.class);
		when(cliente.getMail()).thenReturn("cliente@gmail.com");
		pedido = mock(Pedido.class);
		when(pedido.getCliente()).thenReturn(cliente);
		notificador = new NotificadorDeMail(sender);
	}
	
	@Test
	void testActualizarDeBorradorAConfirmadoEnviaMail() {
		EstadoDePedido anterior = new Borrador();
		EstadoDePedido nuevo = new Confirmado();
		notificador.actualizar(pedido, anterior, nuevo);
		verify(sender).enviarMail("cliente@gmail.com", "Su pedido se ha actualizado", "Su pedido paso de" + anterior + "a" + nuevo, null);
	}
	
	@Test
	void testActualizarDeEnPreparacionAEnviado() {
		EstadoDePedido anterior = new EnPreparacion();
		EstadoDePedido nuevo = new Enviado();
		notificador.actualizar(pedido, anterior, nuevo);
		verify(sender).enviarMail("cliente@gmail.com", "Su pedido se ha actualizado", "Su pedido paso de" + anterior + "a" + nuevo, null);
	}
	
	@Test
	void testActualizarDeEnviadoAEntregado() {
		EstadoDePedido anterior = new Enviado();
		EstadoDePedido nuevo = new Entregado();
		notificador.actualizar(pedido, anterior, nuevo);
		verify(sender).enviarMail("cliente@gmail.com", "Su pedido se ha actualizado", "Su pedido paso de" + anterior + "a" + nuevo, null);
	}

}
