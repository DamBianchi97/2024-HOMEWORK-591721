package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPrendiTest {

	@Test
	void test() {
		Partita test = new Partita();
		Comando prova = new ComandoPrendi();		
		prova.setParametro("osso");
		prova.esegui(test);
		assertNotNull(test.getPlayer().getBag().getAttrezzo("osso"));
	}
}
