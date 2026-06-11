package ecommerce;

public interface EstadoDePedido {

	void agregarItem(Pedido pedido, CatalogoDeProductos p);
	void quitarItem(Pedido pedido, CatalogoDeProductos p);
	void preparar(Pedido pedido);
	void enviar(Pedido pedido);
	void entregar(Pedido pedido);
	void cancelarPedido(Pedido pedido);
	void confirmarPedido(Pedido pedido);
	
}

//hay que cambiar las excepciones porque el enunciado dice "Intentar una operación inválida debe lanzar una excepción de dominio propia, no una excepción genérica."