package metodosDePago;

import ecommerce.Pedido;

public class BilleteraVirtual extends MetodosDePago{
	
	final APIBilleteraVirtual apiBilletera;
	
	
	public BilleteraVirtual(APIBilleteraVirtual apiBilletera) {
		this.apiBilletera = apiBilletera;
	}
	
	public void validarDatos(Pedido pedido) throws MetodoDePagoException {
		boolean tieneSaldo = apiBilletera.validarSaldoSuficiente(pedido.getMontoTotal());
		if(!tieneSaldo) {
			throw new MetodoDePagoException("Tu billetera no tiene saldo suficiente para la compra :)");
		}
		System.out.println("Tus datos fueron validados con exito");
	}

	public void reservarFondos(Pedido pedido) throws MetodoDePagoException {
		boolean bloqueoConfirmado = apiBilletera.bloquearSaldo(pedido.getMontoTotal());
		if(!bloqueoConfirmado) {
			throw new MetodoDePagoException("No se pudo bloquear el saldo");
		}
		System.out.println("Tu saldo fue bloqueado hasta confirmar la compra");
	}

	public void ejecutarTransaccion(Pedido pedido) throws MetodoDePagoException {
		boolean acreditacion = apiBilletera.acreditarAlVendedor(pedido.getMontoTotal());
		if(!acreditacion) {
			throw new MetodoDePagoException("Tu pago no fue acreditado");
		}
		System.out.println("Tu pago fue acreditado con exito");
	}
	
	public void notificarResultados() {
		apiBilletera.notificar();
	}
	
}
