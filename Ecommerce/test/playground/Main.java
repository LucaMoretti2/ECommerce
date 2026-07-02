package playground;

import ecommerce.Paquete;
import ecommerce.Producto;
import estadoDePedido.Borrador;
import metodosDePago.APITarjetaDeCredito;
import metodosDePago.MetodoDePagoException;
import metodosDePago.TarjetaDeCredito;
import notificacion.Fidelizacion;
import notificacion.GeneradorDeFactura;
import notificacion.MailSender;
import notificacion.NotificadorDeMail;
import reporte.ExportadorReporte;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import busquedaPorCatalogo.BuscadorDeCatalogo;
import busquedaPorCatalogo.Criterio;
import busquedaPorCatalogo.CriterioAND;
import busquedaPorCatalogo.CriterioPorCategoria;
import busquedaPorCatalogo.CriterioPorPrecioMaximo;
import ecommerce.*;
import envio.*;
import metodosDePago.*;
import reporte.*;

public class Main {
	public static void main(String[] args) throws MetodoDePagoException {
		 
		System.out.println("===== 1. Armado del catalogo =====");
 
		//Productos
		Producto auriculares = new Producto(111, "Auriculares Bluetooth", "MarcaX",
				"Electronica", 8000f, 0.3f, 0f, 10);
		Producto funda = new Producto(112, "Funda protectora", "MarcaX",
				"Electronica", 1500f, 0.1f, 0f, 15);
		Producto cableUsb = new Producto(113, "Cable USB-C", "MarcaX",
				"Electronica", 800f, 0.05f, 0f, 20);
 
		//Paquete con descuento del 15%
		Paquete packAudioMovil = new Paquete("Pack Audio Movil", "Combo de audio para movil",
				"Electronica", 15f); 
		packAudioMovil.agregarProducto(auriculares); 
		packAudioMovil.agregarProducto(funda);
		packAudioMovil.agregarProducto(cableUsb);
 
		System.out.println("Precio base del pack: " + packAudioMovil.getPrecio());
		System.out.println("Precio final del pack (con descuento): " + packAudioMovil.getPrecioFinal());
 
		List<CatalogoDeProductos> catalogo = new ArrayList<>();
		catalogo.add(auriculares);
		catalogo.add(funda);
		catalogo.add(cableUsb);
		catalogo.add(packAudioMovil);
 
		System.out.println();
		System.out.println("===== 2. Busqueda en el catalogo =====");
 
		BuscadorDeCatalogo buscador = new BuscadorDeCatalogo(catalogo);
 
		// (Electronica) AND (precio <= 5000)  esto deberia devolver funda y cable USB
		Criterio esElectronica = new CriterioPorCategoria("Electronica");
		Criterio esMenorACincoMil = new CriterioPorPrecioMaximo(5000f);
		Criterio criterioCompuesto = new CriterioAND(esElectronica, esMenorACincoMil);
 
		List<CatalogoDeProductos> resultado = buscador.buscar(criterioCompuesto);
		System.out.println("Items encontrados (Electronica AND precio <= 5000):");
		for (CatalogoDeProductos item : resultado) {
			System.out.println(item.getNombre() + " $" + item.getPrecio() );
		}
 
		System.out.println();
		System.out.println("===== 3. Armado y ciclo de vida del pedido =====");
 
		Direccion direccion1 = new Direccion("Saenz Peña", "Quilmes", "Buenos Aires", "1877");
		
		Cliente cliente = new Cliente("Luca Moretti",direccion1, "luca.moretti@mail.com");
 
		List<CatalogoDeProductos> itemsDelPedido = new ArrayList<>();
		itemsDelPedido.add(packAudioMovil);
 
		MetodoDeEnvio metodoDeEnvio = new RetiroEnSucursal(); 
 
		Pedido pedido = new Pedido(new Borrador(), itemsDelPedido, cliente, metodoDeEnvio);
		
		//se agregar los observadores a la lista 
		MailSender sender = (destino, titulo, mensaje, adjunto) ->
				System.out.println("mail a " + destino + " " + titulo + ": " + mensaje);
 
		pedido.agregarObservador(new NotificadorDeMail(sender));
		pedido.agregarObservador(new GeneradorDeFactura());
		pedido.agregarObservador(new Fidelizacion(sender));
 
		pedido.confirmarPedido();       
		System.out.println("Precio total del pedido: $" + pedido.getPrecio());
 
		System.out.println();
		System.out.println("===== 4. Pago del pedido =====");
 
		APITarjetaDeCredito apiTarjeta = new APITarjetaDeCredito() { 
			@Override
			public boolean validarTarjeta() { return true; }
			@Override
			public boolean preAutorizarMonto(float monto) { return true; }
			@Override
			public boolean transferenciaRealizada() { return true; }
		};
 
		MetodosDePago tarjeta = new TarjetaDeCredito(apiTarjeta, "3921932193921934", "832", LocalDate.now().plusYears(2));
 
		pedido.setMetodoDePago(tarjeta);
		tarjeta.finalizarPago(pedido);   
 
		System.out.println();
		System.out.println("===== 5. Avance del pedido hasta Entregado =====");
 
		pedido.preparar(); 
		pedido.enviar();              
		pedido.entregar();            
 
		System.out.println("Comprobantes del pedido:");
		for (String comprobante : pedido.getComprobantes()) {
			System.out.println(comprobante);
		}
 
		System.out.println();
		System.out.println("===== 6. Reporte de productos mas vendidos ====="); 
 
		auriculares.incrementarCantidadVendida(); 
		auriculares.incrementarCantidadVendida();
		funda.incrementarCantidadVendida();
 
		ReporteProductosMasVendidos reporte = new ReporteProductosMasVendidos();
		for (CatalogoDeProductos item : catalogo) {
			item.aceptar(reporte); 
		}
 
		List<ExportadorReporte> exportadores = new ArrayList<>();
		exportadores.add(new ReporteTextoPlano());
		exportadores.add(new ReporteCSV());
		exportadores.add(new ReporteHTML());
 
		for (ExportadorReporte exportador : exportadores) {
			System.out.println();
			System.out.println("--- " + exportador.getClass().getSimpleName() + " ---");
			System.out.println(exportador.exportar(reporte.getProductosMasVendidos()));
		}
	}
	
}
