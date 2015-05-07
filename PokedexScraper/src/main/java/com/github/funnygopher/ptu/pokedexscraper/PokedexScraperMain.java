package com.github.funnygopher.ptu.pokedexscraper;

import com.sun.glass.ui.View;
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
        List<String> skipNames = new ArrayList<String>(Arrays.asList(
                "PUMPKABOO", "GOURGEIST", "ROTOM", "TOTODILE", "MAGMAR", "PORYGON-Z"));
        try {
            int firstPage = 745; //12
            int lastPage = 745; //745

            PDDocument pdf;
            File input = new File("C:\\Users\\braolson\\downloads\\PTU 1.05\\Pokedex 1.05.pdf");  // The PDF file from where you would like to extract
            pdf = PDDocument.load(input);
            PDFTextStripper stripper = new PDFTextStripper();
            int pokemonNumber = 1;
            //System.out.println(stripper.getText(pdf));


            /*
            The Problem Children
            PUMPKABOO - has different sizes which causes problems
            GOURGEIST - has different sizes which causes problems
            ROTOM - has alternate forms which cause problems
            TOTODILE - does not have the keyword evolution can only half parse
            MAGMAR - does not have the keyword evolution can only half parse
            PORYGON-Z - has "Biology" (WHAT!) instead of "Diet" (WTF!!!!)
            WHIMSICOTT - has "()" in his Fly capability
            EXEGGCUTE - Missing "," after the power capability
            EXEGGUTOR - Missing "," after the power capability
            VULPIX - Missing "," after the power capability
            NINETALES - Missing "," after the power capability
             */

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
                String hp = getPokemonStat(currentPageText, "HP:", "Attack:");;
                System.out.println("HP : " + hp);

                //GET ATTACK
                String attack = getPokemonStat(currentPageText, "Attack:", "Defense:");
                System.out.println("Attack : " + attack);

                //GET DEFENSE
                String defense = getPokemonStat(currentPageText, "Defense:", "Special Attack:");;
                System.out.println("Defense : " + defense);

                //GET SPECIAL ATTACK
                String specialAttack = getPokemonStat(currentPageText, "Special Attack:", "Special Defense");
                System.out.println("Special Attack : " + specialAttack);

                //GET SPECIAL DEFENSE
                String specialDefense = getPokemonStat(currentPageText, "Special Defense:", "Speed:");
                System.out.println("Special Defense : " + specialDefense);

                //GET SPEED
                String speed = getPokemonStat(currentPageText, "Speed:", "Basic Information");
                System.out.println("Speed : " + speed);

                //GET THE TYPE
                List<String> types = getPokemonTypes(currentPageText);
                System.out.println("Types : " + types.toString());

                //GET THE BASIC ABILITY
                List<String> basicAbilities = getBasicAbility(currentPageText);
                System.out.println("Basic Abilities : " + basicAbilities.toString());

                //GET THE ADV ABILITY
                List<String> advAbilities = getAdvAbility(currentPageText);
                System.out.println("Adv Abilities : " + advAbilities.toString());

                //GET THE HIGH ABILITY
                List<String> highAbilities = getHighAbility(currentPageText);
                System.out.println("High Abilities : " + highAbilities.toString());

                //GET EVOLUTION TREE
                List<String> evolutions = getEvolutionTree(currentPageText);
                System.out.println("Evolution : " + evolutions.toString());

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
                System.out.println("Egg Groups : " + eggGroups.toString());

                //GET AVERAGE HATCH RATE
                int hatchRate = getHathRate(currentPageText);
                if (hatchRate != -1)
                    System.out.println("Hatch Rate: " + hatchRate);

                //GET DIETS
                List<String> diets = getDiets(currentPageText);
                System.out.println("Diets : " + diets.toString());

                //GET HABITATS
                List<String> habitats = getHabitats(currentPageText);
                System.out.println("Habitats : " + habitats.toString());

                //GET OVERLAND
                int overland = getCapabilityValue(currentPageText, "Overland");
                System.out.println("Overland : " + overland);

                //GET SWIM
                int swim = getCapabilityValue(currentPageText, "Swim");
                System.out.println("Swim : " + swim);

                //GET SKY
                int sky = getCapabilityValue(currentPageText, "Sky");
                System.out.println("Sky : " + sky);

                //GET BURROW
                int burrow = getCapabilityValue(currentPageText, "Burrow");
                System.out.println("Burrow : " + burrow);

                //GET LEVITATE
                int levitate = getCapabilityValue(currentPageText, "Levitate");
                System.out.println("Levitate : " + levitate);

                //GET POWER
                int power = getCapabilityValue(currentPageText, "Power");
                System.out.println("Power : " + power);

                //GET LONG JUMP
                int longJump = getCapabilityValue(currentPageText, "Jump");
                System.out.println("Long Jump : " + longJump);

                //GET HIGH JUMP
                int highJump = getHighJumpValue(currentPageText);
                System.out.println("High Jump : " + highJump);

                //GET CAPABILITIES
                List<String> capabilities = getCapabilities(currentPageText);
                System.out.print("Capabilities : ");
                //System.out.println(capabilities.toString());
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
        System.out.println("There are " + skipNames.size() + " problem children.");
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

        /*
        for (int i = 0; i < output.size(); i++) {
            output.set(i, output.get(i).trim());
        }
        */

        for (String string : output) {
            if (string.length() < 0 || string.equals(" "))
                output.remove(string);
        }

        output.removeAll(Arrays.asList(Arrays.asList("", null, " ")));
        return output;
    }

    public static String getSubString(String input, String startString, String endString) {
        return input.substring(input.indexOf(startString), input.indexOf(endString));
    }

    public static String getBetweenSubString(String input, String startString, String endString){
        return input.substring(input.indexOf(startString) + startString.length(), input.indexOf(endString));
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
            eggGroupLine = getSubString(pageText, "Egg Group", "Average ").trim();
        }
        catch (Exception a) {
            try {
                eggGroupLine = getSubString(pageText, "Egg Group", "Diet ").trim();
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
    public static int getHathRate(String pageText) {
        if (pageText.contains("Average Hatch")) {
            String hatchRateLine = getSubString(pageText, "Average Hatch Rate:", "Day").trim();
            hatchRateLine = hatchRateLine.substring(hatchRateLine.indexOf(":") + 1).trim();
            int hatchRate;
            try {
                hatchRate = Integer.parseInt(hatchRateLine);
                return hatchRate;
            } catch (Exception e) {
                return -1;
            }
        }
        else {
            return -1;
        }
    }

    //GET DIETS
    public static List<String> getDiets(String pageText) {
        String dietsLine = "";
        List<String> diets = new ArrayList<String>();
        dietsLine = getSubString(pageText, "Diet", "Habitat").trim();
        dietsLine = dietsLine.substring(dietsLine.indexOf(":") + 1);
        diets = Arrays.asList(dietsLine.split(","));
        for (int i = 0; i < diets.size(); i++) {
            diets.set(i, diets.get(i).trim());
        }
        return diets;
    }

    //GET HABITATS
    public static List<String> getHabitats(String pageText) {
        String habitatLine = "";
        List<String> habitats = new ArrayList<String>();
        habitatLine = getSubString(pageText, "Habitat", "Capability").trim();
        habitatLine = habitatLine.substring(habitatLine.indexOf(":") + 1);
        habitats = Arrays.asList(habitatLine.split(","));
        for (int i = 0; i < habitats.size(); i++) {
            habitats.set(i, habitats.get(i).trim());
        }
        return habitats;
    }

    //GET CAPABILITY VALUE
    public static int getCapabilityValue(String pageText, String valueName) {
        String capabilities = getBetweenSubString(pageText, "Capability List", "Skill List").trim().replaceAll("\\s+", "");
        if (capabilities.contains(valueName)) {
            int value;
            int startIndex = capabilities.indexOf(valueName) + valueName.length();
            try {
                value = Integer.parseInt((capabilities.substring(startIndex, startIndex + 2).trim()));
            }
            catch (Exception a) {
                try {
                    value = Integer.parseInt((capabilities.substring(startIndex, startIndex + 1).trim()));
                }
                catch (Exception b) {
                    return 0;
                }
            }
            return value;
        } else
            return 0;
    }

    //GET HIGH JUMP
    public static int getHighJumpValue(String pageText) {
        int value = 0;
        String capabilities = getBetweenSubString(pageText, "Capability List", "Skill List").trim().replaceAll("\\s+", "");
        if (capabilities.contains("Jump")){
            int startIndex = capabilities.indexOf("Jump") + 6;

            try {
                value = Integer.parseInt(capabilities.substring(startIndex, startIndex + 1));
            }
            catch (Exception e){
                return -1;
            }
        }
        return value;
    }

    //GET CAPABILITIES
    public static List<String> getCapabilities (String pageText){
        List<String> capabilityList = new ArrayList<String>();
        String capabilities = getBetweenSubString(pageText, "Capability List", "Skill List").trim().replaceAll("-", "").replaceAll("\n", "");
        String powerValue = getCapabilityValue(pageText, "Power") + "";
        int startIndex = capabilities.indexOf("Power") + 6 + powerValue.length();
        capabilities = capabilities.substring(startIndex).trim();
        capabilityList = Arrays.asList(capabilities.split(","));

        //TRIMMING capabilityList ENTRIES
        for (int i = 0; i < capabilityList.size(); i++){
            capabilityList.set(i, capabilityList.get(i).trim());
        }
        return capabilityList;
    }

    //GET ATHLETICS

    //GET ACROBATICS

    //GET COMBAT

    //GET STEALTH

    //GET PERCEPTION

    //GET FOCUS

    //GET MOVE LIST

    //GET TM/HM

    //GET EGG MOVE LIST

    //TUTOR MOVE LIST
}


