package metodosDePago;

public interface APIBilleteraVirtual {
	boolean validarSaldoSuficiente(float monto);
	boolean bloquearSaldo(float monto);
	boolean acreditarAlVendedor(float monto);
	void notificar();
}
