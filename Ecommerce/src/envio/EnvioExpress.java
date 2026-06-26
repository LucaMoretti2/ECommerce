package envio;

import ecommerce.Pedido;

public class EnvioExpress implements MetodoDeEnvio {

	@Override
	public float costoDeEnvio(Pedido pedido) {
		//return EnvioExpress.calcularCosto(pedido.getPrecio());
		return 0;
	}

}
