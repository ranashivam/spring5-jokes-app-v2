package guru.springframework.spring5jokesappv2.controllers;

import guru.springframework.spring5jokesappv2.services.JokeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokesController {

    private final JokeService jokeService;


    // Constructor for above field
    @Autowired
    public JokesController(JokeService jokeService) {
        this.jokeService = jokeService;
    }


    @RequestMapping({"/",""})   // @RequestMapping({"/",""}) 1st arg means that when the URL path is given as / and 2nd arg eman that when nothing is given, it will execute below code
    public String showJoke(Model model){

        model.addAttribute("joke", jokeService.getJokes());
        return "index"; // calling index.html file
    }

}
