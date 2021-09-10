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
    protected boolean deplfini=true;
    final int unite = 15;
        
        public ASprite(IPersonnage persoadessiner,Image img){
            perso = persoadessiner;
            imageperso = img;
            xpix = getPosition().getX()*unite;
            ypix = getPosition().getY()*unite;
        }
        
    	public void dessiner(GraphicsContext g){
            
                

            if(xpix != getPosition().getX()*unite ||ypix != getPosition().getY()*unite){
            deplfini=false;
        }
            else{
                deplfini=true;
            }
            if(xpix != getPosition().getX()*unite){
                if(xpix< getPosition().getX()*unite){
                   xpix = xpix+1; 
                }
                else{
                    xpix = xpix-1;
                }
                
            }
            
            else if(ypix != getPosition().getY()*unite){
                if(ypix< getPosition().getY()*unite){
                   ypix = ypix+1; 
                }
                else{
                    ypix = ypix-1;
                }
            }
            
            
            
            g.drawImage(imageperso,xpix,ypix,18,18);
                  
        }
	public void setCoordonnees(int xpix, int ypix){
            xpix=xpix+1;
            ypix=ypix+1;
        }
        
        public ISalle getPosition(){
          return perso.getPosition();
        }
        
        public void setPosition(ISalle s){
            perso.setPosition(s);
        }
        @Override
        public ISalle faitSonChoix(Collection<ISalle> sallesAccessibles){
                if(deplfini){
                    return perso.faitSonChoix(sallesAccessibles); 
                }
               return getPosition();
            
            
        }
        
        public static int lerp(int a, int b, float f) {
        return (int) (a + f * (b - a));
    }
}
