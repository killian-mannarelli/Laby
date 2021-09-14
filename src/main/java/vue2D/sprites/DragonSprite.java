/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author kmannarelli
 */
public class DragonSprite extends ASprite  {
    Dragon dragon;
    int compteur = 0;
    private ISalle positionheroprecedente ;
    public DragonSprite(Dragon dragon,ILabyrinthe labyrinthe){
        super(dragon,new Image("file:icons/monstre1.gif"));
        this.dragon = dragon;
    }

    
    

}