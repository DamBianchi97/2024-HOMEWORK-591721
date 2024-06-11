package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoRegala extends AbstractComando{
	private static final String NOME = "regala";
	
	@Override
	public void esegui(Partita partita) {
		if (this.getParametro() == null) {
			this.getIo().mostraMessaggio("non hai inserito nome attrezzo");
			return;
		}
		Stanza stanzaCorrente = partita.getLab().getStanzaCorrente();
		Borsa bag = partita.getPlayer().getBag();
		if (stanzaCorrente.getPersonaggio() == null) {
			this.getIo().mostraMessaggio("nella stanza non è presente alcun personaggio");
			return;
		}

		if(bag.hasAttrezzo(this.getParametro())) {
			stanzaCorrente.getPersonaggio().riceviRegalo(bag.getAttrezzo(this.getParametro()), partita);
		}
		else {
			this.getIo().mostraMessaggio("L'attrezzo non e' presente nella borsa");
			return;
		}
	}
}
