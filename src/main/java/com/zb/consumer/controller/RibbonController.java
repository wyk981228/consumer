package com.zb.consumer.controller;

import com.zb.consumer.service.RibbonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RibbonController {

    @Autowired
    RibbonService ribbonService;


    @RequestMapping("/hello")
    public String hello(Model model){

        model.addAttribute("msg",ribbonService.dazhaohu());
        return "index";
    }
}
