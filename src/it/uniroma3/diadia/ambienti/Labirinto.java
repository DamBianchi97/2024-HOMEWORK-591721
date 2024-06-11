package it.uniroma3.diadia.ambienti;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;


public class Labirinto {
	

	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	
	private Labirinto(String nomeFile) throws FileNotFoundException, FormatoFileNonValidoException{
		CaricatoreLabirinto c =
		new CaricatoreLabirinto(nomeFile);
		c.carica();
		this.stanzaIniziale = c.getStanzaIniziale();
		this.stanzaVincente = c.getStanzaVincente();
	}
    /**
     * Crea tutte le stanze e le porte di collegamento
     * @throws FormatoFileNonValidoException 
     * @throws FileNotFoundException 
     */
	public static LabirintoBuilder newLab(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
		return new LabirintoBuilder(labirinto);
	}

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
	
	public void setStanzaVincente(Stanza stanzaVincente) {
		this.stanzaVincente = stanzaVincente;
	}
	
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaIniziale = stanzaCorrente;
	}

	public Stanza getStanzaCorrente() {
		return this.stanzaIniziale;
	}
	
	
	public static class LabirintoBuilder {
		private Labirinto lab;
		private Stanza UltimaStanza;
		private Map<String,Stanza> AltraStanza;
		
		public LabirintoBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException{
			this.lab = new Labirinto(labirinto);
			this.AltraStanza = new HashMap<>();
		} 
			
		public Labirinto getLab() {
			return this.lab;
		}
		
		public Stanza getUltimaStanza() {
			return this.UltimaStanza;
		}
		
		public Map<String, Stanza> getAltraStanza() {
			return this.AltraStanza;
		}
		
		public void AggiornaUltimaStanza(Stanza s) {
			this.UltimaStanza = s;
			this.AltraStanza.put(s.getNome(), s);
		}
		
		public LabirintoBuilder addStanzaIniziale(String nomeStanza) {
			Stanza s = new Stanza(nomeStanza);
			this.lab.setStanzaCorrente(s);
			this.AggiornaUltimaStanza(s);
			return this;
		}
		
		public LabirintoBuilder addStanzaVincente(String nomeStanza) {
			Stanza s = new Stanza(nomeStanza);
			this.lab.setStanzaVincente(s);
			this.AggiornaUltimaStanza(s);
			return this;
		}
		
		public LabirintoBuilder addStanza(String nomeStanza) {
			Stanza s = new Stanza(nomeStanza);
			this.AggiornaUltimaStanza(s);
			return this;
		}
		
		public LabirintoBuilder addAttrezzo(String nome, int peso) {
			Attrezzo a = new Attrezzo(nome, peso);
			if (this.UltimaStanza.equals(null)) return this;
			this.UltimaStanza.addAttrezzo(a);
			return this;
		}
		
		public LabirintoBuilder addAdiacente(String stanzaCorrente, String stanzaAdiacente, Direzioni direzione) {
			Stanza a = this.AltraStanza.get(stanzaCorrente);
			Stanza b = this.AltraStanza.get(stanzaAdiacente);
			a.impostaStanzaAdiacente(direzione, b);
			return this;
		}
		
		public LabirintoBuilder addStanzaMagica(String nome) {
			Stanza s = new StanzaMagica(nome);
			this.AggiornaUltimaStanza(s);
			return this;
		}
		
		public LabirintoBuilder addStanzaBuia(String nome, String nomeAttrezzoLuminoso,int peso) {
			Stanza s = new StanzaBuia(nome, nomeAttrezzoLuminoso);
			this.AggiornaUltimaStanza(s);
			return this;
		}
		
		public LabirintoBuilder addStanzaBloccata(String nome, String attrezzoSbloccante, String direzioneBloccata) {
			Stanza s = new StanzaBloccata(nome, attrezzoSbloccante, Direzioni.valueOf(direzioneBloccata));
			this.AggiornaUltimaStanza(s);
			return this;
		}
		
		public LabirintoBuilder addPersonaggio(AbstractPersonaggio pg) {
			this.UltimaStanza.setPersonaggio(pg);
			return this;
		}
	}
}