package br.com.facapegraf.examples;

import br.com.facapegraf.model.Grafo;
import br.com.facapegraf.leitu.ConstruGraf;

import java.io.File;

/**
 * Created by marcus on 23/05/2015.
 */

/*
    Dependencies:
        br.com.facapegraf.examples.facapegraf.teste.Conexo;
 */
public class Broto {
    public static void main(String[] args) {

        String caminho = new File("").getAbsoluteFile() + "/resources/matriz6.txt";

        Grafo g = new ConstruGraf(caminho).getGrafo();

        System.out.println("Is Broto: " + isBroto(g));
    }

    public static boolean isBroto(Grafo g) {
        /*A Verificar
        *   Um broto é um ciclo ímpar que é um caminho M-alternante. O único vértice do broto
                que não é saturado por arestas de M que estão no broto é chamado de base do broto
                http://www.din.uem.br/sbpo/sbpo2008/pdf/arq0297.pdf
        * */
        return /*g.getVertices().size() % 2 != 0 && Conexo.isConexo(g);*/true;
    }


}
