package filesys;

import java.util.ArrayList;
import java.util.Hashtable;

import org.junit.Test;


import junit.framework.Assert;


public class TestSys {
	
    @Test
    public void NomVide() {
    	 File fich1;
		try {
			fich1 = new File("", 0);
	        Assert.assertTrue(!fich1.getNom().equals(""));
		} catch (ExceptionSystemeFichier e) {
			System.out.println("Il faut un nom de composant.");
		}
    }
	
    @Test
    public void calculTailleVide() {
    	 File fich1;
		try {
			fich1 = new File("fich1");
			int taille=fich1.getTaille();
	        
	        Assert.assertEquals(0, taille);
		} catch (ExceptionSystemeFichier e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Test
    public void calculTailleNonVide() {
        File fich1;
		try {
			fich1 = new File("fich1", 10);
			int taille=fich1.getTaille();
			Assert.assertTrue(taille >0);
		} catch (ExceptionSystemeFichier e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    @Test
    public void calculTailleNegative() {
        File fich1;
		try {
			fich1 = new File("fich1", -10);
	        int taille=fich1.getTaille();
	        
	        Assert.assertTrue(taille >=0);
		} catch (ExceptionSystemeFichier e) {
			System.out.println("La taille d'un fichier ne peut pas être négative");
		}
    }
    
    @Test
    public void calculTailleRepertoire() {
    	Repertoire dir1;
		try {
			dir1 = new Repertoire("Dir1");
			File fich1= new File("fich1", 10);
	        File fich2= new File("fich2", 20);
	        dir1.ajoutComposant(fich1);
	        dir1.ajoutComposant(fich2);
	        int taille=dir1.getTaille();
	        
	        Assert.assertTrue(taille == (fich1.getTaille()+fich2.getTaille()));
		} catch (ExceptionSystemeFichier e) {
			System.out.println("La taille du répertoire n'est pas égale à la somme des tailles des composants du répertoire.");
		}
    }
    
    @Test
    public void referenceNulle() {
        try {
            Repertoire dir1= new Repertoire("Dir1");
            File fich1= null;
			dir1.ajoutComposant(fich1);
			Assert.assertTrue(!dir1.getComposants().contains(null));
		} catch (ExceptionSystemeFichier e) {
			System.out.println("Le fichier est nul.");
		}
    }
    
    @Test
    public void ajoutMemeNom() {
        Repertoire dir1;
		try {
			dir1 = new Repertoire("Dir1");
			File fich1= new File("fich1", 10);
	        dir1.ajoutComposant(fich1);
	        dir1.ajoutComposant(fich1);
	        
			ArrayList<Composant> contenu = dir1.getComposants();
			Hashtable<Composant,Integer> h = new Hashtable<Composant,Integer>();
			
			
			for (Composant item : contenu) {
				if(!h.containsKey(item))
				{
					h.put(item,new Integer(1));
				}
				else
				{
					Integer occurrence = h.get(item) + 1;
					h.remove(item);
					h.put(item,occurrence);
				}
			}
			
	        Assert.assertTrue(h.size() == contenu.size());
		} catch (ExceptionSystemeFichier e) {
			System.out.println("On ne peut pas ajouter deux composants de même nom.");
		}
    }
    
    @Test
    public void ajoutSoitMeme() {
        try {
        	Repertoire dir1= new Repertoire("Dir1");
			dir1.ajoutComposant(dir1);
			Assert.assertTrue(!dir1.getComposants().contains(dir1));
		} catch (ExceptionSystemeFichier e) {
			System.out.println("On ne peut pas ajouter un rêpertoire à lui-même.");
		}
    }  
    
    @Test
    public void sousRepertoireLuiMeme() {
        Repertoire dir1;
		try {
			dir1 = new Repertoire("Dir1");
	        Repertoire dir2= new Repertoire("Dir2");
	        Repertoire dir3= new Repertoire("Dir3");
	        File fich1= new File("Fich1", 10);
	        File fich2= new File("Fich2", 10);
	        
	        dir1.ajoutComposant(dir2);
	        dir1.ajoutComposant(fich1);
	        
	        dir2.ajoutComposant(dir3);
	        
	        dir3.ajoutComposant(dir1);
	        dir3.ajoutComposant(fich2);
	        
	        Assert.assertTrue(!dir1.getComposants().contains(dir1));
		} catch (ExceptionSystemeFichier e) {
			System.out.println("Un répertoire ne peut pas être un sous-répertoire de lui-même.");
		}
    }  

}

