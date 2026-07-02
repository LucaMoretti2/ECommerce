package ecommerce;

import java.util.ArrayList;
import java.util.List;
import reporte.ReporteVisitable;
import reporte.ReporteVisitor;

public class Paquete extends CatalogoDeProductos implements ReporteVisitable{
	
	List<CatalogoDeProductos> productos;
	float descuento;
	float peso;
	 
	public Paquete(String nombre, String descripcion, String categoria, float descuento) {
		super(nombre, descripcion, categoria);
		this.productos = new ArrayList<>();
		this.descuento = descuento;
	}

	
	
	public void agregarProducto(CatalogoDeProductos producto) {
		this.productos.add(producto);
	}
	
	public void quitarProducto(CatalogoDeProductos producto) {
		this.productos.remove(producto);
	}
	

	@Override
	public void decrementarStock() {
		for(CatalogoDeProductos p: productos) {
			p.decrementarStock();
		}
	}

	@Override
	public void incrementarStock() {
		for(CatalogoDeProductos p: productos) {
			p.incrementarStock();
		}
	}
	
	public float getPeso() {
		float peso= 0;
		for(CatalogoDeProductos p: productos) {
			peso += p.getPeso();
		}
		return peso;
	}
	
	@Override
	public boolean tieneStockDisponible() {
		for(CatalogoDeProductos p: productos) {
			if(p.tieneStockDisponible()) {
				return true;
			}
		}
		return false;
	}
	
	
	public void aceptar(ReporteVisitor visitor) {
		visitor.visitarPaquete(this);
	}

	@Override
	public int getStock() {
		int cantidadDeStock = 0;
		for(CatalogoDeProductos p: productos ) {
			cantidadDeStock += p.getStock();
		}
		return cantidadDeStock;
	}

	@Override
	public float getPrecio() {
		float precioBase = 0;
		for (CatalogoDeProductos p : productos) {
			precioBase += p.getPrecio();
		}
		return precioBase ;
	}
	
	
	public float getPrecioFinal() {
		return getPrecio() * ((100 - this.descuento) /100);
	}
	
	
	public List<CatalogoDeProductos> getProductos(){
		return productos;
	}

}
