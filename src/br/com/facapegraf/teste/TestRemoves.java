package br.com.facapegraf.teste;

import br.com.facapegraf.enums.Remove;
import br.com.facapegraf.leitu.ConstruGraf;
import br.com.facapegraf.leitu.MatrizAdj;
import br.com.facapegraf.model.Aresta;
import br.com.facapegraf.model.Grafo;
import br.com.facapegraf.model.Vertice;

import java.io.File;

/**
 * Created by NTI-Sistema on 22/05/2015.
 */
public class TestRemoves {

    public static void main(String args[]) {
        String caminho = new File("").getAbsoluteFile() + "/resources/matriz1.txt";
        //String caminho = "C:/Projects/Projetos/Eclipse/FacapeGraf/resources/matriz1.txt";
        Grafo g = new ConstruGraf(caminho).getGrafo();
        //g.remove(Remove.Single, new Aresta(1, 2)); OK
        //g.remove(Remove.Clear); OK
        //g.remove(Remove.Single,new Vertice(1)); OK

    }
}
