package it.uniroma3.diadia.personaggi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;


class CaneTest {
	Partita testPartita;
	Cane cane;
	
	@BeforeEach
	public void setUp() {
		testPartita = new Partita(null);
		cane = new Cane("pippo", "cane Pippo");
	}
	@Test
	void testInteragisciCane() {
		cane.agisci(testPartita);
		assertEquals(19, testPartita.getPlayer().getCfu());
	}

}
