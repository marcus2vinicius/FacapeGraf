package br.com.facapegraf.leitu;

import br.com.facapegraf.model.Aresta;
import br.com.facapegraf.model.Grafo;
import br.com.facapegraf.model.Vertice;


public class ConstruGraf {
	private Grafo g;
	public int[][] Matriz;
	public String EnderecoArquivo;
	
	public ConstruGraf(String EnderecoArquivo){
		this.EnderecoArquivo = EnderecoArquivo;
		init();
	}
	
	private void init(){
		Matriz = new MatrizAdj(EnderecoArquivo).getMatriz();		
		g = new Grafo();		
		addVertices();
		addArestas();
	}
	private void addVertices(){		
		for (int i=0;i<Matriz.length;i++) {
			g.getVertices().add(new Vertice(i+1));
		}
	}
	private void addArestas(){
		int max = Matriz.length;	
		for (int i=0;i<max;i++) {
			   for (int j=0;j<max;j++) {
				   if(i<=j){//i<=j Pega a diagonal principal e Acima dela tambem
					   if(Matriz[i][j]==1){
						   Vertice v1 = g.getVertices().get(i);
						   Vertice v2 = g.getVertices().get(j);
						   
						   Aresta a = new Aresta(v1,v2);
						   
						   v1.getArestas().add(a);
						   v2.getArestas().add(a);
						   
						   g.getArestas().add( a );
					   }
				   }
			    }
		}
	}
	public void printMatriz(){
		int max = Matriz.length;
		for (int i=0;i<max;i++) {
			   for (int j=0;j<max;j++) {
				   System.out.print(Matriz[i][j]+" ");			    }
			   System.out.println("");
		}
	}
	
	public Grafo getGrafo(){
		return g;
	}
}
