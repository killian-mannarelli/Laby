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
import personnages.Dragon;

/**
 *
 * @author kmannarelli
 */
public class DragonSprite extends ASprite implements EventHandler<KeyEvent> {
    ILabyrinthe labyrinthe;
    Dragon dragon;
    int compteur = 0;
    private ISalle positionheroprecedente ;
    private Collection<ISalle> precedentchemin ;
    public DragonSprite(Dragon dragon,ILabyrinthe labyrinthe){
        super(dragon,new Image("file:icons/monstre1.gif"));
        this.labyrinthe  = labyrinthe;
        this.dragon = dragon;
    }

    @Override
    public void handle(KeyEvent arg0) {
        
    }
    
     public void changerSalleChoisie(){
                if(compteur == 0){
             precedentchemin = labyrinthe.chemin(Core.herosstat.getPosition(), labyrinthe.getSortie());
            positionheroprecedente = Core.herosstat.getPosition();
            for(ISalle i :precedentchemin){
                if(i.estAdjacente(dragon.getPosition())){
                   dragon.setSalleChoisie(i);
                break; 
                }
                
            
            }
            compteur++;
            
        }
        else{
                    if(Core.herosstat.getPosition().equals(positionheroprecedente)){
            for(ISalle i : precedentchemin){
                    if(i.estAdjacente(dragon.getPosition())){
                   dragon.setSalleChoisie(i);
                break; 
                }
            }
            
        }
        else{
            precedentchemin = labyrinthe.chemin(Core.herosstat.getPosition(), labyrinthe.getSortie());
            positionheroprecedente = Core.herosstat.getPosition();
            for(ISalle i :precedentchemin){
            if(i.estAdjacente(dragon.getPosition())){
                   dragon.setSalleChoisie(i);
                break; 
                }
        }
    }
}
}
}