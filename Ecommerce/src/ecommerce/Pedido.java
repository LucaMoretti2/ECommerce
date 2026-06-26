package ecommerce;

import java.util.ArrayList;
import java.util.List;

import envio.Direccion;
import envio.MetodoDeEnvio;
import estadoDePedido.EstadoDePedido;
import metodosDePago.MetodoDePagoException;
import metodosDePago.MetodosDePago;
import notificacion.*;

public class Pedido {

	EstadoDePedido estadoActual;
	EstadoDePedido estadoAnterior;
	List<CatalogoDeProductos> productos;
	MetodoDeEnvio metodoDeEnvio;
	MetodosDePago metodoDePago;
	List<ObservadorDePedido> observadores;
	Cliente cliente;
	List<NotaDeCredito> notasDeCredito;
	Direccion direccionDeEntrega;
	List<String> comprobantes;
	
	public Pedido(EstadoDePedido e, List<CatalogoDeProductos> p) {
		this.estadoActual = e;
		this.productos = p;
		this.observadores = new ArrayList<>();
	    this.notasDeCredito = new ArrayList<>();
	    this.comprobantes = new ArrayList<>();
	}
	
	public Cliente getCliente() {
		return cliente;
	}
	
	public void agregarProducto(CatalogoDeProductos p) {
		productos.add(p);
	}
	
	public void quitarProducto(CatalogoDeProductos p) {
		productos.remove(p);
	}
	
	public void setEstado(EstadoDePedido e) {
		this.estadoAnterior = this.estadoActual;
		this.estadoActual = e;
		notificar(estadoAnterior, estadoActual);
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
		estadoActual.confirmarPedido(this);
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
	
	public void decrementarStock() {
		// TODO Auto-generated method stub
		for(CatalogoDeProductos p: productos) {
			p.decrementarStock();
			p.incrementarCantidadVendida();
		}
	}

	public void generarNotaCreditoProductos() {
		generarNotaDeCredito(getPrecio());
	}

	public void generarNotaCreditoEnvio() {
		generarNotaDeCredito(calcularCostoDeEnvio());
	}
	
	public NotaDeCredito generarNotaDeCredito(float monto) {
		NotaDeCredito nota = new NotaDeCredito(cliente, monto, this);
		notasDeCredito.add(nota);
		return nota;
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
	
	public List<CatalogoDeProductos> getProductos(){
		return productos;
	}
	
	public float calcularCostoDeEnvio() {
		return this.metodoDeEnvio.costoDeEnvio(this);
	}
	
	public void agregarObservador(ObservadorDePedido obs) {
		observadores.add(obs);
	}
	
	public void quitarObservador(ObservadorDePedido obs) {
		observadores.remove(obs);
	}
	
	public void notificar(EstadoDePedido anterior, EstadoDePedido nuevo){
		for(ObservadorDePedido obs: observadores) {
			obs.actualizar(this, anterior, nuevo);
		}
	}
	
	public float getMontoTotal() {
		return (getPrecio() + calcularCostoDeEnvio());
	}
	
	public Direccion getDireccionDeEntrega() {
	    return direccionDeEntrega;
	}

	public void agregarComprobante(String comprobante) {
		comprobantes.add(comprobante);
	}
	
	public void setMetodoDeEnvio(MetodoDeEnvio metodoDeEnvio) {
	    this.metodoDeEnvio = metodoDeEnvio;
	}
	
	public void setMetodoDePago(MetodosDePago metodoDePago) {
	    this.metodoDePago = metodoDePago;
	}
	public void realizarPago() throws MetodoDePagoException {
	    metodoDePago.finalizarPago(this);
	}
	
	
}
