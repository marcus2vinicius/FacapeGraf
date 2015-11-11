import java.util.ArrayList;
import java.util.List;

import br.com.facapegraf.leitu.ConstruGraf;
import br.com.facapegraf.model.Aresta;
import br.com.facapegraf.model.Grafo;
import br.com.facapegraf.model.Vertice;

public class TesteCollectionVertices {

    public static void main(String[] args) {
        Grafo g = new Grafo();
        List<Vertice> vertices = new ArrayList<Vertice>();
        Vertice v = new Vertice();

        v.getArestas().add(new Aresta(5, 6));  //Nao usar isso
        v.getArestas().add(new Aresta(8, 7));  //Nao usar isso

        v.add(new Aresta(2, 3)); //Usar assim pf implementar o metodo

        vertices.add(new Vertice(v));
        vertices.add(new Vertice(1));
        vertices.add(new Vertice(3));
        vertices.add(new Vertice(4));
        vertices.add(new Vertice(1));


        g.add(vertices);
        ConstruGraf cg = new ConstruGraf(g);
        System.out.println(cg.matrizToString());
    }

}
