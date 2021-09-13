/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnages;

import java.util.Collection;
import labyrinthe.ISalle;

/**
 *
 * @author kmannarelli
 */
public class Dragon extends APersonnage{
    
        ISalle salleChoisie;
        
         public Dragon(ISalle salle) {
        super(salle);
    }
    
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        return null;
    }
    
}
