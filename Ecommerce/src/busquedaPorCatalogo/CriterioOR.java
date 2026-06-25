package busquedaPorCatalogo;

import ecommerce.CatalogoDeProductos;

public class CriterioOR extends CriterioComplejo{
	

	Criterio primerCriterio;
	Criterio segundoCriterio;
	
	

	public CriterioOR(Criterio primerCriterio, Criterio segundoCriterio) {
		super();
		this.primerCriterio = primerCriterio;
		this.segundoCriterio = segundoCriterio;
	}

	@Override
	public boolean satisface(CatalogoDeProductos catalogo) {
		
		return (primerCriterio.satisface(catalogo) || segundoCriterio.satisface(catalogo));
	}

}

