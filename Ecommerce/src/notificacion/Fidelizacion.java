package notificacion;

import ecommerce.Pedido;
import estadoDePedido.*;

public class Fidelizacion implements ObservadorDePedido {

	MailSender sender;

    public Fidelizacion(MailSender sender) {
        this.sender = sender;
    }
	
	@Override
	public void actualizar(Pedido ped, EstadoDePedido anterior, EstadoDePedido nuevo) {
		if(nuevo instanceof Cancelado) {
			String cupon = generarCupon();
            sender.enviarMail(ped.getCliente().getMail(), "Te regalamos un cupon", cupon, null);
		}
	}

	public String generarCupon() {
		return "Lamentamos que se haya cancelado el pedido, te regalamos un cupon del 5% en tu proxima compra.";
	}
}
