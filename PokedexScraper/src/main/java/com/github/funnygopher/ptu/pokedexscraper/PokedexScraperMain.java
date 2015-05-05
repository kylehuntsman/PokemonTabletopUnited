package com.github.funnygopher.ptu.pokedexscraper;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokedexScraperMain {
    public static void main(String[] args) {
        textParseTest();
    }

    public static void textParseTest() {
        try {
            int firstPage = 12; //12
            int lastPage = 13; //745

            PDDocument pdf;
            File input = new File("C:\\Users\\braolson\\downloads\\PTU 1.05\\Pokedex 1.05.pdf");  // The PDF file from where you would like to extract
            pdf = PDDocument.load(input);
            PDFTextStripper stripper = new PDFTextStripper();
            int pokemonNumber = 1;
            //System.out.println(stripper.getText(pdf));
            for (int currentPageIndex = firstPage; currentPageIndex <= lastPage; currentPageIndex++) {
                stripper.setStartPage(currentPageIndex);
                stripper.setEndPage(currentPageIndex);
                String currentPageText = stripper.getText(pdf);
                //currentPageText = currentPageText.replaceAll("\\s+", " ");
                List<String> skipNames = new ArrayList<String>(Arrays.asList("PUMPKABOO", "GOURGEIST", "ROTOM", "TOTODILE", "MAGMAR"));

                containsBase: if(currentPageText.contains("Base")) {

                    System.out.println("------------------------------------");
                    System.out.println(currentPageText);

                    //INCREMENT NUMBER
                    System.out.println(pokemonNumber++);

                    //GET THE NAME
                    String name = currentPageText
                            .substring(currentPageText.indexOf("\n") + 1, currentPageText.indexOf("Base"))
                            .replaceAll("\\s+", " ");
                    name = name.substring(0,name.indexOf(" "));
                    if (skipNames.contains(name)){
                        break containsBase;
                    }
                    System.out.println(name);

                    //GET HP
                    String hp = currentPageText
                            .substring(currentPageText.indexOf("HP:") + 3, currentPageText.indexOf("Attack:"))
                            .replaceAll("\\s+", "");
                    System.out.println("HP : " + hp);


                    //GET ATTACK
                    String attack = currentPageText
                            .substring(currentPageText.indexOf("Attack:") + 7, currentPageText.indexOf("Defense:"))
                            .replaceAll("\\s+", "");
                    System.out.println("Attack : " + attack);

                    //GET DEFENSE
                    String defense = currentPageText
                            .substring(currentPageText.indexOf("Defense:") + 7, currentPageText.indexOf("Special Attack:"))
                            .replaceAll("\\s+", "");
                    System.out.println("Defense : " + defense);

                    //GET SPECIAL ATTACK
                    String specialAttack = currentPageText
                            .substring(currentPageText.indexOf("Special Attack:") + 15, currentPageText.indexOf("Special Defense:"))
                            .replaceAll("\\s+", "");
                    System.out.println("Special Attack : " + specialAttack);

                    //GET SPECIAL DEFENSE
                    String specialDefense = currentPageText
                            .substring(currentPageText.indexOf("Special Defense:") + 16, currentPageText.indexOf("Speed:"))
                            .replaceAll("\\s+", "");
                    System.out.println("Special Defense : " + specialDefense);

                    //GET SPEED
                    String speed = currentPageText
                            .substring(currentPageText.indexOf("Speed:") + 6, currentPageText.indexOf("Basic Information"))
                            .replaceAll("\\s+", "");
                    System.out.println("Speed : " + speed);

                    /*
                    if(currentPageText.contains("Mega Evolution")) {
                        System.out.println("------------------------------------");
                        System.out.println(pokemonNumber);
                        System.out.println("Mega " + name);
                        String mega = currentPageText
                                .substring(currentPageText.indexOf("Mega Evolution") + 14);
                        System.out.println(mega);
                    }
                    */

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

                    //GET THE BASIC ABILITY
                    List<String> basicAbilitiesList = new ArrayList<String>();
                    if(currentPageText.contains("Basic Ability")){

                        String basicAbilities = currentPageText
                                .substring(currentPageText.indexOf("Basic Ability") + 13, currentPageText.indexOf("Adv"));
                        String[] rawAbilities = basicAbilities.split("Basic Ability ");

                        for (String rawAbility : rawAbilities) {
                            String ability = rawAbility.substring(3);
                            basicAbilitiesList.add(ability.replaceAll("\\s+", ""));
                        }
                        for (int i = 0; i < basicAbilitiesList.size(); i++) {
                            System.out.println("Basic Ability " + (i + 1) + " : " + basicAbilitiesList.get(i));
                        }
                    }


                    //GET THE ADV ABILITY
                    List<String> advAbilitiesList = new ArrayList<String>();
                    if(currentPageText.contains("Adv Ability")){

                        String advAbilities = currentPageText
                                .substring(currentPageText.indexOf("Adv Ability") + 11, currentPageText.indexOf("High Ability"));
                        String[] rawAbilities = advAbilities.split("Adv Ability ");

                        for (String rawAbility : rawAbilities) {
                            String ability = rawAbility.substring(3);
                            advAbilitiesList.add(ability.replaceAll("\\s+", ""));
                        }
                        for (int i = 0; i < advAbilitiesList.size(); i++) {
                            System.out.println("Adv Ability " + (i + 1) + " : " + advAbilitiesList.get(i));
                        }
                    }


                    //GET THE HIGH ABILITY
                    List<String> highAbilitiesList = new ArrayList<String>();
                    if(currentPageText.contains("High Ability")){

                        String highAbilities = currentPageText
                                .substring(currentPageText.indexOf("High Ability") + 11, currentPageText.indexOf("Evolution"));
                        String[] rawAbilities = highAbilities.split("High Ability ");

                        for (String rawAbility : rawAbilities) {
                            String ability = rawAbility.substring(3);
                            highAbilitiesList.add(ability.replaceAll("\\s+", ""));
                        }
                        for (int i = 0; i < highAbilitiesList.size(); i++) {
                            System.out.println("High Ability " + (i + 1) + " : " + highAbilitiesList.get(i));
                        }
                    }

                    //GET EVOLUTION
                    if(currentPageText.contains("Evolution")) {
                        //String[] rawEvolutions = currentPageText.substring(curr).split("High Ability ");
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void imageParseTest() {
    }
}
