package busquedaPorCatalogo;

import ecommerce.CatalogoDeProductos;

public abstract class CriterioComplejo implements Criterio {

	public abstract boolean satisface(CatalogoDeProductos catalogo);
}
