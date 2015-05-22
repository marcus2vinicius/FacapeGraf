package br.com.facapegraf.leitu;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Scanner;

public class MatrizAdj {
	private String enderecoArquivo;

	/**
	 * Construtor recebendo o endereço completo do arquivo
	 * @param Endereco String Ex.: C:\arquivomatriz.txt
	 */

	public MatrizAdj(String enderecoArquivo){
		this.enderecoArquivo = enderecoArquivo;
	}

	/**
	 * @return Matriz de Adjacencia do Grafo
	 */

	public int[][] getMatriz(){
		try{
			int linha = CountLinhas();
			int coluna = CountColunas();

			int[][] matriz = new int[linha][coluna];

			Scanner entrada = new Scanner(new File(enderecoArquivo));

			for(int i=0;i<linha;i++)
				for(int j=0;j<coluna;j++)
					matriz[i][j]=entrada.nextInt(); //nexInt() pega os valores inteiros do arquivo
			return matriz;
		}catch(Exception e){
			return null;
		}
	}

	/**
	 * @return Quantidade de Linhas da Matriz
	 */

	private int CountLinhas(){
		try{
			LineNumberReader contLinhas = new LineNumberReader(
					new InputStreamReader( new FileInputStream(
							enderecoArquivo ) ) );//objeto contador de linhas

			String proximaLinha = null;

			while ( ( proximaLinha = contLinhas.readLine() ) != null ){//enquanto a proxima linha nao for null, continua contando
				if ( proximaLinha == null )
					break;//termina o loop
			}//while
			return contLinhas.getLineNumber();//pega o numero de linhas contados no while acima
		}catch (Exception e){//tratamento de erros
			e.printStackTrace();//mostra a pilha de onde partiu o erro
		}//catch
		return 0;
	}//getLinhas

	/**
	 * @return Numero de Colunas
	 */

	private int CountColunas(){
		int x = 0;
		try{
			String linha;
			String[] colunas;

			BufferedReader mat = new BufferedReader(
					new FileReader(enderecoArquivo ) );//ler o arquivo em string

			linha = mat.readLine();//recebe a primeira linha
			colunas = linha.split(" ");//vetor recebe a quantidade de char tirando os espaÃ§os em branco
			x = colunas.length;//tamanho do vetor( quantidade de colunas )

		}catch ( Exception e ){
			e.printStackTrace();
		}//catch
		return x;
	}

	/**
	 * @return Quantidade de Linhas
	 */

	public int size(){
		if(enderecoArquivo!=null)
			return CountLinhas();
		else return 0;
	}
}
