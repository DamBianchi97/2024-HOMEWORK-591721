package it.uniroma3.diadia;

public interface IO {
	public void mostraMessaggio(String msg); 
	public void mostraMessaggio(Object o); 
	public void mostraMessaggioSequenziale(String msg);
	public void mostraMessaggioSequenziale(Object o);
	public String leggiRiga();
}


