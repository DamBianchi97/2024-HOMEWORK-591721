package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa extends AbstractComando {
	private static final String NOME = "posa";
	
	@Override
	public void esegui(Partita partita) {
		if (this.getParametro() == null) {
			this.getIo().mostraMessaggio("non hai inserito nome attrezzo");
			return;
		}
		Stanza stanzaCorrente = partita.getLab().getStanzaCorrente();
		Borsa bag = partita.getPlayer().getBag();
		if(bag.hasAttrezzo(this.getParametro())) {
			stanzaCorrente.addAttrezzo(bag.getAttrezzo(this.getParametro()));
			bag.removeAttrezzo(this.getParametro());
		}
		else {
			this.getIo().mostraMessaggio("L'attrezzo non e' presente nella borsa");
			return;
		}
	}
}
