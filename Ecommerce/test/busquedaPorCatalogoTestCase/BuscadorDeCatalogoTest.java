package busquedaPorCatalogoTestCase;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import busquedaPorCatalogo.*;
import busquedaPorCatalogo.CriterioPorNombre;
import ecommerce.CatalogoDeProductos;
import ecommerce.Producto;

class BuscadorDeCatalogoTest {
	BuscadorDeCatalogo buscador;
	List<CatalogoDeProductos> productos;
	Criterio criterioPorNombre;
	Criterio criterioPorPrecioMaximo;
	Criterio criterioPorPrecioMaximo2;
	Criterio criterioPorCategoria;
	Criterio criterioPorStock;
	Criterio criterioAND;
	Criterio criterioNOT;
	Criterio criterioOR;
	Criterio criterioANDcompuesto;
	CatalogoDeProductos producto1;
	CatalogoDeProductos producto2;
	
	
	
	
	@BeforeEach
	void setUp() {
		productos = new ArrayList<>();
		producto1 = new Producto(212, "Auriculares", "Sony", "Electrodomesticos", 100f,
				2.5f, 10f, 1);
		producto2 = new Producto(212, "Television", "Sony", "Electrodomesticos", 100000f,
				2.5f, 10f, 0);
		productos.add(producto1);
		productos.add(producto1);
		productos.add(producto2);
		criterioPorNombre = new CriterioPorNombre("Auriculares");
		criterioPorPrecioMaximo = new CriterioPorPrecioMaximo(100f);
		criterioPorCategoria = new CriterioPorCategoria("Electrodomesticos");
		criterioPorStock = new CriterioPorStock();
		criterioAND = new CriterioAND(criterioPorNombre, criterioPorStock);
		criterioNOT = new CriterioNOT(criterioPorNombre);
		criterioOR = new CriterioOR(criterioPorCategoria, criterioPorPrecioMaximo);
		buscador = new BuscadorDeCatalogo(productos);
	}
	
	
	@Test
	void testCriterioPorNombreTiene2Productos() {
		assertEquals(buscador.buscar(criterioPorNombre).size(), 2);
	}
	
	
	@Test
	void testCriterioPorNombreContieneAlPrimerProducto() {
		assertTrue(buscador.buscar(criterioPorNombre).contains(producto1));
	}
	
	@Test
	void testCriterioPorNombreNoContieneAlSegundoProducto() {
		assertFalse(buscador.buscar(criterioPorNombre).contains(producto2));
	}
	
	@Test
	void testCriterioPorPrecioMaximoTiene2Productos() {
		assertEquals(buscador.buscar(criterioPorPrecioMaximo).size(), 2);
	}
	
	@Test
	void testCriterioPorPrecioMaximoContieneAlPrimerProducto() {
		assertTrue(buscador.buscar(criterioPorPrecioMaximo).contains(producto1));
	}
	
	@Test
	void testCriterioPorPrecioMaximoNoContieneAlPrimerProducto2() {
		assertFalse(buscador.buscar(criterioPorPrecioMaximo).contains(producto2));
	}
	
	@Test
	void testCriterioPorPrecioMaximo2EsVacio() {
		criterioPorPrecioMaximo2 = new CriterioPorPrecioMaximo(80f);
		assertTrue(buscador.buscar(criterioPorPrecioMaximo2).isEmpty());
	}
	
	@Test
	void testCriterioPorCategoriaTiene3Productos() {
		assertEquals(buscador.buscar(criterioPorCategoria).size(), 3);
	}
	
	@Test
	void testCriterioPorCategoriaContieneAlPrimerProductoYAlSegundoProducto() {
		assertTrue(buscador.buscar(criterioPorCategoria).contains(producto1));
		assertTrue(buscador.buscar(criterioPorCategoria).contains(producto2));
	}
	
	@Test
	void testCriterioPorStockTiene2Productos() {
		assertEquals(buscador.buscar(criterioPorStock).size(), 2);
	}
	
	@Test
	void testCriterioPorStockContieneAlProducto1() {
		assertTrue(buscador.buscar(criterioPorStock).contains(producto1));
	}
	
	@Test
	void testCriterioPorStockNoContieneAlProducto2() {
		assertFalse(buscador.buscar(criterioPorStock).contains(producto2));
	}
	
	@Test
	void testCriterioANDTiene2Productos() {
		assertEquals(buscador.buscar(criterioAND).size(), 2);
	}
	
	@Test
	void testCriterioANDContieneAlProducto1() {
		assertTrue(buscador.buscar(criterioAND).contains(producto1));
	}
	
	@Test
	void testCriterioANDNoContieneAlProducto2() {
		assertFalse(buscador.buscar(criterioAND).contains(producto2));
	}
	
	@Test
	void testCriterioNOTTiene1Producto() {
		assertEquals(buscador.buscar(criterioNOT).size(), 1);
	}
	
	@Test
	void testCriterioNOTContieneAlProducto2() {
		assertTrue(buscador.buscar(criterioNOT).contains(producto2));
	}
	
	@Test
	void testCriterioNOTNoContieneAlProducto1() {
		assertFalse(buscador.buscar(criterioNOT).contains(producto1));
	}
	
	@Test
	void testCriterioORTiene3Productos() {
		assertEquals(buscador.buscar(criterioOR).size(), 3);
	}
	
	@Test
	void testCriterioORContieneAlProducto1YAlProducto2() {
		assertTrue(buscador.buscar(criterioOR).contains(producto1));
		assertTrue(buscador.buscar(criterioOR).contains(producto2));
	}
	
	@Test
	void testCriterioANDConOtrosCriteriosComplejos() {
		criterioANDcompuesto = new CriterioAND(criterioPorNombre, criterioOR);
		assertEquals(buscador.buscar(criterioANDcompuesto).size(), 2);
		assertTrue(buscador.buscar(criterioANDcompuesto).contains(producto1));
		assertFalse(buscador.buscar(criterioANDcompuesto).contains(producto2));
	}
}
