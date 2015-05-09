package com.github.funnygopher.ptu.pokedexscraper;

import java.io.IOException;

public class PokedexScraperMain {

    public static void main(String[] args) throws IOException {
        PokedexScraper scraper  = new PokedexScraper("pokedex_v1-05.pdf", 12, 745, false);
    }
}


