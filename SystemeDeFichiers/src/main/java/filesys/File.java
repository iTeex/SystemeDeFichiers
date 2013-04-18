package filesys;

/**
 * Write a description of class File here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class File extends Composant {
	// instance variables - replace the example below with your own
	int taille;

	/**
	 * Constructor for objects of class File
	 * @throws ExceptionSystemeFichier 
	 */
	public File(String parNom, int partaille) throws ExceptionSystemeFichier {
		
		super(parNom);
		if(partaille < 0) throw new ExceptionSystemeFichier("La taille d'un fichier ne peut pas �tre n�gative"); 
		else 
		{
			taille = partaille;
		}
	}
	
	/**
	 * Constructor for objects of class File
	 * @param parNom
	 * @throws ExceptionSystemeFichier
	 */
	public File(String parNom) throws ExceptionSystemeFichier {
		super(parNom);
		taille = 0;
	}
	
	@Override
	public int getTaille() {
		return (taille);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + taille;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		File other = (File) obj;
		if (taille != other.taille)
			return false;
		return true;
	}
}
