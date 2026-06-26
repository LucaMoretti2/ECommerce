package estadoDePedido;

import ecommerce.*;

public class Confirmado implements EstadoDePedido {

	@Override
	public void agregarItem(Pedido pedido, CatalogoDeProductos p) {
		throw new OperacionInvalidaException("No se puede agregar un item en confirmado");
	}

	@Override
	public void quitarItem(Pedido pedido, CatalogoDeProductos p) {
		throw new OperacionInvalidaException("No se puede quitar un item en confirmado");
	}

	@Override
	public void preparar(Pedido pedido) {
		pedido.decrementarStock();
		pedido.setEstado(new EnPreparacion());
	}

	@Override
	public void enviar(Pedido pedido) {
		throw new OperacionInvalidaException("No se puede enviar un pedido en confirmado");
	}

	@Override
	public void entregar(Pedido pedido) {
		throw new OperacionInvalidaException("No se puede entregar un pedido en confirmado");
	}


	@Override
	public void cancelarPedido(Pedido pedido) {
		pedido.setEstado(new Cancelado());
	}

	@Override
	public void confirmarPedido(Pedido pedido) {
		throw new OperacionInvalidaException("No se puede confirmar un pedido en confirmado");
	}

}
