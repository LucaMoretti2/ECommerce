package busquedaPorCatalogo;

import ecommerce.CatalogoDeProductos;

public abstract class CriterioSimple implements Criterio{
	
	public abstract boolean satisface(CatalogoDeProductos catalogo);
}
