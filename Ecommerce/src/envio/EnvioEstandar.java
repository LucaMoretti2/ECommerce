package envio;

import ecommerce.Pedido;

public class EnvioEstandar implements MetodoDeEnvio {

	@Override
	public float costoDeEnvio(Pedido pedido) {
		// TODO Auto-generated method stub
		//return float CorreoArgentina.estimarEnvio(pedido.getPeso(), Direccion direccionEnvio );
		return 0;
		

	}

}
