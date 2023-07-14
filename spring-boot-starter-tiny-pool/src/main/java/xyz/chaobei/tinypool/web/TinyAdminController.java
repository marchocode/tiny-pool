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

}
