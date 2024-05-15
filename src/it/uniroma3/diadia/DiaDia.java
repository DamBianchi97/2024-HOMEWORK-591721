package it.uniroma3.diadia;





import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.FabbricaDiComandi;
import it.uniroma3.diadia.comandi.FabbricaDiComandiFisarmonica;


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
	

	private Partita partita;
	private IO io;
	private FabbricaDiComandi factory;
	
	public DiaDia(Labirinto lab, IO io) {
		this.io = io;
		this.partita = new Partita(lab);
		this.factory = new FabbricaDiComandiFisarmonica();
	}
	
	public void gioca() {
		String istruzione; 

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
		Comando comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(partita);

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
	
	
	public static void main(String[] argc) {
		IO io = new IOConsole();
		Labirinto lab = new LabirintoBuilder()
											.addStanzaIniziale("Atrio")
											.addAttrezzo("osso", 1)
											.addStanza("Aula N10")
											.addAttrezzo("chiave", 2)
											.addAdiacente("Atrio", "Aula N10", "sud")
											.addStanzaBloccata("Corridoio uffici", "chiave", "est")
											.addAdiacente("Aula N10", "Corridoio uffici", "est")
											.addStanzaVincente("Ufficio Crescenzi")
											.addAdiacente("Corridoio uffici", "Ufficio Crescenzi", "est")
											.getLab();
		DiaDia gioco = new DiaDia(lab,io);
		gioco.gioca();
	}
}