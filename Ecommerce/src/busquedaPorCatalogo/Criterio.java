package busquedaPorCatalogo;

import ecommerce.CatalogoDeProductos;

public interface Criterio {
	
	public boolean satisface(CatalogoDeProductos catalogo);
}
