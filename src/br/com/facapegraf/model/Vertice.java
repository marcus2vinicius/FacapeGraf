package br.com.facapegraf.model;

import br.com.facapegraf.enums.Remove;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;


public class Vertice {

    private int valor;
    private List<Aresta> arestas = new ArrayList<Aresta>();

    public Vertice() {
    }

    /**
     * @param Valor do Vertice
     */
    public Vertice(int valor) {
        this.valor = valor;
    }

    /**
     * @return Lista de Arestas
     */
    public List<Aresta> getArestas() {
        return arestas;
    }

    /** Auteracao das Arestas
     * @param Objeto Arestas
     */
//	public void setArestas(List<Aresta> arestas) {
//		Grafo g = new Grafo();
//		for(Aresta arts : arestas){
//			g.addAresta(arts);
//		}
//	}

    /**
     * @param Objeto Vertice
     */
    public Vertice(Vertice valor) {
        this.valor = valor.getValor();
    }

    /**
     * @param Valor do Vertice
     */
    public int getValor() {
        return valor;
    }

    /**
     * @param Valor do Vertice
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    public void add(Aresta aresta) {
        throw new NotImplementedException();
    }

    public void setValor(Vertice valor) {
        this.valor = valor.getValor();
    }

    public boolean remove(Remove remove) {
        if (Remove.Clear == remove)
            return clearArestas();
        return false;
    }

    public boolean remove(Remove remove, Aresta aresta) {
        if (Remove.Single == remove)
            return removeSingle(aresta);
        return false;
    }

    private boolean removeSingle(Aresta aresta) {
        try {
            arestas.remove(aresta);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean clearArestas() {
        try {
            arestas.clear();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * (non-Javadoc)
     *
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

    /**
     * (non-Javadoc)
     *
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
