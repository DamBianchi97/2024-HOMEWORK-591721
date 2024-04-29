package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {

	@Test
	void testConOggettoLuminoso() {
		Stanza test = new StanzaBuia("magica","lanterna");
		test.addAttrezzo(new Attrezzo("lanterna", 3));
		assertNotEquals("qui c'è buio pesto", test.getDescrizione());
	}
	
	@Test
	void testSenzaOggettoLuminoso() {
		Stanza test = new StanzaBuia("magica","lanterna");
		test.addAttrezzo(new Attrezzo("osso", 3));
		assertEquals("qui c'è buio pesto", test.getDescrizione());
	}

}
