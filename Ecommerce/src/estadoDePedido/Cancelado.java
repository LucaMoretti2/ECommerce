package estadoDePedido;

import ecommerce.*;
public class Cancelado implements EstadoDePedido {

	@Override
	public void agregarItem(Pedido pedido, CatalogoDeProductos p) {
		// TODO Auto-generated method stub
		throw new RuntimeException("No se puede agregar un item en cancelado");
	}

	@Override
	public void quitarItem(Pedido pedido, CatalogoDeProductos p) {
		// TODO Auto-generated method stub
		throw new RuntimeException("No se puede quitar un item en cancelado");
	}

	@Override
	public void preparar(Pedido pedido) {
		// TODO Auto-generated method stub
		throw new RuntimeException("No se puede preparar un pedido en cancelado");
	}

	@Override
	public void enviar(Pedido pedido) {
		// TODO Auto-generated method stub
		throw new RuntimeException("No se puede enviar un pedido en cancelado");
	}

	@Override
	public void entregar(Pedido pedido) {
		// TODO Auto-generated method stub
		throw new RuntimeException("No se puede enviar un entregar en cancelado");
	}


	@Override
	public void cancelarPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		throw new RuntimeException("No se puede enviar un cancelar en cancelado");
	}

	@Override
	public void confirmarPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		throw new RuntimeException("No se puede enviar un confirmar en cancelado");
	}

}


