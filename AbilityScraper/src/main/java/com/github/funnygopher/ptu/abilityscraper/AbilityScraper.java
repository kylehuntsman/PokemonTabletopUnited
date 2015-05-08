package com.github.funnygopher.ptu.abilityscraper;

import com.github.funnygopher.ptu.Ability;
import javafx.scene.effect.Effect;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AbilityScraper {

    private File pdfFile;
    private PDDocument pdf;
    private int startPage;
    private int endPage;

    public AbilityScraper(File pdfFile, int startPage, int endPage) throws IOException{
        this.pdfFile = pdfFile;
        this.startPage = startPage;
        this.endPage = endPage;

        pdf = PDDocument.load(pdfFile);
    }

    public List<Ability> parseAbilities(String input) throws IOException {
        List<Ability> abilities = new ArrayList<Ability>();
        for (int currentPageNumber = startPage; currentPageNumber <= endPage; currentPageNumber++) {
            List<String> lines = getPageLines(currentPageNumber);
            String name, frequncy, target, trigger, effect;
            name = frequncy = target = trigger = effect = "";
            for (int lineIndex = 0; lineIndex < lines.size(); lineIndex++) {
                String currentLine = lines.get(lineIndex);
                if (currentLine.isEmpty() ||
                        currentLine.contains("ABILITY LIST:") ||
                        currentLine.contains("INDICES AND REFERENCES") ||
                        currentLine.matches("^\\d*$")) {}
                else if (currentLine.contains("Ability:")) {
                    if (!name.isEmpty()) {
                        Ability newAbility = new Ability(name, frequncy, target, trigger, effect);
                        abilities.add(newAbility);
                    }
                    else {
                        name = frequncy = target = trigger = effect = "";
                        name = getAbilityName(currentLine);
                        lineIndex++;
                        frequncy = lines.get(lineIndex);
                    }
                }
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
                    effect += currentLine;
                }
            }
        }
        return abilities;
    }

    private List<String> getPageLines(int pageNumber) throws IOException{
        List<String> lines = new ArrayList<String>();
        String pageText = "";
        PDFTextStripper stripper = new PDFTextStripper();
        stripper.setStartPage(pageNumber);
        stripper.setEndPage(pageNumber);
        pageText = stripper.getText(pdf).replaceAll(" +", " ");
        lines = Arrays.asList(pageText.split("\n"));
        for (int lineIndex = 0; lineIndex < lines.size(); lineIndex++) {
            lines.set(lineIndex, lines.get(lineIndex).trim());
        }
        return lines;
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
