import static org.junit.Assert.*;
import java.io.File;
import org.junit.Test;
import outils.Fichier;

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
        fail("not implemented");
    }


    @Test
    public void testPasDeDoublon() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        fail("not implemented");
    }

    @Test
    public void testChemin() {
        File repertoire = new File("labys/");
        File[] fichiers = getFiles(repertoire);
        fail("not implemented");
    }
    
    boolean testCoordonneesSallesFichier(File f){
        Fichier test = new Fichier(f.getAbsolutePath());
        int largeur = test.lireNombre();
        int hauteur = test.lireNombre();
        boolean result = true;
        boolean isX = true;
        int nb = test.lireNombre();
        while(result){
            if(isX){
                if(nb< largeur && nb != -1){
                    result = false;
                    
                }
                else{
                    isX=false;
                    nb = test.lireNombre();
                }
            }
            else{
              if(nb< hauteur && nb != -1){
                    result = false;
                    
                } 
              else{
                  isX=true;
                    nb = test.lireNombre();
              }
            }
        } 
        
        return result;
    }
}
