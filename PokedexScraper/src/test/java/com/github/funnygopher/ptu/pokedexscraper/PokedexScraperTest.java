package com.github.funnygopher.ptu.pokedexscraper;

import org.junit.Test;

import java.io.IOException;

public class PokedexScraperTest {

    @Test
    public void baseStatTest() {
        PokedexScraper scraper;
        int page = 1;
        try {
            scraper = new PokedexScraper("Bulbasaur.pdf", page, page, false);
            System.out.println(scraper.getPageText(page));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}