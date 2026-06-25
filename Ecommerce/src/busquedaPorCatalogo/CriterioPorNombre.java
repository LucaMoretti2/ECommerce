package busquedaPorCatalogo;

import ecommerce.CatalogoDeProductos;

public class CriterioPorNombre extends CriterioSimple {
	
	String nombreBuscado;
	

	public CriterioPorNombre(String nombreBuscado) {
		super();
		this.nombreBuscado = nombreBuscado;
	}


	@Override
	public boolean satisface(CatalogoDeProductos catalogo) {
		
		return catalogo.getNombre().toLowerCase().contains(nombreBuscado);
	}

}
