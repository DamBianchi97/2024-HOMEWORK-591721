package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendi extends AbstractComando {
	private static final String NOME = "prendi";
	@Override
	public void esegui(Partita partita) {
		if (this.getParametro() == null) {
			this.getIo() .mostraMessaggio("non hai inserito nome attrezzo");
			return;
		}
		Stanza stanzaCorrente = partita.getLab().getStanzaCorrente();
		Borsa bag = partita.getPlayer().getBag();
		if(stanzaCorrente.hasAttrezzo(this.getParametro())) {
     		 if(bag.addAttrezzo(stanzaCorrente.getAttrezzo(this.getParametro())))  stanzaCorrente.removeAttrezzo(stanzaCorrente.getAttrezzo(this.getParametro()));
     		 else this.getIo().mostraMessaggio("La tua borsa è troppo piena");
		}
		else this.getIo().mostraMessaggio("L'attrezzo non e' presente nella stanza");
		return;
		
	}
}
