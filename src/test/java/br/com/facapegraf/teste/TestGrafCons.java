package br.com.facapegraf.teste;

import java.io.File;
import java.io.IOException;

import br.com.facapegraf.leitu.ConstruGraf;
import br.com.facapegraf.model.Grafo;
import br.com.facapegraf.model.Vertice;

public class TestGrafCons {

    public static void main(String[] args) throws IOException {
        /*
		 * os arquivos de matriz estao na pasta recources
		 */
        String caminho = new File("").getAbsoluteFile() + Constantes.url_matriz_exemplos+"/matriz8.txt";
        //String caminho = "C:/Projects/Projetos/Eclipse/FacapeGraf/resources/matriz1.txt";
        ConstruGraf consG = new ConstruGraf(caminho);
        System.out.println(consG.matrizToString());
        Grafo g = consG.getGrafo();
        Vertice v = new Vertice();
    }

}
