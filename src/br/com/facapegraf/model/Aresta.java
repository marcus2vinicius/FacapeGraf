package br.com.facapegraf.model;

public class Aresta {
	private Vertice v1;
	private Vertice v2;
	
	public Aresta(){
		
	}
	
	public Aresta(Vertice v1, Vertice v2){
		this.v1 = v1;
		this.v2 = v2;
	}
	
	public Aresta(int v1, int v2){
		this.v1 = new Vertice(v1);
		this.v2 = new Vertice(v2);
	}	
	
	public Vertice getV1() {
		return v1;
	}
	public void setV1(Vertice v1) {
		this.v1 = v1;
	}
	public Vertice getV2() {
		return v2;
	}
	public void setV2(Vertice v2) {
		this.v2 = v2;
	}
	
	@Override
	public String toString() {
		return "["+v1.getValor()+","+v2.getValor()+ "]";
	}
	
	/*
	 * Retorna true se houver algum vertice nesta aresta
	 */
	public boolean ContainAny(Vertice v){		
		return ( (v1 == v) || (v2 == v) );
	}
	/*
	 * Retorna true se houver pelo menos um vertice em comum
	 */
	public boolean isVizinho(Aresta a){		
		return ( (v1 == a.v1) || (v2 == a.v1) || 
				 (v1 == a.v2) || (v2 == a.v2) );
	}
	
	/*
	 * Utilizado no metodo Contains do do List<>, ArrayList<> pra comparacoes
	 * Uma Aresta [1,2] � igual a [2,1]
	 */
	@Override
	public boolean equals(Object obj) {
		Aresta a = (Aresta) obj;
		return ( (v1 == a.v1) && (v2 == a.v2) || 
				 (v1 == a.v2) && (v2 == a.v1) );		
	}
	
	
}
