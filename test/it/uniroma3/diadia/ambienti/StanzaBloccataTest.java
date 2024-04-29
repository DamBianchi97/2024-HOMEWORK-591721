package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {
	private StanzaBloccata StanzaTestA = new StanzaBloccata("test", "grimaldello", "sud");
	private Stanza StanzaTestB = new Stanza("testAdiacente");
	private Attrezzo AttrezzoSbloccante = new Attrezzo("grimaldello", 2);
	
	@Test
	void testConOggettoSbloccante() {
		StanzaTestA.impostaStanzaAdiacente("sud", StanzaTestB);
		StanzaTestA.addAttrezzo(AttrezzoSbloccante);
		assertEquals(StanzaTestB,StanzaTestA.getStanzaAdiacente("sud"));
	}
	@Test
	void testSenzaOggettoSbloccante() {
		Attrezzo a = new Attrezzo("osso",2);
		StanzaTestA.impostaStanzaAdiacente("sud", StanzaTestB);
		StanzaTestA.addAttrezzo(a);
		assertNotEquals(StanzaTestB,StanzaTestA.getStanzaAdiacente("sud"));
	}

}
