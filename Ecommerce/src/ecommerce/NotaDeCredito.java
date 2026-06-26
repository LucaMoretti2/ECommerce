package ecommerce;

public class NotaDeCredito {
	
	
	Cliente cliente;
	Float montoAReembolsar;
	Pedido pedido;
	
	public NotaDeCredito(Cliente cliente, Float monto, Pedido pedido) {
		
		this.cliente = cliente;
		this.montoAReembolsar = monto;
		this.pedido = pedido;
	}
	
	public Float getMontoAReembolsar() {
		return montoAReembolsar;
	}
	
	
	public String getClienteID() {
		return cliente.getID();
		
	}
	
	public Pedido getPedido() {
		return pedido;
	}
}

