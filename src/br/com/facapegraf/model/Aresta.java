package br.com.facapegraf.model;

public class Aresta {
	private Vertice v1;
	private Vertice v2;
	
	public Aresta(){
		
	}
	
	/**
	 * @param Objeto Vertice 1
	 * @param Objeto Vertice 2
	 */	
	public Aresta(Vertice v1, Vertice v2){
		this.v1 = v1;
		this.v2 = v2;
	}
	
	/**
	 * @param Valor Vertice 1
	 * @param Valor Vertice 2
	 */
	
	public Aresta(int v1, int v2){
		this.v1 = new Vertice(v1);
		this.v2 = new Vertice(v2);
	}	
	

	/**
	 * @return Vertice 1
	 */
	
	public Vertice getV1() {
		return v1;
	}
	
	/**
	 * @param Vertice 1
	 */
	
	public void setV1(Vertice v1) {
		this.v1 = v1;
	}
	

	/**
	 * @return Vertice 2
	 */
	
	public Vertice getV2() {
		return v2;
	}
	
	/**
	 * @param Vertice 2 
	 */
	
	public void setV2(Vertice v2) {
		this.v2 = v2;
	}
	
	/**
	 * @return Vertice 1 e Vertive 2
	 */
	
	@Override
	public String toString() {
		return "["+v1.getValor()+","+v2.getValor()+ "]";
	}
	
	/**
	 * @return true se houver algum vertice nesta aresta
	 */
	
	public boolean ContainAny(Vertice v){		
		return ( (v1 == v) || (v2 == v) );
	}
	
	/**
	 * @return true se houver pelo menos um vertice em comum
	 */
	
	public boolean isVizinho(Aresta a){		
		return ( (v1 == a.v1) || (v2 == a.v1) || 
				 (v1 == a.v2) || (v2 == a.v2) );
	}
	
	/**
	 * Utilizado no metodo Contains do do List<>, ArrayList<> pra comparacoes
	 * Se a Aresta [1,2] � igual a Aresta [2,1]
	 * @return boolean
	 */	
	@Override
	public boolean equals(Object obj) {
		Aresta a = (Aresta) obj;
		return ( (v1 == a.v1) && (v2 == a.v2) || 
				 (v1 == a.v2) && (v2 == a.v1) );		
	}	
	
	
}