package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Direzioni;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends AbstractComando{
	private static final String NOME = "vai";
	@Override
	public void esegui(Partita partita) {
		if(this.getParametro()==null) {
			this.getIo().mostraMessaggio("Dove vuoi andare ?");
			return;
		}
		Stanza prossimaStanza = null;
		prossimaStanza = partita.getLab().getStanzaCorrente().getStanzaAdiacente(Direzioni.valueOf(this.getParametro()));
		if (prossimaStanza == null)
			this.getIo().mostraMessaggio("Direzione inesistente");
		else {
			partita.getLab().setStanzaCorrente(prossimaStanza);
			partita.getPlayer().setCfu();
		}
		this.getIo().mostraMessaggio(partita.getLab().getStanzaCorrente().getDescrizione());
		
	}
}
	


