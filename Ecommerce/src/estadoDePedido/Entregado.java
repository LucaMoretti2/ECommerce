package estadoDePedido;


import ecommerce.*;
public class Entregado implements EstadoDePedido {

	@Override
	public void agregarItem(Pedido pedido, CatalogoDeProductos p) {
		// TODO Auto-generated method stub
		throw new RuntimeException("No se puede agregar un item en entregado");
	}

	@Override
	public void quitarItem(Pedido pedido, CatalogoDeProductos p) {
		// TODO Auto-generated method stub
		throw new RuntimeException("No se puede quitar un item en entregado");
	}

	@Override
	public void preparar(Pedido pedido) {
		// TODO Auto-generated method stub
		throw new RuntimeException("No se puede preparar un pedido en entregado");
	}

	@Override
	public void enviar(Pedido pedido) {
		// TODO Auto-generated method stub
		throw new RuntimeException("No se puede enviar un pedido en entregado");
	}

	@Override
	public void entregar(Pedido pedido) {
		// TODO Auto-generated method stub
		throw new RuntimeException("No se puede entregar un pedido en entregado");
	}

	@Override
	public void cancelarPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		throw new RuntimeException("No se puede cancelar un pedido en entregado");
	}

	@Override
	public void confirmarPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		throw new RuntimeException("No se puede confirmar un pedido en entregado");
	}
	//asd

}
