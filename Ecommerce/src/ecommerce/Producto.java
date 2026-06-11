package ecommerce;

public class Producto extends CatalogoDeProductos{
	private Integer SKU;
	String nombre;
	String marca;
	String categoria;
	Float precio;
	Float peso;
	Float descuento;
	int stock;
	
	
	public Producto(int sku, String nombre, String marca, String categoria, Float precio,
			Float peso, Float descuento, int stock) {
		super();
		this.SKU = sku;
		this.nombre = nombre;
		this.marca = marca;
		this.categoria = categoria;
		this.precio = precio;
		this.peso = peso;
		this.descuento = descuento;
		this.stock = stock;
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

	public float getPrecioFinal() {
		return precio * (1 - descuento);
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(Float peso) {
		this.peso = peso;
	}
	
	public Float getDescuento() {
		return descuento;
	}
	
	public void setDescuento(Float descuento) {
		this.descuento = descuento;
	}
	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	public boolean validar() {
		return this.nombre != null && this.SKU != null;
	}

	@Override
	public void decrementarStock() {
		// TODO Auto-generated method stub
		stock--;
	}

	@Override
	public void incrementarStock() {
		// TODO Auto-generated method stub
		stock++;
	}
	
	
	
	
	
}
