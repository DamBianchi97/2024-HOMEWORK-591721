package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai implements Comando{
	
	private String direzione;
	
	
	
	@Override
	public void esegui(Partita partita) {
		IO io = new IOConsole();
		if(this.direzione==null) {
			io.mostraMessaggio("Dove vuoi andare ?");
			return;
		}
		Stanza prossimaStanza = null;
		prossimaStanza = partita.getLab().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			io.mostraMessaggio("Direzione inesistente");
		else {
			partita.getLab().setStanzaCorrente(prossimaStanza);
			partita.getPlayer().setCfu();
		}
		io.mostraMessaggio(partita.getLab().getStanzaCorrente().getDescrizione());
		
	}



	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
		
	}

	@Override
	public String getNome() {
		return "vai";
	}

	@Override
	public String getParametro() {
		return this.direzione;
	}
}
	


