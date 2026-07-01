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
import metodosDePago.APITransferenciaBancaria;
import metodosDePago.MetodoDePagoException;
import metodosDePago.TransferenciaBancaria;

class TransferenciaBancariaTestCase {

	TransferenciaBancaria transferencia1;
	TransferenciaBancaria transferencia2;
	APITransferenciaBancaria api;
	LocalDate hoy;
	EstadoDePedido estadoDePedido;
	Cliente cliente;
	List<CatalogoDeProductos> productos;
	Pedido pedido;
	MetodoDeEnvio metodo;
	
	@BeforeEach
	void setUp() {
		api = mock(APITransferenciaBancaria.class);
		hoy = LocalDate.now();
		transferencia1 = new TransferenciaBancaria(api, "2344234523275849391203", "asd.asd");
		transferencia2 = new TransferenciaBancaria(api, "23442345232754391203", "asd.asd"); // tiene datos invalidos
		estadoDePedido = mock(Borrador.class);
		cliente = mock(Cliente.class);
		productos = new ArrayList<>();
		metodo = mock(EnvioExpress.class);
		pedido = new Pedido(estadoDePedido, productos, cliente, metodo);
		
	}
	
	@Test
	void testValidarDatosNoMandaExcepcion() {
	    try {
	        transferencia1.validarDatos(pedido);
	    } catch (MetodoDePagoException ex) {
	        fail("No se esperaba que se lanzara una excepción, pero se lanzó: " + ex.getMessage());
	    }
	}
	
	@Test
	void testValidarDatosNumeroDeTarjetaMandaExcepcion() {
	    try {
	    	transferencia2.validarDatos(pedido);
	        fail("Se esperaba que se lanzara MetodoDePagoException");
	    } catch (MetodoDePagoException ex) {
	        assertEquals("Tus datos no son validos", ex.getMessage());
	    }
	}
	
	@Test
	void testEjecutarTransaccionLanzaExcepcion() {
	    when(api.transferenciaRealizada()).thenReturn(false);

	    try {
	        transferencia1.ejecutarTransaccion(pedido);
	        fail("Se esperaba que se lanzara MetodoDePagoException");
	    } catch (MetodoDePagoException ex) {
	        assertEquals("La transferencia no fue enviada", ex.getMessage());
	    }
	}
	
	@Test
	void testEjecutarTransaccionNoLanzaExcepcion() {
	    when(api.transferenciaRealizada()).thenReturn(true);

	    try {
	        transferencia1.ejecutarTransaccion(pedido);
	    } catch (MetodoDePagoException ex) {
	    	 fail("No se esperaba que se lanzara una excepción, pero se lanzó: " + ex.getMessage());
	    }
	}
	
	@Test
	void testNotificarResultados() {
	    transferencia1.notificarResultados(pedido);
	    String comprobante = "Comprobante CBU: 2344234523275849391203";
	    assertTrue(pedido.getComprobantes().contains(comprobante));
	}

}
