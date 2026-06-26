package envio;

public class Direccion {

	String calle;
	String ciudad;
	String provincia;
	String codigoPostal;
	
	public Direccion(String calle, String ciudad, String provincia, String codigoPostal) {
        this.calle = calle;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.codigoPostal = codigoPostal;
    }

	public String getCalle() {
		return calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public String getProvincia() {
		return provincia;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

}
