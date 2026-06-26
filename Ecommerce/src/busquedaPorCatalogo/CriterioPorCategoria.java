package busquedaPorCatalogo;

import ecommerce.CatalogoDeProductos;

public class CriterioPorCategoria extends CriterioSimple {
	
	String categoriaBuscada;

	public CriterioPorCategoria(String categoriaBuscada) {
		super();
		this.categoriaBuscada = categoriaBuscada;
	}

	@Override
	public boolean satisface(CatalogoDeProductos catalogo) {
		return catalogo.getCategoria().equalsIgnoreCase(categoriaBuscada);
	}

}



