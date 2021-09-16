/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinthe;

import java.util.Arrays;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Arrays.hashCode(this.tableaudedirection);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DirectionMur other = (DirectionMur) obj;
        if (tableaudedirection[0] != other.tableaudedirection[0] || tableaudedirection[1] != other.tableaudedirection[1] ||tableaudedirection[2] != other.tableaudedirection[2] ||tableaudedirection[3] != other.tableaudedirection[3] ) {
            return false;
        }
        return true;
    }
   
   
}
