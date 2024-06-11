package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio{
	public static final String MESSAGGIO_CANE = "WOOF WOOF (il cane ti morde e perdi un CFU)";
	public static final String MESSAGGIO_REGALO_1 = "Il cane mangia cio' che gli hai dato e ti lascia un osso";
	public static final String MESSAGGIO_REGALO_2 = "Al cane non è piaciuto cio' che gli hai dato";
	
	public Cane(String nome, String presentaz) {
		super(nome, presentaz);
	}

	@Override
	public String agisci(Partita partita) {
		String msg = MESSAGGIO_CANE;
		partita.getPlayer().setCfu();
		return msg;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		if (attrezzo.getNome()!="ciccia") {
			this.agisci(partita);
			return MESSAGGIO_REGALO_2+MESSAGGIO_CANE;
		}
		else {
			Attrezzo osso = new Attrezzo("osso", 2);
			partita.getPlayer().getBag().addAttrezzo(osso);
			return MESSAGGIO_REGALO_1;
		}
	}
}
