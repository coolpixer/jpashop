package jpabook.jpashop.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class HelloController {
    @GetMapping(value = "/hello")
    public String hello(Model model) {
        model.addAttribute("data", "손님");

        return "hello";
    }
}
