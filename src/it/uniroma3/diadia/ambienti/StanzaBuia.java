package it.uniroma3.diadia.ambienti;


public class StanzaBuia extends Stanza{
	
	private String attrezzoLuminoso;
	
	public StanzaBuia(String nome, String nomeAttrezzo) {
		super(nome);
		this.attrezzoLuminoso = nomeAttrezzo;
	}
	
	@Override
	public String getDescrizione() {
		if (this.hasAttrezzo(attrezzoLuminoso)) return super.getDescrizione();
	return "qui c'è buio pesto";
	}
}
