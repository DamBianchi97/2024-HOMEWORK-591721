package it.uniroma3.diadia.ambienti;


public class StanzaBuia extends Stanza{
	
	String attrezzoLuminoso;
	
	public StanzaBuia(String nome, String attrezzo) {
		super(nome);
		this.attrezzoLuminoso = attrezzo;	
	}
	
	@Override
	public String getDescrizione() {
		for (int i = 0; i<this.getNumeroAttrezzi(); i++) {
			if (this.getAttrezzi()[i].getNome()==this.attrezzoLuminoso) return super.getDescrizione();
		}
	return "qui c'è buio pesto";
	}
}
