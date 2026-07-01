package envio;

import ecommerce.Pedido;

public class EnvioEstandar implements MetodoDeEnvio {

	CorreoArgentina correo;
	
	public EnvioEstandar(CorreoArgentina correo) {
        this.correo = correo;
    }

	@Override
	public float costoDeEnvio(Pedido pedido) {
		return correo.estimarEnvio(pedido.getPeso(), pedido.getDireccionDeEntrega());
	}
}
