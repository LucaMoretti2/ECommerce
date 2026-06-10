package ecommerce;

public class Producto extends CatalogoDeProductos{
	private Integer SKU;
	String nombre;
	String marca;
	String categoria;
	Float precio;
	Float precioFinal;
	Float peso;
	Float descuento;
	
	
	public Producto(int sku, String nombre, String marca, String categoria, Float precio, Float precioFinal,
			Float peso) {
		super();
		this.SKU = sku;
		this.nombre = nombre;
		this.marca = marca;
		this.categoria = categoria;
		this.precio = precio;
		this.precioFinal = precioFinal;
		this.peso = peso;
	}

	public int getSKU() {
		return SKU;
	}

	public void setSKU(int sku) {
		SKU = sku;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public Float getPrecioFinal() {
		return precioFinal;
	}

	public void setPrecioFinal(Float precioFinal) {
		this.precioFinal = precio * this.descuento;
	}

	public Float getPeso() {
		return peso; // pesoo
		
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}
	
	public boolean validar() {
		
		return this.nombre != null && this.SKU != null;
		
	}
	
	
	
	
	
}
