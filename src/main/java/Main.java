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




        post("/heroes", (request, response) -> {
            String heroName = request.queryParams("name");
            String squadName = request.queryParams("squad");

//            Squad squad = new Squad(squadName);
//            Hero hero = new Hero(heroName, squad);
//
//            // Add hero to squad
//            squad.addHero(hero);

            return "Hero added: " + heroName;
        });


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



//        get("/squads", (request, response) -> {
//            Map<String, Object> model = new HashMap<>();
//            model.put("squads", Squad.squads); // Pass the list of squads to the template
//
//            // Render the template with the list of squads
//            return new ModelAndView(model, "squads.hbs"); // Replace "squads.hbs" with your template file
//        }, new HandlebarsTemplateEngine());


        get("/squad/new", (request, response) -> {
            // Render the template with the form for creating a new squad
            return new ModelAndView(null, "add-squad.hbs"); // Replace "add-squad.hbs" with your template file
        }, new HandlebarsTemplateEngine());


        get("/hero/new", (request, response) -> {
            // Render the template with the form for creating a new squad
            return new ModelAndView(null, "add-hero.hbs"); // Replace "add-squad.hbs" with your template file
        }, new HandlebarsTemplateEngine());

    }
}
