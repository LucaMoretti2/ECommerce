package envio;

import ecommerce.Pedido;

public class RetiroEnSucursal implements MetodoDeEnvio {

	@Override
	public float costoDeEnvio(Pedido pedido) {
		return 0;
	}

}
