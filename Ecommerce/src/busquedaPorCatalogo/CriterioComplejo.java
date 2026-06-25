package busquedaPorCatalogo;

import java.util.List;

import ecommerce.CatalogoDeProductos;

public abstract class CriterioComplejo implements Criterio {
	
	protected List<Criterio> criterios; 

	public abstract boolean satisface(CatalogoDeProductos catalogo);
}
