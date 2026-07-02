package estadoDePedido;

import ecommerce.*;

public class EnPreparacion implements EstadoDePedido {

	@Override
	public void agregarItem(Pedido pedido, CatalogoDeProductos p) {
		throw new OperacionInvalidaException("No se puede agregar un item en preparacion");

	}

	@Override
	public void quitarItem(Pedido pedido, CatalogoDeProductos p) {
		throw new OperacionInvalidaException("No se puede quitar un item en preparacion");
	}

	@Override
	public void preparar(Pedido pedido) {
		throw new OperacionInvalidaException("No se puede preparar un pedido en preparacion");
	}

	@Override
	public void enviar(Pedido pedido) {
		pedido.setEstado(new Enviado());
	}

	@Override
	public void entregar(Pedido pedido) {
		throw new OperacionInvalidaException("No se puede entregar un pedido en preparacion");
	}


	@Override
	public void cancelarPedido(Pedido pedido) {
		pedido.incrementarStock();
		pedido.generarNotaCreditoProductos();
		pedido.generarNotaCreditoEnvio();
		pedido.setEstado(new Cancelado());
	}

	@Override
	public void confirmarPedido(Pedido pedido) {
		throw new OperacionInvalidaException("No se puede confirmar un pedido en preparacion");
	}

}
