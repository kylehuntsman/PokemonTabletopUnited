package com.github.funnygopher.ptu.pokedexscraper;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PokedexScraperMain {
    public static void main(String[] args) {
        parsePokedex();
    }

    public static void parsePokedex() {
        try {
            int firstPage = 12; //12
            int lastPage = 745; //745

            PDDocument pdf;
            File input = new File("C:\\Users\\braolson\\downloads\\PTU 1.05\\Pokedex 1.05.pdf");  // The PDF file from where you would like to extract
            pdf = PDDocument.load(input);
            PDFTextStripper stripper = new PDFTextStripper();
            int pokemonNumber = 1;
            //System.out.println(stripper.getText(pdf));

            List<String> skipNames = new ArrayList<String>(Arrays.asList("PUMPKABOO", "GOURGEIST", "ROTOM", "TOTODILE", "MAGMAR"));

            for (int currentPageIndex = firstPage; currentPageIndex <= lastPage; currentPageIndex++) {

                stripper.setStartPage(currentPageIndex);
                stripper.setEndPage(currentPageIndex);
                String currentPageText = stripper.getText(pdf);
                //currentPageText = currentPageText.replaceAll("\\s+", " ");


                if(currentPageIndex == 682)
                    continue;

                System.out.println("------------------------------------");
                //System.out.println(currentPageText);

                //INCREMENT NUMBER
                System.out.println(pokemonNumber++);

                //GET THE NAME
                String name = getPokemonName(currentPageText);
                System.out.println(name);

                if (skipNames.contains(name))
                {
                    continue;
                }

                //GET HP
                String hp = getPokemonHP(currentPageText);
                System.out.println("HP : " + hp);

                //GET ATTACK
                String attack = getPokemonAttack(currentPageText);
                System.out.println("Attack : " + attack);

                //GET DEFENSE
                String defense = getPokemonDefense(currentPageText);
                System.out.println("Defense : " + defense);

                //GET SPECIAL ATTACK
                String specialAttack = getPokemonSpecialAttack(currentPageText);
                System.out.println("Special Attack : " + specialAttack);

                //GET SPECIAL DEFENSE
                String specialDefense = getPokemonSpecialDefense(currentPageText);
                System.out.println("Special Defense : " + specialDefense);

                //GET SPEED
                String speed = getPokemonSpeed(currentPageText);
                System.out.println("Speed : " + speed);

                //GET THE TYPE
                List<String> types = getPokemonTypes(currentPageText);
                for (int i = 0; i < types.size(); i++) {
                    System.out.println("Type " + (i + 1) + " : " + types.get(i));
                }

                //GET THE BASIC ABILITY
                List<String> basicAbilities = getBasicAbility(currentPageText);
                for (int i = 0; i < basicAbilities.size(); i++) {
                    System.out.println("Basic Ability " + (i + 1) + " : " + basicAbilities.get(i));
                }

                //GET THE ADV ABILITY
                List<String> advAbilities = getAdvAbility(currentPageText);
                for (int i = 0; i < advAbilities.size(); i++) {
                    System.out.println("Adv Ability " + (i + 1) + " : " + advAbilities.get(i));
                }

                //GET THE HIGH ABILITY
                List<String> highAbilities = getHighAbility(currentPageText);
                for (int i = 0; i < highAbilities.size(); i++) {
                    System.out.println("High Ability " + (i + 1) + " : " + highAbilities.get(i));
                }

                //GET EVOLUTION TREE
                List<String> evolutions = getEvolutionTree(currentPageText);
                System.out.println("Evolution:");
                for (int i = 0; i < evolutions.size(); i++) {
                    System.out.println(evolutions.get(i));
                }

                //GET HEIGHT
                double height = getPokemonHeight(currentPageText);
                System.out.println("Height : " + height + " m");

                //GET WEIGHT
                double weight = getPokemonWeight(currentPageText);
                System.out.println("Weight : " + weight + " kg");

                //GET MALE GENDER RATIO
                double genderRatio = getPokemonGenderRatio(currentPageText);
                System.out.println("Gender Ratio: " + genderRatio + "% MALE");

                //GET EGG GROUPS
                List<String> eggGroups = getPokemonEggGroups(currentPageText);
                System.out.print("Egg Groups : ");
                for (int i = 0; i < eggGroups.size(); i++) {
                    System.out.print(eggGroups.get(i));
                    if (i < eggGroups.size() - 1) {
                        System.out.print(", ");
                    }
                    else {
                        System.out.println();
                    }
                }


                //GET AVERAGE HATCH RATE

                //GET DIETS

                //GET HABITATS

                //GET OVERLAND

                //GET SWIM

                //GET LONG JUMP

                //GET HIGH JUMP

                //GET POWER

                /*
                //GET MEGA
                if(currentPageText.contains("Mega Evolution")) {
                    System.out.println("------------------------------------");
                    System.out.println(pokemonNumber);
                    System.out.println("Mega " + name);
                    String mega = currentPageText
                            .substring(currentPageText.indexOf("Mega Evolution") + 14);
                    System.out.println(mega);
                }
                */
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void imageParseTest() {
    }

    public static List<String> getLabelDelaminatedTermsList(String input, String splitString, String endString) {
        return getLabelDelaminatedTermsList(input, splitString, endString, 0);
    }

    public static List<String> getLabelDelaminatedTermsList(String input, String splitString, String endString, int offset) {
        input = input
                .substring(input.indexOf(splitString) + splitString.length(), input.indexOf(endString));
        List<String> output = Arrays.asList(input.split(splitString));

        for (int i = 0; i < output.size(); i++) {
            String changedOutput = output.get(i);
            changedOutput = changedOutput.substring(offset).trim().replace("\\s+", " ");
            output.set(i, changedOutput);
        }

        return output;
    }

    public static List<String> getNumberedList(String input, String startString, String endString) {
        String inputSubString = (input.substring(input.indexOf(startString) + startString.length() + 2, input.indexOf(endString) - 7));

        List<String> output = Arrays.asList(inputSubString.split("\n"));
        for (int i = 0; i < output.size(); i++) {
            if (output.get(i) == "\n") {
                output.remove(i);
                i++;
            } else {
                output.set(i, output.get(i).trim());
            }
        }
        return output;
    }

    public static String getSubString(String input, String startString, String endString) {
        return input.substring(input.indexOf(startString), input.indexOf(endString));
    }

    //GET THE NAME
    public static String getPokemonName(String pageText) {
        String name = pageText
                .substring(pageText.indexOf("\n") + 1, pageText.indexOf("Base"))
                .replaceAll("\\s+", " ");
        name = name.substring(0,name.indexOf(" "));
        return name;
    }

    //GET POKEMON STAT
    public static String getPokemonStat(String pageText, String startString, String endString) {
        String stat = pageText
                .substring(pageText.indexOf(startString) + startString.length(), pageText.indexOf(endString))
                .trim();
        return stat;
    }

    //GET HP
    public static String getPokemonHP(String pageText) {
        return getPokemonStat(pageText, "HP:", "Attack:");
    }


    //GET ATTACK
    public static String getPokemonAttack(String pageText) {
        return getPokemonStat(pageText, "Attack:", "Defense:");
    }

    //GET DEFENSE
    public static String getPokemonDefense(String pageText) {
        return getPokemonStat(pageText, "Defense:", "Special Attack:");
    }

    //GET SPECIAL ATTACK
    public static String getPokemonSpecialAttack(String pageText) {
        return getPokemonStat(pageText, "Special Attack:", "Special Defense");
    }

    //GET SPECIAL DEFENSE
    public static String getPokemonSpecialDefense(String pageText) {
        return  getPokemonStat(pageText, "Special Defense:", "Speed:");
    }

    //GET SPEED
    public static String getPokemonSpeed(String pageText){
        return getPokemonStat(pageText, "Speed:", "Basic Information");
    }

    //GET THE TYPE
    public static List<String> getPokemonTypes(String pageText){
        List<String> typesList = new ArrayList<String>();
        if(pageText.contains("Type : ")) {
            String type1 = "";
            String type2 = "";
            String type = pageText
                    .substring(pageText.indexOf("Type : ") + 7, pageText.indexOf("Basic Ability 1:"))
                    .replaceAll("\\s+", "");
            if (type.contains("/")) {
                type1 = type.substring(0, type.indexOf('/'));
                type2 = type.substring(type.indexOf('/') + 1);
            }
            else {
                type1 = type;
            }

            typesList.add(type1);

            if (type2 != "") {
                typesList.add(type2);
            }
        }
        return typesList;
    }

    //GET THE BASIC ABILITY
    public static List<String> getBasicAbility(String pageText) {
        List<String> basicAbilitiesList = getLabelDelaminatedTermsList(pageText, "Basic Ability", "Adv", 3);
        return basicAbilitiesList;
    }

    //GET THE ADV ABILITY
    public static List<String> getAdvAbility(String pageText){
        List<String> advAbilitiesList = getLabelDelaminatedTermsList(pageText, "Adv Ability", "High Ability", 3);
        return advAbilitiesList;
    }

    //GET THE HIGH ABILITY
    public static List<String> getHighAbility(String pageText){
        List<String> highAbilitiesList = getLabelDelaminatedTermsList(pageText, "High Ability", "Evolution", 2);
        return highAbilitiesList;
    }

    //GET EVOLUTION TREE
    public static List<String> getEvolutionTree(String pageText){
        List<String> evolutionList = getNumberedList(pageText, "Evolution:", "Size Information");
        return evolutionList;
    }

    //GET HEIGHT
    public static double getPokemonHeight(String pageText) {
        String heightLine = getSubString(pageText, "Height : ", "Weight : ");
        return Double.parseDouble(heightLine.substring(heightLine.indexOf("/") + 1, heightLine.indexOf("m")).trim());
    }

    //GET WEIGHT
    public static double getPokemonWeight(String pageText) {
        String weightLine = getSubString(pageText, "Weight : ", "Breeding Information");
        return Double.parseDouble(weightLine.substring(weightLine.indexOf("/") + 1, weightLine.indexOf("k")).trim());
    }

    //GET MALE GENDER RATIO
    public static double getPokemonGenderRatio(String pageText){
        String genderRatioLine = getSubString(pageText, "Gender Ratio", "Egg Group");
        String genderRatio = genderRatioLine.substring(genderRatioLine.indexOf(":") + 1).trim();
        try {
            genderRatio = genderRatio.substring(0, genderRatio.indexOf("%"));
            return Double.parseDouble(genderRatio);
        }
        catch (Exception exception)
        {
            return -1;
        }
    }

    //GET EGG GROUPS
    public static List<String> getPokemonEggGroups(String pageText) {
        String eggGroupLine = "";
        List<String> eggGroups = new ArrayList<String>();
        try {
            eggGroupLine = (getSubString(pageText, "Egg Group", "Average ")).trim();
        }
        catch (Exception a) {
            try {
                eggGroupLine = (getSubString(pageText, "Egg Group", "Diet ")).trim();
            }
            catch (Exception b) {
                System.out.println(b.getMessage());
            }
        }
        eggGroupLine = eggGroupLine.substring(eggGroupLine.indexOf(":") + 1);
        eggGroups = Arrays.asList(eggGroupLine.split("/"));
        for (int i = 0; i < eggGroups.size(); i++) {
            eggGroups.set(i, eggGroups.get(i).trim());
        }
        return eggGroups;
    }

    //GET AVERAGE HATCH RATE


    //GET DIETS

    //GET HABITATS

    //GET OVERLAND

    //GET SWIM

    //GET LONG JUMP

    //GET HIGH JUMP

    //GET POWER
}


