package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;



public class StanzaTest {
	Stanza st1 ;
	Stanza st2 ;
	Attrezzo spada ;

	@BeforeEach
	void setUp() {
		st1 = new Stanza("stanza 1");
		st2 = new Stanza("stanza 2");
		spada = new Attrezzo("spada",5);
	}

	@Test
	public void testStanzaAdiacente() {
		assertNull(st1.getStanzaAdiacente(Direzioni.sud));
	}
	@Test
	public void testGetStanzaAdiacente() {
		st1.impostaStanzaAdiacente(Direzioni.sud, st2);
		assertEquals(st2,st1.getStanzaAdiacente(Direzioni.sud));
	}

	@Test 
	public void testAddAttrezzo() {
		assertTrue(st1.addAttrezzo(spada));
	}

}
