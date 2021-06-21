package kz.akmanat.springcourse.config.config;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {
   @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model){

       //System.out.println("Hello, "+name+" "+surname);
        model.addAttribute("message","Hello, "+name+" "+surname);
       return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodbyePage(){
        return "first/goodbye";
    }
    @GetMapping("/calculator")
    public String calculate(@RequestParam("a") int a,
                            @RequestParam("b") int b,
                            @RequestParam("action") String action,
                            Model model){
        double c;

        //System.out.println("Hello, "+name+" "+surname);
        model.addAttribute("message1","You entered next two numbers: first number is "+a+" and second number is "+b+".");
        model.addAttribute("message2", "Also you choose next action: "+action);
        switch(action){
            case "multiplication":
                c = a*b;
                break;
            case "addition":
                c = a+b;
                break;
            case "subtraction":
                c = a-b;
                break;
            case "division":
                c = a/(double)b;
                break;
            default:
                c=0;
                break;
        }
        model.addAttribute("result", "The result is : "+c);
       return "first/calculator";
    }
}
