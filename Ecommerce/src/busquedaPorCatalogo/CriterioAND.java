package busquedaPorCatalogo;

import ecommerce.CatalogoDeProductos;

public class CriterioAND extends CriterioComplejo{
	
	Criterio primerCriterio;
	Criterio segundoCriterio;

	public CriterioAND(Criterio primerCriterio, Criterio segundoCriterio) {
		super();
		this.primerCriterio = primerCriterio;
		this.segundoCriterio = segundoCriterio;
	}

	@Override
	public boolean satisface(CatalogoDeProductos catalogo) {
		// TODO Auto-generated method stub
		return (primerCriterio.satisface(catalogo) && segundoCriterio.satisface(catalogo));
	}

}
