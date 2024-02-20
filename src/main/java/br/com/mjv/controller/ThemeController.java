package br.com.mjv.controller;

import br.com.mjv.service.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tema")
public class ThemeController {

    @Autowired
    ThemeService themeService;

    //@GetMapping
    //public

}
