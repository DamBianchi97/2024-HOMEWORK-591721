package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

class BorsaTest {
	
	Borsa bag = new Borsa();
	Attrezzo item = new Attrezzo("spada",10);
	
	@Test
	void testAddAttrezzo() {
		bag.addAttrezzo(item);
		assertEquals(bag.getAttrezzo("spada"), item);
	}
	
	@Test
	void testAddAttrezzoTroppoPeso() {
		assertFalse(bag.addAttrezzo(new Attrezzo("spada", 11)));
	}
}
