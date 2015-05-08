package com.github.funnygopher.ptu.pokedexscraper;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;
import org.apache.pdfbox.util.PDFTextStripper;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.io.File;
import java.io.IOException;
import java.util.*;

public class PokedexScraperMain {
    public static void main(String[] args) {
        parsePokedex();
    }

    public static void parsePokedex() {
        List<String> skipNames = new ArrayList<String>(Arrays.asList(
                "PUMPKABOO", "GOURGEIST", "ROTOM", "TOTODILE", "MAGMAR", "PORYGON-Z"));

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

        PDDocument pdf  = null;
        int firstPage = 12; //12
        int lastPage = 745; //745
        String currentPageText = null;

        try {

            File input = new File("C:\\Users\\braolson\\downloads\\PTU 1.05\\Pokedex 1.05.pdf");  // The PDF file from where you would like to extract
            pdf = PDDocument.load(input);
        }
        catch (Exception e) {
            e.printStackTrace();
        }



        int pokemonNumber = 1;
        //System.out.println(stripper.getText(pdf));
        for (int currentPageIndex = firstPage; currentPageIndex <= lastPage; currentPageIndex++) {
            List pages = pdf.getDocumentCatalog().getAllPages();
            Iterator iter = pages.iterator();
            int index = 1;
            List<PDXObjectImage> imageList = new ArrayList<PDXObjectImage>();

            while(iter.hasNext()) {
                PDPage page = (PDPage) iter.next();
                getImages(page);

                index++;
            }

            try {
                PDFTextStripper stripper = new PDFTextStripper();
                stripper.setStartPage(currentPageIndex);
                stripper.setEndPage(currentPageIndex);
                currentPageText = stripper.getText(pdf);
            }

            catch (Exception e) {
                e.printStackTrace();
            }
            //currentPageText = currentPageText.replaceAll("\\s+", " ");


            if (currentPageIndex == 682)
                continue;

            System.out.println("------------------------------------");
            //System.out.println(currentPageText);

            //INCREMENT NUMBER
            System.out.println(pokemonNumber++);

            //GET THE NAME
            String name = getPokemonName(currentPageText);
            System.out.println(name);

            if (skipNames.contains(name)) {
                continue;
            }

            //GET HP
            String hp = getPokemonStat(currentPageText, "HP:", "Attack:");
            System.out.println("HP : " + hp);

            //GET ATTACK
            String attack = getPokemonStat(currentPageText, "Attack:", "Defense:");
            System.out.println("Attack : " + attack);

            //GET DEFENSE
            String defense = getPokemonStat(currentPageText, "Defense:", "Special Attack:");
            ;
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
            double maleGenderRatio = getPokemonGenderRatio(currentPageText);
            if (maleGenderRatio == -1) {
                System.out.println("Male Gender Ratio : None");
                System.out.println("Female Gender Ratio : None");
            }
            else {
                System.out.println("Male Gender Ratio : " + maleGenderRatio + "%");
                System.out.println("Female Gender Ratio : " + (100 - maleGenderRatio) + "%");
            }

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
            System.out.println("Capabilities : " + capabilities.toString());

            //GET ATHLETICS
            String athletics = getSkill(currentPageText, "Athl");
            System.out.println("Athletics : " + athletics);

            //GET ACROBATICS
            String acrobatics = getSkill(currentPageText, "Acro");
            System.out.println("Acrobatics : " + acrobatics);

            //GET COMBAT
            String combat = getSkill(currentPageText, "Combat");
            System.out.println("Combat : " + combat);

            //GET STEALTH
            String stealth = getSkill(currentPageText, "Stealth");
            System.out.println("Stealth : " + stealth);

            //GET PERCEPTION
            String perception = getSkill(currentPageText, "Percep");
            System.out.println("Perception : " + perception);

            //GET FOCUS
            String focus = getSkill(currentPageText, "Focus");
            System.out.println("Focus : " + focus);

            //GET LEVEL UP MOVES
            List<String> levelUpMoves = getLevelUpMoveList(currentPageText);
            System.out.println("Level Up Moves : " + levelUpMoves.toString());

            //GET TM/HM MOVES
            List<String> tmhmMoves = getTMHMoveList(currentPageText);
            System.out.println("TM/HM Moves : " + tmhmMoves.toString());

            //GET EGG MOVES
            List<String> eggMoves = getEggMoveList(currentPageText);
            System.out.println("Egg Moves : " + eggMoves.toString());

            //GET TUTOR MOVES
            List<String> tutorMoves = getTutorMoveList(currentPageText);
            System.out.println("Tutor Moves : " + tutorMoves.toString());
        }
        System.out.println("There are " + skipNames.size() + " problem children.");
    }

    public static List<String> getLabelDelaminatedTermsList(String input, String splitString, String endString) {
        return getLabelDelaminatedTermsList(input, splitString, endString, 0);
    }

    public static List<String> getLabelDelaminatedTermsList(String input, String splitString, String endString, int offset) {
        input = input.substring(input.indexOf(splitString) + splitString.length(), input.indexOf(endString));
        List<String> output = Arrays.asList(input.split(splitString));

        for (int i = 0; i < output.size(); i++) {
            String changedOutput = output.get(i);
            changedOutput = changedOutput.substring(offset).trim().replace("\\s+", " ");
            output.set(i, changedOutput);
        }

        return output;
    }

    public static List<String> getNumberedList(String input, String startString, String endString) {
        String inputSubString = (input.substring(input.indexOf(startString) + startString.length() + 2, input.indexOf(endString)));

        List<String> output = Arrays.asList(inputSubString.split("\n"));
        List<String> finalOutput = new ArrayList<String>();

        for (int i = 0; i < output.size(); i++) {
            output.set(i, output.get(i).trim());
            if (!output.get(i).isEmpty()) {
                finalOutput.add(output.get(i));
            }
        }

        return finalOutput;
    }

    public static List<String> getSeparatedList(String input, String startString, String endString){
        input = input.substring(input.indexOf(startString) + startString.length(), input.indexOf(endString)).trim().replace("\r", "").replace("\n", "");
        List<String> output = new ArrayList<String>();
        output = Arrays.asList(input.split(","));
        List<String> finalOutput = new ArrayList<String>();

        for (int i = 0; i < output.size(); i++) {
            output.set(i, output.get(i).trim());
            if (!output.get(i).isEmpty()) {
                finalOutput.add(output.get(i));
            }
        }
        return finalOutput;
    }

    public static List<String> getSeparatedList(String input, String startString){
        input = input.substring(input.indexOf(startString) + startString.length(),input.length()).trim().replace("\r", "").replace("\n", "");
        List<String> output = new ArrayList<String>();
        output = Arrays.asList(input.split(","));
        List<String> finalOutput = new ArrayList<String>();

        for (int i = 0; i < output.size(); i++) {
            output.set(i, output.get(i).trim());
            if (!output.get(i).isEmpty()) {
                finalOutput.add(output.get(i));
            }
        }
        return finalOutput;
    }

    public static String getSubString(String input, String startString, String endString) {
        return input.substring(input.indexOf(startString), input.indexOf(endString));
    }

    public static String getBetweenSubString(String input, String startString, String endString){
        return input.substring(input.indexOf(startString) + startString.length(), input.indexOf(endString));
    }

    public static List<PDXObjectImage> getImages(PDPage page){
        PDResources resources = page.getResources();
        Map pageImages = null;
        List<PDXObjectImage> imageList = new ArrayList<PDXObjectImage>();

        try {
            pageImages = resources.getImages();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (pageImages != null) {
            Iterator imageIter = pageImages.keySet().iterator();
            while (imageIter.hasNext()) {
                String key = (String) imageIter.next();
                PDXObjectImage image = (PDXObjectImage) pageImages.get(key);
                imageList.add(image);

                /*try {
                    image.write2file("C:\\Users\\braolson\\downloads\\PTU 1.05\\images\\" + index + ".png");
                } catch (IOException e) {
                    e.printStackTrace();
                }
                */
            }
        }
        return imageList;
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
        List<String> natureWalks = new ArrayList<String>();
        String capabilities = getBetweenSubString(pageText, "Capability List", "Skill List").trim().replaceAll("-", "").replace("\r", "").replace("\n", "");
        if (capabilities.contains("Naturewalk")) {
            natureWalks = getNatureWalk(capabilities);
            int startIndex = capabilities.indexOf("Naturewalk");
            int endIndex = capabilities.indexOf(")");
            String toBeReplaced = capabilities.substring(startIndex, endIndex + 1);
            capabilities = capabilities.replace(toBeReplaced, "");
        }
        String powerValue = getCapabilityValue(pageText, "Power") + "";
        int startIndex = capabilities.indexOf("Power") + 8 + powerValue.length();
        try {
            capabilities = capabilities.substring(startIndex).trim();
        }
        catch (Exception e) {
            return capabilityList;
        }
        capabilityList = Arrays.asList(capabilities.split(","));
        List<String> finalCapabilityList = new ArrayList<String>();

        for (String natureWalk : natureWalks) {
            finalCapabilityList.add(natureWalk);
        }

        //TRIMMING capabilityList ENTRIES
        for (int i = 0; i < capabilityList.size(); i++){
            capabilityList.set(i, capabilityList.get(i).trim());
            if (!(capabilityList.get(i).isEmpty() || capabilityList.get(i).equals("") || capabilityList.get(i).equals("\n" ))) {
                finalCapabilityList.add(capabilityList.get(i));
            }
        }

        return finalCapabilityList;
    }

    //GET SKILL VALUE
    public static String getSkill(String pageText, String skillName){
        String skills = getBetweenSubString(pageText, "Skill List", "Move List").trim().replaceAll("\\s+", "");
        if (skills.contains(skillName)){
            int startIndex = skills.indexOf(skillName) + skillName.length();
            skills = skills.substring(startIndex);
            try {
                skills = skills.substring(0, skills.indexOf(","));
            }
            catch (Exception e){
                return skills;
            }
        }
        return skills;
    }

    //GET MOVE LIST
    public static List<String> getLevelUpMoveList(String pageText){
        String startString = "Level Up Move List";
        List<String> moves = new ArrayList<String>();

        if (pageText.contains("TM/HM")){
            moves = getNumberedList(pageText, startString, "TM/HM");
        }
        else if (pageText.contains("Egg Move List")){
            moves = getNumberedList(pageText, startString, "Egg Move List");
        }
        else if (pageText.contains("Tutor Move List")){
            moves = getNumberedList(pageText, startString, "Tutor Move List");
        }
        else{
            String inputSubString = (pageText.substring(pageText.indexOf(startString) + startString.length() + 2, pageText.length() - 1));
            List<String> output = Arrays.asList(inputSubString.split("\n"));

            for (int i = 0; i < output.size(); i++) {
                output.set(i, output.get(i).trim());
                if (!output.get(i).isEmpty()) {
                    moves.add(output.get(i));
                }
            }
        }
        return moves;
    }

    //GET TM/HM
    public static List<String> getTMHMoveList( String pageText){
        List<String> moveList = new ArrayList<String>();
        if (pageText.contains("TM/HM Move List")){
            if (pageText.contains("Egg Move List"))
                moveList = getSeparatedList(pageText, "TM/HM Move List", "Egg Move List");
            else if (pageText.contains("Tutor Move List"))
                moveList = getSeparatedList(pageText, "TM/HM Move List", "Tutor Move List");
            else
                moveList = getSeparatedList(pageText, "TM/HM Move List");
        }
        return moveList;
    }

    //GET EGG MOVE LIST
    public static List<String> getEggMoveList( String pageText){
        List<String> moveList = new ArrayList<String>();
        if (pageText.contains("Egg Move List")){
            if (pageText.contains("Egg Move List"))
                moveList = getSeparatedList(pageText, "Egg Move List", "Tutor Move List");
            else
                moveList = getSeparatedList(pageText, "Egg Move List");
        }
        return moveList;
    }

    //TUTOR MOVE LIST
    public static List<String> getTutorMoveList( String pageText){
        List<String> moveList = new ArrayList<String>();
        if (pageText.contains("Tutor Move List")){
            moveList = getSeparatedList(pageText, "Tutor Move List");
        }
        return moveList;
    }

    //GET IMAGES

    //GET NATUREWALK
    public static List<String> getNatureWalk(String cabapilitiesList) {
        List<String> raw = new ArrayList<String>();
        List<String> natureWalks = new ArrayList<String>();
        raw = Arrays.asList((cabapilitiesList.substring(cabapilitiesList.indexOf("(") + 1, cabapilitiesList.indexOf(")")).split(",")));
        for (int i = 0; i < raw.size(); i++){
            if (!(raw.get(i).isEmpty() || raw.get(i).equals("") || raw.get(i).equals("\n" ))) {
                natureWalks.add("Naturewalk (" + raw.get(i).trim() + ")");
            }
        }
        return natureWalks;
    }
}


