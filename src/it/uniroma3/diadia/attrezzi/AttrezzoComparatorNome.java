package it.uniroma3.diadia.attrezzi;

public class AttrezzoComparatorNome implements java.util.Comparator<Attrezzo>{
	@Override
	public int compare(Attrezzo a, Attrezzo b) {
		return a.getNome().compareTo(b.getNome());
	}	  
}
