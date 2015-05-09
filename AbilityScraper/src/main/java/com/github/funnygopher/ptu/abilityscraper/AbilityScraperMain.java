package com.github.funnygopher.ptu.abilityscraper;

import com.github.funnygopher.ptu.Ability;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AbilityScraperMain {

    public static void main (String[] args) throws IOException {
        int firstPage = 1;
        int lastPage = 25;
        AbilityScraper abilityScraper = new AbilityScraper(ClassLoader.getSystemResourceAsStream("Abilities.pdf"), firstPage, lastPage);
        List<Ability> abilities = new ArrayList<>();
        try {
            abilities = abilityScraper.parseAbilities();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println();
        for (Ability ability : abilities ) {
            System.out.println(ability.toString());
        }
    }

}
