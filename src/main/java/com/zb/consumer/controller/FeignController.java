package com.zb.consumer.controller;

import com.zb.consumer.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class FeignController {

    @Autowired
    FeignService feignService;

    @RequestMapping("/list")
    public String list(@RequestParam Map map, Model model, HttpSession session){
        //通過feign組件調用遠端(sp)接口
        model.addAttribute("users",feignService.findAll(map));
        session.getServletContext().setAttribute("roles",feignService.getAllRoles());
        return "list";
    }

    @RequestMapping("/del/{id}")
    @ResponseBody
    public Integer delete(@PathVariable("id")String id){
        System.out.println("id:"+id);
        return feignService.delete(id);
    }

    @RequestMapping("/get")
    public String get(@RequestParam(value = "id") String id,Model model){
        System.out.println("id:"+id);
        model.addAttribute("user",feignService.get(id));
      //  model.addAttribute("roles",feignService.getAllRoles());
        return "view";
    }


}
