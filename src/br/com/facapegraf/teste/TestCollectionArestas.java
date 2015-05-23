package br.com.facapegraf.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.facapegraf.leitu.ConstruGraf;
import br.com.facapegraf.model.Aresta;
import br.com.facapegraf.model.Grafo;

public class TestCollectionArestas {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Grafo g = new Grafo();
        List<Aresta> arestas = new ArrayList<Aresta>();

        arestas.add(new Aresta(1, 2));
        arestas.add(new Aresta(1, 3));
        arestas.add(new Aresta(1, 4));
        arestas.add(new Aresta(1, 5));
        arestas.add(new Aresta(1, 1));
        arestas.add(new Aresta(1, 2));
        arestas.add(new Aresta(1, 2));
        arestas.add(new Aresta(2, 1));

        g.add(arestas);
        ConstruGraf cg = new ConstruGraf(g);
        System.out.println(cg.matrizToString());
    }

}
