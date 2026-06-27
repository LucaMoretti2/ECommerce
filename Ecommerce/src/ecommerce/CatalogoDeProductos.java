package ecommerce;

public abstract class CatalogoDeProductos {
	String nombre;
	String descripcion;
	String categoria;
	int cantidadVendida;
	
	public abstract float getPrecioFinal();
	public abstract void decrementarStock();
	public abstract void incrementarStock();
	protected abstract float getPeso();
	public abstract boolean tieneStockDisponible();
	public abstract int getStock();
	public abstract float getPrecio();

	public CatalogoDeProductos(String nombre, String descripcion, String categoria) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoria = categoria;
	}
	
	
	public String getNombre() {
		return nombre;
	}

	public int getCantidadVendida() {
		return cantidadVendida;
	}
	
	public void incrementarCantidadVendida() {
		cantidadVendida ++;
	}
	
	public String getCategoria() {
		
		return categoria;
	}
	
}


