package ecommerce;

public class Cliente {
	String id;
	String direccion;
	String mail;
	Pedido pedido;
	
	public Cliente(String id, String direccion, String mail) {
		this.id = id;
		this.direccion = direccion;
		this.mail = mail;
	}
	
	public String getID() {
		return id;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setPedido(Pedido p) {
		this.pedido = p;
	}
}
