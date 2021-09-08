/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue2D.sprites;


import java.util.ArrayList;
import java.util.Collection;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import labyrinthe.Labyrinthe;
import labyrinthe.Salle;
import personnages.Heros;

/**
 *
 * @author kmannarelli
 */
public class HerosSprite extends ASprite implements EventHandler<KeyEvent>{
    ILabyrinthe labyrinthe;
    Heros hero;
    public HerosSprite(Heros hero,ILabyrinthe labyrinthe){
        super(hero,new Image("file:icons/link/LinkRunShieldL1.gif"));
        this.labyrinthe  = labyrinthe;
        this.hero = hero;
    }

    @Override
    public void handle(KeyEvent event) {
        switch(event.getCode()){
            case LEFT:
               Salle depl = new Salle(getPosition().getX()-1,getPosition().getY());
               hero.setSalleChoisie(depl);
               break;
            case RIGHT:
                depl = new Salle(getPosition().getX()+1,getPosition().getY());
               hero.setSalleChoisie(depl);
               break;
            case UP:
               depl = new Salle(getPosition().getX(),getPosition().getY()-1);
               hero.setSalleChoisie(depl);
               break;
            case DOWN:
               depl = new Salle(getPosition().getX(),getPosition().getY()+1);
               hero.setSalleChoisie(depl);
               break;
               
        }
    }
    
}
