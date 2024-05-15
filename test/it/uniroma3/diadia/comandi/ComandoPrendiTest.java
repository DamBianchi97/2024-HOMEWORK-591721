package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;

class ComandoPrendiTest {

	@Test
	void test() {
		Labirinto lab = new LabirintoBuilder()
												.addStanzaIniziale("Atrio")
												.addAttrezzo("osso", 2)
												.getLab();
		Partita test = new Partita(lab);
		Comando prova = new ComandoPrendi();		
		prova.setParametro("osso");
		prova.esegui(test);
		assertNotNull(test.getPlayer().getBag().getAttrezzo("osso"));
	}
}
