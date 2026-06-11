package ecommerce;

import java.util.List;

public class Paquete extends CatalogoDeProductos{
	
	 List<CatalogoDeProductos> productos;
	 float descuento;
	
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
	
}
