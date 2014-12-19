package br.com.facapegraf.model;
import java.util.ArrayList;
import java.util.List;


public class Vertice {
	
	private int valor;
	private List<Aresta> arestas = new ArrayList<Aresta>();
	
	public Vertice(){

	}	
	
	/**
	 * @return Lista de Arestas
	 */
	
	public List<Aresta> getArestas() {
		return arestas;
	}
	
	/** Autera��o das Arestas
	 * @param Objeto Arestas
	 */

	public void setArestas(List<Aresta> arestas) {
		Grafo g = new Grafo(); 
		for(Aresta arts : arestas){
			g.AddAresta(arts);
		}
	}
	
	/**
	 * @param Valor do V�rtice
	 */
	
	public Vertice(int valor){
		this.valor = valor;
	}	
	
	/**
	 * @param Objeto V�rtice
	 */
	
	public Vertice(Vertice valor){
		this.valor = valor.getValor();
	}	
	
	/**
	 * @return Valor do V�rtice
	 */
	
	public int getValor() {
		return valor;
	}

	/**
	 * @return Valor do V�rtice
	 */
	
	public void setValor(int valor) {
		this.valor = valor;
	}
	
	/**
	 * @return Objeto V�rtice
	 */
	public void setValor(Vertice valor) {
		this.valor = valor.getValor();
	}


	
	
	/** (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 * Gera��o de C�digo �nico para o Objeto
	 */
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + valor;
		return result;
	}

	/** (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vertice other = (Vertice) obj;
		if (valor != other.valor)
			return false;
		return true;
	}
}
