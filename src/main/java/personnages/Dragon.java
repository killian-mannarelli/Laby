
package personnages;

import application.Core;
import java.util.ArrayList;
import java.util.Collection;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import labyrinthe.LabyrintheGraphe;


/**
 *  Class Dragon.
 *
 * @author kmannarelli
 */
public class Dragon extends APersonnage{
    
        
        ISalle salleChoisie;
        
        
        ISalle positionHero;
        
       
        int compteur = 0;
        
       
        int avantmouvement = 15;
        
       
        ILabyrinthe laby;
        
         /**
          * Constructeur de la classe dragon.
          *
          * @param salle salle de départ
          * @param laby labyrinthe de référence
          */
         public Dragon(ISalle salle, ILabyrinthe laby) {
        super(salle);
        this.laby = laby;
    }
    
    /**
     * Fait son choix de salle.
     *
     * @param sallesAccessibles les salles accessibles
     * @return la salle vers où le dragon doit bouger
     */
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        if(compteur < avantmouvement){
            compteur++;
            return getPosition();
        }
        else{
            ArrayList<ISalle> cheminv  = (ArrayList<ISalle>) laby.chemin(getPosition(), Core.herosstat.getPosition());
            salleChoisie  = cheminv.get(1);
            if(sallesAccessibles.contains(salleChoisie)){
                compteur=0;
             return salleChoisie;
         }
            
         return this.getPosition();
        }
       
           
           
           
       
        
    }
     
     /**
      * Sets  salle choisie.
      *
      * @param nouvelleSalle  nouvelle salle choisie
      */
     public void setSalleChoisie(ISalle nouvelleSalle){
         salleChoisie = nouvelleSalle;
     }
}
