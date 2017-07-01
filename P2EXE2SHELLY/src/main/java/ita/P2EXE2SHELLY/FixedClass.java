package ita.P2EXE2SHELLY;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FixedClass {
	public final void fixedMethod(String FILENAME){
		while (true) {
		    final Scanner console = new Scanner(System.in);
		    System.out.print("Digite a operacao desejada para realizar no arquivo <R para ler um arquivo, "
		    		+ "W para escrever em um arquivo, "+ "S para sair>: ");
		    try {
		    final String opr = console.nextLine();				// protegido com try/catch contra entradas proibidas
		    if ("R".equals(opr)){
				BufferedReader br = null;				
				
				try {
					String sCurrentLine = null;				

					br = new BufferedReader(new FileReader(FILENAME));

					while ((sCurrentLine = br.readLine()) != null) {
						System.out.println(sCurrentLine);
					}

				} catch (IOException e) {

					e.printStackTrace();

				}finally {										// fecha BufferedReader e FileReader

					try {

						if (br != null)
							br.close();

					} catch (IOException ex) {

						ex.printStackTrace();

					}

				}
				
			}
		    else if ("W".equals(opr)) {
		    	BufferedWriter buffWrite = null;	
				  try {
					buffWrite = new BufferedWriter(new FileWriter(FILENAME));
					System.out.println("Escreva algo: ");
				    buffWrite.append(console.nextLine() + "\n");
				} catch (IOException e) {
					e.printStackTrace();
				} finally {

					try {

						if (buffWrite != null)
							buffWrite.close();

					} catch (IOException ex) {

						ex.printStackTrace();

					}

				}
			}
		    else if ("S".equals(opr)){
		    	console.close();
		    	System.out.print("Programa finalizado.");
		    	break;
		    }
		    else {
		    	System.out.print("Entrada incorreta!\n");
		    }
		
		}
		catch (java.util.NoSuchElementException a) {
			System.out.print("Não foi recebida a entrada devida!Programa encerrado.\n");
			break;
		}
	}
}
}