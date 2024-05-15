package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaBuia extends Stanza{
	
	Attrezzo attrezzoLuminoso;
	
	public StanzaBuia(String nome, Attrezzo it) {
		super(nome);
		this.attrezzoLuminoso = it;	
	}
	
	@Override
	public String getDescrizione() {
		if (this.getAttrezzi().contains(attrezzoLuminoso)) return super.getDescrizione();
	return "qui c'è buio pesto";
	}
}
