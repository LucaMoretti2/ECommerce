package ecommerceTestCase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ecommerce.Cliente;
import ecommerce.NotaDeCredito;
import ecommerce.Pedido;
import envio.Direccion;

class NotaDeCreditoTestCase {

	Cliente cliente;
	NotaDeCredito nota;
	Pedido pedido;
	Direccion direccion;
	
	@BeforeEach
	void setUp() {
		direccion = mock(Direccion.class);
		pedido = mock(Pedido.class);
		cliente = new Cliente("123", direccion, "asd@gmail.com");
		nota = new NotaDeCredito(cliente, 500f, pedido);
		
	}
	
	@Test
	void testMontoAReembolsar() {
		assertEquals(nota.getMontoAReembolsar(), 500f);
	}
	
	@Test
	void testGetClienteID() {
		assertEquals(nota.getClienteID(), "123");
	}
	
	@Test
	void testGetPedido() {
		assertEquals(nota.getPedido(), pedido);
	}

}
