package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPosaTest {

	@Test
	void testPosaOggettoNonValido() {
		Partita test = new Partita();
		Comando prova = new ComandoPosa();
		test.getPlayer().getBag().addAttrezzo(new Attrezzo("osso",5));
		prova.setParametro("osso");
		prova.esegui(test);
		assertNull(test.getPlayer().getBag().getAttrezzo("osso"));
	}
}
