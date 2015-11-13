import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import br.com.facapegraf.enums.Tipo;
import br.com.facapegraf.leitu.ConstruGraf;
import br.com.facapegraf.model.Aresta;
import br.com.facapegraf.model.Grafo;
import br.com.facapegraf.model.Vertice;

public class TestDijkstra1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        Grafo g = new Grafo();
        List<Aresta> arestas = new ArrayList<Aresta>();
        HashMap<Aresta, Integer> distancias = new HashMap<Aresta, Integer>();

        
        String caminho = new File("").getAbsoluteFile() + 
        		Constantes.url_matriz_exemplos+"/matriz7.txt";
        ConstruGraf cg = new ConstruGraf(caminho,Tipo.Digrafo);
        Grafo g= cg.getGrafo();
        arestas = cg.getGrafo().getArestas();
        List<Vertice> vertices = cg.getGrafo().getVertices();
        
        System.out.println(cg.matrizToString());
        for(Aresta a : arestas){
        	System.out.println("Aresta " + a.getV1() + " - " + a.getV2() + " -> " + a.getPeso());
        }
        
        Dijkstra1 dijkstra = new Dijkstra1(cg.getGrafo());
        
        //coloca o vertice destino como parametro
        LinkedList<Vertice> menorCaminho = dijkstra.getCaminho(vertices.get(0), 
        													   vertices.get(0));
        System.out.println();
        if(menorCaminho != null){
        	System.out.print("Caminho: ");
        	for(Vertice vertice : menorCaminho){
        		System.out.print("-> v" + vertice.getValor());
        	}
        } else {
        	System.out.println("Não existe caminho!");
        }
    }

}
