package com.rs.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * created by rs 1/30/2022.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    String index(){
        return "index";
    }
}
