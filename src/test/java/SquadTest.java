import static org.junit.jupiter.api.Assertions.*;

import models.Hero;
import models.Squad;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

public class SquadTest {

    @Test
    public void testAddHeroToSquad() {
        Squad squad = new Squad(5, "Justice League", "Fighting for justice");

        Hero hero = new Hero(30, "Superman", "Flight", "Kryptonite");

        squad.addHero(hero);

        assertEquals(squad.getHeroes().get(0), hero);
        assertEquals(hero.getSquadId(), squad.getId());
    }

    @Test
    public void testAddHeroToSquad_AlreadyInSquad() {
        Squad squad = new Squad(5, "Avengers", "Protecting the world");

        Hero hero1 = new Hero(35, "Iron Man", "Technology", "Pride");
        Hero hero2 = new Hero(28, "Hulk", "Strength", "Rage");

        squad.addHero(hero1);

        assertThrows(IllegalArgumentException.class, () -> squad.addHero(hero1));
    }
}
