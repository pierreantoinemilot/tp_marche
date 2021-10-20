package src;

public class Orange {

	private double prix;
	private String origine;
	
	public Orange(double prix, String origine) throws PriceException {
		super();
		if(prix < 0)
		{
			throw new PriceException("Le prix est negatif");
		}
		this.prix = prix;
		this.origine = origine;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) throws PriceException {
		if(prix < 0)
		{
			throw new PriceException("Le prix est negatif");
		}
		this.prix = prix;
	}

	public String getOrigine() {
		return origine;
	}

	public void setOrigine(String origine) {
		this.origine = origine;
	}

	@Override
	public String toString() {
		return "Orange [prix=" + prix + ", origine=" + origine + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((origine == null) ? 0 : origine.hashCode());
		long temp;
		temp = Double.doubleToLongBits(prix);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orange other = (Orange) obj;
		if (origine == null) {
			if (other.origine != null)
				return false;
		} else if (!origine.equals(other.origine))
			return false;
		if (Double.doubleToLongBits(prix) != Double.doubleToLongBits(other.prix))
			return false;
		return true;
	}
	
}
