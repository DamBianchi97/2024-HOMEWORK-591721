package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


class GiocatoreTest {
	Giocatore g1 = new Giocatore();
	
	@Test
	void testGetCfu() {
		assertEquals(20,g1.getCfu());
	}
	
	@Test
	void testSetCfu() {
		g1.setCfu();
		assertTrue(g1.getCfu()==19);
	}
}
