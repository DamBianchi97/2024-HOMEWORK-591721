package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.personaggi.Mago;

class ComandoSalutaTest {
	Comando test;
	Partita partita;
	Mago merlino;
	IO io;
	Labirinto lab;
	
	@BeforeEach
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		
		merlino = new Mago("merlino", null, null);
		Labirinto lab = Labirinto.newLab("labirinto1.txt").getLab();	
		partita = new Partita(lab);
		test = new ComandoSaluta();
		
	}
	
	@Test
	void testSalutaMago() {
		test.esegui(partita);
		assertTrue(merlino.haSalutato());
	}

}
