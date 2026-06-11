package estadoDePedido;


import ecommerce.CatalogoDeProductos;
import ecommerce.Pedido;

public class Borrador implements EstadoDePedido {

	@Override
	public void agregarItem(Pedido ped, CatalogoDeProductos p) {
		// TODO Auto-generated method stub
		ped.agregarProducto(p);
	}

	@Override
	public void quitarItem(Pedido ped, CatalogoDeProductos p) {
		// TODO Auto-generated method stub
		ped.quitarProducto(p);
	}	

	@Override
	public void cancelarPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		pedido.setEstado(new Borrador());
	}

	@Override
	public void confirmarPedido(Pedido pedido) {
		// TODO Auto-generated method stub
		pedido.decrementarStock();
		pedido.setEstado(new Confirmado());
	}

	@Override
	public void preparar(Pedido pedido) {
		// TODO Auto-generated method stub
		throw new RuntimeException("No se puede preparar un pedido en borrador");
	}

	@Override
	public void enviar(Pedido pedido) {
		// TODO Auto-generated method stub
		throw new RuntimeException("No se puede enviar un pedido en borrador");
	}

	@Override
	public void entregar(Pedido pedido) {
		// TODO Auto-generated method stub
		throw new RuntimeException("No se puede entregar un pedido en borrador");
	}
	
}
