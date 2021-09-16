
package vue2D.sprites;

import java.util.Collection;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import labyrinthe.ISalle;
import labyrinthe.Salle;
import personnages.IPersonnage;


/**
 *  Class ASprite.
 *
 * @author kmannarelli
 */
public abstract class ASprite implements ISprite {

   
    protected IPersonnage perso;
    
  
    protected Image imageperso;
    
  
    protected float xpix;
    
   
    protected float ypix;
    
   
    protected boolean deplfini = true;
    
   
    final int unite = 15;

    /**
     * Instantiates a new a sprite.
     *
     * @param persoadessiner the persoadessiner
     * @param img the img
     */
    public ASprite(IPersonnage persoadessiner, Image img) {
        perso = persoadessiner;
        imageperso = img;
        xpix = getPosition().getX() * unite;
        ypix = getPosition().getY() * unite;
    }

    /**
     * Dessiner le sprite.
     *
     * @param g 
     */
    public void dessiner(GraphicsContext g) {
        float vitesse = 0.13f;
        if ((xpix - (getPosition().getX()) * unite)*-1 >0.6 || (ypix - (getPosition().getY()) * unite)*-1 > 0.6) {
            deplfini = false;
        } else {
            deplfini = true;
        }
        xpix = lerp(xpix, getPosition().getX()*unite, vitesse);
        ypix = lerp(ypix, getPosition().getY()*unite, vitesse);
        g.drawImage(imageperso, xpix, ypix, 18, 18);

    }

    /**
     * Sets  coordonnees.
     *
     * @param xpix  
     * @param ypix  
     */
    public void setCoordonnees(int xpix, int ypix) {
       
    }

    /**
     * Gets  position.
     *
     * @return  position
     */
    public ISalle getPosition() {
        return perso.getPosition();
    }

    /**
     * Sets  position.
     *
     * @param s  nouvelle position
     */
    public void setPosition(ISalle s) {
        perso.setPosition(s);
    }

    /**
     * Fait son choix.
     *
     * @param sallesAccessibles the salles accessibles
     * @return the i salle
     */
    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        if (deplfini) {
            return perso.faitSonChoix(sallesAccessibles);
        }
        return getPosition();

    }

    /**
     * Lerp.
     *
     * @param a coordonnés de départ
     * @param b coordonnés de fin
     * @param f vitesse
     * @return  mouvement
     */
    public static float lerp(float a, float b, float f) {
        return  (a + f * (b - a));
    }
    
    /**
     * Sets  image.
     *
     * @param newImage  nouvelle image
     */
    public void setImage(Image newImage){
        imageperso = newImage;
    }
}
