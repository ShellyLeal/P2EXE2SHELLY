package a.P2EXE2SHELLY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class VulnerableClass {
	public void vulnerableMethod(String FILENAME){
		while (true) {
		    Scanner console = new Scanner(System.in);      // scanner n�o � fechado
		    System.out.print("Digite a operacao desejada para realizar no arquivo <R para ler um arquivo, "
		    		+ "W para escrever em um arquivo>? ");
			
		    String opr= console.nextLine();			// opr pode ser chamado fora do if
			
		    if (opr.equals("R")){
				BufferedReader br = null;  // podem ser usados fora do try
				FileReader fr = null;
				
				try {

					fr = new FileReader(FILENAME);
					br = new BufferedReader(fr);  // uso de declara��o dupla de br

					String sCurrentLine;   // pode ser usada fora do while

					br = new BufferedReader(new FileReader(FILENAME));

					while ((sCurrentLine = br.readLine()) != null) {
						System.out.println(sCurrentLine);
					}

				} catch (IOException e) {

					e.printStackTrace();

				} 
			}
			
			else {
				  BufferedWriter buffWrite;   //buffWrite pode ser usado fora do try
				  
				  try {
					buffWrite = new BufferedWriter(new FileWriter(FILENAME));
					String linha = "";
					System.out.println("Escreva algo: ");
				    linha = console.nextLine();
				    buffWrite.append(linha + "\n");
				     
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
		}
	}
}
