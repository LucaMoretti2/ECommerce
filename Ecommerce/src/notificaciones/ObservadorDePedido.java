package notificaciones;

import estadoDePedido.*;
import ecommerce.*;

public interface ObservadorDePedido {
	void actualizar(Pedido ped, EstadoDePedido anterior, EstadoDePedido nuevo);
}
