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

class PedidoTestCase {
	EstadoDePedido estadoDePedido;
	List<CatalogoDeProductos> productos;
	Cliente cliente;
	Pedido pedido;
	CatalogoDeProductos producto1;
	Direccion direccion;
	MetodoDeEnvio metodo;
	
	@BeforeEach
	void setUp() {
		productos = new ArrayList<>();
		estadoDePedido = new Borrador();
		direccion = new Direccion("Saenz Peña", "Quilmes", "Buenos Aires", "1978");
		cliente = new Cliente("123", direccion, "dasdas@gmail.com");
		metodo = mock(MetodoDeEnvio.class);
		pedido = new Pedido(estadoDePedido,productos,cliente, metodo);
		producto1 = mock(Producto.class);
	}
	@Test
	
	void testGetCliente() {
		assertEquals(pedido.getCliente(),cliente);
	}
	
	@Test
	void testAgregarProducto() {
		pedido.agregarProducto(producto1);
		assertEquals(pedido.getProductos().size(),1);
	}
	
	@Test
	void testQuitarProducto() {
		pedido.agregarProducto(producto1);
		pedido.quitarProducto(producto1);
		assertEquals(pedido.getProductos().size(),0);
	}
	
	@Test
	void testSetEstado() {
		EstadoDePedido estadoDePedidoNuevo = mock(EnPreparacion.class);
		pedido.setEstado(estadoDePedidoNuevo);
		assertEquals(pedido.getEstado(),estadoDePedidoNuevo);
	}
	
	@Test
	void testGetEstado() {
		assertEquals(pedido.getEstado(),estadoDePedido);
	}
	
	@Test
	void testAgregarItem() {
		EstadoDePedido estadoDePedidoNuevo = new Borrador();
		pedido.setEstado(estadoDePedidoNuevo);
		pedido.getEstado().agregarItem(pedido, producto1);
		assertEquals(pedido.getProductos().size(),1);
	}
	
	@Test
	void testQuitarItem() {
		EstadoDePedido estadoDePedidoNuevo = new Borrador();
		pedido.setEstado(estadoDePedidoNuevo);
		pedido.getEstado().agregarItem(pedido, producto1);
		pedido.getEstado().quitarItem(pedido, producto1);
		assertEquals(pedido.getProductos().size(),0);
	}
	
	@Test
	void testConfirmarPedido() {
		EstadoDePedido estadoDePedidoNuevo = new Borrador();
		pedido.setEstado(estadoDePedidoNuevo);
		pedido.confirmarPedido();
		assertFalse(pedido.getEstado() == estadoDePedidoNuevo);
	}
	
	@Test
	void testCancelarPedido() {
		pedido.cancelarPedido();
		assertFalse(pedido.getEstado() == estadoDePedido);
	}
	
	@Test
	void testPreparar() {
		EstadoDePedido estadoDePedidoNuevo = new Confirmado();
		pedido.setEstado(estadoDePedidoNuevo);
		pedido.preparar();
		assertFalse(pedido.getEstado() == estadoDePedido);
	}
	
	@Test
	void testEnviar() {
		EstadoDePedido estadoDePedidoNuevo = new EnPreparacion();
		pedido.setEstado(estadoDePedidoNuevo);
		pedido.enviar();
		assertFalse(pedido.getEstado() == estadoDePedido);
	}

	@Test
	void testEntregar() {
		EstadoDePedido estadoDePedidoNuevo = new Enviado();
		pedido.setEstado(estadoDePedidoNuevo);
		pedido.entregar();
		assertFalse(pedido.getEstado() == estadoDePedido);
	}
	
	@Test
	void testIncrementarStock() {
		CatalogoDeProductos producto = new Producto(12,"Coca","COCA-COLA","Bebida",120.0f,10.0f,0f,1);
		pedido.agregarProducto(producto);
		pedido.incrementarStock();
		assertEquals(producto.getStock(),2);
	}
	
	@Test
	void testDecrementarStock() {
		CatalogoDeProductos producto = new Producto(12,"Coca","COCA-COLA","Bebida",120.0f,10.0f,0f,1);
		pedido.agregarProducto(producto);
		pedido.decrementarStock();
		assertEquals(producto.getStock(),0);
	}
	
	@Test
	void testGenerarNotaDeCreditoProductos() {
		pedido.generarNotaCreditoProductos();
		assertEquals(pedido.getNotasDeCredito().size(),1);
	}
	
	@Test
	void testGenerarNotaDeCreditoEnvio() {
		MetodoDeEnvio metodo = mock(EnvioEstandar.class);
		pedido.setMetodoDeEnvio(metodo);
		pedido.generarNotaCreditoEnvio();
		assertEquals(pedido.getNotasDeCredito().size(),1);
	}
	
	@Test
	void getPeso() {
		CatalogoDeProductos producto = new Producto(12,"Coca","COCA-COLA","Bebida",120.0f,10.0f,0f,1);
		pedido.agregarProducto(producto);
		assertEquals(pedido.getPeso(),10.0f);
	}

	@Test
	void getPrecio() {
		CatalogoDeProductos producto = new Producto(12,"Coca","COCA-COLA","Bebida",120.0f,10.0f,0f,1);
		pedido.agregarProducto(producto);
		assertEquals(pedido.getPrecio(),120.0f);
	}
	
	@Test
	void calcularCostoDeEnvio() {
		CatalogoDeProductos producto = new Producto(12,"Coca","COCA-COLA","Bebida",120.0f,10.0f,0f,1);
		pedido.agregarProducto(producto);
		MetodoDeEnvio metodo = new RetiroEnSucursal();
		pedido.setMetodoDeEnvio(metodo);
		assertEquals(pedido.calcularCostoDeEnvio(),0.0f);
	}
	
	@Test
	void testAgregarObservador() {
		ObservadorDePedido obs = mock(NotificadorDeMail.class);
		pedido.agregarObservador(obs);
		assertEquals(pedido.getObservadores().size(),1);
	}
	
	@Test
	void testQuitarObservador() {
		ObservadorDePedido obs = mock(NotificadorDeMail.class);
		pedido.agregarObservador(obs);
		pedido.quitarObservador(obs);
		assertEquals(pedido.getObservadores().size(),0);
	}
	
	/*@Test
	void testNotificador() {
		ObservadorDePedido obs = mock(NotificadorDeMail.class);
		pedido.agregarObservador(obs);
		pedido.notificar(estadoDePedido, estadoDePedido);
		assertEquals(pedido.getObservadores().size(),1);
	} HAY QUE FIJARSE ESTE*/
	
	@Test
	void testGetMontoTotal() {
		CatalogoDeProductos producto = new Producto(12,"Coca","COCA-COLA","Bebida",120.0f,10.0f,0f,1);
		pedido.agregarProducto(producto);
		MetodoDeEnvio metodo = new RetiroEnSucursal();
		pedido.setMetodoDeEnvio(metodo);
		assertEquals(pedido.getMontoTotal(),120.0f);
	}
	
	@Test
	void testGetDireccionDeEntrega() {
		assertEquals(pedido.getDireccionDeEntrega(),direccion);
	}
	
	@Test
	void testSetMetodoDePago() {
		APIBilleteraVirtual api = mock(APIBilleteraVirtual.class);
		MetodosDePago metodo = new BilleteraVirtual(api);
		pedido.setMetodoDePago(metodo);
		assertEquals(pedido.getMetodoDePago(),metodo);
	}
	
	/*@Test
	void testRealizarPago() {
		APIBilleteraVirtual api = mock(APIBilleteraVirtual.class);
		MetodosDePago metodo = new BilleteraVirtual(api);
		pedido.realizarPago();
		assertEquals(pedido.getMetodoDePago(),metodo);
	} HAY QUE FIJARSE EN ESTE*/ 
}
