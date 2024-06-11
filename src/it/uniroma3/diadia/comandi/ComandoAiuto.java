package it.uniroma3.diadia.comandi;


import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends AbstractComando {
	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa","guarda","borsa","interagisci","saluta","regala"};
	private static final String NOME = "aiuto";

	@Override
	public void esegui(Partita partita) {
		for(int i=0; i< elencoComandi.length; i++) 
			this.getIo().mostraMessaggio(elencoComandi[i]+" ");
	}


}

