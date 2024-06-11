package it.uniroma3.diadia.ambienti;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;


class LabirintoTest {
	
	Labirinto lab;	

	@BeforeEach
	void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		lab = Labirinto.newLab("labirinto1.txt").getLab();	
	}
	@Test
	void testGetStanzaVincente() {
		assertEquals("Biblioteca", lab.getStanzaVincente().getNome());		
	}
	
	@Test 
	void testGetStanzaCorrente() {
		assertEquals("Atrio", lab.getStanzaCorrente().getNome());
	}
	
	@Test
	void testSetStanzaAdiacente() {
		Stanza st1 = new Stanza("corrente");
		lab.setStanzaCorrente(st1);
		assertEquals("corrente", lab.getStanzaCorrente().getNome());
	}
}
