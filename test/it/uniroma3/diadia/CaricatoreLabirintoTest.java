package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class CaricatoreLabirintoTest {

	Scanner scannerDiLinee;
	Labirinto lab1,lab2;
	
	@BeforeEach
	void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		lab1 = Labirinto.newLab("monolocale.txt").getLab();
		lab2 = Labirinto.newLab("bilocale.txt").getLab();
	}
	
	@Test
	void testMonolocale() {
		assertEquals("biblioteca", lab1.getStanzaVincente().getNome());
		assertEquals("biblioteca", lab1.getStanzaCorrente().getNome());
	}
	
	@Test
	void testBilocale() {
		assertEquals("N10", lab2.getStanzaVincente().getNome());
		assertEquals("biblioteca", lab2.getStanzaCorrente().getNome());
	}

	@Test
	void testBilocaleConAttrezzo() {
		Attrezzo testAttrezzo = new Attrezzo("martello", 10);
		assertEquals(testAttrezzo, lab2.getStanzaCorrente().getAttrezzo("martello"));
	}
}
