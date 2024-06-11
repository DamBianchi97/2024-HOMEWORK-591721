package it.uniroma3.diadia.personaggi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class AbstractPersonaggioTest {
	AbstractPersonaggio a1;
	@BeforeEach
	void setUp() {
		a1 = new FakePersonaggio("Dam", "ciao");
	}
	
	@Test
	void testHaSalutato() {
		a1.saluta();
		assertTrue(a1.haSalutato());
	}
}
