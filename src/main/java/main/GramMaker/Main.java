package main.GramMaker;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import main.FILES;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    static final File CORPUS = FILES.CORPUS;
    static final File UNIGRAM_FILE = FILES.UNIGRAM_FILE;
    static final File BIGRAM_FILE = FILES.BIGRAM_FILE;
    static final File TRIGRAM_FILE = FILES.TRIGRAM_FILE;
    static final File NGRAM_FILE = FILES.NGRAM_FILE;
    static final File NGRAM_FILE_ORDER = FILES.NGRAM_FILE_ORDER;

    public static void main(String[] args) throws IOException {
        nGram ();
        nGramByOrder ();
//        triGram ();
    }

    public static void nGram() throws IOException {
        Multiset<String> NGram = HashMultiset.create ();
        NGram.addAll (uniGram ());
        NGram.addAll (biGram ());
        NGram.addAll (triGram ());
        printer (NGram, NGRAM_FILE);
    }

    public static void nGramByOrder() throws IOException {
        Multiset<String> uniGram = uniGram ();
        Multiset<String> biGram = biGram ();
        Multiset<String> triGram = triGram ();
        PrintWriter printWriter = new PrintWriter (new FileWriter (NGRAM_FILE_ORDER));
        printWriter.write ("");
        printer (uniGram,printWriter);
        printer (biGram,printWriter);
        printer (triGram,printWriter);

    }
    public static Multiset<String> uniGram() throws IOException {
        Multiset<String> set = HashMultiset.create ();
        Scanner in = new Scanner (CORPUS);
        while (in.hasNext ()) {
            String str = in.nextLine ();
            String[] array = str.split (" ");
            for (String s : array) {
                if (s.equals ("\n") || s.equals (" "))
                    continue;
                if (s.toLowerCase ().equals (s.toUpperCase ()))
                    set.add (s);
            }
        }
        printer (set, UNIGRAM_FILE);
        return set;
    }

    public static Multiset<String> biGram() throws IOException {
        Multiset<String> set = HashMultiset.create ();
        Scanner in = new Scanner (CORPUS);
        while (in.hasNext ()) {
            String str = in.nextLine ();
            String[] array = str.split (" ");
            for (int i = 0; i < array.length - 1; i++) {
                String s = array[i];
                String next = array[i + 1];
                if (s.equals ("\n") || s.equals (" "))
                    continue;
                if (s.toLowerCase ().equals (s.toUpperCase ()))
                    set.add (s + " " + next);
            }
        }
        printer (set, BIGRAM_FILE);
        return set;
    }

    public static Multiset<String> triGram() throws IOException {
        Multiset<String> set = HashMultiset.create ();
        Scanner in = new Scanner (CORPUS);
        while (in.hasNext ()) {
            String str = in.nextLine ();
            String[] array = str.split (" ");
            for (int i = 0; i < array.length - 2; i++) {
                String s = array[i];
                String next = array[i + 1];
                String nextNext = array[i + 2];
                if (s.equals ("\n") || s.equals (" "))
                    continue;
                if (s.toLowerCase ().equals (s.toUpperCase ()))
                    set.add (s + " " + next + " " + nextNext);
            }
        }
        printer (set, TRIGRAM_FILE);
        return set;
    }

    public static void printer(Multiset<String> set, File nGramFile) throws IOException {
        PrintWriter printWriter = new PrintWriter (new FileWriter (nGramFile));
        printWriter.write ("");
        printer (set,printWriter);
    }

    private static void printer(Multiset<String> set,PrintWriter printWriter){
        int existCounter = 0;
        for (String s : set) {
            if (existCounter > 0) {
                existCounter--;
                continue;
            }
            int count = set.count (s);
            printWriter.println (s + ',' + count);
            existCounter = count;
        }
        printWriter.flush ();
    }
}
