import static org.junit.Assert.*;
import java.io.File;
import java.util.HashSet;
import labyrinthe.ISalle;
import org.junit.Test;
import outils.Fichier;
import labyrinthe.Labyrinthe;
import labyrinthe.LabyrintheGraphe;
import labyrinthe.Salle;

/**
 *
 * @author INFO Professors team
 */
public class TestFichiersLabyrinthe {

    private File[] getFiles(File repertoire) {
        if (!repertoire.isDirectory()) {
            fail("testCoordonneesSalles - les tests ne concernent pas un répertoire");
        }
        File[] fichiers = repertoire.listFiles();
        return fichiers;
    }

    @Test
    public void testCoordonneesSalles() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        for(File i : fichiers){

            assertTrue(Fichier.testCoordonneesSallesFichier(i));
        }

    }


    @Test
    public void testPasDeDoublon() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        for(File i : fichiers){
            
            
            assertTrue(Fichier.testPasDeDoublonFichier(i));
        }
    }
    
    

    @Test
    public void testChemin() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        for(File i : fichiers){
            
            
            assertTrue(testCheminUnitaire(i));
        }
    }
    
    public boolean testCheminUnitaire(File file){
        Labyrinthe test = new LabyrintheGraphe();
        test.creerLabyrinthe(file.getAbsolutePath());
        if(test.chemin(test.getEntree(),test.getSortie()) == null){
            return false;
        }
        return true;
    }
    
}
