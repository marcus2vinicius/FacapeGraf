package br.com.facapegraf.model;
import java.util.ArrayList;
import java.util.List;


public class Vertice {
	private int valor;
	private List<Aresta> arestas = new ArrayList<Aresta>();

	public Vertice(){

	}	
	
	public List<Aresta> getArestas() {
		return arestas;
	}


	public void setArestas(List<Aresta> arestas) {
		this.arestas = arestas;
	}


	public Vertice(int valor){
		this.valor = valor;
	}	
	
	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}
}
