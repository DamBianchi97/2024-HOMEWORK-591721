package it.uniroma3.diadia;


import java.util.Scanner;

import it.uniroma3.ambienti.Stanza;
import it.uniroma3.giocatore.Borsa;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa"};

	private Partita partita;
	private IOConsole io;
	
	public DiaDia(IOConsole console) {
		this.io = console;
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione; 
		Scanner scannerDiLinee;

		io.mostraMessaggio(MESSAGGIO_BENVENUTO);		
		do		
			istruzione = io.leggiRiga();
		while (!processaIstruzione(istruzione));
	   }


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		Comando comandoDaEseguire = new Comando(istruzione);
		
		if (comandoDaEseguire.getNome() == null)
			io.mostraMessaggio("Devi inserire un comando");
		else if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else
			io.mostraMessaggio("Comando sconosciuto");
	    if (this.partita.getPlayer().getCfu()==0) {
	    	io.mostraMessaggio("Cfu : "+this.partita.getPlayer().getCfu()+". Hai perso!");
			return true;
	    }
		if (this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!");
			return true;
		}
		return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		System.out.println();
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLab().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.getLab().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getPlayer().getCfu();
			this.partita.getPlayer().setCfu();
		}
		io.mostraMessaggio(partita.getLab().getStanzaCorrente().getDescrizione());
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}
	
	/**
	 * 
	 * @param nomeAttrezzo
	 * prende l'attrazzo nomeAttrezzo dalla stanza e lo mette nella borsa
	 */
	private void prendi(String nomeAttrezzo) {
		if (nomeAttrezzo == null) {
			io.mostraMessaggio("non hai inserito nome attrezzo");
			return;
		}
		Stanza stanzaCorrente = this.partita.getLab().getStanzaCorrente();
		Borsa bag = this.partita.getPlayer().getBag();
		if(stanzaCorrente.hasAttrezzo(nomeAttrezzo)) {
		 bag.addAttrezzo(stanzaCorrente.getAttrezzo(nomeAttrezzo));
		 stanzaCorrente.removeAttrezzo(stanzaCorrente.getAttrezzo(nomeAttrezzo));
		}
		else io.mostraMessaggio("L'attrezzo non e' presente nella stanza");
		return;
	}
	
	private void posa(String nomeAttrezzo) {
		if (nomeAttrezzo == null) {
			io.mostraMessaggio("non hai inserito nome attrezzo");
			return;
		}
		Stanza stanzaCorrente = this.partita.getLab().getStanzaCorrente();
		Borsa bag = this.partita.getPlayer().getBag();
		if(bag.hasAttrezzo(nomeAttrezzo)) {
			stanzaCorrente.addAttrezzo(bag.getAttrezzo(nomeAttrezzo));
			bag.removeAttrezzo(nomeAttrezzo);
		}
		else {
			io.mostraMessaggio("L'attrezzo non e' presente nella borsa");
			return;
		}
		
	}
	public static void main(String[] argc) {
		
		DiaDia gioco = new DiaDia(new IOConsole());
		gioco.gioca();
	}
}