package ecommerce;

import java.util.HashMap;
import java.util.Map;
import reporte.ReporteVisitable;
import reporte.ReporteVisitor;

public class Producto extends CatalogoDeProductos implements ReporteVisitable{
	private Integer SKU;
	String marca;
	float precio;
	float descuento;
	float peso;
	int stock;
	Map<String, Object> atributosDinamicos;
	
	
	public Producto(int sku, String nombre, String marca, String categoria, Float precio,
			Float peso, Float descuento, int stock) {
		super(nombre, null, categoria);
		this.SKU = sku;
		this.marca = marca;
		this.precio = precio;
		this.peso = peso;
		this.descuento = descuento;
		this.stock = stock;
		this.atributosDinamicos = new HashMap<>();
	}
	
	public int getSKU() {
		return SKU;
	}

	public String getNombre() {
		return nombre;
	}

	public String getMarca() {
		return marca;
	}

	public float getPrecio() {
		return precio;
	}
	
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	
	public float getPrecioFinal() {
		return  precio * ((100 - descuento)/100);
	}
	

	public float getPeso() {
		return peso;
	}

	
	public float getDescuento() {
		return descuento;
	}
	
	public void setDescuento(Float descuento) {
		this.descuento = descuento;
	}
	
	public int getStock() {
		return stock;
	}
	
	
	public boolean validar(String[] atributosDinamicosRequeridos) {
		if( this.nombre == null || this.SKU == null) {
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
	
	public void aceptar(ReporteVisitor visitor) {
		visitor.visitarProducto(this);
	}
	
}
