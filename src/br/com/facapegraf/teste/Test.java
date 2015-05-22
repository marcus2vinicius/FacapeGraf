package br.com.facapegraf.teste;

import java.io.File;

import br.com.facapegraf.leitu.MatrizAdj;

/* Teste git Testing*/
public class Test {
	/*Este programa apenas cria uma Matriz Ajacente em Objeto e mostra o tamanho dela

      */
	public static void main(String[] args) {
		/*
		 * os arquivos de matriz estao na pasta recources
		 */
		String caminho = new File("").getAbsoluteFile()+"/resources/matriz1.txt";
		//String caminho = "C:/Projects/Projetos/Eclipse/FacapeGraf/resources/matriz1.txt";

		//Retorna uma matriz
		int[][] matriz = new MatrizAdj(caminho).getMatriz();
		/*
		 * Tamanho da Matriz
		 * Ex.: 
		 * 	se 5x5 = 5
		 * 	se 2x2 = 2
		 * 	se 3x3 = 3
		 * 	E o mesmo que:
		 * 		max_i
		 * 		numero de vertices
		 * 		numero de linhas
		 */
		int tam = new MatrizAdj(caminho).size();
		System.out.println(tam);
	}

}