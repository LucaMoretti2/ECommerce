package metodoDePagoTestCase;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
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
import metodosDePago.APIBilleteraVirtual;
import metodosDePago.BilleteraVirtual;
import metodosDePago.MetodoDePagoException;

class BilleteraVirtualTestCase {

	BilleteraVirtual billetera1;
	APIBilleteraVirtual api;
	LocalDate hoy;
	EstadoDePedido estadoDePedido;
	Cliente cliente;
	List<CatalogoDeProductos> productos;
	Pedido pedido;
	MetodoDeEnvio metodo;
	
	@BeforeEach
	void setUp() {
		api = mock(APIBilleteraVirtual.class);
		hoy = LocalDate.now();
		billetera1 = new BilleteraVirtual(api);
		estadoDePedido = mock(Borrador.class);
		cliente = mock(Cliente.class);
		productos = new ArrayList<>();
		metodo = mock(EnvioExpress.class);
		pedido = new Pedido(estadoDePedido, productos, cliente, metodo);
		
	}
	
	@Test
	void testValidarDatosNoMandaExcepcion() {
		when(api.validarSaldoSuficiente(pedido.getMontoTotal())).thenReturn(true);
	    try {
	        billetera1.validarDatos(pedido);
	    } catch (MetodoDePagoException ex) {
	        fail("No se esperaba que se lanzara una excepción, pero se lanzó: " + ex.getMessage());
	    }
	}
	
	@Test
	void testValidarDatosMandaExcepcion() {
		when(api.validarSaldoSuficiente(pedido.getMontoTotal())).thenReturn(false);
	    try {
	        billetera1.validarDatos(pedido);
	        fail("Se esperaba que se lanzara MetodoDePagoException");
	    } catch (MetodoDePagoException ex) {
	        assertEquals("Tu billetera no tiene saldo suficiente para la compra :)", ex.getMessage());
	    }
	}
	
	@Test
	void testReservarFondosLanzaExcepcion() {
	    when(api.bloquearSaldo(pedido.getMontoTotal())).thenReturn(false);

	    try {
	        billetera1.reservarFondos(pedido);
	        fail("Se esperaba que se lanzara MetodoDePagoException");
	    } catch (MetodoDePagoException ex) {
	        assertEquals("No se pudo bloquear el saldo", ex.getMessage());
	    }
	}
	
	@Test
	void testReservarFondosNoLanzaExcepcion() {
	    when(api.bloquearSaldo(pedido.getMontoTotal())).thenReturn(true);

	    try {
	        billetera1.reservarFondos(pedido);
	    } catch (MetodoDePagoException ex) {
	    	fail("No se esperaba que se lanzara una excepción, pero se lanzó: " + ex.getMessage());
	    }
	}
	
	@Test
	void testEjecutarTransaccionLanzaExcepcion() {
	    when(api.acreditarAlVendedor(pedido.getMontoTotal())).thenReturn(false);

	    try {
	        billetera1.ejecutarTransaccion(pedido);;
	        fail("Se esperaba que se lanzara MetodoDePagoException");
	    } catch (MetodoDePagoException ex) {
	        assertEquals("Tu pago no fue acreditado", ex.getMessage());
	    }
	}
	
	@Test
	void testEjecutarTransaccionNoLanzaExcepcion() {
	    when(api.acreditarAlVendedor(pedido.getMontoTotal())).thenReturn(true);

	    try {
	        billetera1.ejecutarTransaccion(pedido);
	    } catch (MetodoDePagoException ex) {
	    	fail("No se esperaba que se lanzara una excepción, pero se lanzó: " + ex.getMessage());
	    }
	}
	
	@Test
	void testNotificarLlamaANotificarDeBilleteraVirtual() {
	  
		billetera1.notificarResultados(pedido);
	    verify(api).notificar();
	}
	
	

}
