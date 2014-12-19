package br.com.facapegraf.teste;

import java.util.ArrayList;
import java.util.List;
import br.com.facapegraf.leitu.ConstruGraf;
import br.com.facapegraf.model.Aresta;
import br.com.facapegraf.model.Grafo;
import br.com.facapegraf.model.Vertice;

public class TesteCollectionVertices {

	public static void main(String[] args) {
		Grafo g = new Grafo();
		List<Vertice> vertices = new  ArrayList<Vertice>();
		Vertice v = new Vertice();
		
		v.getArestas().add(new Aresta(5, 6));
		v.getArestas().add(new Aresta(8, 7));
		
		vertices.add(new  Vertice(v));
		vertices.add(new  Vertice(1));
		vertices.add(new  Vertice(3));
		vertices.add(new  Vertice(4));
		vertices.add(new  Vertice(1));
		
		
		g.setVertices(vertices);
		ConstruGraf cg = new ConstruGraf(g);
		System.out.println(cg.matrizToString());
	}

}
