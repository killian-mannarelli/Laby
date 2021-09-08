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
    protected int xpix;
    protected int ypix;
    final int unite = 15;
        
        public ASprite(IPersonnage persoadessiner,Image img){
            perso = persoadessiner;
            imageperso = img;
        }
        
    	public void dessiner(GraphicsContext g){
            xpix = getPosition().getX()*unite;
            ypix = getPosition().getY()*unite;
            g.drawImage(imageperso,xpix,ypix,20,20);
        }
	public void setCoordonnees(int xpix, int ypix){
            //Je ne vois pas l'intérêt de cette méthode
        }
        
        public ISalle getPosition(){
          return perso.getPosition();
        }
        
        public void setPosition(ISalle s){
            perso.setPosition(s);
        }
        @Override
        public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles){
            return perso.faitSonChoix(sallesAccessibles);
        }
}
