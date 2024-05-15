package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	
	Attrezzo it1 = new Attrezzo("lanterna", 3);
	Attrezzo it2 = new Attrezzo("osso", 1);
	Stanza test = new StanzaBuia("magica",it1);
	
	
	
	@Test
	void testInserisciOggettoLuminoso() {
		test.addAttrezzo(it1);
		assertTrue(test.getAttrezzi().contains(it1));
	}
	
	@Test
	void testConOggettoLuminoso() {
		test.addAttrezzo(it1);
		assertNotEquals("qui c'è buio pesto", test.getDescrizione());
	}
		
	@Test
	void testSenzaOggettoLuminoso() {
		test.addAttrezzo(it2);
		assertEquals("qui c'è buio pesto", test.getDescrizione());
	}

}
