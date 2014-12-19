package br.com.facapegraf.teste;

import br.com.facapegraf.leitu.ConstruGraf;
import br.com.facapegraf.model.Grafo;

public class TestGrafoToMatriz {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grafo g = new Grafo();
		
		g.addAresta(1, 1);
		g.addAresta(1, 2);
		g.addAresta(1, 3);
		g.addAresta(2, 4);
		g.addAresta(2, 5);
		g.addAresta(3, 4);
		g.addAresta(3, 5);
		g.addAresta(2, 1);
		g.addAresta(4, 5);
		g.addAresta(5, 5);
		g.addAresta(5, 6);
		g.addAresta(5, 7);
		g.addAresta(6, 7);

		ConstruGraf ConG = new ConstruGraf(g);
		System.out.println(ConG.matrizToString());
		System.out.println("N = " + g.getVertices().size());
		System.out.println("M = " + g.getArestas().size());
	}
}
