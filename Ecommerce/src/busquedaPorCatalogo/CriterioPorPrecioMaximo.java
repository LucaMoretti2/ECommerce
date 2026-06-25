package busquedaPorCatalogo;

import ecommerce.CatalogoDeProductos;

public class CriterioPorPrecioMaximo extends CriterioSimple {
	
	float precioMaximo;
	
	

	public CriterioPorPrecioMaximo(float precioMaximo) {
		super();
		this.precioMaximo = precioMaximo;
	}


	@Override
	public boolean satisface(CatalogoDeProductos catalogo) {
		return catalogo.getPrecioFinal() <= precioMaximo;
	}

}
