package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;

class PartitaTest {
	private Partita game;
	
	@BeforeEach
	void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
	Labirinto lab = Labirinto.newLab("labirinto1.txt").getLab();	
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
