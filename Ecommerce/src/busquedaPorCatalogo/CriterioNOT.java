package busquedaPorCatalogo;

import ecommerce.CatalogoDeProductos;

public class CriterioNOT extends CriterioComplejo{
	
	Criterio criterio;

	public CriterioNOT(Criterio criterio) {
		super();
		this.criterio = criterio;	
	}

	@Override
	public boolean satisface(CatalogoDeProductos catalogo) {
		
		return (!criterio.satisface(catalogo));
	}

}

