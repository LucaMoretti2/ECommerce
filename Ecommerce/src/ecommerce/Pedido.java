package ecommerce;

import java.util.List;

public class Pedido {

	EstadoDePedido estadoActual;
	List<CatalogoDeProductos> productos;
	float peso;
	float precio;
	MetodoDeEnvio metodoDeEnvio;
	//MetodoDePago metodoDePago;
	//List<ObservadorDePedido> observadores;
	
	public Pedido(EstadoDePedido e, List<CatalogoDeProductos> p) {
		this.estadoActual = e;
		this.productos = p;
	}
	
	public void agregarProducto(CatalogoDeProductos p) {
		productos.add(p);
	}
	
	public void quitarProducto(CatalogoDeProductos p) {
		productos.remove(p);
	}
	
	public void setEstado(EstadoDePedido e) {
		this.estadoActual = e;
	}
	
	public EstadoDePedido getEstado() {
		return this.estadoActual;
	}
	
	public void agregarItem(CatalogoDeProductos p){
		estadoActual.agregarItem(this, p);
	}
	
	public void quitarItem(CatalogoDeProductos p){
		estadoActual.quitarItem(this, p);;
	}
	
	public void confirmarPedido() {
		//decremetarStock();
		estadoActual.confirmarPedido(this);
	}
	
	public void decrementarStock() {
		// TODO Auto-generated method stub
		for(CatalogoDeProductos p: productos) {
			p.decrementarStock();
		}
	}


	public void cancelarPedido() {
		estadoActual.cancelarPedido(this);
	}
	
	public void preparar() {
		estadoActual.preparar(this);
	}
	
	public void enviar() {
		estadoActual.enviar(this);
	}
	
	public void entregar() {
		estadoActual.entregar(this);
	}

	public void incrementarStock() {
		// TODO Auto-generated method stub
		for(CatalogoDeProductos p: productos) {
			p.incrementarStock();
		}
	}

	public void generarNotaCreditoProductos() {
		// TODO Auto-generated method stub
		//ver como hacer la nota de credito
	}

	public void generarNotaCreditoEnvio() {
		// TODO Auto-generated method stub
		
	}
	
	public float getPeso() {
		float peso = 0;
		for(CatalogoDeProductos p: productos) {
			peso += p.getPeso();
		}
		return peso;
	}
	
	public float getPrecio() {
		float precio = 0;
		for(CatalogoDeProductos p: productos) {
			precio += p.getPrecioFinal();
		}
		return precio;
	}
	
	public double calcularCostoDeEnvio() {
		return this.metodoDeEnvio.costoDeEnvio(this);
		
		
	}
	
	
	
}
