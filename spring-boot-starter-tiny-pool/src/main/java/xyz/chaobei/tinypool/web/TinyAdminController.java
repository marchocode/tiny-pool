package xyz.chaobei.tinypool.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/tiny-pool")
public class TinyAdminController {

    @GetMapping("/")
    public String view() {
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/core")
    public String core() {
        return "core";
    }

}
