package com.github.funnygopher.ptu.pokedexscraper;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import java.io.File;

public class PokedexScraperMain {
    public static void main(String[] args) {
        textParseTest();
    }

    public static void textParseTest() {
        try {
            PDDocument pdf;
            int firstPage = 12;
            int lastPage = 745; //745
            File input = new File("C:\\Users\\braolson\\downloads\\PTU 1.05\\Pokedex 1.05.pdf");  // The PDF file from where you would like to extract
            pdf = PDDocument.load(input);
            PDFTextStripper stripper = new PDFTextStripper();
            int pokemonNumber = 1;
            //System.out.println(stripper.getText(pdf));
            for (int currentPageIndex = firstPage; currentPageIndex <= lastPage; currentPageIndex++) {
                stripper.setStartPage(currentPageIndex);
                stripper.setEndPage(currentPageIndex);
                String currentPageText = stripper.getText(pdf);
                if(currentPageText.contains("Base")) {
                    System.out.println("------------------------------------");

                    //INCREMENT NUMBER
                    System.out.println(pokemonNumber++);

                    //GET THE NAME
                    String name = currentPageText
                            .substring(currentPageText.indexOf("\n") + 1, currentPageText.indexOf("Base"))
                            .replaceAll("\\s+", " ");
                    System.out.println(name);

                    //GET THE TYPE
                    if(currentPageText.contains("Type : ")) {
                        String type1 = "";
                        String type2 = "";
                        String type = currentPageText
                                .substring(currentPageText.indexOf("Type : ") + 7, currentPageText.indexOf("Basic Ability 1:"))
                                .replaceAll("\\s+", "");
                        if (type.contains("/")) {
                            type1 = type.substring(0, type.indexOf('/'));
                            type2 = type.substring(type.indexOf('/') + 1);
                        }
                        else {
                            type1 = type;
                        }

                        if (type2 != "") {
                            System.out.println("Type 1 : " + type1);
                            System.out.println("Type 2 : " + type2);
                        }
                        else {
                            System.out.println("Type : " + type1);
                        }
                    }

                    //GET THE STATS
                    String hp = currentPageText
                            .substring(currentPageText.indexOf("HP:") + 3, currentPageText.indexOf("Attack:"))
                            .replaceAll("\\s+", "");
                    System.out.println("HP : " + hp);
                    String attack = currentPageText
                            .substring(currentPageText.indexOf("Attack:") + 7, currentPageText.indexOf("Defense:"))
                            .replaceAll("\\s+", "");
                    System.out.println("Attack : " + attack);

                    if(currentPageText.contains("Mega Evolution")) {
                        System.out.println("------------------------------------");
                        System.out.println(pokemonNumber);
                        System.out.println("Mega " + name);
                        String mega = currentPageText
                                .substring(currentPageText.indexOf("Mega Evolution") + 14);
                        System.out.println(mega);
                    }

                }
                //currentPageText.
                //currentPageText.indexOf("HP : ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void imageParseTest() {
    }
}
