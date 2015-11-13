package br.com.facapegraf.examples;
import br.com.facapegraf.enums.Tipo;
import br.com.facapegraf.leitu.ConstruGraf;
import br.com.facapegraf.model.Aresta;
import br.com.facapegraf.model.Vertice;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Endereco: ");
        InputStreamReader r = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(r);
        String caminho = br.readLine();

        ConstruGraf cg = new ConstruGraf(caminho, Tipo.Digrafo);

        List<Vertice> vertices = cg.getGrafo().getVertices();

        Dijkstra dijkstra = new Dijkstra(cg.getGrafo());
        
        System.out.println("Vertice de saída: ");
        r = new InputStreamReader(System.in);
        br = new BufferedReader(r);
        int v1 = Integer.parseInt(br.readLine());
        
        System.out.println("Vertice de chegada: ");
        r = new InputStreamReader(System.in);
        br = new BufferedReader(r);
        int v2 = Integer.parseInt(br.readLine());

        LinkedList<Vertice> menorCaminho = dijkstra.getCaminho(vertices.get(v1-1),
        													   vertices.get(v2-1));
        System.out.println();
        if (menorCaminho != null) {
        	System.out.print("Caminho: ");
        	for(Vertice vertice : menorCaminho){
        		System.out.print("-> v" + vertice.getValor());
        	}
		} else {
			System.out.println("Sem caminho!");
		}
    }
}
