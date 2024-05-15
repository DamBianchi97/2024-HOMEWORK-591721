package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPosaTest {

	@Test
	void testPosaOggettoNonValido() {
		Labirinto lab = new LabirintoBuilder()
											.addStanzaIniziale("Atrio")
											.getLab();
		Partita test = new Partita(lab);
		Comando prova = new ComandoPosa();
		test.getPlayer().getBag().addAttrezzo(new Attrezzo("osso",2));
		prova.setParametro("osso");
		prova.esegui(test);
		assertNull(test.getPlayer().getBag().getAttrezzo("osso"));
	}
}
