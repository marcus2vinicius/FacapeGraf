package br.com.facapegraf.examples;

import java.io.File;

import br.com.facapegraf.model.Grafo;
import br.com.facapegraf.leitu.ConstruGraf;

/**
 * Created by marcus on 23/05/2015.
 */
public class Trivial {
    public static void main(String[] args) {

        String caminho = new File("").getAbsoluteFile() + "/resources/matriz7.txt";

        Grafo g = new ConstruGraf(caminho).getGrafo();

        System.out.println("Is Trivial: " + isTrivial(g));
    }

    public static boolean isTrivial(Grafo g) {
        return g.getVertices().size() == 1 && g.getArestas().size() == 0;
    }
}
