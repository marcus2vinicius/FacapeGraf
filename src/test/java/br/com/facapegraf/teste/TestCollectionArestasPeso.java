package br.com.facapegraf.teste;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import br.com.facapegraf.leitu.ConstruGraf;
import br.com.facapegraf.model.Aresta;

public class TestCollectionArestasPeso {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        Grafo g = new Grafo();
        List<Aresta> arestas = new ArrayList<Aresta>();
        HashMap<Aresta, Integer> distancias = new HashMap<Aresta, Integer>();

//        arestas.add(new Aresta(1, 2, 2));
//        arestas.add(new Aresta(1, 3, 1));
//        arestas.add(new Aresta(2, 4, 5));
//        arestas.add(new Aresta(3, 4, 3));
//        arestas.add(new Aresta(3, 5, 2));        
//
//        g.add(arestas);
        
        String caminho = new File("").getAbsoluteFile() + Constantes.url_matriz_exemplos+"/matriz1.txt";
        ConstruGraf cg = new ConstruGraf(caminho);
        Random random = new Random();
        
        arestas = cg.getGrafo().getArestas();
        
        for(Aresta a : arestas)
        	distancias.put(a, random.nextInt(5 - 1 + 1) + 1);
        
//        arestas.get(0).setPeso(2);
//        arestas.get(1).setPeso(1);
//        arestas.get(2).setPeso(5);
//        arestas.get(3).setPeso(3);
//        arestas.get(4).setPeso(2);
        
        for (int i = 0; i < arestas.size(); i++) {
        	arestas.get(i).setPeso(random.nextInt(5 - 1 + 1) + 1);
		}
        
        System.out.println(cg.matrizToString());
        for(Aresta a : arestas){
        	System.out.println("Aresta " + a.getV1() + " - " + a.getV2() + " -> " + a.getPeso());
        }
    }

}
