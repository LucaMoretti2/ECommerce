package estadoDePedido;


import ecommerce.CatalogoDeProductos;
import ecommerce.Pedido;

public class Borrador implements EstadoDePedido {

	@Override
	public void agregarItem(Pedido ped, CatalogoDeProductos p) {
		ped.agregarProducto(p);
	}

	@Override
	public void quitarItem(Pedido ped, CatalogoDeProductos p) {
		ped.quitarProducto(p);
	}	

	@Override
	public void cancelarPedido(Pedido pedido) {
		pedido.setEstado(new Cancelado());
	}

	@Override
	public void confirmarPedido(Pedido pedido) {
		pedido.setEstado(new Confirmado());
	}

	@Override
	public void preparar(Pedido pedido) {
		throw new OperacionInvalidaException("No se puede preparar un pedido en borrador");
	}

	@Override
	public void enviar(Pedido pedido) {
		throw new OperacionInvalidaException("No se puede enviar un pedido en borrador");
	}

	@Override
	public void entregar(Pedido pedido) {
		throw new OperacionInvalidaException("No se puede entregar un pedido en borrador");
	}
	
}
