package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FabbricaDiComandiFisarmonicaTest {

	@Test
	void testComandoVaiNome() {
		FabbricaDiComandi test = new FabbricaDiComandiFisarmonica();
		assertEquals("vai",test.costruisciComando("vai").getNome());
	}

	@Test
	void testComandoVaiParametro() {
		FabbricaDiComandi test = new FabbricaDiComandiFisarmonica();
		assertEquals("sud",test.costruisciComando("vai sud").getParametro());
	}
}
