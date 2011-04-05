package modele;

public class Voie {
	Station station1;
	Station station2;
	int tempsTrajet;
	boolean incident;
	Ligne lignesAssociee;
	
	public Voie(Station station1, Station station2, int tempsTrajet) {
		station1.getVoiesAssociees().add(this);
		station2.getVoiesAssociees().add(this);
		this.station1 = station1;
		this.station2 = station2;
		this.tempsTrajet = tempsTrajet;
	}

	public boolean isIncident() {
		return incident;
	}

	public void setIncident(boolean incident) {
		this.incident = incident;
	}

	public Station getStation1() {
		return station1;
	}

	public Station getStation2() {
		return station2;
	}

	public int getTempsTrajet() {
		return tempsTrajet;
	}
	
	public Ligne getLigneAssociee() {
		return lignesAssociee;
	}
	
}
