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
	
}
