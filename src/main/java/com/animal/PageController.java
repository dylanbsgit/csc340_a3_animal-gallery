package com.animal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {
    
    @GetMapping("/about")
    public String showAbout() {
        return "about"; // Will render about.ftlh
    }
    
    @GetMapping("/")
    public String home() {
        return "redirect:/animals"; // Redirect root to animals page
    }
}