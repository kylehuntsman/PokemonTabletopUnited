package com.github.funnygopher.ptu.abilityscraper;

import com.github.funnygopher.ptu.Ability;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AbilityScraper {

    private PDDocument pdf;
    private int startPage;
    private int endPage;

    public AbilityScraper(InputStream pdfFile, int startPage, int endPage) throws IOException{
        this.startPage = startPage;
        this.endPage = endPage;

        pdf = PDDocument.load(pdfFile);
    }

    public List<Ability> parseAbilities() throws IOException {
        List<Ability> abilities = new ArrayList<>();

        for (int currentPageNumber = startPage; currentPageNumber <= endPage; currentPageNumber++) {
            List<String> lines = getPageLines(currentPageNumber);
            List<Integer> abilityNameIndexes = getAbilityNameIndexes(lines);
            String name, frequency, target, trigger, effect;

            for (int i = 0; i < abilityNameIndexes.size() - 1; i++) {
                name = getAbilityName(lines.get(abilityNameIndexes.get(i)));
                frequency = lines.get(abilityNameIndexes.get(i) + 1);
                target = "";
                trigger = "";
                effect = "";
                for (int lineIndex = abilityNameIndexes.get(i); lineIndex <= abilityNameIndexes.get(i + 1); lineIndex++) {
                    String currentLine = lines.get(lineIndex);
                    if (currentLine.contains("Ability:")) {}
                    else if (currentLine.contains("Target:")) {
                        target = getAbilityTarget(currentLine);
                    }
                    else if (currentLine.contains("Trigger:")) {
                        trigger = getAbilityTrigger(currentLine);
                    }
                    else if (currentLine.contains("Effect:")) {
                        effect = getAbilityEffect(currentLine);
                    }
                    else {
                        effect += " " + currentLine;
                    }
                }
                abilities.add(new Ability(name, frequency, target, trigger, effect));
            }
        }
        return abilities;
    }

    //Get indexes of the abilities
    private List<String> getPageLines(int pageNumber) throws IOException{
        List<String> lines;
        String pageText;
        PDFTextStripper stripper = new PDFTextStripper();
        stripper.setStartPage(pageNumber);
        stripper.setEndPage(pageNumber);
        pageText = stripper.getText(pdf).replaceAll(" +", " ");
        lines = Arrays.asList(pageText.split("\n"));
        for (int lineIndex = 0; lineIndex < lines.size(); lineIndex++) {
            lines.set(lineIndex, lines.get(lineIndex).trim() + " ");
        }
        return lines;
    }

    private ArrayList<Integer> getAbilityNameIndexes(List<String> pageLines) {
        ArrayList<Integer> abilityIndexes = new ArrayList<>();
        for (int lineIndex = 0; lineIndex < pageLines.size(); lineIndex++) {
            String currentLine = pageLines.get(lineIndex);
            if (currentLine.contains("Ability:"))
                abilityIndexes.add(lineIndex);
        }
        abilityIndexes.add(pageLines.size() - 1);
        return abilityIndexes;
    }

    private String getAbilityName(String input) {
        return input.substring(8).trim();
    }

    private String getAbilityTarget(String input) {
        return input.substring(7).trim();
    }

    private String getAbilityTrigger(String input) {
        return input.substring(8).trim();
    }

    private String getAbilityEffect(String input) {
        return input.substring(7).trim();
    }
}
