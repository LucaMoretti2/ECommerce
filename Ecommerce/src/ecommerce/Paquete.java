package ecommerce;

import java.util.List;

import reporte.ReporteVisitor;

public class Paquete extends CatalogoDeProductos{
	
	
	 List<CatalogoDeProductos> productos;
	 float descuento;
	 float peso;
	 
	  public Paquete(String nombre, String descripcion, String categoria) {
		super(nombre, descripcion, categoria);
	
	}

	public void aceptar(ReporteVisitor visitor) {
			visitor.visitarPaquete(this);
	}
	
	public void agregarProducto(CatalogoDeProductos producto) {
		this.productos.add(producto);
	}
	
	public void quitarProducto(CatalogoDeProductos producto) {
		this.productos.remove(producto);
	}
	
	public float getPrecioFinal() {
		
		float precioFinal = 0;
		for (CatalogoDeProductos p : productos) {
			precioFinal += p.getPrecioFinal();
		}
		return precioFinal * 	(1 - descuento);
	}

	@Override
	public void decrementarStock() {
		// TODO Auto-generated method stub
		for(CatalogoDeProductos p: productos) {
			p.decrementarStock();
		}
	}

	@Override
	public void incrementarStock() {
		// TODO Auto-generated method stub
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


	@Override
	public String getCategoria() {
		
		return categoria;
	}
	
}
