package estadoDePedido;

import ecommerce.*;

public class EnPreparacion implements EstadoDePedido {

	@Override
	public void agregarItem(Pedido pedido, CatalogoDeProductos p) {
		// TODO Auto-generated method stub
		
		throw new RuntimeException("No se puede agregar un item en preparacion");

	}

	@Override
	public void quitarItem(Pedido pedido, CatalogoDeProductos p) {
		// TODO Auto-generated method stub
		throw new RuntimeException("No se puede quitar un item en preparacion");
	}

	@Override
	public void preparar(Pedido pedido) {
		// TODO Auto-generated method stub
		throw new RuntimeException("No se puede preparar un pedido en preparacion");
	}

	@Override
	public void enviar(Pedido pedido) {
		// TODO Auto-generated method stub
		pedido.setEstado(new Enviado());
	}

	@Override
	public void entregar(Pedido pedido) {
		// TODO Auto-generated method stub
		throw new RuntimeException("No se puede entregar un pedido en preparacion");
	}


	@Override
	public void cancelarPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		//REPONER STOCK
		pedido.incrementarStock();
		pedido.generarNotaCreditoProductos();
		pedido.generarNotaCreditoEnvio();
		pedido.setEstado(new Cancelado());
	}

	@Override
	public void confirmarPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		throw new RuntimeException("No se puede confirmar un pedido en preparacion");
	}

}
