package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;


class ComandoPrendiTest {

	@Test
	void test() throws FileNotFoundException, FormatoFileNonValidoException {
		
		Labirinto lab = Labirinto.newLab("labirinto1.txt").getLab();										
		Partita test = new Partita(lab);
		Comando prova = new ComandoPrendi();		
		prova.setParametro("osso");
		prova.esegui(test);
		assertNotNull(test.getPlayer().getBag().getAttrezzo("osso"));
	}
}
