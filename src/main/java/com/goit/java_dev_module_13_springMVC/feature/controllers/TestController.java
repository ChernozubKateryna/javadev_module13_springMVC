package com.goit.java_dev_module_13_springMVC.feature.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {
    @GetMapping("/test")
    public ModelAndView getName() {
        ModelAndView result = new ModelAndView("test");
        result.addObject("test");
        return result;
    }
}

