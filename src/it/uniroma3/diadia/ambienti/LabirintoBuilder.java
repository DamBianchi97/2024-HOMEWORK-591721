package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder {
	private Labirinto lab;
	private Stanza UltimaStanza;
	private Map<String,Stanza> AltraStanza;
	
	public LabirintoBuilder() {
		this.lab = new Labirinto();
		this.AltraStanza = new HashMap<String, Stanza>();
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
	
	public LabirintoBuilder addAdiacente(String stanzaCorrente, String stanzaAdiacente, String direzione) {
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
	
	public LabirintoBuilder addStanzaBuia(String nome, Attrezzo attrezzoLuminoso) {
		Stanza s = new StanzaBuia(nome, attrezzoLuminoso);
		this.AggiornaUltimaStanza(s);
		return this;
	}
	
	public LabirintoBuilder addStanzaBloccata(String nome, String attrezzoSbloccante, String direzioneBloccata) {
		Stanza s = new StanzaBloccata(nome, attrezzoSbloccante, direzioneBloccata);
		this.AggiornaUltimaStanza(s);
		return this;
	}
	
}
	
