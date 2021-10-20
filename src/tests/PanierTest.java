package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import src.Panier;

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

		assertTrue(p2.getContenance() == 5);
		assertTrue(p2.getOranges().isEmpty());
	}

	
}
