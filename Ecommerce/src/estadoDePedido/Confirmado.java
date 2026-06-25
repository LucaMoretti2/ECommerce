package estadoDePedido;

import ecommerce.*;

public class Confirmado implements EstadoDePedido {

	@Override
	public void agregarItem(Pedido pedido, CatalogoDeProductos p) {
		// TODO Auto-generated method stub
		throw new RuntimeException("No se puede agregar un item en confirmado");
	}

	@Override
	public void quitarItem(Pedido pedido, CatalogoDeProductos p) {
		// TODO Auto-generated method stub
		throw new RuntimeException("No se puede quitar un item en confirmado");
	}

	@Override
	public void preparar(Pedido pedido) {
		// TODO Auto-generated method stub
		pedido.decrementarStock();
		pedido.setEstado(new EnPreparacion());
	}

	@Override
	public void enviar(Pedido pedido) {
		// TODO Auto-generated method stub
		throw new RuntimeException("No se puede enviar un pedido en confirmado");
	}

	@Override
	public void entregar(Pedido pedido) {
		// TODO Auto-generated method stub
		throw new RuntimeException("No se puede entregar un pedido en confirmado");
	}


	@Override
	public void cancelarPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		pedido.incrementarStock();
		pedido.setEstado(new Cancelado());
	}

	@Override
	public void confirmarPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		throw new RuntimeException("No se puede confirmar un pedido en confirmado");
	}

}
