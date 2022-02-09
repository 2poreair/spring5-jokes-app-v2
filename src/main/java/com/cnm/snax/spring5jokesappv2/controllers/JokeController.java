package com.cnm.snax.spring5jokesappv2.controllers;

import com.cnm.snax.spring5jokesappv2.services.JokeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {
    private final JokeService jokeService;

    //as of Spring 4.2 we no longer have to use AutoWire with the constructor when there is only one.
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/",""})
    public String showJoke(Model model){
        model.addAttribute("joke", jokeService.getJoke());

        return "index";
    }
}
