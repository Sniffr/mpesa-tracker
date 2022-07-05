package com.cryptochain.movies.controller.mvc;

import com.cryptochain.movies.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class HomeController {
    @Autowired
    private MovieService movieService;

    @RequestMapping("/list_contact")
    public String index(Model model) {
        model.addAttribute("movies",movieService.getAllMovies());
        return "movies";
    }
}
