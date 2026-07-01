package metodoDePagoTestCase;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import ecommerce.Pedido;
import metodosDePago.APITarjetaDeCredito;
import metodosDePago.MetodoDePagoException;
import metodosDePago.TarjetaDeCredito;

class MetodosDePagoTestCase {

	TarjetaDeCredito tarjeta;
	Pedido pedido;

	@BeforeEach
	void setUp() {
		APITarjetaDeCredito api = mock(APITarjetaDeCredito.class);
		when(api.preAutorizarMonto(500f)).thenReturn(true);
		when(api.transferenciaRealizada()).thenReturn(true);
		tarjeta = spy(new TarjetaDeCredito(api, "3921932193921934", "832", LocalDate.now().plusYears(1)));
		pedido = mock(Pedido.class);
		when(pedido.getMontoTotal()).thenReturn(500f);
	}

	@Test
	void testFinalizarPagoEjecutaLosCuatroPasosEnOrden() throws MetodoDePagoException {
		
		tarjeta.finalizarPago(pedido);
		verify(tarjeta).validarDatos(pedido);
		verify(tarjeta).reservarFondos(pedido);
		verify(tarjeta).ejecutarTransaccion(pedido);
		verify(tarjeta).notificarResultados(pedido);
	}

}
