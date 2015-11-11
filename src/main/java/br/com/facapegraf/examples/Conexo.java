package br.com.facapegraf.examples;
/**
 * Created by marcus on 23/05/2015.
 */

import br.com.facapegraf.model.Grafo;
import br.com.facapegraf.leitu.ConstruGraf;
import br.com.facapegraf.model.Vertice;
import br.com.facapegraf.model.Aresta;

import java.io.File;

public class Conexo {
    public static void main(String[] args) {

        String caminho = new File("").getAbsoluteFile() + "/resources/matriz6.txt";

        Grafo g = new ConstruGraf(caminho).getGrafo();

        System.out.println("Is Conexo: " + isConexo(g));
    }

    public static boolean isConexo(Grafo g) {
         /*Caso exista algum vertice ou aresta desconexa ele ja considera o grafo
         * desconexo!
		 */
        /*Verificando se existe algum vertice desconexo*/
        for (Vertice v : g.getVertices()) {
            if (v.getArestas().size() == 0)
                return false;
        }
		/*verificando se existe alguma aresta desconexa*/
        for (Aresta are : g.getArestas()) {
            if (!(are.getV1().getArestas().size() > 1 ||
                    are.getV2().getArestas().size() > 1)) {
                return false;
            }
        }
        return true;
    }
}
