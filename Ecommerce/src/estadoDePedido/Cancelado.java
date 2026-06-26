package estadoDePedido;

import ecommerce.*;
public class Cancelado implements EstadoDePedido {

	@Override
	public void agregarItem(Pedido pedido, CatalogoDeProductos p) {
		throw new OperacionInvalidaException("No se puede agregar un item en cancelado");
	}

	@Override
	public void quitarItem(Pedido pedido, CatalogoDeProductos p) {
		throw new OperacionInvalidaException("No se puede quitar un item en cancelado");
	}

	@Override
	public void preparar(Pedido pedido) {
		throw new OperacionInvalidaException("No se puede preparar un pedido en cancelado");
	}

	@Override
	public void enviar(Pedido pedido) {
		throw new OperacionInvalidaException("No se puede enviar un pedido en cancelado");
	}

	@Override
	public void entregar(Pedido pedido) {
		throw new OperacionInvalidaException("No se puede enviar un entregar en cancelado");
	}


	@Override
	public void cancelarPedido(Pedido pedido) {
		throw new OperacionInvalidaException("No se puede enviar un cancelar en cancelado");
	}

	@Override
	public void confirmarPedido(Pedido pedido) {
		throw new OperacionInvalidaException("No se puede enviar un confirmar en cancelado");
	}

}


