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
		    		+ "W para escrever em um arquivo>? ");
			
		    if (console.nextLine().equals("R")){
			
				try {
					BufferedReader br = new BufferedReader(new FileReader(FILENAME));

					while ((br.readLine()) != null) {
						System.out.println(br.readLine());
					}
					br.close();
				} catch (IOException e) {

					e.printStackTrace();

				} 
			}
			
			else {
				  
				  try {
					BufferedWriter buffWrite = new BufferedWriter(new FileWriter(FILENAME));
					System.out.println("Escreva algo: ");
				    buffWrite.append(console.nextLine() + "\n");
				    buffWrite.close();
				} catch (IOException e) {
					e.printStackTrace();
				} 
			}
		console.close();
		}
	}
}
