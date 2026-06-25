package busquedaPorCatalogo;

import java.util.ArrayList;
import java.util.List;

import ecommerce.CatalogoDeProductos;

public class BuscadorDeCatalogo {
	
	List<CatalogoDeProductos> resultado = new ArrayList<>();
	List<CatalogoDeProductos> productos;
	
	public List<CatalogoDeProductos> buscar(Criterio criterio){
		for(CatalogoDeProductos p: productos) {
			if(criterio.satisface(p)) {
				resultado.add(p);
			}
		}
		return resultado;
	}
}
