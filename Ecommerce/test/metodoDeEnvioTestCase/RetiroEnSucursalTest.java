package metodoDeEnvioTestCase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import ecommerce.Pedido;
import envio.RetiroEnSucursal;

class RetiroEnSucursalTest {

	Pedido pedido = mock(Pedido.class);
	RetiroEnSucursal envio ;
	
	
	@Test
	void testRetiroEnSucursalCalculaElCosto() {
		envio = new RetiroEnSucursal();
		assertEquals(envio.costoDeEnvio(pedido), 0);
	}

}
