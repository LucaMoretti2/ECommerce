package notificacion;

import ecommerce.Pedido;
import estadoDePedido.*;

public class GeneradorDeFactura implements ObservadorDePedido {

	@Override
	public void actualizar(Pedido ped, EstadoDePedido anterior, EstadoDePedido nuevo) {
		if(nuevo instanceof Entregado) {
			generarFactura(ped);
		}
	}
	public String generarFactura(Pedido p) {
		return "Factura: " + p.getProductos() + "| Total: $" + p.getPrecio();
	}

}
