package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa implements Comando {
	String nomeAttrezzo;
	@Override
	public void esegui(Partita partita) {
		IO io = new IOConsole();
		if (nomeAttrezzo == null) {
			io .mostraMessaggio("non hai inserito nome attrezzo");
			return;
		}
		Stanza stanzaCorrente = partita.getLab().getStanzaCorrente();
		Borsa bag = partita.getPlayer().getBag();
		if(bag.hasAttrezzo(nomeAttrezzo)) {
			stanzaCorrente.addAttrezzo(bag.getAttrezzo(nomeAttrezzo));
			bag.removeAttrezzo(nomeAttrezzo);
		}
		else {
			io.mostraMessaggio("L'attrezzo non e' presente nella borsa");
			return;
		}
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;

	}
	@Override
	public String getNome() {
		return "posa";
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}
}
