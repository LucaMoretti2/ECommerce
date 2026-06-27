package ecommerceTestCase;

import static org.junit.jupiter.api.Assertions.*;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import ecommerce.*;
import envio.*;
import notificacion.*;
import estadoDePedido.*;
import metodosDePago.*;
import notificacion.NotificadorDeMail;

public class PaqueteTestCase {

	Paquete paquete;
	Producto producto;
	CatalogoDeProductos componente1;
	CatalogoDeProductos componente2;
	
	
	@BeforeEach
	void setUp() {
		paquete = new Paquete("Combo electrodomesticos", "Estufas, microondas, ventiladores", "Electronica");
		producto = new Producto(212, "Auriculares", "Sony", "Electrodomesticos", 100f,
				2.5f, 10f, 0); // 100 precio, 2.5 peso, 10f descuento 
		componente1 = mock(CatalogoDeProductos.class);
		componente2 = mock(CatalogoDeProductos.class);
	}
	
	@Test
	void testAgregarProducto() {
		
		paquete.agregarProducto(producto);
		assertEquals(paquete.getProductos().size(),1);
	}
	
	@Test
	void testQuitarProducto() {
		
		paquete.agregarProducto(producto);
		paquete.quitarProducto(producto);
		assertEquals(paquete.getProductos().size(),0);
	}
	
	@Test
	void testGetPrecioFinal() {
		Producto producto2 = new Producto(314, "Auriculares", "Realtek", "Electrodomesticos", 100f,
				2.5f, 10f, 0);
		paquete.agregarProducto(producto);
		paquete.agregarProducto(producto2);
		
		assertEquals(paquete.getPrecioFinal(), 200f);
		
	}
}
