package ecommerce;

public abstract class CatalogoDeProductos {
	String nombre;
	static String descripcion;
	String categoria;
	
	public abstract float getPrecioFinal();
	public abstract void decrementarStock();
	public abstract void incrementarStock();
	protected abstract float getPeso();
	public abstract boolean tieneStockDisponible();
	public abstract String getCategoria();
	

	public CatalogoDeProductos(String nombre, String descripcion, String categoria) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoria = categoria;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	
}


