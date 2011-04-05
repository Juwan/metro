import java.util.ArrayList;
import java.util.Scanner;

import modele.Direction;
import modele.Ligne;
import modele.Reseau;
import modele.Station;
import modele.Voie;


public class Main {

	public static void main(String[] args) {
			
		ArrayList<Station> stations = new ArrayList<Station>();
		Station s1 = new Station("Republique", 2, 50, 50);
		Station s2 = new Station("Oberkampf", 1, 21, 21);
		Station s3 = new Station("Bastille", 1, 58, 67);
		stations.add(s1);
		stations.add(s2);
		stations.add(s3);
		Reseau.setStations(stations);
		
		ArrayList<Voie> voies1 = new ArrayList<Voie>();
		voies1.add(new Voie(s1, s2, 5));
		voies1.add(new Voie(s2, s3, 3));
		Direction dir1 = new Direction(voies1, "Bastille");
		
		ArrayList<Voie> voies2 = new ArrayList<Voie>();
		voies2.add(new Voie(s3, s2, 3));
		voies2.add(new Voie(s2, s1, 5));
		Direction dir2 = new Direction(voies2, "Republique");
		
		Ligne l1 = new Ligne(dir1, dir2, 1);
		Station nouvelle = new Station("nouvelle", 1, 50, 10);
		System.out.println(l1.getDirection1());
		l1.addStationDirection1(nouvelle , "Oberkampf", "Bastille", 2, 3);
		System.out.println(l1.getDirection1());
		Reseau.getLignes().add(l1);
		
	   System.out.println("Entrez les deux coordonnées : longitude/latitude");
	   Scanner sc = new Scanner(System.in);
	   int longitudeMaPosition = sc.nextInt();
	   int latitudeMaPosition = sc.nextInt();
	   System.out.println("Vous vous trouvez aux coordonnées : longitude : "+longitudeMaPosition+" latitude : "+latitudeMaPosition);
	
	   // Permet d'obtenir la station la plus proche
	   Station dep = Reseau.getStationProche(longitudeMaPosition,latitudeMaPosition);
	   System.out.println("La station la plus proche est "+dep.getNom());
	   
	   System.out.println("Entrez la station ou vous souhaitez aller :");
	   String nomStation = sc.next();
	   Station s = Reseau.getStationByNom(nomStation);
	   if (s == null) {
	       System.out.println("La station n'existe pas");
	   } else {
	       System.out.println("Vous voyagez à destination de "+nomStation);
	   }

    }
	
}
