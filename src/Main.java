package dor.norVocab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public ArrayList<Vocab> vocabulary = new ArrayList<Vocab>();

    public static void main(String[] args) {
        Main m = new Main();
        m.addVocab();
        m.startTraining();
    }

    public void startTraining() {
        while(vocabulary.size()>0) {
            String notice = "";
            if(!vocabulary.get(0).getNotice().equalsIgnoreCase("")) {
                notice = " (Anmerkung: "+vocabulary.get(0).getNotice()+")";
            }
            String input = null;

            System.out.println("Übersetzung für "+vocabulary.get(0).getGerman()+"?");
            boolean correct = false;
            while(correct!=true) {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                try {
                    input = br.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if(input.equalsIgnoreCase("-")) {
                    System.out.println("Die richtige Antwort ist:");
                    System.out.println(vocabulary.get(0).getBokmal()+notice+";Kapitel: "+vocabulary.get(0).getChapter());
                    correct = true;
                    vocabulary.add(vocabulary.remove(0));
                } else if(!input.equalsIgnoreCase(vocabulary.get(0).getBokmal())) {
                    System.out.println("Die Antwort ist falsch");
                } else if(input.equalsIgnoreCase(vocabulary.get(0).getBokmal())) {
                    System.out.println("Die Antwort ist korrekt."+notice);
                    correct = true;
                    vocabulary.remove(0);
                }
            }
        }

        System.out.println("Alle Vokabeln sind abgearbeitet.");
    }

    public void addVocab() {
        vocabulary.add(new Vocab("ich", "jeg", "", 1));
        vocabulary.add(new Vocab("du", "du", "", 1));
        vocabulary.add(new Vocab("er", "han", "", 1));
        vocabulary.add(new Vocab("sie (Singular)", "hun", "", 1));
        vocabulary.add(new Vocab("wir", "vi", "", 1));
        vocabulary.add(new Vocab("ihr", "dere", "", 1));
        vocabulary.add(new Vocab("sie (Plural)", "de", "", 1));
        vocabulary.add(new Vocab("Sie (Höflichkeitsform)", "De", "", 1));
        Collections.shuffle(vocabulary);
    }
}