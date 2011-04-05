package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import modele.Reseau;
import modele.Station;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReseauTest {

	@Before
	public void setUp() throws Exception {
		ArrayList<Station> stations = new ArrayList<Station>();
		stations.add(new Station("Republique", 5, 50, 50));
		stations.add(new Station("Test", 1, 41, 29));
		stations.add(new Station("Test2", 5, 198, 175));
		Reseau.setStations(stations);
	}

	@After
	public void tearDown() throws Exception {
		
	}

	@Test
	public void testGetStationProche() {
		String nomStationReelle = "Republique";
		System.out.println("Test de la station la plus proche");
		Station result = Reseau.getStationProche(48,52);
		String nomRet = result.getNom();
		assertEquals(nomStationReelle,nomRet);
		//fail("Not yet implemented");
	}

	@Test
	public void testGetStationByNom() {
		Station station = new Station("Test3", 5, 50, 50);
		Reseau.getStations().add(station);
		System.out.println("Récupération de la station par le nom");
		Station result = Reseau.getStationByNom("Test3");
		assertEquals(result, station);
		//fail("Not yet implemented");
	}

}
