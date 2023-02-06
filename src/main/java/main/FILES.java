package main;

import java.io.File;

public interface FILES {
    //HOME FOLDER
    String FOLDER = "C:\\Users\\Ahmad Khateeb\\Desktop";
    String PDF_FOLDER = "C:\\Users\\Ahmad Khateeb\\Desktop\\ArabicPdf";
    String[]PDFS = {
            "arabic-7-p1 -2020.pdf",
            "Arabic08P1CS62020.pdf",
            "ARABICadab12.pdf",
            "ArabicMotalaa122020Raed.pdf",
            "Biology12 2020.pdf",
            "Derasat07P1.pdf",
            "Derasat08P1.pdf",
            "Derasat09P1.pdf",
            "History11P1.pdf",
            "History11P1_2.pdf",
            "History12.pdf",
            "History12_2.pdf",
            "Thaqafeh12.pdf",
            "احياء.pdf",
            "الثقافة العلمية.pdf",
            "اللغة العربية المطالعة والقواعد.pdf",
            "جغرافيا .pdf",
            "جغرافيا10.pdf",
            "لغة عربية مهني.pdf"
    };
    //THE FILTERED CORPUS
//    File CORPUS = new File(FOLDER, "corpus2.txt");
    File CORPUS = new File(FOLDER,"ArabicCorpus.txt");

    //GRAMS' FILES
    File UNIGRAM_FILE = new File(FOLDER, "unigram.csv");
    File BIGRAM_FILE = new File(FOLDER, "bigram.csv");
    File TRIGRAM_FILE = new File(FOLDER, "trigram.csv");
    File NGRAM_FILE = new File (FOLDER, "Ngram.csv");
    File NGRAM_FILE_ORDER = new File (FOLDER, "NgramOrdered.csv");

    //FETCHER'S FILES
//    File LINKS = new File ("links.txt");
    File LINKS = new File ("testLinks.txt");
    File TEMP_TEXT_FETCHED = new File("TEXT.TXT");

    //FILTER'S FILES
//     File FILTER_INPUT = new File(FOLDER, "corpus1.txt");
     File FILTER_INPUT = new File("TEXT.txt");
     File FILTER_OUTPUT = new File (FOLDER,"corp.txt");
}
