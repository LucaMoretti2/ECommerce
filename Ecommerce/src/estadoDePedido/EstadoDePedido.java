package estadoDePedido;

import ecommerce.CatalogoDeProductos;
import ecommerce.Pedido;

public interface EstadoDePedido {

	void agregarItem(Pedido pedido, CatalogoDeProductos p);
	void quitarItem(Pedido pedido, CatalogoDeProductos p);
	void preparar(Pedido pedido);
	void enviar(Pedido pedido);
	void entregar(Pedido pedido);
	void cancelarPedido(Pedido pedido);
	void confirmarPedido(Pedido pedido);
	
}
