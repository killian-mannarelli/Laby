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
 * @author Epsi
 */
public abstract class APersonnage implements IPersonnage{
    private ISalle position;
 
    public APersonnage(ISalle p){
        position=p;
    }

    // renvoie sa position courante
    @Override
    public ISalle getPosition(){
        return position;
    }
        
    
    
    // definit sa position courante
    @Override
    public void setPosition( ISalle s) {
        position = s;
    }  
    @Override
     public abstract ISalle faitSonChoix(Collection<ISalle> sallesAccessibles);
    
}
