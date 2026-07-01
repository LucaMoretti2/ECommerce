package ecommerce;

import envio.Direccion;

public class Cliente {
	String id;
	Direccion direccion;
	String mail;
	Pedido pedido;
	
	public Cliente(String id, Direccion direccion, String mail) {
		this.id = id;
		this.direccion = direccion;
		this.mail = mail;
	}
	
	public String getID() {
		return id;
	}
	
	public Direccion getDireccion() {
		return direccion;
	}
	
	public String getMail() {
		return mail;
	}
	
	public void setPedido(Pedido p) {
		this.pedido = p;
	}
	
	public Pedido getPedido() {
		return this.pedido;
	}
}
