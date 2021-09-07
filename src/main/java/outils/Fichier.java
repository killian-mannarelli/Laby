package outils;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import labyrinthe.ISalle;
import labyrinthe.Labyrinthe;
import outils.InvalidFileException;

/**
 *
 * @author INFO Professors team
 */
public class Fichier {
    Scanner sc=null;
    
    public Fichier(String nomFichier){
        try{
	    sc = new Scanner(new File(nomFichier));
	}
	catch(Exception e){ System.out.println(e); }     
    }
    
  // retourne le prochain entier dans le fichier
  // retourne -1 s'il n'y en a pas
    public int lireNombre(){
        if (sc.hasNextInt()){
            return sc.nextInt();
        }
        return -1;
    }
    
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
            System.out.println("NB = "+ nb);
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
    
    public static boolean testPasDeDoublonFichier(File f){
        Labyrinthe test = new Labyrinthe();
        test.creerLabyrinthe(f.getAbsolutePath());
            HashSet<ISalle> test2 = new HashSet<>(test);
            return test2.size() == test.size();
    }
    
    public static boolean testValide(String nomFichier){
        File fichier = new File(nomFichier);
        if(!testCoordonneesSallesFichier(fichier) || !testPasDeDoublonFichier(fichier)){
            return false;

 
        }
        else{
            return true;
        }
    }
    
}
