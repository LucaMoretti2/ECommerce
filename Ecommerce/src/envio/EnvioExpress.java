package envio;

import ecommerce.Pedido;

public class EnvioExpress implements MetodoDeEnvio {

	EnvioExpressLib envioExpress;
	
	public EnvioExpress(EnvioExpressLib envioLib) {
		this.envioExpress = envioLib;
	}
	
	@Override
	public float costoDeEnvio(Pedido pedido) {
		return envioExpress.calcularCosto(pedido.getPrecio());
		
	}
	
}
