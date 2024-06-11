package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.Partita;

public class ComandoFine extends AbstractComando {
	private static final String NOME = "fine";
	
	@Override
	public void esegui(Partita partita) {
		this.getIo().mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

}
