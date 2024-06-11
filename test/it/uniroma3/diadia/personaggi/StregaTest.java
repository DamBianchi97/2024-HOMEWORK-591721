package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;

public class StregaTest {
	Partita partita;
	Labirinto labirinto;
	AbstractPersonaggio strega;

	@BeforeEach
	public void setUp1() throws FileNotFoundException, FormatoFileNonValidoException {
		Labirinto lab = Labirinto.newLab("labirinto1.txt").getLab();	
	}
	
	public void setUp2() throws FileNotFoundException, FormatoFileNonValidoException {
		Labirinto lab = Labirinto.newLab("labirinto1.txt").getLab();	
	}

	@Test
	public void testHaSalutato() {
		strega.saluta();
		strega.agisci(partita);
		assertEquals("terza", partita.getLab().getStanzaCorrente().getNome());
	}

	@Test
	public void testNonHaSalutato() {
		strega.agisci(partita);
		assertEquals("seconda", partita.getLab().getStanzaCorrente().getNome());
	}	
	
	@Test
	public void testHaSalutatoStanzaInizialePiuOggetti() throws FileNotFoundException, FormatoFileNonValidoException {
		setUp2();
		strega.saluta();
		strega.agisci(partita);
		assertEquals("terza", partita.getLab().getStanzaCorrente().getNome());
	}
}
