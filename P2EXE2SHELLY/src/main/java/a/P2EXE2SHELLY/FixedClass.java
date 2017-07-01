package a.P2EXE2SHELLY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FixedClass {
	public void fixedMethod(String FILENAME){
		while (true) {
		    Scanner console = new Scanner(System.in);
		    System.out.print("Digite a operacao desejada para realizar no arquivo <R para ler um arquivo, "
		    		+ "W para escrever em um arquivo, "+ "S para sair>: ");
		    String opr= console.nextLine();	
		    if (opr.equals("R")){
				BufferedReader br = null;				// buffer reader e file reader não são fechados
				FileReader fr = null;
				
				try {

					fr = new FileReader(FILENAME);
					br = new BufferedReader(fr);

					String sCurrentLine;				// não é necessário declarar essa string fora

					br = new BufferedReader(new FileReader(FILENAME));

					while ((sCurrentLine = br.readLine()) != null) {
						System.out.println(sCurrentLine);
					}

				} catch (IOException e) {

					e.printStackTrace();

				} 
			}
		    else if (opr.equals("W")) {
				  
				  try {
					BufferedWriter buffWrite = new BufferedWriter(new FileWriter(FILENAME));
					System.out.println("Escreva algo: ");
				    buffWrite.append(console.nextLine() + "\n");
				    buffWrite.close();
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
		    else if (opr.equals("S")){
		    	console.close();
		    	System.out.print("Programa finalizado.");
		    	break;
		    }
		    else {
		    	System.out.print("Entrada incorreta!\n");
		    }
		
		}
	}
}
