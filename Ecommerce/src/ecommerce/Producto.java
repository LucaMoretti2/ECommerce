package ecommerce;

import java.util.HashMap;
import java.util.Map;

import busquedaPorCatalogo.Criterio;

public class Producto extends CatalogoDeProductos{
	private Integer SKU;
	String nombre;
	String marca;
	Float precio;
	Float peso;
	Float descuento;
	int stock;
	Float alto;
	Float ancho;
	Map<String, Object> atributosDinamicos;
	
	
	
	
	public Producto(int sku, String nombre, String marca, String categoria, Float precio,
			Float peso, Float descuento, int stock) {
		super(nombre, descripcion, categoria);
		this.SKU = sku;
		this.marca = marca;
		this.categoria = categoria;
		this.precio = precio;
		this.peso = peso;
		this.descuento = descuento;
		this.stock = stock;
		this.atributosDinamicos = new HashMap<>();
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
	
	public String getCategoria() {
		return categoria;
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
	
	
	public boolean validar(String[] atributosDinamicosRequeridos) {
		if( this.nombre != null && this.SKU != null) {
			return false;
		}
		if (atributosDinamicosRequeridos != null) {
            for (String atributo : atributosDinamicosRequeridos) {
                if (!this.atributosDinamicos.containsKey(atributo) || this.atributosDinamicos.get(atributo) == null) {
                    return false; 
                }
            }
		}
		return true;
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
	
	public void agregarAtributoDinamico(String nombreAtributo, Object valor) {
        this.atributosDinamicos.put(nombreAtributo, valor);
    }
	
	public Object getAtributoDinamico(String nombreAtributo) {
        return this.atributosDinamicos.get(nombreAtributo);
    }

	@Override
	public boolean tieneStockDisponible() {
		return stock > 0;
		
	}
	
	
	
	
}
