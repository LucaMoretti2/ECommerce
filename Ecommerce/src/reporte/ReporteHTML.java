package reporte;

import java.util.List;

import ecommerce.CatalogoDeProductos;

public class ReporteHTML implements ExportadorReporte {


	@Override
	public String exportar(List<CatalogoDeProductos> productos) {

	    String resultado = "<html>\n";
	    resultado += "  <body>\n";
	    resultado += "    <ul>\n";

	    for (CatalogoDeProductos p : productos) {
	        resultado += "      <li>"
	                + p.getNombre()
	                + " - "
	                + p.getCantidadVendida()
	                + " - "
	                + p.getPrecioFinal()
	                + "</li>\n";
	    }

	    resultado += "    </ul>\n";
	    resultado += "  </body>\n";
	    resultado += "</html>";

	    return resultado;
	}

}
	
	



