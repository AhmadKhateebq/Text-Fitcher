package main;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        String[]files = FILES.PDFS;
        PrintWriter pw = new PrintWriter("pdf.txt");
        pw.print("");
        int x = 0;
//        for (String file : files) {
//            System.out.println ("printing file " +(++x));
//            File pdf = new File (FILES.PDF_FOLDER,file);
//            pw.append (pdfReader (pdf));
//        }
        File file = new File (FILES.PDF_FOLDER,"موسوعة الأمثال الشعبية الفلسطينية_36140_Foulabook.com_.pdf");
        pw.append (pdfReader (file));
        pw.flush ();
        pw.close();
    }
    public static String pdfReader(File file) throws IOException {
        PDFParser parser = new PDFParser (new RandomAccessFile (file, "r"));
        parser.parse();
        COSDocument cosDoc = parser.getDocument();
        PDFTextStripper pdfStripper = new PDFTextStripper();
        PDDocument pdDoc = new PDDocument(cosDoc);
        return pdfStripper.getText(pdDoc);

    }

}
