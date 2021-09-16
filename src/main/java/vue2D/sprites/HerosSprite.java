
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
 *  Class HerosSprite.
 *
 * @author kmannarelli
 */
public class HerosSprite extends ASprite implements EventHandler<KeyEvent>{
    
   
    ILabyrinthe labyrinthe;
    
    
    Heros hero;
    
    /**
     * Constructeur de la classe  herossprite.
     *
     * @param hero Le héro
     * @param labyrinthe le labyrinthe de référenc
     */
    public HerosSprite(Heros hero,ILabyrinthe labyrinthe){
        super(hero,new Image("file:icons/link/LinkRunShieldL1.gif"));
        this.labyrinthe  = labyrinthe;
        this.hero = hero;
    }

    /**
     * Méthode qui réagit aux interactions avec les touches directionnelles du clavier.
     *
     * @param event the event
     */
    @Override
    public void handle(KeyEvent event) {
        switch(event.getCode()){
            case LEFT:
               Salle depl = new Salle(getPosition().getX()-1,getPosition().getY());
               hero.setSalleChoisie(depl);
               setImage(new Image("file:icons/link/LinkRunShieldL1.gif"));
               break;
            case RIGHT:
                depl = new Salle(getPosition().getX()+1,getPosition().getY());
               hero.setSalleChoisie(depl);
               setImage(new Image("file:icons/link/LinkRunR1.gif"));
               break;
            case UP:
               depl = new Salle(getPosition().getX(),getPosition().getY()-1);
               hero.setSalleChoisie(depl);
               setImage(new Image("file:icons/link/LinkRunU1.gif"));
               break;
            case DOWN:
               depl = new Salle(getPosition().getX(),getPosition().getY()+1);
               hero.setSalleChoisie(depl);
               setImage(new Image("file:icons/link/LinkRunShieldD2.gif"));
               break;
               
        }
    }
    
}
