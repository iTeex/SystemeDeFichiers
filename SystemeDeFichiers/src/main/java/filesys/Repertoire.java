package filesys;

import java.util.ArrayList;

/**
 * Write a description of class Repertoire here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class Repertoire extends Composant {
	// instance variables - replace the example below with your own
	private ArrayList<Composant> composants;
	private int nbrComposants;

	/**
	 * Constructor for objects of class Repertoire
	 * @throws ExceptionSystemeFichier 
	 */
	public Repertoire(String parNom) throws ExceptionSystemeFichier {
		super(parNom);
		// initialise instance variables
		this.composants = new ArrayList<Composant>();
		this.nbrComposants = 0;
	}

	/**
	 * Fonction ajoutant un Composant au r�pertoire
	 * @param parComposant
	 * @throws ExceptionSystemeFichier
	 */
	public void ajoutComposant(Composant parComposant) throws ExceptionSystemeFichier {
		
		if(parComposant == null)throw new ExceptionSystemeFichier("Le composant ajout� doit �tre non nul."); 
		else
		{
			if(parComposant == this)throw new ExceptionSystemeFichier("On ne peut pas ajouter un r�pertoire � lui-m�me."); 
			else
			{
				if(!estDescendant(parComposant))throw new ExceptionSystemeFichier("On ne peut pas ajouter un r�pertoire � lui-m�me."); 
				else
				{
					boolean testMemeNom = true;
					for (Composant item : composants) {
						if(item.getNom().equals(parComposant.getNom()))
						{
							testMemeNom = false;
						}
					}
					
					if(!testMemeNom)throw new ExceptionSystemeFichier("On ne peut pas ajouter deux composants de m�me nom."); 
					else
					{
						this.composants.add(parComposant);
						this.nbrComposants += 1;
					}
				}
			}
		}

	}
	
	@Override
	public int getTaille() {
		int retour = 0;
		ArrayList<Composant> contenu = composants;
			 
		for (Composant item : contenu) {
			retour += item.getTaille();
		}
		return (retour);
	}
	
	/**
	 * Getter composants: Retourne les composants du r�pertoire
	 * @return composants
	 */
	public ArrayList<Composant> getComposants()
	{
		return(composants);
	}
	
	/**
	 * 
	 * @return Le nombre de composants du r�pertoire
	 */
	
	public int getNbrComposants()
	{
		return(nbrComposants);
	}

	/**
	 * V�rifie si un r�pertoire est un sous-r�pertoire de lui m�me (m�me indirectement)
	 * @param rep2
	 * @return vrai si c'est un descendant sinon faux
	 */
	public boolean estDescendant(Composant rep2)
	{
		if (rep2 instanceof Repertoire) {
			ArrayList<Composant> contenu = ((Repertoire)rep2).composants;
			 
			for (Composant item : contenu) {
				if(item.equals(this))
					return true;
				else
				{
					if (item instanceof Repertoire)
					estDescendant(item);
				}
			}
		}
		return(false);
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((composants == null) ? 0 : composants.hashCode());
		result = prime * result + nbrComposants;
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
		Repertoire other = (Repertoire) obj;
		if (composants == null) {
			if (other.composants != null)
				return false;
		} else if (!composants.equals(other.composants))
			return false;
		if (nbrComposants != other.nbrComposants)
			return false;
		return true;
	}
	
}
