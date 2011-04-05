package modele;

import java.util.ArrayList;

public class Direction {
	ArrayList<Voie> voies;
	String libelle;
	
	public Direction(ArrayList<Voie> v, String l) {
		voies = v;
		libelle = l;
	}
	
	public ArrayList<Voie> getVoies() {
		return voies;
	}
	
	public String getLibelle() {
		return libelle;
	}
	
	public String toString() {
		String res = "Direction : "+libelle+"\n";
		Voie voie = null;
		for(int i = 0 ; i < voies.size() ; i++) {
			voie = voies.get(i);
			res = res + voie.getStation1().getNom() + ":"+ voie.getStation1().getTempsArret() + ":" + " --- "+voie.getTempsTrajet() + " --- ";
		}
		voie = voies.get(voies.size()-1);
		res = res + voie.getStation2().getNom() + ":" + voie.getTempsTrajet() + ":";
		return res;
	}
}
