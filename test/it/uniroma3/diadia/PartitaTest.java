package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;

class PartitaTest {
	private Labirinto lab;
	private Partita game;
	
	@BeforeEach
	void setUp() {
	lab = new LabirintoBuilder()
										.addStanzaIniziale("stanza1")
										.addStanza("stanza2")
										.addAdiacente("stanza1", "stanza2", "sud")
										.addStanzaVincente("stanza2")
										.getLab();
	game = new Partita(lab);
	}
	
	@Test
	public void testGetStanzaVincente() {
		assertEquals("stanza2",game.getLab().getStanzaVincente().getNome());
	}
	
	@Test
	public void testSetStanzaCorrente() {
		assertEquals("stanza1",game.getLab().getStanzaCorrente().getNome());
	}
	
	@Test
	public void testVinta() {
		assertFalse(game.vinta());
	}
}
