package filesys;

/**
 * Write a description of class Composant here.
 * 
 * @author (your name)
 * @version 1.0
 */
public abstract class Composant {
	protected String nom;

	/**
	 * Constructor for objects of class Composant
	 * @throws ExceptionSystemeFichier 
	 */
	public Composant(String parnom) throws ExceptionSystemeFichier {
		// initialise instance variables
		if(parnom.equals(""))throw new ExceptionSystemeFichier("On ne peut pas ajouter un r�pertoire � lui-m�me.");
		else
			nom = parnom;
	}
	/**
	 * la taille du composant
	 * @return la taille du composant
	 */
	public abstract int getTaille();



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
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
		Composant other = (Composant) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
	/**
	 * Getter Nom
	 * @return nom
	 */
	public String getNom()
	{
		return(nom);
	}
}
