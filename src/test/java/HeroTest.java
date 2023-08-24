import static org.junit.jupiter.api.Assertions.*;

import models.Hero;
import models.Squad;
import org.junit.jupiter.api.Test;
import java.util.List;

public class HeroTest {

    @Test
    public void testHeroCreation() {
        Hero hero = new Hero(28, "Spider-Man", "Web-Slinging", "Venom");

        assertEquals(hero.getName(), "Spider-Man");
        assertEquals(hero.getPower(), "Web-Slinging");
        assertEquals(hero.getWeakness(), "Venom");
    }

    @Test
    public void testHeroSquadAssociation() {
        Squad squad = new Squad(4, "X-Men", "Mutant superheroes");

        Hero hero = new Hero(25, "Wolverine", "Regeneration", "Adamantium");

        squad.addHero(hero);

        assertEquals(hero.getSquadId(), squad.getId());
    }

    @Test
    public void testHeroSquadDisassociation() {
        Squad squad = new Squad(3, "Guardians of the Galaxy", "Cosmic defenders");

        Hero hero = new Hero(32, "Star-Lord", "Leadership", "Element Guns");

        squad.addHero(hero);
        hero.setSquadId(-1); // Simulate hero leaving the squad

        assertEquals(hero.getSquadId(), -1);
    }
}
