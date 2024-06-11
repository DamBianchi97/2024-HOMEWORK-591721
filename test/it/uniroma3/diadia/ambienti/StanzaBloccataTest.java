package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {
	private StanzaBloccata StanzaTestA;
	private Stanza StanzaTestB;
	private Attrezzo AttrezzoSbloccante;
	
	@BeforeEach
	void setUp() {
		StanzaTestA = new StanzaBloccata("test", "grimaldello", Direzioni.sud);
		StanzaTestB = new Stanza("testAdiacente");
		AttrezzoSbloccante = new Attrezzo("grimaldello", 2);
	}
	@Test
	void testConOggettoSbloccante() {
		StanzaTestA.impostaStanzaAdiacente(Direzioni.sud, StanzaTestB);
		StanzaTestA.addAttrezzo(AttrezzoSbloccante);
		assertEquals(StanzaTestB,StanzaTestA.getStanzaAdiacente(Direzioni.sud));
	}
	@Test
	void testSenzaOggettoSbloccante() {
		Attrezzo a = new Attrezzo("osso",2);
		StanzaTestA.impostaStanzaAdiacente(Direzioni.sud, StanzaTestB);
		StanzaTestA.addAttrezzo(a);
		assertNotEquals(StanzaTestB,StanzaTestA.getStanzaAdiacente(Direzioni.sud));
	}

}
