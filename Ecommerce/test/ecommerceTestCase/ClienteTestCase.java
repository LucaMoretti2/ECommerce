package ecommerceTestCase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import ecommerce.Cliente;
import ecommerce.Pedido;
import envio.Direccion;

class ClienteTestCase {
	
	Direccion direccion = new Direccion("Saenz Peña", "Quilmes", "Buenos Aires", "1978");
	Cliente cliente = new Cliente("123", direccion, "dasdas@gmail.com");
	Pedido pedido = mock(Pedido.class); 

	@Test
	void testGetID() {
		
		assertEquals(cliente.getID(), "123");
	}
	
	@Test
	void testGetDireccion() {
		assertEquals(cliente.getDireccion(), direccion);
	}

	
	@Test
	void testGetMail() {
		assertEquals(cliente.getMail(), "dasdas@gmail.com");
	}
	
	@Test
	void testSetPedido() {
		cliente.setPedido(pedido);
		assertEquals(cliente.getPedido(), pedido);
	}

}
