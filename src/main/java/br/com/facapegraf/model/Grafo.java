package br.com.facapegraf.model;

import br.com.facapegraf.enums.Remove;
import br.com.facapegraf.enums.Tipo;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Class Grafo, onde contera as listas de Vertices e Arestas, e suas Condicoes.
 * @version 0.1
 */

public class Grafo {

    private List<Aresta> arestas = new ArrayList<Aresta>();
    private List<Vertice> vertices = new ArrayList<Vertice>();
    private Tipo tipo;

    public Grafo() {

    }

    /**
     * Adicionar uma Aresta ao Grafo
     *
     * @param Valor Vertice 1 e Valor Vertice 2
     *              Adinionar Aresta. Ao incluir uma aresta obrigatoriamente, inclui-se dois vertices
     */
    private void addAresta(int V1, int V2) {

        Vertice v1 = addVertice(V1);
        Vertice v2 = addVertice(V2);

        Aresta a = new Aresta(v1, v2);

        if (!arestas.contains(a)) {
            arestas.add(a);
            v1.getArestas().add(a);
            v2.getArestas().add(a);
        }
    }

    /**
     * @param Object Vertice 1 e Objeto Vertice 2
     *  Adicionar uma Aresta ao Grafo
     */
    private void addAresta(Vertice V1, Vertice V2) {

        Vertice v1 = addVertice(V1.getValor());
        Vertice v2 = addVertice(V2.getValor());

        Aresta a = new Aresta(v1, v2);


        if (!arestas.contains(a)) {
            arestas.add(a);
            v1.getArestas().add(a);
            v2.getArestas().add(a);
        }
    }

    /**
     * @param Objeto Aresta
     */
    public void add(Aresta a) {
        addAresta(a.getV1(), a.getV2());
    }

    /**
     * Metodo para adicionar um vertice ao grafico Valor
     *
     * @param Valor Vertice 1
     * @return Valor do vertice 1
     */

    private Vertice addVertice(int V) {
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

    private boolean isValido(int Vertice) {
        if (Vertice == 0)//nao existe vertice de valor zero 0
            return false;
        return true;
    }

    /**
     * Metodo para adicionar um verrtice ao grafico Objeto
     *
     * @param Objeto Vertice
     * @return vertice 1
     */
    public Vertice add(Vertice V) {
        if (isValido(V.getValor())) {
            Vertice v1 = addVertice(V.getValor());

            if (!vertices.contains(v1)) {
                vertices.add(v1);
            }
            return v1;
        }
        return null;
    }

    public void add(List<?> objects) {
        if (objects != null && objects.size() > 0) {
            if (objects.get(0) instanceof Vertice)
                setVertices((List<Vertice>) (Object) objects);
            else if (objects.get(0) instanceof Aresta)
                setAretas((List<Aresta>) (Object) objects);
        }
    }

    public boolean remove(Aresta aresta) {
        return remove(Remove.Single, aresta);
    }

    public boolean remove(Vertice vertice) {
        return remove(Remove.Single, vertice);
    }

    public boolean remove(List<?> objects) {
        try {
            if (objects != null && objects.size() > 0) {

                if (objects.get(0) instanceof Vertice)
                    removeVerticeAll((List<Vertice>) (Object) objects);
                else if (objects.get(0) instanceof Aresta)
                    removeArestaAll((List<Aresta>) (Object) objects);

                return true;
            }
            return false;
        }catch (Exception e){
            return false;
        }

    }

    private void removeArestaAll(List<Aresta> arestas) {
        throw new NotImplementedException();
    }

    private void removeVerticeAll(List<Vertice> vertices) {
        throw new NotImplementedException();
    }

    public boolean remove(Remove remove) {
        if (Remove.Clear == remove)
            return clearGrafo();
        return false;
    }

    private boolean clearGrafo() {
        try {
            arestas.clear();
            vertices.clear();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean remove(Remove remove, Aresta aresta) {
        if (Remove.Single == remove)
            return removeSingle(aresta);
        return false;
    }

    private boolean removeSingle(Aresta aresta) {
        try {
            aresta = arestas.get(arestas.indexOf(aresta));

            Vertice v1 = vertices.get(vertices.indexOf(aresta.getV1()));
            Vertice v2 = vertices.get(vertices.indexOf(aresta.getV2()));
            v1.remove(Remove.Single, aresta);
            v2.remove(Remove.Single, aresta);
            arestas.remove(aresta);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private boolean remove(Remove remove, Vertice vertice) {
        if (Remove.Single == remove)
            return removeSingle(vertice);
        return false;
    }

    private boolean removeSingle(Vertice vertice) {
        try {
            vertice = vertices.get(vertices.indexOf(vertice));
            arestas.removeAll(vertice.getArestas());
            vertice.remove(Remove.Clear);
            vertices.remove(vertice);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Metodo para retornar uma lista de Aresta do Grafo
     *
     * @return Lista de arestas do Grafo
     */

    public List<Aresta> getArestas() {
        return arestas;
    }

    /**
     * Metodo para adicionar uma lista de Aresta ao Grafo
     *
     * @param List<Aresta> = Lista de Arestas.
     */
    private void setAretas(List<Aresta> arestas) {
        //this.arestas = arestas;
        for (Aresta aresta : arestas) {
            add(aresta);
        }
    }

    public void corrigeFalhas() {
        throw new NotImplementedException();
    }

    /**
     * Metodo para retornar uma lista de vertices do Grafo
     *
     * @return Lista de vertives
     */

    public List<Vertice> getVertices() {
        return vertices;
    }

    /**
     * Metodo para adicionar uma lista de Vertices ao Grafo
     *
     * @param List<Vertice> => Lista de vertices
     */
    private void setVertices(List<Vertice> vertices) {
        for (Vertice vertice : vertices) {
            add(vertice);
        }
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public boolean contains(Aresta aresta){
        Aresta arestaIvertida = new Aresta(aresta.getV2(),aresta.getV1());
        return arestas.contains(aresta) || arestas.contains(arestaIvertida);
    }
}
