package tdtu.edu.Lab09.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public  String login(){
        return  "login";
    }

    @GetMapping("/register")
    public  String register(){
        return  "register";
    }
}
