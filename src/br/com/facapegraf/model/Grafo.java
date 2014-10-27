package br.com.facapegraf.model;
/*marcus vinicius 2014*/
import java.util.ArrayList;
import java.util.List;

public class Grafo {
	private List<Aresta> arestas = new ArrayList<Aresta>();
	private List<Vertice> vertices = new ArrayList<Vertice>();
	
	public Grafo(){
		
	}
	
	public List<Aresta> getArestas() {
		return arestas;
	}
	public void setAretas(List<Aresta> arestas) {
		this.arestas = arestas;
	}
	public List<Vertice> getVertices() {
		return vertices;
	}
	public void setVertices(List<Vertice> vertices) {
		this.vertices = vertices;
	}
	
}
