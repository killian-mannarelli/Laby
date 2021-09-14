/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnages;

import application.Core;
import java.util.ArrayList;
import java.util.Collection;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import labyrinthe.LabyrintheGraphe;

/**
 *
 * @author kmannarelli
 */
public class Dragon extends APersonnage{
    
        ISalle salleChoisie;
        ISalle positionHero;
        int compteur = 0;
        int avantmouvement = 15;
        ILabyrinthe laby;
        
         public Dragon(ISalle salle, ILabyrinthe laby) {
        super(salle);
        this.laby = laby;
    }
    
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
     public void setSalleChoisie(ISalle nouvelleSalle){
         salleChoisie = nouvelleSalle;
     }
}
