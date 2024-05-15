package it.uniroma3.diadia.attrezzi;

public class AttrezzoComparatorPeso implements java.util.Comparator<Attrezzo>{
	@Override
	public int compare(Attrezzo a, Attrezzo b) {
		if (a.getPeso()-b.getPeso()==0) return a.getNome().compareTo(b.getNome());
		return a.getPeso()-b.getPeso();
	}	  
}
