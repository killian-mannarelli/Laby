/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vue2D.sprites;

import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import labyrinthe.ILabyrinthe;
import personnages.Monstre;

/**
 *
 * @author kmannarelli
 */
public class MonstreSprite extends ASprite {
    ILabyrinthe labyrinthe;
    Monstre monstre;
    public MonstreSprite(Monstre monstre,ILabyrinthe labyrinthe){
        super(monstre,new Image("file:icons/monstre0.gif"));
        this.labyrinthe  = labyrinthe;
        this.monstre = monstre;
    }

    
}
