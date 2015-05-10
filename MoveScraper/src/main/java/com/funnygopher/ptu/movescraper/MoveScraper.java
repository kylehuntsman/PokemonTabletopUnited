package com.funnygopher.ptu.movescraper;

import com.github.funnygopher.ptu.move.Move;
import com.github.funnygopher.ptu.move.MoveBuilder;
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

    public List<Move> parseMoves() throws IOException {
        List<Move> moves = new ArrayList<>();

        // Loops through each page
        for (int currentPageNumber = startPage; currentPageNumber <= endPage; currentPageNumber++) {
            List<String> pageText = getPageLines(currentPageNumber);

            MoveBuilder moveBuilder = new MoveBuilder();
            String effect = "";

            // Loops through each Move
            for (String currentLine : pageText) {
                //System.out.println(currentLine);

                if (currentLine.equals("Indices and References") || currentLine.isEmpty() || currentLine.equals(346 + currentPageNumber + "")) {
                    continue;
                }

                if (currentLine.contains("Move:")) {
                    if (moveBuilder.bName) {
                        moveBuilder.effect(effect);
                        Move newMove = moveBuilder.build();
                        moves.add(newMove);
                        moveBuilder = new MoveBuilder();
                        String name = getName(currentLine);
                        moveBuilder.name(name);
                    } else {
                        String name = getName(currentLine);
                        moveBuilder.name(name);
                    }
                    continue;
                }

                if (!moveBuilder.bConStat && currentLine.contains("Contest Type:")) {
                    ContestStat contestStat = getContestStat(currentLine);
                    moveBuilder.contestStat(contestStat);
                    continue;
                }

                if (!moveBuilder.bType && currentLine.contains("Type:")) {
                    Type type = getType(currentLine);
                    moveBuilder.type(type);
                    continue;
                }

                if (!moveBuilder.bFrequency && currentLine.contains("Frequency:")) {
                    String frequency = getFrequency(currentLine);
                    moveBuilder.frequency(frequency);
                    continue;
                }

                if (!moveBuilder.bAccCheck && currentLine.contains("AC:")) {
                    int accuracyCheck = getAccuracyCheck(currentLine);
                    moveBuilder.accuracyCheck(accuracyCheck);
                    continue;
                }

                if (!moveBuilder.bDamageBase && currentLine.contains("Damage Base")) {
                    int damageBaseValue = getDamageBaseValue(currentLine);
                    moveBuilder.damageBase(damageBaseValue);
                    continue;
                }

                if (!moveBuilder.bMoveClass && currentLine.contains("Class:")) {
                    MoveClass moveClass = getMoveClass(currentLine);
                    moveBuilder.moveClass(moveClass);
                    continue;
                }

                if (!moveBuilder.bRange && currentLine.contains("Range:")) {
                    String range = getRange(currentLine);
                    moveBuilder.range(range);
                    continue;
                }

                if (!moveBuilder.bConEffect && currentLine.contains("Contest Effect")) {
                    ContestEffect contestEffect = getContestEffect(currentLine);
                    moveBuilder.contestEffect(contestEffect);
                    continue;
                }

                if (currentLine.contains("Effect:")) {
                    effect = getEffect(currentLine);
                    continue;
                }

                if (!moveBuilder.bSpecial && currentLine.contains("Special:")) {
                    String special = getSpecial(currentLine);
                    moveBuilder.special(special);
                    continue;
                }

                effect += " " + currentLine;
            }
            moveBuilder.effect(effect);
            Move newMove = moveBuilder.build();
            moves.add(newMove);
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

    private String getName(String input) {
        return input.substring(5).trim();
    }

    private Type getType(String input) {
        String value = input.substring(5).trim().toUpperCase();
        try {
            return Type.valueOf(value);
        } catch (Exception e) {
            return Type.ERROR;
        }
    }

    private String getFrequency(String input) {
        return input.substring(10).trim();
    }

    private int getAccuracyCheck(String input) {
        String value = input.substring(3).trim();
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            return -1;
        }
    }

    private int getDamageBaseValue(String input) {
        String value = input.substring(input.indexOf("Damage Base") + 11, input.indexOf(":")).trim();
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            return -1;
        }
    }

    private MoveClass getMoveClass(String input) {
        String value = input.substring(6).trim().toUpperCase();
        try {
            return MoveClass.valueOf(value);
        } catch (Exception e) {
            return MoveClass.ERROR;
        }
    }

    private String getRange(String input) {
        return input.substring(6).trim();
    }

    private String getEffect(String input) {
        return input.substring(7).trim();
    }

    private ContestStat getContestStat(String input) {
        String value = input.substring(13).trim().toUpperCase();
        try {
            return ContestStat.valueOf(value);
        } catch (Exception e) {
            return ContestStat.ERROR;
        }
    }

    private ContestEffect getContestEffect(String input) {
        String contestEffectName = input.substring(15).trim();
        //Look up the die roll and effect from the database table table
        return new ContestEffect(contestEffectName, "", "");
    }

    private String getSpecial(String input) {
        return input.substring(8).trim();
    }
}
