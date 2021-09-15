/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinthe;

/**
 *
 * @author kmannarelli
 */
public class DirectionMur {
    public int[] tableaudedirection;
    
   public DirectionMur(int droite, int haut ,int gauche, int bas){
       int[] tab = {
           droite,haut,gauche,bas
       };
       tableaudedirection = tab;
   }
}
