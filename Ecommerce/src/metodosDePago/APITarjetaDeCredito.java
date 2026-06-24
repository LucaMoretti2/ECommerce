package metodosDePago;

public interface APITarjetaDeCredito {
	boolean validarTarjeta();
	boolean preAutorizarMonto(float monto);
	boolean transferenciaRealizada();
}
