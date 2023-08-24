import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) {

        Squad justiceLeague = new Squad(5, "Justice League", "Fighting for justice");

        Squad.squads.add(justiceLeague);

        port(8085);
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<String, Object>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());




        post("/squads", (request, response) -> {
            String name = request.queryParams("name");
            int maxSize = Integer.parseInt(request.queryParams("maxSize"));
            String cause = request.queryParams("cause");

            // Create a new Squad instance
            Squad squad = new Squad(maxSize, name, cause);

            // Save squad to the list
            Squad.squads.add(squad);

            // Redirect to a page that displays the list of squads or provides a success message
            response.redirect("/"); // Change the URL as needed

            return null; // Returning null since we're redirecting
        });



        get("/squads", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("squads", Squad.squads); // Pass the list of squads to the template

            // Render the template with the list of squads
            return new ModelAndView(model, "squads.hbs"); // Replace "squads.hbs" with your template file
        }, new HandlebarsTemplateEngine());


        get("/squad/new", (request, response) -> {
            // Render the template with the form for creating a new squad
            return new ModelAndView(null, "add-squad.hbs"); // Replace "add-squad.hbs" with your template file
        }, new HandlebarsTemplateEngine());

        get("/squads/:squadId/heroes/new", (request, response) -> {
            int squadId = Integer.parseInt(request.params(":squadId"));
            Map<String, Object> model = new HashMap<>();
            model.put("squadId", squadId);
            return new ModelAndView(model, "add-hero.hbs"); // Replace with your template file
        }, new HandlebarsTemplateEngine());



        // Handling the form submission
        post("/heroes", (request, response) -> {
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String power = request.queryParams("power");
            String weakness = request.queryParams("weakness");
            int squadId = Integer.parseInt(request.queryParams("squadId"));

            Hero hero = new Hero(age, name, power, weakness);

            // Add the hero to the appropriate squad using the squadId
            Squad squad = Squad.squads.stream()
                    .filter(s -> s.getId() == squadId)
                    .findFirst()
                    .orElse(null);

            if (squad != null) {
                squad.addHero(hero);
                response.redirect("/squads/" + squadId); // Redirect to the squad's page
            } else {
                response.status(404); // Squad not found
                return "Squad not found";
            }

            return null; // Returning null since we're redirecting
        });



        get("/heroes/:heroId", (request, response) -> {
            int heroId = Integer.parseInt(request.params(":heroId"));

            // Find the hero with the given heroId
            Hero hero = Hero.heroes.stream()
                    .filter(h -> h.getId() == heroId)
                    .findFirst()
                    .orElse(null);

            if (hero != null) {
                Squad squad = Squad.squads.stream()
                        .filter(s -> s.getId() == hero.getSquadId())
                        .findFirst()
                        .orElse(null);

                if (squad != null) {
                    Map<String, Object> model = new HashMap<>();
                    model.put("hero", hero);
                    model.put("squad", squad);
                    return new ModelAndView(model, "hero-details.hbs"); // Replace with your template file
                } else {
                    response.status(404); // Squad not found
                    return null;
                }
            } else {
                response.status(404); // Hero not found
                return null;
            }
        }, new HandlebarsTemplateEngine());



        get("/squads/:squadId", (request, response) -> {
            int squadId = Integer.parseInt(request.params(":squadId"));

            // Find the squad with the given squadId
            Squad squad = Squad.squads.stream()
                    .filter(s -> s.getId() == squadId)
                    .findFirst()
                    .orElse(null);

            if (squad != null) {
                Map<String, Object> model = new HashMap<>();
                model.put("squad", squad);
                return new ModelAndView(model, "squad.hbs"); // Replace with your template file
            } else {
                response.status(404); // Squad not found
                return null;
            }
        }, new HandlebarsTemplateEngine());
    }
}