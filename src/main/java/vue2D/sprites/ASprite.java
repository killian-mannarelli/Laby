/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue2D.sprites;

import java.util.Collection;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import labyrinthe.ISalle;
import personnages.IPersonnage;

/**
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

    public ASprite(IPersonnage persoadessiner, Image img) {
        perso = persoadessiner;
        imageperso = img;
        xpix = getPosition().getX() * unite;
        ypix = getPosition().getY() * unite;
    }

    public void dessiner(GraphicsContext g) {
        float vitesse = 0.14f;
        if ((xpix - getPosition().getX() * unite)*-1 >0.6 || (ypix - getPosition().getY() * unite)*-1 > 0.6) {
            deplfini = false;
        } else {
            deplfini = true;
        }
        xpix = lerp(xpix, getPosition().getX()*unite, vitesse);
        ypix = lerp(ypix, getPosition().getY()*unite, vitesse);
        g.drawImage(imageperso, xpix, ypix, 18, 18);

    }

    public void setCoordonnees(int xpix, int ypix) {
        xpix = xpix + 1;
        ypix = ypix + 1;
    }

    public ISalle getPosition() {
        return perso.getPosition();
    }

    public void setPosition(ISalle s) {
        perso.setPosition(s);
    }

    @Override
    public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles) {
        if (deplfini) {
            return perso.faitSonChoix(sallesAccessibles);
        }
        return getPosition();

    }

    public static float lerp(float a, float b, float f) {
        return  (a + f * (b - a));
    }
}
