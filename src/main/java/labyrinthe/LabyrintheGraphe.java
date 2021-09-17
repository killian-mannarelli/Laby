/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labyrinthe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import labyrinthe.ISalle;
import org.jgrapht.alg.connectivity.KosarajuStrongConnectivityInspector;
import org.jgrapht.alg.interfaces.ShortestPathAlgorithm.SingleSourcePaths;
import org.jgrapht.alg.interfaces.StrongConnectivityAlgorithm;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.SimpleGraph;
import outils.Fichier;
import outils.InvalidFileException;
import personnages.IPersonnage;


/**
 * The Class LabyrintheGraphe.
 *
 * @author kmannarelli
 */
public class LabyrintheGraphe extends Labyrinthe implements ILabyrinthe {


    /** The standard graph. */
    public Graph<ISalle, DefaultEdge> standardGraph;
    public Graph<ISalle, DefaultEdge> lightGraph;

    /**
     * Creer un labyrinthe en reprenant la méthode de Labyrinthe et en créant un Graphe.
     *
     * @param file the file
     */
    @Override
    public void creerLabyrinthe(String file) {
        SimpleGraph<ISalle, DefaultEdge> standardGraph
                = new SimpleGraph<ISalle, DefaultEdge>(DefaultEdge.class);
        super.creerLabyrinthe(file);
        for (ISalle i : this) {
            standardGraph.addVertex(i);
        }

        for (ISalle i : this) {
            for (ISalle j : this) {
                if (i.estAdjacente(j) && !standardGraph.containsEdge(i, j)) {

                    standardGraph.addEdge(i, j);
                }
            }
        }

        this.standardGraph = standardGraph;
        SimpleGraph<ISalle, DefaultEdge> standard2Graph  = new SimpleGraph<ISalle, DefaultEdge>(DefaultEdge.class);
         for (ISalle i : this) {
            standard2Graph.addVertex(i);
        }

        for (ISalle i : this) {
            for (ISalle j : this) {
                if (i.estAdjacente(j) && !standard2Graph.containsEdge(i, j)) {

                    standard2Graph.addEdge(i, j);
                }
            }
    }
        for(ISalle i : this.listeMur){
            standard2Graph.addVertex(i);
            for(ISalle j : this){
                 if (i.estAdjacente(j) && !standard2Graph.containsEdge(i, j)) {

                    standard2Graph.addEdge(i, j);
                }
            }
        }
        this.lightGraph = standard2Graph;
    }
    /**
     * Calcule un chemin entre deux salles à partir du graphe.
     *
     * @param u première salle
     * @param v deuxième salle
     * @return Le chemin sous forme de Liste de ISalle
     */
    @Override
    public Collection<ISalle> chemin(ISalle u, ISalle v) {
        DijkstraShortestPath<ISalle, DefaultEdge> dijkstraAlg =
            new DijkstraShortestPath<>(standardGraph);
        SingleSourcePaths<ISalle, DefaultEdge> iPaths = dijkstraAlg.getPaths(u);
        
        return iPaths.getPath(v).getVertexList();
    }
    
     public Collection<ISalle> cheminLight(ISalle u, ISalle v) {
        DijkstraShortestPath<ISalle, DefaultEdge> dijkstraAlg =
            new DijkstraShortestPath<>(lightGraph);
        SingleSourcePaths<ISalle, DefaultEdge> iPaths = dijkstraAlg.getPaths(u);
        
        return iPaths.getPath(v).getVertexList();
    }
}
