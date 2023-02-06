package main.TextFetcher;

import main.FILES;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    /**
     * @author Ahmad Khateeb
     */
    public static void main(String[] args) throws Exception {
        File file = FILES.TEMP_TEXT_FETCHED;
        FileWriter fw = new FileWriter (file);
        fw.write ("");
        // input url you can change accordingly
        ArrayList<String> list = getLinks ();
        Main text = new Main ();
        for (String s : list) {
            fw.append (text.getText (s));
            fw.append ("\n");
        }
    }

    //method to get links from file
    public static ArrayList<String> getLinks() throws FileNotFoundException {
        File file = FILES.LINKS;
        ArrayList<String> list = new ArrayList<> ();
        Scanner scanner = new Scanner (file);
        while (scanner.hasNext ()) {
            list.add (scanner.nextLine ());
            System.out.println (list.get (list.size () - 1));
            System.out.println ();
        }
        return list;
    }

    /**
     * @author Dinesh Krishnan
     */
    // method to extract text from url
    public String getText(final String link) {
        String text = null;
        try {
            // creating URL object
            URL url = new URL (link);
//            System.out.println (fromPdf (url.getPath ()));
            // getting the HTML documents from the url
            Document document = Jsoup.parse (url, 5000);
            // extracting the text from give url
            text = document.text ();
        } catch (IOException e) {
            System.out.println (e.getMessage ());
            e.printStackTrace ();
        }
        System.out.println (text);
        return text;
    }


}