package application;

import java.io.IOException;
import java.util.Collection;
import labyrinthe.ILabyrinthe;
import labyrinthe.ISalle;
import personnages.Dragon;
import personnages.Heros;
import personnages.IPersonnage;
import personnages.Monstre;
import vue2D.IVue;
import vue2D.sprites.DragonSprite;
import vue2D.sprites.HerosSprite;
import vue2D.sprites.ISprite;
import vue2D.sprites.MonstreSprite;

/**
 *
 * @author INFO Professors team
 */
/**
 * @author Epsi
 *
 */
public class Core {
    ISprite heros;
    DragonSprite dragon;
    public static ISprite herosstat;
    ILabyrinthe labyrinthe;

    protected void initLabyrinthe() {
        // creation du labyrinthe
        labyrinthe = new labyrinthe.LabyrintheGraphe();
        chargementLaby("labys/level10.txt");
    }

    protected void initSprites(IVue vue) {
        // creation du heros 
        
        for(int i =0; i < 4 ; i++){
            Monstre m = new personnages.Monstre(labyrinthe.getSortie());
            MonstreSprite m2 = new MonstreSprite(m,labyrinthe);
            vue.add(m2);
        }
        Dragon d = new personnages.Dragon(labyrinthe.getSortie(),labyrinthe);
        this.dragon = new DragonSprite(d,labyrinthe);
        vue.add(this.dragon);
        Heros h = new personnages.Heros(labyrinthe.getEntree());
        this.heros = new HerosSprite(h, labyrinthe);
        this.herosstat = heros;
        vue.add(this.heros);
    }

    protected void jeu(IVue vue) {
        // boucle principale
        ISalle destination = null;
        while (!labyrinthe.getSortie().equals(heros.getPosition())) {
            // choix et deplacement
            for (IPersonnage p : vue) {
                Collection<ISalle> sallesAccessibles = labyrinthe.sallesAccessibles(p);
                
                destination = p.faitSonChoix(sallesAccessibles); // on demande au personnage de faire son choix de salle
                p.setPosition(destination); // deplacement
            }
            // detection des collisions
            boolean collision = false;
            ISprite monstre = null;
            for (ISprite p : vue) {
                if (p != heros) {
                    if (p.getPosition().equals(heros.getPosition())) {
                        System.out.println("Collision !!");
                        collision = true;
                        monstre = p;
                    }
                    
                }
            }
            if (collision) {
                vue.remove(monstre);
                vue.remove(heros);
                System.out.println("Perdu !");
                System.out.println("Plus que " + vue.size() + " personnages ...");
            }

            temporisation(30);
        }
        System.out.println("Gagn??!");
    }

    private void chargementLaby(String fic) {
        try {
            labyrinthe.creerLabyrinthe(fic);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    protected void temporisation(int nb) {
        try {
            Thread.sleep(nb); // pause de nb millisecondes
        } catch (InterruptedException ie) {
        };
    }
}
