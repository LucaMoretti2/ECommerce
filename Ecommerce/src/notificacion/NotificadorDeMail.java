package notificacion;

import estadoDePedido.*;
import ecommerce.*;

public class NotificadorDeMail implements ObservadorDePedido{

	MailSender sender;
	
	public NotificadorDeMail(MailSender sender) {
        this.sender = sender;
    }
	
	@Override
	public void actualizar(Pedido p, EstadoDePedido anterior, EstadoDePedido nuevo) {
		if(nuevo instanceof Confirmado || nuevo instanceof Enviado || nuevo instanceof Entregado) {
			sender.enviarMail(p.getCliente().getMail(), "Su pedido se ha actualizado", "Su pedido paso de" + anterior + "a" + nuevo, null);
		}
	}
	
}
