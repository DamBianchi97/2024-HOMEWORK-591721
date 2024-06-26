package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

class LabirintoTest {
	
	Labirinto lab = new Labirinto();

	@Test
	void testGetStanzaVincente() {
		assertEquals("Biblioteca", lab.getStanzaVincente().getNome());		
	}
	
	@Test 
	void testGetStanzaCorrente() {
		assertEquals("Atrio", lab.getStanzaCorrente().getNome());
	}
	
	@Test
	void testSetStanzaAdiacente() {
		Stanza st1 = new Stanza("corrente");
		lab.setStanzaCorrente(st1);
		assertEquals("corrente", lab.getStanzaCorrente().getNome());
	}
}
