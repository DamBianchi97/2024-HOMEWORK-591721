package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendi implements Comando {
	private String nomeAttrezzo;
	@Override
	public void esegui(Partita partita) {

		IO io = new IOConsole();
		if (nomeAttrezzo == null) {
			io .mostraMessaggio("non hai inserito nome attrezzo");
			return;
		}
		Stanza stanzaCorrente = partita.getLab().getStanzaCorrente();
		Borsa bag = partita.getPlayer().getBag();
		if(stanzaCorrente.hasAttrezzo(nomeAttrezzo)) {
     		 if(bag.addAttrezzo(stanzaCorrente.getAttrezzo(nomeAttrezzo)))  stanzaCorrente.removeAttrezzo(stanzaCorrente.getAttrezzo(nomeAttrezzo));
     		 else io.mostraMessaggio("La tua borsa è troppo piena");
		}
		else io.mostraMessaggio("L'attrezzo non e' presente nella stanza");
		return;
		
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
		
	}
	@Override
	public String getNome() {
		return "prendi";
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}
}
