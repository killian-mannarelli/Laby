/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
import labyrinthe.ISalle;

/**
 *
 * @author Epsi
 */
public class Heros extends APersonnage{
   ISalle salleChoisie;
   
   public Heros(ISalle salle){
       salleChoisie = salle;
   }
   @Override
     public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles){
         if(sallesAccessibles.contains(salleChoisie)){
             return salleChoisie;
         }
         return this.getPosition();
     }
     
     public void setSalleChoisie(ISalle nouvelleSalle){
         salleChoisie = nouvelleSalle;
     }
}
