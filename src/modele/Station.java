package modele;

import java.util.ArrayList;

public class Station {
	String nom;
	int tempsArret;
	boolean incident;
	int longitude;
	int latitude;
	ArrayList<Voie> voiesAssociees;
	
	public Station(String n, int ta, int lon, int lat) {
		nom = n;
		tempsArret = ta;
		incident = false;
		longitude = lon;
		latitude = lat;
		voiesAssociees = new ArrayList<Voie>();
	}

	public boolean isIncident() {
		return incident;
	}

	public void setIncident(boolean incident) {
		this.incident = incident;
	}

	public String getNom() {
		return nom;
	}

	public int getTempsArret() {
		return tempsArret;
	}

	public int getLongitude() {
		return longitude;
	}

	public int getLatitude() {
		return latitude;
	}
	
	public ArrayList<Voie> getVoiesAssociees() {
		return voiesAssociees;
	}
}
