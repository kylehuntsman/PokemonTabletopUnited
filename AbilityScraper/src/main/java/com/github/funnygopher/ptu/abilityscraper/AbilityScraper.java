package com.github.funnygopher.ptu.abilityscraper;

import com.github.funnygopher.ptu.Ability;
import org.apache.pdfbox.pdmodel.PDDocument;

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

    public List<Ability> parseAbilities(String input) {
        List<Ability> abilities;
        for (int currrentPageNumber = startPage; currrentPageNumber < endPage + 1; currrentPageNumber++) {
            List<String> lines = getPageLines(currrentPageNumber);
            String name, frequncy, target, trigger, effect = "";
            for (int lineIndex = 0; lineIndex < lines.size(); lineIndex++) {
                String currentLine = lines.get(lineIndex);
                if (currentLine.isEmpty()) {
                    continue;
                }
                else if (currentLine.contains("Ability:")) {
                    name = getAbilityName(currentLine);
                    lineIndex++;
                    frequncy = lines.get(lineIndex);
                }
                else if (currentLine.contains("Target:")) {
                    target = getAbilityTarget(currentLine);
                }
                else if (currentLine.contains("Trigger:")) {
                    trigger = getAbilityTrigger(currentLine);
                }
                else if (currentLine.contains("Effect:")) {

                }
                else if (currentLine.contains("ABILITY LIST:")) {

                }
            }
        }
        return null;
    }

    private List<String> getPageLines(int pageNumber) {
        List<String> lines = new ArrayList<String>();
        return null;
    }

    private String getAbilityName(String input) {
        return null;
    }

    private String getAbilityTarget(String input) {
        return null;
    }

    private String getAbilityTrigger(String input) {
        return null;
    }

    private String getAbilityEffect(String input) {
        return null;
    }
}
