package metodoDePagoTestCase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ecommerce.CatalogoDeProductos;
import ecommerce.Cliente;
import ecommerce.Pedido;
import envio.EnvioExpress;
import envio.MetodoDeEnvio;
import estadoDePedido.Borrador;
import estadoDePedido.EstadoDePedido;
import metodosDePago.APITarjetaDeCredito;
import metodosDePago.MetodoDePagoException;
import metodosDePago.TarjetaDeCredito;


class TarjetaDeCreditoTestCase {

	TarjetaDeCredito tarjeta1;
	TarjetaDeCredito tarjeta2;
	TarjetaDeCredito tarjeta3;
	TarjetaDeCredito tarjeta4;
	APITarjetaDeCredito api;
	LocalDate hoy;
	EstadoDePedido estadoDePedido;
	Cliente cliente;
	List<CatalogoDeProductos> productos;
	Pedido pedido;
	MetodoDeEnvio metodo;
	
	@BeforeEach
	void setUp() {
		api = mock(APITarjetaDeCredito.class);
		hoy = LocalDate.now();
		tarjeta1 = new TarjetaDeCredito(api,"3921932193921293","832", hoy);
		tarjeta2 = new TarjetaDeCredito(api,"392132193921293","832", hoy);
		tarjeta3 = new TarjetaDeCredito(api,"3921321939212933","83", hoy);
		tarjeta4 = new TarjetaDeCredito(api,"3921321939212933","833", hoy.minusDays(1));
		estadoDePedido = mock(Borrador.class);
		cliente = mock(Cliente.class);
		productos = new ArrayList<>();
		metodo = mock(EnvioExpress.class);
		pedido = new Pedido(estadoDePedido, productos, cliente, metodo);
		
	}
	
	@Test
	void testValidarDatosNoMandaExcepcion() {
	    try {
	        tarjeta1.validarDatos(pedido);
	    } catch (MetodoDePagoException ex) {
	        fail("No se esperaba que se lanzara una excepción, pero se lanzó: " + ex.getMessage());
	    }
	}

	@Test
	void testValidarDatosNumeroDeTarjetaMandaExcepcion() {
	    try {
	        tarjeta2.validarDatos(pedido);
	        fail("Se esperaba que se lanzara MetodoDePagoException");
	    } catch (MetodoDePagoException ex) {
	        assertEquals("Los datos de la tarjeta son incorrectos", ex.getMessage());
	    }
	}

	@Test
	void testValidarDatosCVVMandaExcepcion() {
	    try {
	        tarjeta3.validarDatos(pedido);
	        fail("Se esperaba que se lanzara MetodoDePagoException");
	    } catch (MetodoDePagoException ex) {
	        assertEquals("Los datos de la tarjeta son incorrectos", ex.getMessage());
	    }
	}

	@Test
	void testValidarDatosTarjetaVencidaMandaExcepcion() {
	    try {
	        tarjeta4.validarDatos(pedido);
	        fail("Se esperaba que se lanzara MetodoDePagoException");
	    } catch (MetodoDePagoException ex) {
	        assertEquals("Los datos de la tarjeta son incorrectos", ex.getMessage());
	    }
	}
	
	@Test
	void testReservarFondosSinAutorizacionLanzaExcepcion() {
	    when(api.preAutorizarMonto(pedido.getMontoTotal())).thenReturn(false);

	    try {
	        tarjeta1.reservarFondos(pedido);
	        fail("Se esperaba que se lanzara MetodoDePagoException");
	    } catch (MetodoDePagoException ex) {
	        assertEquals("El pago no fue autorizado por la entidad bancaria", ex.getMessage());
	    }
	}
	
	@Test
	void testReservarFondosConAutorizacionNoLanzaExcepcion() {
	    when(api.preAutorizarMonto(pedido.getMontoTotal())).thenReturn(true);

	    try {
	        tarjeta1.reservarFondos(pedido);
	    } catch (MetodoDePagoException ex) {
	    	fail("No se esperaba que se lanzara una excepción, pero se lanzó: " + ex.getMessage());
	    }
	}
	
	
	@Test
	void testEjecutarTransaccionLanzaExcepcion() {
	    when(api.transferenciaRealizada()).thenReturn(false);

	    try {
	        tarjeta1.ejecutarTransaccion(pedido);
	        fail("Se esperaba que se lanzara MetodoDePagoException");
	    } catch (MetodoDePagoException ex) {
	        assertEquals("La transferencia no fue enviada", ex.getMessage());
	    }
	}
	
	@Test
	void testEjecutarTransaccionNoLanzaExcepcion() {
	    when(api.transferenciaRealizada()).thenReturn(true);

	    try {
	        tarjeta1.ejecutarTransaccion(pedido);
	    } catch (MetodoDePagoException ex) {
	    	fail("No se esperaba que se lanzara una excepción, pero se lanzó: " + ex.getMessage());
	    }
	}
	
	@Test
	void testNotificarResultados() {
	    tarjeta1.notificarResultados(pedido);
	    String cupon = "Cupón de pago - Tarjeta: 3921932193921293";
	    assertTrue(pedido.getComprobantes().contains(cupon));
	}
	


}
