package com.github.funnygopher.ptu.abilityscraper;

import com.github.funnygopher.ptu.Ability;
import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AbilityScraperMain {

    public static void main (String[] args) throws IOException {
        int firstPage = 1;
        int lastPage = 25;
        AbilityScraper abilityScraper = new AbilityScraper("C:\\Users\\braolson\\Desktop\\PTU\\PokemonTabletopUnited\\AbilityScraper\\src\\main\\resources\\Abilities.pdf",
        firstPage, lastPage);
        List<Ability> abilities = new ArrayList<Ability>();
        try {
            abilities = abilityScraper.parseAbilities();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Ability ability : abilities ) {
            System.out.println(ability.getName());
        }
    }

}
