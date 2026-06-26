package envio;

import ecommerce.Pedido;

public class EnvioEstandar implements MetodoDeEnvio {

	
	private Direccion direccionDestino;
	
	public EnvioEstandar(Direccion direccionDestino) {
        this.direccionDestino = direccionDestino;
    }

	
	@Override
	public float costoDeEnvio(Pedido pedido) {
		//return float CorreoArgentina.estimarEnvio(pedido.getPeso(), pedido.getDireccionDeEntrega);
		return 0;
	}
}
