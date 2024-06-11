package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.Partita;

public class ComandoSaluta extends AbstractComando{
	private final static String NOME = "saluta";
	
	@Override
	public void esegui(Partita partita) {
		try {
			this.getIo().mostraMessaggio(partita.getLab().getStanzaCorrente().getPersonaggio().saluta());  
		} catch (NullPointerException e) {
			this.getIo().mostraMessaggio("nessun personaggio da salutare");
		}	
	}
}
