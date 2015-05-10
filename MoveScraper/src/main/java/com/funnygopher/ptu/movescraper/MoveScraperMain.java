package com.funnygopher.ptu.movescraper;

import com.github.funnygopher.ptu.move.Move;

import java.io.IOException;
import java.util.List;

public class MoveScraperMain {

    public static void main(String[] args) throws IOException {

        MoveScraper moveScraper = new MoveScraper(ClassLoader.getSystemResourceAsStream("Moves.pdf"), 1 , 90);
        List<Move> moves = moveScraper.parseMoves();

        for (Move move : moves) {
            System.out.println(move.toString());
            System.out.println();
        }
    }

}
