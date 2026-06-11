package ecommerce;

public abstract class CatalogoDeProductos {
	String nombre;
	String descripcion;
	
	public abstract float getPrecioFinal();
	public abstract void decrementarStock();
	public abstract void incrementarStock();
}


