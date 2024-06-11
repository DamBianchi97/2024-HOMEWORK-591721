package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FabbricaDiComandiFisarmonicaTest {



	@Test
	void testComandoVaiParametro() throws Exception {
		FabbricaDiComandi test = new FabbricaDiComandiFisarmonica();
		assertEquals("sud",test.costruisciComando("vai sud").getParametro());
	}
}
