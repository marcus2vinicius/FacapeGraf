package br.com.facapegraf.leitu;

import br.com.facapegraf.model.Aresta;
import br.com.facapegraf.model.Grafo;
import br.com.facapegraf.model.Vertice;

/**
 * Classe utilizada para construir o Grafo da Matriz de Adjac�ncia
 */
public class ConstruGraf {

    private Grafo g;
    public int[][] Matriz;
    public String EnderecoArquivo;

    /**
     * @param EnderecoArquivo
     */
    public ConstruGraf(String EnderecoArquivo) {
        this.EnderecoArquivo = EnderecoArquivo;
        init();
    }

    /**
     * @param Grafo
     */
    public ConstruGraf(Grafo g) {
        this.g = g;
        this.addVerticeInMatriz();
        this.addArestaInMatriz();
    }

    /**
     * Adicionar os Vertices na Matriz de Adjacencia
     */
    private void addVerticeInMatriz() {
        int cont = getGrafo().getVertices().size();

        Matriz = new int[cont][cont];

        for (int i = 0; i < cont; i++) {
            for (int j = 0; j < cont; j++) {
                Matriz[i][j] = 0;
            }
        }
    }

    /**
     * Adicionar os Vertices nas Arestas da Matriz de Adjacencia
     */
    private void addArestaInMatriz() {
        if (g.getArestas().size() > 0) {
            for (Aresta a : g.getArestas()) {
                Matriz[a.getV1().getValor() - 1][a.getV2().getValor() - 1] = 1;
                Matriz[a.getV2().getValor() - 1][a.getV1().getValor() - 1] = 1;

                /** @Resumo.:
                 * Uma aresta contem dois valores (v1, v2).
                 * Se um vertice for adjacente a outro, entao, tem-se uma ligacao ou (Toque) representado por '1'
                 * Se nao ouver ligacao entao o valor er '0'.
                 *
                 * - Conceito de Adjacencia (Se dois vertices tiverem uma aresta em comum esses vertices sao Adjacentes)
                 *
                 * Para um melhor entendimento executar o Programa em modo 'Debug' pressionando F6 - caso esteja usando o  'Eclipse'
                 */
            }
        }
    }

    /**
     * Instancia a Matriz
     * Instancia o Grafo
     * Adiciona os Vertices e Arestoas no Grafo
     */
    private void init() {
        Matriz = new MatrizAdj(EnderecoArquivo).getMatriz();
        g = new Grafo();
        addVertices();
        addArestas();
    }

    /**
     * Adicionar os Vertices na Matriz de Adjacencia
     */
    private void addVertices() {
        for (int i = 0; i < Matriz.length; i++) {
            g.getVertices().add(new Vertice(i + 1));
        }
    }

    /**
     * Adicionar as Arestas na Matriz de adjacencia
     */
    private void addArestas() {
        int max = Matriz.length;
        int vert = 0;
        int arest = 0;

        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                if (i <= j) {//i<=j Pega a diagonal principal e Acima dela tambem
                    if (Matriz[i][j] != 0) {

                        Vertice v1 = g.getVertices().get(i);
                        Vertice v2 = g.getVertices().get(j);

                        Aresta a = new Aresta(v1, v2);
                        a.setPeso(Matriz[i][j]);
                        
                        v1.getArestas().add(a);
                        v2.getArestas().add(a);

                        g.getArestas().add(a);
                    }
                }
            }
        }
    }

    /**
     * @return Matriz de Adjacencia do Grafo
     */
    public String matrizToString() {
        String saida = "";
        int max = Matriz.length;
        for (int i = 0; i < max; i++) {
            for (int j = 0; j < max; j++) {
                saida += Matriz[i][j] + " ";

            }
            saida += "\n";
        }
        return saida;
    }

    /**
     * @return Grafo
     */
    public Grafo getGrafo() {
        return g;
    }
}
