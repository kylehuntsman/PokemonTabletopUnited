package com.funnygopher.ptu.movescraper;

import com.github.funnygopher.ptu.move.Move;
import com.github.funnygopher.ptu.move.MoveClass;
import com.github.funnygopher.ptu.move.contest.ContestEffect;
import com.github.funnygopher.ptu.move.contest.ContestStat;
import com.github.funnygopher.ptu.pokemon.species.Type;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveScraper {

    private PDDocument pdf;
    private int startPage;
    private int endPage;

    public MoveScraper(InputStream pdfFile, int startPage, int endPage) throws IOException {
        this.startPage = startPage;
        this.endPage = endPage;

        pdf = PDDocument.load(pdfFile);
    }

    public List<Move> parseAbilities() throws IOException {
        List<Move> moves = new ArrayList<>();

        for (int currentPageNumber = startPage; currentPageNumber <= endPage; currentPageNumber++) {
            List<String> lines = getPageLines(currentPageNumber);
            List<Integer> abilityNameIndexes = getMoveNameIndexes(lines);

            String name;
            Type type;
            String frequency;
            int accuracyCheck;
            int damageBaseValue;
            String calculatedDamage;
            int quickDamage;
            MoveClass moveClass;
            String range;
            String effect;
            ContestStat contestStat;
            ContestEffect contestEffect;

            /*
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
            */
        }

        return moves;
    }

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

    private ArrayList<Integer> getMoveNameIndexes(List<String> pageLines) {
        ArrayList<Integer> abilityIndexes = new ArrayList<>();
        for (int lineIndex = 0; lineIndex < pageLines.size(); lineIndex++) {
            String currentLine = pageLines.get(lineIndex);
            if (currentLine.contains("Move:"))
                abilityIndexes.add(lineIndex);
        }
        abilityIndexes.add(pageLines.size() - 1);
        return abilityIndexes;
    }

    private String getName(String input) {
        return null;
    }

    private Type getType(String input) {
        return null;
    }

    private String getFrequency(String input) {
        return null;
    }

    private String getAccuracyCheck(String input) {
        return null;
    }

    private Integer getDamageBaseValue(String input) {
        return null;
    }

    private String getCalculatedDamage(String input) {
        return null;
    }

    private Integer getQuickDamage(String input) {
        return null;
    }

    private MoveClass getMoveClass(String input) {
        return null;
    }

    private String getRange(String input) {
        return null;
    }

    private String getEffect(String input) {
        return null;
    }

    private ContestStat getContestStat(String input) {
        return null;
    }

    private ContestEffect getContestEffect(String input) {
        return null;
    }
}
