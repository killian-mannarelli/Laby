/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinthe;

import java.io.IOException;
import java.util.Collection;
import labyrinthe.ISalle;
import org.jgrapht.alg.connectivity.KosarajuStrongConnectivityInspector;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm.SingleSourcePaths;
import org.jgrapht.alg.interfaces.StrongConnectivityAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.Graph;
import org.jgrapht.graph.SimpleGraph;
import outils.Fichier;
import outils.InvalidFileException;
import personnages.IPersonnage;

/**
 *
 * @author kmannarelli
 */
public class LabyrintheGraphe extends Labyrinthe implements ILabyrinthe {
    private int largeur;
    private int hauteur;

    @Override
    public void creerLabyrinthe(String file) {
        SimpleGraph<ISalle, DefaultEdge> standardGraph
                = new SimpleGraph<ISalle, DefaultEdge>(DefaultEdge.class);
                super.creerLabyrinthe(file);
                for(ISalle i : this){
                    standardGraph.addVertex(i);
                }
                
                for(ISalle i :this){
                    for(ISalle j : this){
                        if(i.estAdjacente(j) && !standardGraph.containsEdge(i, j)){
                            
                            standardGraph.addEdge(i, j);
                        }
                    }
                }
    }

   

   

    

   

}
