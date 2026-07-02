package metodosDePago;

import ecommerce.Pedido;

public class TransferenciaBancaria extends MetodosDePago {
	final APITransferenciaBancaria apiTransferencia;
	String cbu;
	String alias;
	
	public TransferenciaBancaria(APITransferenciaBancaria apiTransferencia, String cbu, String alias) {
		this.apiTransferencia = apiTransferencia;
		this.cbu = cbu;
		this.alias = alias;
	}
	
	public void validarDatos(Pedido pedido) throws MetodoDePagoException {
		if(cbu.length() != 22 || alias.isBlank()) {
			throw new MetodoDePagoException("Tus datos no son validos");
		}
		System.out.println("Tus datos fueron validados con exito");
	}
	
	public void reservarFondos(Pedido pedido) throws MetodoDePagoException {
		//No aplica para transferencia bancaria
	}

	public void ejecutarTransaccion(Pedido pedido) throws MetodoDePagoException {
		if(!apiTransferencia.transferenciaRealizada()) {
			throw new MetodoDePagoException("La transferencia no fue enviada");
			}
			System.out.println("El monto " + pedido.getMontoTotal() + " fue transferido o programado con exito");
	}
	
	
	public void notificarResultados(Pedido pedido) {
		String comprobante = "Comprobante CBU: " + cbu;
	    pedido.agregarComprobante(comprobante);
	}
	
	
}
