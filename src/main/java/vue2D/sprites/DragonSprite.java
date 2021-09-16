
package vue2D.sprites;

import java.util.Collection;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import application.Core;
import javafx.scene.canvas.GraphicsContext;
import personnages.Dragon;


/**
 *  Class DragonSprite.
 *
 * @author kmannarelli
 */
public class DragonSprite extends ASprite  {
    
    /**  dragon. */
    Dragon dragon;
    
    /**  compteur. */
    int compteur = 0;
    
    
    private ISalle positionheroprecedente ;
    
    /**
     * Constructeur de la classe dragonsprite.
     *
     * @param dragon the dragon
     * @param labyrinthe the labyrinthe
     */
    public DragonSprite(Dragon dragon,ILabyrinthe labyrinthe){
        super(dragon,new Image("file:icons/monstre1.gif"));
        this.dragon = dragon;
    }

    
    

}