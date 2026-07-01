package metodoDeEnvioTestCase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ecommerce.Cliente;
import ecommerce.Pedido;
import ecommerce.Producto;
import ecommerce.CatalogoDeProductos;
import envio.CorreoArgentina;
import envio.Direccion;
import envio.EnvioEstandar;
import envio.MetodoDeEnvio;
import estadoDePedido.Borrador;

class EnvioEstandarTest {
	
	EnvioEstandar envio;
	CorreoArgentina correo;
	Direccion direccion;
	List<CatalogoDeProductos> productos;
	Cliente cliente;
	MetodoDeEnvio metodo;
	Pedido pedido;
	Producto producto1;
	Borrador estadoDePedido;

	@BeforeEach
	void setUp() {
		correo = mock(CorreoArgentina.class);
		productos = new ArrayList<>();
		estadoDePedido = new Borrador();
		direccion = new Direccion("Saenz Peña", "Quilmes", "Buenos Aires", "1978");
		cliente = new Cliente("123", direccion, "dasdas@gmail.com");
		metodo = mock(MetodoDeEnvio.class);
		pedido = new Pedido(estadoDePedido,productos,cliente, metodo);
		producto1 = mock(Producto.class);
		envio = new EnvioEstandar(correo);
	}

	@Test
	void testEnvioEstandarUsaLaLibreria() {
		when(correo.estimarEnvio(pedido.getPeso(), direccion)).thenReturn(12900f);
		float costo = envio.costoDeEnvio(pedido);
		assertEquals(12900f,costo);
	}

}
