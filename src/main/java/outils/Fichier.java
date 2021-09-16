package outils;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import labyrinthe.ISalle;
import labyrinthe.Labyrinthe;
import labyrinthe.Salle;
import outils.InvalidFileException;

// 
/**
 *  Class Fichier.
 *
 * @author INFO Professors team
 */
public class Fichier {
    
    
    Scanner sc=null;
    
    /**
     * Constructeur de la classe fichier.
     *
     * @param nomFichier  nom fichier
     */
    public Fichier(String nomFichier){
        try{
	    sc = new Scanner(new File(nomFichier));
	}
	catch(Exception e){ System.out.println(e); }     
    }
    
  // retourne le prochain entier dans le fichier
  /**
   * Lire nombre.
   *
   * @return the int
   */
  // retourne -1 s'il n'y en a pas
    public int lireNombre(){
        if (sc.hasNextInt()){
            return sc.nextInt();
        }
        return -1;
    }
    
    /**
     * Test si les coordonnees des salles sont valides dans le fichier.
     *
     * @param f le fichier
     * @return true, if successful
     */
    public static boolean testCoordonneesSallesFichier(File f){
        Fichier test = new Fichier(f.getAbsolutePath());
        System.out.println("Analyse du niveau : " + f.getName());
        int largeur = test.lireNombre();
        int hauteur = test.lireNombre();
        boolean result = true;
        boolean isX = true;
        boolean fin = true;
        int nb = test.lireNombre();
        while(result && fin){
            //System.out.println("NB = "+ nb);
            if(isX){
                if(nb> largeur || nb<0 && nb !=-1){
                    
                    result = false;
                    
                }
                else if(nb == -1){
                    fin = false;
                }
                else{
                    isX=false;
                    nb = test.lireNombre();
                }
            }
            else{
              if(nb> hauteur || nb<0 && nb !=-1){
                    result = false;
                    
                }
              else if(nb == -1){
                    fin = false;
                }
              else{
                  isX=true;
                    nb = test.lireNombre();
              }
            }
        } 
        
        return result;
    }
    
    /**
     * Test si il n'y a pas de doublon dans le fichier.
     *
     * @param file le fichier
     * @return true, if successful
     */
    public static boolean testPasDeDoublonFichier(File file){
        Labyrinthe test = new Labyrinthe();
             Fichier f = new Fichier(file.getAbsolutePath());
                test.setLargeur(f.lireNombre()); 
        test.setHauteur(f.lireNombre());
        int xentree = f.lireNombre();
        int yentree = f.lireNombre();
        int xsortie = f.lireNombre();
        int ysortie = f.lireNombre();
        Salle entree = new Salle(xentree,yentree);
        Salle sortie = new Salle(xsortie,ysortie);
        test.add(entree);
        test.add(sortie);
        test.setEntree(entree);
        test.setSortie(sortie);
        int nb = ysortie;
        int nextX = 0;
        int nextY = 0;
        boolean isX = false;
        while(nb != -1){
          isX = !isX;
          nb = f.lireNombre();
          if(isX && nb !=-1){
              
              nextX= nb;
              
          }
          else if(!isX && nb != -1)   {
                      nextY = nb;
                      Salle newSalle = new Salle(nextX,nextY);
                      test.add(newSalle);
                      }
        }
            HashSet<ISalle> test2 = new HashSet<>(test);
            return test2.size() == test.size();
    }
    
    /**
     * Test si un fichier de niveau est valide.
     *
     * @param nomFichier  nom fichier
     * @return true, if successful
     * @throws InvalidFileException renvoie cette exception si le fichier est invalide
     */
    public static boolean testValide(String nomFichier) throws InvalidFileException{
        File fichier = new File(nomFichier);
        if(!testCoordonneesSallesFichier(fichier)){
            throw new InvalidFileException("Mauvais fichier");

 
        }
        else{
            File fichier2 = new File(nomFichier);
            if(!testPasDeDoublonFichier(fichier2)){
                throw new InvalidFileException("Mauvais fichier");
            }
        }
        return true;
    }
    
}
