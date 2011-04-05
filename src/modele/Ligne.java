package modele;

import java.util.ArrayList;

public class Ligne {
	Direction direction1;
	Direction direction2;
	int numero;
	
	public Ligne(Direction direction1, Direction direction2, int numero) {
		for(Voie voie : direction1.getVoies()) {
			if(!voie.getStation1().getVoiesAssociees().contains(voie)) {
				voie.getStation1().getVoiesAssociees().add(voie);
			}
			if(!voie.getStation2().getVoiesAssociees().contains(voie)) {
				voie.getStation2().getVoiesAssociees().add(voie);
			}
		}
		this.direction1 = direction1;
		this.direction2 = direction2;
		this.numero = numero;
	}

	public Direction getDirection1() {
		return direction1;
	}

	public Direction getDirection2() {
		return direction2;
	}

	public int getNumero() {
		return numero;
	}
	
	//méthode qui ajoute la station passée en paramètre entre la station portant le nom libelle1 et celle portant le nom libelle2, avec respectivement pour temps de trajet tempsTrajet1 et tempsTrajet2
	public void addStationDirection1(Station nouvelle, String libelle1, String libelle2, int tempsTrajet1, int tempsTrajet2) {
		ArrayList<Voie> voies1 = direction1.getVoies();
		Voie voie = null;
		int indice = -1;
		Station stat1 = null;
		Station stat2 = null;
		int j = 0;
		boolean trouve = false;
		while(j < voies1.size() && !trouve) {
			voie = voies1.get(j);
			stat1 = voie.getStation1();
			stat2 = voie.getStation2();
			if(stat1.getNom().equals(libelle1) && stat2.getNom().equals(libelle2)) {
				indice = j;
				trouve = true;
			}
			j++;
		}
		if (trouve) {
			Voie add1 = new Voie(stat1, nouvelle, tempsTrajet1);
			Voie add2 = new Voie(nouvelle, stat2, tempsTrajet2);
			voies1.remove(indice);
			voies1.add(indice, add2);
			voies1.add(indice, add1);
			nouvelle.getVoiesAssociees().add(add1);
			nouvelle.getVoiesAssociees().add(add2);
		} else {
			System.out.println("Stations "+libelle1+" et "+libelle2+" inexistantes pour cette ligne, ou pas dans le bon ordre pour cette direction");
		}
	}
	
}
