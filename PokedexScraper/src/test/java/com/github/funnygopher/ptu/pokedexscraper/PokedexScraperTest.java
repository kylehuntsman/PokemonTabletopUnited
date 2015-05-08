package com.github.funnygopher.ptu.pokedexscraper;

import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class PokedexScraperTest {

    @Test
    public void baseStatTest() {
        PokedexScraper scraper;
        int page = 1;
        try {
            scraper = new PokedexScraper("C:/Users/braolson.KNOWN-UNIVERSE/Dev/PokemonTabletopUnited/PokedexScraper/src/test/resources/Bulbasaur.pdf", page, page, false);
            List<String> pageText = scraper.getPageText(page);
            for (String s : pageText) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}