package envio;

import ecommerce.Pedido;

public interface MetodoDeEnvio {	
	
	 float costoDeEnvio(Pedido pedido);
	 
}
