package ecommerce;

public class NotaDeCredito {
	
	String NotaID;
	Cliente cliente;
	Float montoAReembolsar;
	
	public NotaDeCredito(String id, Cliente cliente, Float monto) {
		this.NotaID = id;
		this.cliente = cliente;
		this.montoAReembolsar = monto;
	}
	
	public Float getMontoAReembolsar() {
		return montoAReembolsar;
	}
	
	public String getClienteID() {
		return cliente.id;
		
	}
}

