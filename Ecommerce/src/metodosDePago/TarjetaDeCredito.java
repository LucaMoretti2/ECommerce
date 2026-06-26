package metodosDePago;

import java.time.LocalDate;

import ecommerce.Pedido;

public class TarjetaDeCredito extends MetodosDePago {
	final APITarjetaDeCredito apiTarjeta;
	String numeroDeTarjeta;
	String cvv;
	LocalDate vencimiento;
	LocalDate hoy = LocalDate.now();
	
	
	public TarjetaDeCredito(APITarjetaDeCredito apiTarjeta, String numeroDeTarjeta, String cvv, LocalDate vencimiento) {
		this.apiTarjeta = apiTarjeta;
		this.numeroDeTarjeta = numeroDeTarjeta;
		this.cvv = cvv;
		this.vencimiento = vencimiento;
	}
	
	public void validarDatos(Pedido pedido) throws MetodoDePagoException{
		if (numeroDeTarjeta.length() != 16 || cvv.length() != 3 || vencimiento.isBefore(hoy)) {
			throw new MetodoDePagoException("Los datos de la tarjeta son incorrectos");
		}
		System.out.println("Los datos de la tarjeta fueron validados");
	};
	
	
	public void reservarFondos(Pedido pedido) throws MetodoDePagoException {
		if(!apiTarjeta.preAutorizarMonto(pedido.getMontoTotal())) {
			throw new MetodoDePagoException("El pago no fue autorizado por la identidad bancaria");
		}
		System.out.println("El monto" + pedido.getMontoTotal() + "fue reservado en la tarjeta");
	}
	
	
	public void ejecutarTransaccion(Pedido pedido) throws MetodoDePagoException {
		if(!apiTarjeta.transferenciaRealizada()) {
			throw new MetodoDePagoException("La transferencia no fue enviada");
		}
		System.out.println("El monto" + pedido.getMontoTotal() + "fue transferido con exito");
	};
	
	
	public void notificarResultados(Pedido pedido) {
		 String cupon = "Cupón de pago - Tarjeta: " + numeroDeTarjeta;
		 pedido.agregarComprobante(cupon);
	}

	
	
}
