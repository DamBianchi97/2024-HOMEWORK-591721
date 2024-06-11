package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza{
	
	String AttrezzoSbloccante;
	Direzioni DirezioneBloccata;

	public StanzaBloccata(String nome, String attrezzo, Direzioni direzioni) {
		super(nome);
		this.AttrezzoSbloccante = attrezzo;
		this.DirezioneBloccata = direzioni;
	}
	
	@Override
	public Stanza getStanzaAdiacente(Direzioni direzione) {
		if (this.DirezioneBloccata.equals(direzione) && !this.hasAttrezzo(AttrezzoSbloccante)) {
			return this;			
		}
		else return super.getStanzaAdiacente(direzione);
	}
	
	@Override
	public String getDescrizione() {
		if (!this.hasAttrezzo(AttrezzoSbloccante)) return super.getDescrizione()+"\ndirezione bloccata : "+ this.DirezioneBloccata +"\noggetto sbloccante : "+ this.AttrezzoSbloccante;
		return super.getDescrizione();
	}	
}
