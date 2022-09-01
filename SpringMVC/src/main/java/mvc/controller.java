package mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class controller {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/target")
    public String target(){
        return "target";
    }

    @RequestMapping("/target1/{id}")
    public String target1(@PathVariable("id")Integer ss){

        System.out.println("id:"+ss);
        return "target";
    }

    @RequestMapping("/modelAndView")
    public ModelAndView modelAndView(){

        ModelAndView modelAndView = new ModelAndView();

        modelAndView.addObject("scope","hello ModelAndView");
        modelAndView.setViewName("target");

        return modelAndView;



    }

}
