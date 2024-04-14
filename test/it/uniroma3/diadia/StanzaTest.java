package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.ambienti.Stanza;
import it.uniroma3.attrezzi.Attrezzo;



public class StanzaTest {
	Stanza st1 = new Stanza("stanza 1");
	Stanza st2 = new Stanza("stanza 2");
	Attrezzo spada = new Attrezzo("spada",30);
	@Test
	public void testStanzaAdiacente() {
		assertNull(st1.getStanzaAdiacente("sud"));
	}
	@Test
	public void testGetStanzaAdiacente() {
		st1.impostaStanzaAdiacente("sud", st2);
		assertEquals(st2,st1.getStanzaAdiacente("sud"));
	}
	
	@Test 
	public void testAddAttrezzo() {
		assertTrue(st1.addAttrezzo(spada));
	}

}
