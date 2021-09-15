/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinthe;

import java.util.HashMap;
import javafx.scene.image.Image;

/**
 *
 * @author kmannarelli
 */
public class Mur extends Salle {
    private Image imageMur;
    HashMap<DirectionMur,Image> choix = new HashMap<>();
    
    public Mur(int x, int y){
        super(x,y);
        
    }
    
    
    @Override
    public boolean equals(Object obj) {
        Mur other = (Mur) obj;
        if (getX() != other.getX()) {
            return false;
        }
        if (getY() != other.getY()) {
            return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + getX();
        result = prime * result + getY();
        return result;
    }
    public void setImage(Image newImage){
        imageMur = newImage;
    }
    
    public void choisirImage(){
        choix.put(new DirectionMur(1, 1, 1, 1), new Image("file:icons/mur0.gif"));
        choix.put(new DirectionMur(1, 0, 1, 1), new Image("file:icons/mur1.gif"));
        choix.put(new DirectionMur(1, 1, 1, 0), new Image("file:icons/mur2.gif"));
        choix.put(new DirectionMur(0, 1, 1, 1), new Image("file:icons/mur3.gif"));
        choix.put(new DirectionMur(1, 1, 0, 1), new Image("file:icons/mur4.gif"));
        choix.put(new DirectionMur(1, 0, 1, 0), new Image("file:icons/mur5.gif"));
        choix.put(new DirectionMur(0, 1, 1, 0), new Image("file:icons/mur6.gif"));
        choix.put(new DirectionMur(0, 0, 1, 1), new Image("file:icons/mur7.gif"));
        choix.put(new DirectionMur(1, 0, 0, 1), new Image("file:icons/mur8.gif"));
        choix.put(new DirectionMur(1, 1, 0, 0), new Image("file:icons/mur9.gif"));
        choix.put(new DirectionMur(0, 1, 0, 1), new Image("file:icons/mur10.gif"));
        choix.put(new DirectionMur(0, 0, 0, 1), new Image("file:icons/mur11.gif"));
        choix.put(new DirectionMur(0, 1, 0, 1), new Image("file:icons/mur12.gif"));
        choix.put(new DirectionMur(0, 0, 1, 0), new Image("file:icons/mur13.gif"));
        choix.put(new DirectionMur(1, 0, 0, 0), new Image("file:icons/mur14.gif"));
    }
 
}
