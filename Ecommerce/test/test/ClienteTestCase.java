package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ecommerce.Cliente;
import envio.Direccion;

class ClienteTestCase {
	
	Direccion direccion = new Direccion("Saenz Peña", "Quilmes", "Buenos Aires", "1978");
	Cliente cliente = new Cliente("123", direccion, "dasdas@gmail.com");

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

}
