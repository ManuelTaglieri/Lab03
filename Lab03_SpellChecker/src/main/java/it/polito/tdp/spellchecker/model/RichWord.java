package it.polito.tdp.spellchecker.model;

public class RichWord {
	
	String parola;
	boolean corretta;
	
	public RichWord(String parola, boolean corretta) {
		super();
		this.parola = parola;
		this.corretta = corretta;
	}

	public boolean isCorretta() {
		return corretta;
	}

	public String getParola() {
		return parola;
	}

}
