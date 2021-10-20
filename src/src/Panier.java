package src;

import java.util.ArrayList;

public class Panier {

	private int contenance;
	
	private ArrayList<Orange> oranges;

	public Panier(int contenance) {
		super();
		this.contenance = contenance;
		oranges = new ArrayList<Orange>();
	}

	public boolean estVide() {
		return oranges.isEmpty();
	}
	
	public boolean estPlein() {
		return oranges.size() >= contenance;
	}
	
	public boolean ajoute(Orange o) {
		if(oranges.size() < contenance)
		{
			oranges.add(o);
			return true;
		}
		return false;
	}
	
	public void retire() {
		oranges.remove(oranges.size() -1);
	}
	
	public double getPrix () {
		double resultat=0;
		for (Orange i: oranges) {
			resultat+=i.getPrix();
		} 
		return resultat;
	}
	
	public void boycottOrigine(String origine) {
		for (int i=0; i<oranges.size(); i++) {
			if(oranges.get(i).getOrigine()==origine) {
				oranges.remove(i);
			}
		}
		
	}
	
	public int getContenance() {
		return contenance;
	}

	public void setContenance(int contenance) {
		this.contenance = contenance;
	}

	public ArrayList<Orange> getOranges() {
		return oranges;
	}

	public void setOranges(ArrayList<Orange> oranges) {
		this.oranges = oranges;
	}

	@Override
	public String toString() {
		return "Panier [contenance=" + contenance + ", oranges=" + oranges + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + contenance;
		result = prime * result + ((oranges == null) ? 0 : oranges.hashCode());
		return result;
	}

	public boolean equals(Panier panier) throws PriceException {
		boolean resultat=false;
		for (int i=0; i<this.oranges.size();i++) {

			for (int k=0; k<panier.getOranges().size();k++) {
				Orange it= new Orange(0, "") ;
				if (oranges.get(i).getOrigine().equals(panier.getOranges().get(k).getOrigine()) && this.oranges.get(i).getPrix()==panier.getOranges().get(k).getPrix()){

					if (it!=panier.getOranges().get(k))
						it = this.oranges.get(i);
					resultat=true;

					if (it==panier.getOranges().get(k)) {
						resultat = false;	
					}

				}
			}
		}
		return resultat;
	}
	
	
}
