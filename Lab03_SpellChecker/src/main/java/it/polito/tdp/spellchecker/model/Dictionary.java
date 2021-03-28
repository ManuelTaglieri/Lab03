package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Dictionary {
	
	LinkedList<String> dizionario;
	
	public Dictionary() {
		this.dizionario = new LinkedList<String>();
	}

	public void loadDictionary(String language) {
		
		if (language.equals("English")) {
		try {
			FileReader fr = new FileReader("src/main/resources/English.txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			while ((word = br.readLine()) != null) {
				dizionario.add(word);
			}
			br.close();
			} catch (IOException e){
			System.out.println("Errore nella lettura del file");
			}
		}
		else if (language.equals("Italian")) {
			try {
				FileReader fr = new FileReader("src/main/resources/Italian.txt");
				BufferedReader br = new BufferedReader(fr);
				String word;
				while ((word = br.readLine()) != null) {
					dizionario.add(word);
				}
				br.close();
				} catch (IOException e){
				System.out.println("Errore nella lettura del file");
				}
		}
				
	}
	
	public List<RichWord> spellCheckTestLinear(List<String> inputTextList) {
		LinkedList<RichWord> risultato = new LinkedList<RichWord>();
		for (String s : inputTextList) {
			if (dizionario.contains(s)) {
				risultato.add(new RichWord(s,true));
			}
			else {
				risultato.add(new RichWord(s,false));
			}
		}
		return risultato;
	}
	
	public List<RichWord> spellCheckTestDichotomic(List<String> inputTextList) {
		LinkedList<RichWord> risultato = new LinkedList<RichWord>();
		for (String s : inputTextList) {
			boolean controllo = false;
			if (s.compareTo(dizionario.get((int) dizionario.size()/2))==0) {
				controllo = true;
			}
			else if (s.compareTo(dizionario.get(dizionario.size()/2))>0) {
				int i = (int) dizionario.size()/2;
				while(i<dizionario.size()) {
					if (s.equals(dizionario.get(i))) {
						controllo = true;
						break;
					}
					i++;
				}
			}
			else if (s.compareTo(dizionario.get(dizionario.size()/2))<0) {
				int i = (int) dizionario.size()/2;
				while(i>-1) {
					if (s.equals(dizionario.get(i))) {
						controllo = true;
						break;
					}
					i--;
				}
			}
			risultato.add(new RichWord(s, controllo));
		}
		return risultato;
	}

}
