package it.uniroma3.diadia;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfiguratoreProperties {
	private static final String DIADIA_PROPERTIES = "diadia.properties";
	private static final String PESO_MAX = "pesoMax";
	private static final String CFU = "cfu";
	private static Properties p = null;
	
	public static int getCFU() {
		if(p == null)
			carica();
		return Integer.parseInt(p.getProperty(CFU));
	}
	
	public static int getPesoMax() {
		if(p == null)
			carica();
		return Integer.parseInt(p.getProperty(PESO_MAX));
	}

	private static void carica() {
		p = new Properties();
		try {
			FileInputStream input = new FileInputStream(DIADIA_PROPERTIES);
			p.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
