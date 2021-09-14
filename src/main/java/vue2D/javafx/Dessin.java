package vue2D.javafx;

import application.Core;
import java.util.Collection;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Light;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import vue2D.sprites.ISprite;

/**
*
* @author INFO Professors team
*/

public class Dessin extends Canvas {
    
    private Collection<ISprite> sprites;
    private ILabyrinthe labyrinthe;
    private int unite = 15;
    int compteur = 0;
    private GraphicsContext tampon;
    private Image solImage;
    private Image groundImage;
    private Image cheminImage;
    private ISalle positionDuHero;
    private ISprite spritehero;
    private boolean spritetrouve = false;
    private ISalle positionheroprecedente ;
    private Collection<ISalle> precedentchemin ;
    public Dessin(ILabyrinthe labyrinthe, Collection<ISprite> sprites)
    {
        this.sprites = sprites;
        this.labyrinthe = labyrinthe;
        setWidth(labyrinthe.getLargeur()*unite);
        setHeight(labyrinthe.getHauteur()*unite);
        tampon = this.getGraphicsContext2D();
        chargementImages();
        dessinFond();
        setHeroPosition();
        
    }
    
     public void chargementImages(){
    	solImage = new Image("file:icons/pyramide.jpg");
        groundImage = new Image ("file:icons/marbre.jpg");
        cheminImage = new Image ("file:icons/ground.gif");
    }
    
    public void dessinFond(){
        
        tampon.drawImage(solImage,0,0,unite*labyrinthe.getLargeur(),
                unite*labyrinthe.getHauteur());
    }
    
    public void dessinerSprites(){
        tampon.setGlobalAlpha(1);

        for(ISprite i : sprites){
            setLight(i.getPosition());
            i.dessiner(tampon);
            
            
        }
    }
    
    public void dessinSalles(){

        for(ISalle i : labyrinthe){
            setLight(i); 
            tampon.drawImage(cheminImage,i.getX()*unite,i.getY()*unite,unite,unite);
        }
    }
    
    public void dessinChemin(){
        for(ISalle i : labyrinthe.chemin(labyrinthe.getEntree(), labyrinthe.getSortie())){
            setLight(i);
            tampon.drawImage(groundImage,i.getX()*unite,i.getY()*unite,unite,unite);
        }
    }
    
    public void setHeroPosition(){
        if(!spritetrouve){
            for(ISprite i : sprites){
            if(i.getPosition().equals(labyrinthe.getEntree())){
                positionDuHero = i.getPosition();
                spritehero = i;
                spritetrouve=true;
                break;
            }
        }
        }
        else{
            positionDuHero = spritehero.getPosition();
        }
    }
    
    public void setLight(ISalle salleEnQuestion){
  double x1 = positionDuHero.getX(); 
  double y1 = positionDuHero.getY(); 
  double x2 = salleEnQuestion.getX(); 
  double y2 = salleEnQuestion.getY();        
    double distance = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
    if(distance > 5){
        tampon.setGlobalAlpha(0);
    }
    else if(distance >4){
        tampon.setGlobalAlpha(0.2);
    }
    else if(distance >3){
        tampon.setGlobalAlpha(0.3);
    }
    else if(distance >2){
        tampon.setGlobalAlpha(0.5);
    }
    else {
        tampon.setGlobalAlpha(1);
    }
}
    
    
    public void dessinPlusCourtChemin(ISprite heros){
        
        if(compteur == 0){
             precedentchemin = labyrinthe.chemin(heros.getPosition(), labyrinthe.getSortie());
            positionheroprecedente = heros.getPosition();
            for(ISalle i :precedentchemin){
            setLight(i);
            tampon.drawImage(groundImage,i.getX()*unite,i.getY()*unite,unite,unite);
            compteur++;
            }
        }
        else{
                    if(heros.getPosition().equals(positionheroprecedente)){
            for(ISalle i : precedentchemin){
                setLight(i);
            tampon.drawImage(groundImage,i.getX()*unite,i.getY()*unite,unite,unite);
            }
            
        }
        else{
            precedentchemin = labyrinthe.chemin(heros.getPosition(), labyrinthe.getSortie());
            positionheroprecedente = heros.getPosition();
            for(ISalle i :precedentchemin){
            setLight(i);
            tampon.drawImage(groundImage,i.getX()*unite,i.getY()*unite,unite,unite);
        }
        }
        }

        
    }
}