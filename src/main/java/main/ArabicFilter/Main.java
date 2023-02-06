package main.ArabicFilter;

import main.FILES;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static final File input = FILES.FILTER_OUTPUT;
    static final File output = new File (FILES.FOLDER,"OnlyArabic.txt");

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter(output);
        fw.write("");
        Scanner in = new Scanner(input);
        while (in.hasNext()) {
            String[] str = in.nextLine().split (" ");
            for (String s : str) {
                if(s.toLowerCase ().equals (s.toUpperCase ()))
                    fw.append (s).append (" ");
            }
            fw.append ("\n");
        }
        fw.flush();
        fw.close();
    }
}
