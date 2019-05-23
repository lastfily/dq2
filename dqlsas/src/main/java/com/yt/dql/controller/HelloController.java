package com.yt.dql.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloController {

    @RequestMapping("/a")
    public String index(ModelMap map) {
        // 加入一个属性，用来在模板中读取
        map.addAttribute("host", "http://blog.didispace.com");
        // return模板文件的名称，对应src/main/resources/templates/index.html
        return "index";
    }

        @RequestMapping(value = "/{name}", method = RequestMethod.GET)
        public String getMovie(@PathVariable String name, ModelMap model) {
            model.addAttribute("name", name);
            model.addAttribute("query", "");
            model.addAttribute("submit", "");
            return "hello";
        }

        @RequestMapping(value = "/query", method = RequestMethod.GET)
        public String query(@RequestParam("name") String name, ModelMap model) {
            model.addAttribute("name", "");
            model.addAttribute("query", name);
            model.addAttribute("submit", "");
            return "hello";
        }

        @RequestMapping(value = "/submit", method = RequestMethod.GET)
        public String submit(@RequestParam("name") String name, ModelMap model) {
            model.addAttribute("name", "");
            model.addAttribute("query", "");
            model.addAttribute("submit", name);
            return "hello";
        }

    }