package it.uniroma3.diadia.giocatore;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

class BorsaTest {
	
	Borsa bag = new Borsa();
	Attrezzo item1;
	Attrezzo item2;
	Attrezzo item3;	
	Attrezzo item4;
	
	@BeforeEach
	public void setUp(){
		item1 = new Attrezzo("spada",5);
		item2 = new Attrezzo("osso",2);
		item3 = new Attrezzo("tronco", 12);
		item4 = new Attrezzo("palla", 2);
		bag.addAttrezzo(item1);
		bag.addAttrezzo(item2);
		bag.addAttrezzo(item3);
		bag.addAttrezzo(item4);
	}
	
	@Test
	void testAddAttrezzo() {
		assertEquals(bag.getAttrezzo("spada"), item1);
	}
	
	@Test
	void testAddAttrezzoTroppoPeso() {
		assertFalse(bag.addAttrezzo(item3));
	}
	
	@Test
	void testRemoveAttrezzo() {
		assertTrue(bag.removeAttrezzo("spada"));
	}
	
	@Test
	void testGetContenutoOrdinatoPerPeso() {
		List<Attrezzo> tmp = bag.getContenutoOrdinatoPerPeso();
		assertTrue(tmp.containsAll(bag.getListaAttrezzi()));
	}
	
	@Test
	void testGetContenutoOrdinatoPerNome() {
		SortedSet<Attrezzo> tmp = bag.getContenutoOrdinatoPerNome();
		assertEquals(item2,tmp.first());
		assertEquals(item1,tmp.last());
	}
	
	@Test
	void testGetSortedSetOrdinatoPerPesoStessoPeso() {
		SortedSet<Attrezzo> tmp = bag.getSortedSetOrdinatoPerPeso();
		assertTrue(tmp.contains(item2));
		assertTrue(tmp.contains(item4));
	}	
	
	@Test 
	void testGetContenutoRaggruppatoPerPeso(){
		Map<Integer,Set<Attrezzo>> tmp = bag.getContenutoRaggruppatoPerPeso();
		assertTrue(tmp.containsKey(2));
		assertTrue(tmp.containsKey(5));
		assertFalse(tmp.containsKey(12));
	}
}
