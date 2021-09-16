package vue2D.javafx;

import application.Core;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.effect.Light;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import labyrinthe.Labyrinthe;
import labyrinthe.LabyrintheGraphe;
import labyrinthe.Mur;
import labyrinthe.Salle;
import vue2D.sprites.ISprite;


/**
 *   Dessin.
 *
 * @author INFO Professors team
 */

public class Dessin extends Canvas {
    
    
    private Collection<ISprite> sprites;
    
   
    private ILabyrinthe labyrinthe;
    
    
    Labyrinthe lcast;
    
    
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
    
  
    HashMap<CoupleDeSalle,Integer> hm = new HashMap<>();
    
  
    HashSet<ISalle> sallevisitee = new HashSet<>();
    
    /**
     * Constructeur de la classe dessin.
     *
     * @param labyrinthe le  labyrinthe
     * @param sprites la liste des sprites
     */
    public Dessin(ILabyrinthe labyrinthe, Collection<ISprite> sprites)
    {
        this.sprites = sprites;
        this.labyrinthe = labyrinthe;
        lcast= (Labyrinthe) labyrinthe;
        setWidth(labyrinthe.getLargeur()*unite);
        setHeight(labyrinthe.getHauteur()*unite);
        tampon = this.getGraphicsContext2D();
        chargementImages();
        dessinFond();
        //setHeroPosition();
        
    }
    
     /**
      * Chargement des images.
      */
     public void chargementImages(){
    	solImage = new Image("file:icons/pyramide.jpg");
        groundImage = new Image ("file:icons/marbre.jpg");
        cheminImage = new Image ("file:icons/ground.gif");
    }
    
    /**
     * Dessine le fond.
     */
    public void dessinFond(){
        
        tampon.drawImage(solImage,0,0,unite*labyrinthe.getLargeur(),
                unite*labyrinthe.getHauteur());
    }
    
    /**
     * Dessine les sprites.
     */
    public void dessinerSprites(){
        tampon.setGlobalAlpha(1);

        for(ISprite i : sprites){
            setLight(i.getPosition());
            i.dessiner(tampon);
            
            
        }
    }
    
    /**
     * Dessine  les salles.
     */
    public void dessinSalles(){

        for(ISalle i : labyrinthe){
            setLight(i); 
            tampon.drawImage(cheminImage,i.getX()*unite,i.getY()*unite,unite,unite);
        }
    }
    
    /**
     * Dessine  le chemin vers la sortie depuis l'entrée.
     */
    public void dessinChemin(){
        for(ISalle i : labyrinthe.chemin(labyrinthe.getEntree(), labyrinthe.getSortie())){
            setLight(i);
            tampon.drawImage(groundImage,i.getX()*unite,i.getY()*unite,unite,unite);
        }
    }
    
    /**
     * Dessine les murs.
     */
    public void dessinMurs(){
        
        //System.out.println(lcast.listeMur);
        for(Mur i :lcast.listeMur){
            //setLight(i);
            //tampon.setGlobalAlpha(1);
            //i.attribuerImage();
            //System.out.println(i.getImage());
            tampon.drawImage(i.getImage(),i.getX()*unite,i.getY()*unite,unite,unite);
        }
    }
    
    /**
     * Etablis la luminosité de la salle en fonction de la distance (en comptant les salles) du héro .
     *
     * @param salleEnQuestion la salle d'où on veut établir la luminosité
     */
    public void setLight(ISalle salleEnQuestion){
        /**
  Mur m =  new Mur(0,0,(Labyrinthe) labyrinthe);      
  double x1 = positionDuHero.getX(); 
  double y1 = positionDuHero.getY(); 
  double x2 = salleEnQuestion.getX(); 
  double y2 = salleEnQuestion.getY();        
    double distance = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        */
    if(sallevisitee.contains(salleEnQuestion)){
        tampon.setGlobalAlpha(1);
    }
    
    else{
        
            int distance = distanceGraphe(positionDuHero,salleEnQuestion);         
    if(distance > 7){
        tampon.setGlobalAlpha(0);
    }
    else if(distance >6){
        tampon.setGlobalAlpha(0.2);
    }
    else if(distance >5){
        tampon.setGlobalAlpha(0.3);
    }
    else if(distance >4){
        tampon.setGlobalAlpha(0.5);
    }
    else {
        tampon.setGlobalAlpha(1);
    }
    }

}
    
    
    /**
     * Dessine le plus court chemin à partir de la position du héro.
     *
     * @param heros Le Sprite du héro pour récupérer sa position
     */
    public void dessinPlusCourtChemin(ISprite heros){
        
        if(compteur == 0){
             precedentchemin = labyrinthe.chemin(heros.getPosition(), labyrinthe.getSortie());
            positionheroprecedente = heros.getPosition();
            for(ISalle i :precedentchemin){
                for(ISalle j : labyrinthe.sallesAccessibles(heros)){
                    distanceGraphe(i,j);
                }
                
            }
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
    
    /**
     * Calcule la distance entre deux salles à partir du graphe
     *
     * @param u the u
     * @param v the v
     * @return the int
     */
    int distanceGraphe(ISalle u, ISalle v){
        double x1 = u.getX(); 
  double y1 = u.getY(); 
  double x2 = v.getX(); 
  double y2 = v.getY();        
    double distancebrute = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        CoupleDeSalle test = new CoupleDeSalle(u,v);
        if(hm.containsKey(test)){
            return hm.get(test);
        }
        else if(distancebrute>6){
            return 99;
        }
        else{
            
            Collection<ISalle> cheminentre= labyrinthe.chemin(u,v);
            int distance=  cheminentre.size();
            hm.put(test, distance);
            return distance;
        }
        
    }
    
    
}