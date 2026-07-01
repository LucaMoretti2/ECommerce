package metodoDeEnvioTestCase;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import envio.Direccion;

class DireccionTest {
	
	Direccion direccion;
	

	@BeforeEach
	void setUp() {
		direccion = new Direccion("Roque Saenz Peña", "Quilmes", "Buenos Aires", "1877");
	}
	
	@Test
	void testGetCalle() {
		assertEquals(direccion.getCalle(), "Roque Saenz Peña");
	}
	
	@Test
	void testGetCiudad() {
		assertEquals(direccion.getCiudad(), "Quilmes");
	}
	
	@Test
	void testGetProvincia() {
		assertEquals(direccion.getProvincia(), "Buenos Aires");
	}

	@Test
	void testGetCodigoPostal() {
		assertEquals(direccion.getCodigoPostal(), "1877");
	}
}
