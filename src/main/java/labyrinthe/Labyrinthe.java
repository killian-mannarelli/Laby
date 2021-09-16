package labyrinthe;

import java.util.ArrayList;
import java.util.Collection;

import outils.Fichier;
import outils.InvalidFileException;
import personnages.IPersonnage;

/**
 * The Class Labyrinthe.
 *
 * @author INFO Professors team
 */
public class Labyrinthe extends ArrayList<ISalle> implements ILabyrinthe {

    /**  entree. */
    protected ISalle entree;
    
    /**  sortie. */
    protected ISalle sortie;
    
    /**  largeur. */
    private int largeur;
    
    /**  hauteur. */
    private int hauteur;
    
    /**  liste mur. */
    public ArrayList<Mur> listeMur = new ArrayList<>();

    /**
     * Creer un labyrinthe à partir d'un fichier.
     *
     * @param file chemin du fichier
     */
    @Override
    public void creerLabyrinthe(String file) {
        
       try{
           
              Fichier.testValide(file);
             Fichier f = new Fichier(file);
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
         ArrayList<ISalle> murpossibles = new ArrayList<>();
         for(int i=0;i<largeur;i++){
             for(int j=0;j<hauteur;j++){
                 Salle newSalle = new Salle(i,j);
                 if(!this.contains(newSalle)){
                     for(ISalle k :this){
                         if(k.estAdjacente(newSalle)){
                             Mur newMur = new Mur(i,j,this);
                             listeMur.add(newMur);
                             break;
                         }
                     }
                 }
             }
         }
       }
    
    	catch(InvalidFileException e){
            if(!file.equals("labys/level7.txt")){
                creerLabyrinthe("labys/level7.txt");
            }
            else{
               System.exit(0); 
            }
        }
           
           
        

    }

    /**
     * Renvoie les Salles accessibles (adjacentes) .
     *
     * @param bob Le joueur
     * @return La liste des salles accessibles
     */
    @Override
    public Collection<ISalle> sallesAccessibles(IPersonnage bob) {
        ArrayList<ISalle> adj = new ArrayList<>();
        for(ISalle i  : this){
            if(i.estAdjacente(bob.getPosition())){
                adj.add(i);
            }
        }
        return adj;
    }

    /**
     * Gets  entree.
     *
     * @return the entree
     */
    @Override
    public ISalle getEntree() {
        return entree;
    }

    /**
     * Gets  sortie.
     *
     * @return the sortie
     */
    @Override
    public ISalle getSortie() {
        return sortie;
    }

    /**
     * Méthode non implementée dans cette classe.
     *
     * @param u  u
     * @param v  v
     * @return  collection
     */
    @Override
    public Collection<ISalle> chemin(ISalle u, ISalle v) {
        return null;
    }

    /**
     * Gets  largeur.
     *
     * @return  largeur
     */
    @Override
    public int getLargeur() {
        return largeur;
    }

    /**
     * Gets  hauteur.
     *
     * @return  hauteur
     */
    @Override
    public int getHauteur() {
        return hauteur;
    }
    
    /**
     * Sets the largeur.
     *
     * @param newlargeur the new largeur
     */
    public void setLargeur(int newlargeur){
        largeur = newlargeur;
    }
    
    /**
     * Sets  hauteur.
     *
     * @param newhauteur  nouvelle hauteur
     */
    public void setHauteur(int newhauteur){
        hauteur = newhauteur;
    }
    
    /**
     * Sets  entree.
     *
     * @param newEntree  nouvelle entree
     */
    public void setEntree(Salle newEntree){
        this.entree=newEntree;
    }
    
    /**
     * Sets  sortie.
     *
     * @param newSortie  nouvelle sortie
     */
    public void setSortie(Salle newSortie){
        this.sortie = newSortie;
    }

}
