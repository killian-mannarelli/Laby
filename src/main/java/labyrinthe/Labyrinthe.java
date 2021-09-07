package labyrinthe;

import java.util.ArrayList;
import java.util.Collection;

import outils.Fichier;
import outils.InvalidFileException;
import personnages.IPersonnage;

/**
 *
 * @author INFO Professors team
 */
public class Labyrinthe extends ArrayList<ISalle> implements ILabyrinthe {

    protected ISalle entree;
    protected ISalle sortie;
    private int largeur;
    private int hauteur;

    @Override
    public void creerLabyrinthe(String file) {
        try{
          Fichier f = new Fichier(file);
        if(!Fichier.testValide(file)){
            throw new InvalidFileException("Fichier Invalide");
        }
                largeur=f.lireNombre(); 
        hauteur=f.lireNombre();
        int xentree = f.lireNombre();
        int yentree = f.lireNombre();
        int xsortie = f.lireNombre();
        int ysortie = f.lireNombre();
        Salle entree = new Salle(xentree,yentree);
        Salle sortie = new Salle(xsortie,ysortie);
        add(entree);
        add(sortie);
        this.entree=entree;
        this.sortie = sortie;
        int nb = ysortie;
        int nextX = 0;
        int nextY = 0;
        boolean isX = false;
        while(nb != -1){
          isX = !isX;
          nb = f.lireNombre();
          if(isX && nb !=-1){
              
              nextX= nb;
              
          }
          else if(!isX && nb != -1)   {
                      nextY = nb;
                      Salle newSalle = new Salle(nextX,nextY);
                      add(newSalle);
                      }
        }
        }
    	catch(InvalidFileException e){
            System.out.println("Niveau invalide, chargement du niveau de secours");
            if(file.equals("labys/level7.txt")){
                System.exit(0);
            }
            else{
              creerLabyrinthe("labys/level7.txt");  
            }
           
        }

    }

    @Override
    public Collection<ISalle> sallesAccessibles(IPersonnage bob) {
        return null;
    }

    @Override
    public ISalle getEntree() {
        return entree;
    }

    @Override
    public ISalle getSortie() {
        return sortie;
    }

    @Override
    public Collection<ISalle> chemin(ISalle u, ISalle v) {
        return null;
    }

    @Override
    public int getLargeur() {
        return largeur;
    }

    @Override
    public int getHauteur() {
        return hauteur;
    }

}
