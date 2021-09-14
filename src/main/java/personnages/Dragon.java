/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnages;

import application.Core;
import java.util.Collection;
import labyrinthe.ISalle;

/**
 *
 * @author kmannarelli
 */
public class Dragon extends APersonnage{
    
        ISalle salleChoisie;
        ISalle positionHero;
        Collection<ISalle> ancienchemin;
        int compteur = 0;
        int avantmouvement = 15;
        
         public Dragon(ISalle salle) {
        super(salle);
    }
    
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        if(compteur < avantmouvement){
            compteur++;
            return getPosition();
        }
        else{
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
