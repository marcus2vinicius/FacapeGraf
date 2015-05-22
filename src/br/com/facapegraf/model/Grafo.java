package br.com.facapegraf.model;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

/**Class Grafo, onde contera as listas de Vertices e Arestas, e suas Condicoes.

 * @author Lucas Barros e Marcus Vinicius

 * @version 1.00

 */

public class Grafo {

	private List<Aresta> arestas = new ArrayList<Aresta>();
	private List<Vertice> vertices = new ArrayList<Vertice>();

	public Grafo(){

	}

	/** Adicionar uma Aresta ao Grafo
	 * @param Valor Vertice 1 e Valor Vertice 2
	 * Adinionar Aresta. Ao incluir uma aresta obrigatoriamente, inclui-se dois vertices
	 */
	public void addAresta(int V1, int V2){

		Vertice v1 = addVertice(V1);
		Vertice v2 = addVertice(V2);

		Aresta a = new Aresta(v1,v2);

		if(!arestas.contains(a)){
			arestas.add(a);
			v1.getArestas().add(a);
			v2.getArestas().add(a);
		}
	}

	/** Adicionar uma Aresta ao Grafo
	 * @param Objeto Vertice 1 e Objeto Vertice 2
	 */

	public void addAresta(Vertice V1, Vertice V2) {

		Vertice v1 = addVertice(V1.getValor());
		Vertice v2 = addVertice(V2.getValor());

		Aresta a = new Aresta(v1,v2);


		if(!arestas.contains(a)){
			arestas.add(a);
			v1.getArestas().add(a);
			v2.getArestas().add(a);
		}
	}

	/**
	 * @param Objeto Aresta
	 */

	public void addAresta(Aresta a){
		addAresta(a.getV1(), a.getV2());
	}

	/** Metodo para adicionar um vertice ao grafico Valor
	 *   @param Valor Vertice 1 
	 *   @return Valor do vertice 1
	 */

	public Vertice addVertice(int V){
		if (isValido(V)) {
			Vertice v1 = new Vertice(V);
			//verifica se o vertice nao esta no grafo, caso nao exista ele sera retornado
			if (!vertices.contains(v1)) {
				vertices.add(v1);
			} else {
				//quando o vertice ja existe no grafo ele e retornado
				for (Vertice v : vertices) {
					if (v.equals(v1))
						return v;
				}
			}
			return v1;
		}
		return new Vertice(0);
	}
	private boolean isValido(int Vertice){
		if(Vertice==0)//nao existe vertice de valor zero 0
			return false;
		return true;
	}
	/** Metodo para adicionar um verrtice ao grafico Objeto
	 *   @param Objeto Vertice
	 *   @return vertice 1
	 */

	public Vertice addVertice(Vertice V){
		if (isValido(V.getValor())) {
			Vertice v1 = addVertice(V.getValor());

			if (!vertices.contains(v1)) {
				vertices.add(v1);
			}
			return v1;
		}
		return null;
	}

	/** Metodo para retornar uma lista de Aresta do Grafo
	 *
	 *   @return Lista de arestas do Grafo
	 */

	public List<Aresta> getArestas() {
		return arestas;
	}

	/** Metodo para adicionar uma lista de Aresta ao Grafo
	 *
	 * @param List<Aresta> = Lista de Arestas.
	 */

	public void setAretas(List<Aresta> arestas) {
		//this.arestas = arestas;
		for (Aresta aresta : arestas) {
			addAresta(aresta);
		}
	}

	public void corrigeFalhas() {
		throw new NotImplementedException();
	}

	/** Metodo para retornar uma lista de vertices do Grafo
	 *
	 *   @return Lista de vertives
	 */

	public List<Vertice> getVertices() {
		return vertices;
	}

	/** Metodo para adicionar uma lista de Vertices ao Grafo
	 *
	 * @param List<Vertice> => Lista de vertices
	 */
	public void setVertices(List<Vertice> vertices) {
		for (Vertice vertice : vertices) {
			addVertice(vertice);
		}
	}
}
