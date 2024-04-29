package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	
	String AttrezzoSbloccante;
	String DirezioneBloccata;

	public StanzaBloccata(String nome, String attrezzo, String direzione) {
		super(nome);
		this.AttrezzoSbloccante = attrezzo;
		this.DirezioneBloccata = direzione;
	}
	
	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if (this.DirezioneBloccata.equals(direzione) && !this.hasAttrezzo(AttrezzoSbloccante)) return this;			
		else return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		if (!this.hasAttrezzo(AttrezzoSbloccante)) return "direzione bloccata : "+ this.DirezioneBloccata +"oggetto sbloccante : "+ this.AttrezzoSbloccante;
		return super.getDescrizione();
	}	
}
