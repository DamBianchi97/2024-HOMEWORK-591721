package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends AbstractComando {
	private static final String NOME = "guarda";
	
	@Override
	public void esegui(Partita partita) {
		this.getIo().mostraMessaggio(partita.getLab().getStanzaCorrente().getDescrizione());
		this.getIo().mostraMessaggio("CFU rimanenti :"+ partita.getPlayer().getCfu());
	}
}
