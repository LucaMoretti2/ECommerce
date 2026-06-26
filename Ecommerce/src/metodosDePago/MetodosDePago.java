package metodosDePago;

import ecommerce.Pedido;

public abstract class MetodosDePago {
	
	public final void finalizarPago(Pedido pedido) throws MetodoDePagoException {
		validarDatos(pedido);
		reservarFondos(pedido);
		ejecutarTransaccion(pedido);
		notificarResultados(pedido);
	}
	public abstract void validarDatos(Pedido pedido) throws MetodoDePagoException;
	public abstract void reservarFondos(Pedido pedido) throws MetodoDePagoException;
	public abstract void ejecutarTransaccion(Pedido pedido) throws MetodoDePagoException;
	public abstract void notificarResultados(Pedido pedido);
}
