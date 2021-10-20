package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import src.Orange;
import src.Panier;
import src.PriceException;

public class PanierTest {

	private Panier p1, p2;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		p1 = new Panier(5);
		p2 = new Panier(10);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		assertNotNull(p1);
		assertNotNull(p2);
		
		assertTrue(p1.getContenance() == 5);
		assertTrue(p1.getOranges().isEmpty());

		assertTrue(p2.getContenance() == 10);
		assertTrue(p2.getOranges().isEmpty());
	}

	@Test
	public void testEstVide() {
		try {
			assertTrue(p1.estVide());
			boolean result = p1.ajoute(new Orange(1.1, "O1"));
			assertTrue(result);
			assertFalse(p1.estVide());
		} catch (PriceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void testAjoute() {
		
		try {
			assertTrue(p1.estVide());
			
			boolean result = p1.ajoute(new Orange(1.1, "O1"));
			assertTrue(result);
			assertFalse(p1.estVide());
			assertFalse(p1.estPlein());
			assertTrue(p1.getOranges().size() == 1);
			
			result = p1.ajoute(new Orange(1.1, "O2"));
			assertTrue(result);
			assertFalse(p1.estVide());
			assertFalse(p1.estPlein());
			assertTrue(p1.getOranges().size() == 2);
			
			result = p1.ajoute(new Orange(1.1, "O3"));
			assertTrue(result);
			assertFalse(p1.estVide());
			assertFalse(p1.estPlein());
			assertTrue(p1.getOranges().size() == 3);
			
			result = p1.ajoute(new Orange(1.1, "O4"));
			assertTrue(result);
			assertFalse(p1.estVide());
			assertFalse(p1.estPlein());
			assertTrue(p1.getOranges().size() == 4);
			
			result = p1.ajoute(new Orange(1.1, "O5"));
			assertTrue(result);
			assertFalse(p1.estVide());
			assertTrue(p1.estPlein());
			assertTrue(p1.getOranges().size() == 5);

			result = p1.ajoute(new Orange(1.1, "O6"));
			assertFalse(result);
			assertFalse(p1.estVide());
			assertTrue(p1.estPlein());
			assertTrue(p1.getOranges().size() == 5);
			
		} catch (PriceException e) {
			e.printStackTrace();
		}
	}
}
