package notificaciones;

import ecommerce.Pedido;
import estadoDePedido.*;

public class Fidelizacion implements ObservadorDePedido {

	@Override
	public void actualizar(Pedido ped, EstadoDePedido anterior, EstadoDePedido nuevo) {
		if(nuevo instanceof Cancelado) {
			generarCupon();
		}
	}

	public String generarCupon() {
		return "Lamentamos que se haya cancelado el pedido, te regalamos un cupon del 5% en tu proxima compra.";
	}
}
