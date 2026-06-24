package envio;

import ecommerce.Pedido;

public class EnvioExpress implements MetodoDeEnvio {

	@Override
	public float costoDeEnvio(Pedido pedido) {
		// TODO Auto-generated method stub
		//return float EnvioExpress.calcularCosto(pedido.getPrecio());
		return 0;

	}

}
