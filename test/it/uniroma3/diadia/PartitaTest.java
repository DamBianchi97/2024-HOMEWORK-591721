package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.ambienti.Stanza;

class PartitaTest {
	Partita game = new Partita();
	Stanza st1 = new Stanza("stanza 1");
	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca",game.getLab().getStanzaVincente().getNome());
	}
	
	@Test
	public void testSetStanzaCorrente() {
		game.getLab().setStanzaCorrente(st1);
		assertEquals(st1,game.getLab().getStanzaCorrente());
	}
	@Test
	public void testVinta() {
		assertFalse(game.vinta());
	}
}
