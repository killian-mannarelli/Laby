package vue2D.javafx;

import application.Core;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import labyrinthe.ILabyrinthe;
import vue2D.IVue;
import vue2D.AVue;
import vue2D.sprites.ISprite;


/**
 *  Class Vue.
 *
 * @author INFO Professors team
 */
public class Vue extends AVue implements IVue {

    /** The dessin. */
    Dessin dessin;
    
    /** The labyrinthe. */
    ILabyrinthe labyrinthe;
    
    /** The scene. */
    public Scene scene;

    /**
     * Instantiates a new vue.
     *
     * @param labyrinthe the labyrinthe
     */
    public Vue(ILabyrinthe labyrinthe) {
        this.labyrinthe = labyrinthe;
        dessin = new Dessin(labyrinthe, this);
        Group root = new Group();
        this.scene = new Scene(root);
        root.getChildren().add(dessin);
    }

    /**
     * Dessiner.
     */
    @Override
    public void dessiner() {
        // recopie du fond (image); murs + salles
        dessin.dessinFond();
        dessin.dessinSalles();
        dessin.dessinPlusCourtChemin(Core.herosstat);
        dessin.dessinMurs();
        dessin.dessinerSprites();

    }

    /**
     * Adds the.
     *
     * @param sprite the sprite
     * @return true, if successful
     */
    @Override
    public boolean add(ISprite sprite) {
        super.add(sprite);

//si le sprite est controle par le clavier
        if (sprite instanceof EventHandler) {
            this.scene.setOnKeyPressed((EventHandler) sprite);
        }//association de l'ecouteur sur le clavier avec le composant graphique principal
        return true;
    }
}
