package modele;

import java.util.ArrayList;

public class Reseau {
	static ArrayList<Ligne> lignes = new ArrayList<Ligne>();
	static ArrayList<Station> stations = new ArrayList<Station>();
	
	public static ArrayList<Ligne> getLignes() {
		return lignes;
	}
	
	public static ArrayList<Station> getStations() {
		return stations;
	}



	public static void setStations(ArrayList<Station> stations) {
		Reseau.stations = stations;
	}



	public static void setLignes(ArrayList<Ligne> lignes) {
		Reseau.lignes = lignes;
	}

	// retourne la station la plus proche des coordonnées passées en paramètres (calcul simplifié)
	public static Station getStationProche(int lon, int lat) {
		Station res = null;
		int distanceMin = Integer.MAX_VALUE;
		int distanceCalc = 0;
		for(Station s : stations) {
			distanceCalc = (int) Math.sqrt((s.getLongitude() - lon)*(s.getLongitude() - lon) + (s.getLatitude() - lat)*(s.getLatitude() - lat));
			if(distanceCalc < distanceMin) {
				distanceMin = distanceCalc;
				res = s;
			}
		}
		return res;
	}
	
	// retourne la station dont le nom est passé en paramètre
	public static Station getStationByNom(String nom) {
		Station res = null;
		int i = 0;
		boolean trouve = false;
		while(!trouve && i < stations.size()) {
			if (stations.get(i).getNom().compareTo(nom) == 0) {
				trouve = true;
				res = stations.get(i);
			}
			i++;
		}
		return res;
	}
	
}
