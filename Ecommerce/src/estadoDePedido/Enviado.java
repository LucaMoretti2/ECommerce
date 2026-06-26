package estadoDePedido;

import ecommerce.*;

public class Enviado implements EstadoDePedido {

	@Override
	public void agregarItem(Pedido pedido, CatalogoDeProductos p) {
		throw new OperacionInvalidaException("No se puede agregar un item en enviado");
	}

	@Override
	public void quitarItem(Pedido pedido, CatalogoDeProductos p) {
		throw new OperacionInvalidaException("No se puede quitar un item en enviado");
	}

	@Override
	public void preparar(Pedido pedido) {
		throw new OperacionInvalidaException("No se puede preparar un pedido en enviado");
	}

	@Override
	public void enviar(Pedido pedido) {
		throw new OperacionInvalidaException("No se puede enviar un pedido en enviado");
	}

	@Override
	public void entregar(Pedido pedido) {
		pedido.setEstado(new Entregado());
	}



	@Override
	public void cancelarPedido(Pedido pedido) {
		//reembolsa el costo del producto, no del envio
		pedido.generarNotaCreditoProductos();
		pedido.setEstado(new Cancelado());
	}

	@Override
	public void confirmarPedido(Pedido pedido) {
		throw new OperacionInvalidaException("No se puede confirmar un pedido en enviado");
	}

}
