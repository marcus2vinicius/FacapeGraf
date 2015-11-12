import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import br.com.facapegraf.model.Aresta;
import br.com.facapegraf.model.Grafo;
import br.com.facapegraf.model.Vertice;

public class Dijkstra1 {
	
	private final List<Vertice> vertices;
	private final List<Aresta> arestas;
	private Set<Vertice> verticesVerificados;
	private Set<Vertice> verticesNaoVerificados;
	private Map<Vertice, Vertice> predecessores;
	private Map<Vertice, Integer> distancia;
	
	public Dijkstra1(Grafo grafo){
		this.vertices = new ArrayList<Vertice>(grafo.getVertices());
		this.arestas = new ArrayList<Aresta>(grafo.getArestas());
	}
	
	public void run(Vertice fonte){
		verticesVerificados = new HashSet<Vertice>();
		verticesNaoVerificados = new HashSet<Vertice>();
		distancia = new HashMap<Vertice, Integer>();
		predecessores = new HashMap<Vertice, Vertice>();
		
		distancia.put(fonte, 0);
		verticesNaoVerificados.add(fonte);
		
		while(verticesNaoVerificados.size() > 0){
			Vertice v = getMinimo(verticesNaoVerificados);
			verticesVerificados.add(v);
			verticesNaoVerificados.remove(v);
			findDistanciasMinimas(v);
		}
	}
	
	private void findDistanciasMinimas(Vertice vertice){
		List<Vertice> verticesAdjacentes = getVizinhos(vertice);
		for(Vertice adj : verticesAdjacentes){
			if (getMenorDistancia(adj) > getMenorDistancia(vertice) + 
										 getDistancia(vertice, adj)) {
				distancia.put(adj, getMenorDistancia(vertice) + 
						           getDistancia(vertice, adj));
				predecessores.put(adj, vertice);
				verticesNaoVerificados.add(adj);
			}
		}
	}
	
	private int getDistancia(Vertice v1, Vertice v2){
		for(Aresta aresta : arestas){
			if (aresta.getV1().equals(v1) && aresta.getV2().equals(v2)) {
				return aresta.getPeso();
			}
		}
		throw new RuntimeException("Erro");
	}
	
	private List<Vertice> getVizinhos(Vertice vertice){
		List<Vertice> vizinhos = new ArrayList<Vertice>();
		for(Aresta aresta : arestas){
			if (aresta.getV1().equals(vertice) && !isVerificado(aresta.getV2())) {
				vizinhos.add(aresta.getV2());
			}
		}
		return vizinhos;
	}
	
	
	private Vertice getMinimo(Set<Vertice> vertices){
		Vertice minimo = null;
		for(Vertice vertice : vertices){
			if(minimo == null){
				minimo = vertice;
			} else {
				if (getMenorDistancia(vertice) < getMenorDistancia(minimo)) {
					minimo = vertice;
				}
			}
		}
		return minimo;
	}
	
	private boolean isVerificado(Vertice vertice){
		return this.verticesVerificados.contains(vertice);
	}
	
	private int getMenorDistancia(Vertice destino){
		Integer d = distancia.get(destino);
		if (d == null) {
			return Integer.MAX_VALUE;
		} else {
			return d;
		}
	}
	
	public LinkedList<Vertice> getCaminho(Vertice alvo){
		LinkedList<Vertice> caminho = new LinkedList<Vertice>();
		Vertice temp = alvo;
		
		if (predecessores.get(temp) == null) {
			return null;
		}
		
		caminho.add(temp);
		while(predecessores.get(temp) != null){
			temp = predecessores.get(temp);
			caminho.add(temp);
		}
		Collections.reverse(caminho);
		return caminho;
	}
}
