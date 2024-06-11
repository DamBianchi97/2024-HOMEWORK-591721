package it.uniroma3.diadia;
import java.util.Scanner;

public class IOConsole implements IO{
	Scanner scannerDiLinee;
	
	public IOConsole(Scanner scanner) {
		this.scannerDiLinee = scanner;
	}
	
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}

	public void mostraMessaggio(Object o) {
		System.out.println(o);
	}
	
	public void mostraMessaggioSequenziale(String msg) {
		System.out.printf(msg);
	}

	public void mostraMessaggioSequenziale(Object o) {
		System.out.print(o);
	}
	public String leggiRiga() {
		//Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		//scannerDiLinee.close();
		return riga;

	}
}
