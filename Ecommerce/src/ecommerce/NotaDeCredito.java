package ecommerce;

public class NotaDeCredito {
	
	
	Cliente cliente;
	Float montoAReembolsar;
	Pedido pedido;
	
	public NotaDeCredito( Cliente cliente, Float monto, Pedido pedido) {
		
		this.cliente = cliente;
		this.montoAReembolsar = monto;
		this.pedido = pedido;
	}
	
	public Float getMontoAReembolsar() {
		return montoAReembolsar;
	}
	
	public Float getMontoAReembolsar1() {
		return pedido.getMontoTotal();
	}
	
	public String getClienteID() {
		return cliente.id;
		
	}
	
	public Pedido getPedido() {
		return pedido;
	}
}

