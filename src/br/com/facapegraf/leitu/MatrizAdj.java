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
	/*
	 * Construtor recebendo o endere�o completo do arquivo
	 * C:\arquivomatriz.txt
	 */
	public MatrizAdj(String enderecoArquivo){
		this.enderecoArquivo = enderecoArquivo;
	}
	
	/*
	 * Retorna uma matriz
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

	private int CountLinhas(){//retorna o número de linhas
		try{
			LineNumberReader contLinhas = new LineNumberReader(
			new InputStreamReader( new FileInputStream(
				enderecoArquivo ) ) );//objeto contador de linhas 
			String proximaLinha = null;
				while ( ( proximaLinha = contLinhas.readLine() ) != null ){//enquanto a próxima linha não for null, continua contando
					if ( proximaLinha == null )
						break;//termina o loop
				}//while
				return contLinhas.getLineNumber();//pega o número de linhas contados no while acima
			}catch (Exception e){//tratamento de erros
				e.printStackTrace();//mostra a pilha de onde partiu o erro
			}//catch
        return 0;
	}//getLinhas
	
	private int CountColunas(){//retorna o número de colunas
		int x = 0;
		try{
			String linha;
			String[] colunas;
			BufferedReader mat = new BufferedReader(
			new FileReader(enderecoArquivo ) );//ler o arquivo em string
			linha = mat.readLine();//recebe a primeira linha
			colunas = linha.split(" ");//vetor recebe a quantidade de char tirando os espaços em branco
			x = colunas.length;//tamanho do vetor( quantidade de colunas )
		}catch ( Exception e ){
			e.printStackTrace();
		}//catch
		return x;
	}
	public int size(){
		if(enderecoArquivo!=null)
			return CountLinhas();
		else return 0;
	}
}

