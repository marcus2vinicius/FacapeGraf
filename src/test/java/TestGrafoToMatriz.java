import br.com.facapegraf.leitu.ConstruGraf;
import br.com.facapegraf.model.Aresta;
import br.com.facapegraf.model.Grafo;

public class TestGrafoToMatriz {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Grafo g = new Grafo();

        g.add(new Aresta(1, 1));
        g.add(new Aresta(1, 2));
        g.add(new Aresta(1, 3));
        g.add(new Aresta(2, 4));
        g.add(new Aresta(2, 5));
        g.add(new Aresta(3, 4));
        g.add(new Aresta(3, 5));
        g.add(new Aresta(2, 1));
        g.add(new Aresta(4, 5));
        g.add(new Aresta(5, 5));
        g.add(new Aresta(5, 6));
        g.add(new Aresta(5, 7));
        g.add(new Aresta(6, 7));

        ConstruGraf ConG = new ConstruGraf(g);
        System.out.println(ConG.matrizToString());
        System.out.println("N = " + g.getVertices().size());
        System.out.println("M = " + g.getArestas().size());
    }
}
