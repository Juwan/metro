package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import modele.Direction;
import modele.Ligne;
import modele.Station;
import modele.Voie;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class LigneTest {

	Ligne l1;
	
	@Before
	public void setUp() throws Exception {
		Station s1 = new Station("Republique", 2, 50, 50);
		Station s2 = new Station("Oberkampf", 1, 21, 21);
		Station s3 = new Station("Bastille", 1, 58, 67);
		ArrayList<Voie> voies1 = new ArrayList<Voie>();
		voies1.add(new Voie(s1, s2, 5));
		voies1.add(new Voie(s2, s3, 3));
		Direction dir1 = new Direction(voies1, "Bastille");
		
		ArrayList<Voie> voies2 = new ArrayList<Voie>();
		voies2.add(new Voie(s3, s2, 3));
		voies2.add(new Voie(s2, s1, 5));
		Direction dir2 = new Direction(voies2, "Republique");
		
		l1 = new Ligne(dir1, dir2, 1);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddStationDirection1() {
		Station nouvelle = new Station("nouvelle", 1, 50, 10);
		l1.addStationDirection1(nouvelle , "Oberkampf", "Bastille", 2, 3);
		assertEquals("Direction : Bastille\nRepublique:2: --- 5 --- Oberkampf:1: --- 2 --- nouvelle:1: --- 3 --- Bastille:3:", l1.getDirection1().toString());
		//fail("Not yet implemented");
	}

}
