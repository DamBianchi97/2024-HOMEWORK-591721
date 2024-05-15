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
		if (this.DirezioneBloccata.equals(direzione) && !this.hasAttrezzo(AttrezzoSbloccante)) {
			System.out.println("Direzione bloccata. Hai bisogno di un attrezzo");
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
