package metodosDePago;

import ecommerce.Pedido;

public abstract class MetodosDePago {
	
	Pedido pedido;
	
	public final void finalizarPago() throws MetodoDePagoException {
		validarDatos(pedido);
		reservarFondos(pedido);
		ejecutarTransaccion(pedido);
		notificarResultados();
	}
	public abstract void validarDatos(Pedido pedido) throws MetodoDePagoException;
	public abstract void reservarFondos(Pedido pedido) throws MetodoDePagoException;
	public abstract void ejecutarTransaccion(Pedido pedido) throws MetodoDePagoException;
	public abstract void notificarResultados();
}
