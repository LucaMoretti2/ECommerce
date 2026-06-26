package busquedaPorCatalogo;

import ecommerce.CatalogoDeProductos;

public class CriterioPorStock extends CriterioSimple {
	
	@Override
	public boolean satisface(CatalogoDeProductos catalogo) {
		return catalogo.tieneStockDisponible();
	}

}
