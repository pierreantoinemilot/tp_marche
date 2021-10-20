package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import src.Orange;
import src.PriceException;

public class OrangeTest {

	Orange o1, o2, o3, o4;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		o1 = new Orange(1.1, "FR");
		o2 = new Orange(1.5, "FR");
		o3 = new Orange(1.1, "ESP");
		o4 = new Orange(1.1, "FR");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructor() {
		assertNotNull(o1);
		assertNotNull(o2);
		assertNotNull(o3);
		assertNotNull(o4);
		
		assertTrue(o1.getPrix() == 1.1);
		assertTrue(o2.getPrix() == 1.5);
		assertTrue(o3.getPrix() == 1.1);
		assertTrue(o4.getPrix() == 1.1);
		
		assertTrue(o1.getOrigine() == "FR");
		assertTrue(o2.getOrigine() == "FR");
		assertTrue(o3.getOrigine() == "ESP");
		assertTrue(o4.getOrigine() == "FR");
	}

	@Test
	public void testException() {
	    int nbException =0;
		try {
			Orange o = new Orange(-1, "FR");
		} catch (PriceException e) {
			assertTrue(e.getMessage().equals("Le prix est negatif"));
			nbException++;
		}
	    try {
			o1.setPrix(-2);;
		} catch (PriceException e) {
			assertTrue(e.getMessage().equals("Le prix est negatif"));
			nbException++;
		}
	    assertTrue(nbException == 2);
	}
	
	@Test
	public void testEquals() {
		assertTrue(o1.equals(o1));
		assertFalse(o1.equals(null));
		assertTrue(o1.equals(o4));
		assertFalse(o1.equals(o2));
		assertFalse(o1.equals(o3));
	}
	
	@Test
	public void testToString() {
		assertTrue(o1.toString().equals("Orange [prix=1.1, origine=FR]"));
	}
}
