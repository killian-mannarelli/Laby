/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personnages;

import java.util.ArrayList;
import java.util.Collection;
import labyrinthe.ISalle;
import java.util.Random;

/**
 *
 * @author kmannarelli
 */
public class Monstre extends APersonnage {

    ISalle salleChoisie;

    public Monstre(ISalle salle) {
        super(salle);
    }

    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        if(Math.random() < 0.8){
            return getPosition();
        }
        Random rnd = new Random();
        int i = rnd.nextInt(sallesAccessibles.size());
        return (ISalle) sallesAccessibles.toArray()[i];

    }

}
