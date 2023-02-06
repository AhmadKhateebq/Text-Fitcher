package main.FILTER;

import main.FILES;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    static final File input = FILES.FILTER_INPUT;
    static final File output = FILES.FILTER_OUTPUT;

    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter(output);
        fw.write("");
        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        Scanner in = new Scanner(input);
        String[] arr = {
                "."
                , ","
                , ";"
                , ":"
                , "'"
                , "?"
                , "!"
                , "@"
                , "#"
                , "$"
                , "%"
                , "^"
                , "&"
                , "*"
                , "("
                , ")"
                , "-"
                , "–"
                , "_"
                , "+"
                , "="
                , "|"
                , "\\"
                , "'"
                , "\""
                , "/"
                , "،"
                , "["
                , "]"
                , "»"
                , "«"
                , "<"
                , ">"
                , "-"
                , "↑"
                , "←"
                , "؛"
                , "›"
                , "•"
                , "ʾ"
                , "ˁ"
                , "ʿ"
                , "ʻ"
                , "٪"
                , "£"
                , "©"
                , "°"
                , "²"
                , "×"
        };
        String[] tashkeel = {
                "~"
                , "ّ"
                , "َ"
                , "ً"
                , "ُ"
                , "ٌ"
                , "ٍ"
                , "ِ"
                , "ْ"
                , "·"
                , "ـ", "ـ"
                , " "
                ,"1"
                ,"2"
                ,"3"
                ,"4"
                ,"5"
                ,"6"
                ,"7"
                ,"8"
                ,"9"
                ,"0"
        };
        while (in.hasNext()) {
            String str = in.nextLine();
            for (String s : arr) {
                str = str.replace(s, "");
            }
            for (String s : tashkeel) {
                str = str.replace(s, "");
            }
            for (char s : alphabet) {
                str = str.replace(""+s,"");
                str = str.replace((""+s).toUpperCase (),"");
            }
            System.out.println(str);
            str = str.replaceAll("( +)", " ").trim();
            fw.append (str).append ("\n");

        }
        fw.flush();
        fw.close();
    }
}
