package mvc.controller;

import domain.User;
import mvc.dao.impl.userdaoimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class mainController {

    @Autowired
    @Qualifier("userdaoimpl")
    private userdaoimpl userdao;

    @RequestMapping(value = "/querry",method = RequestMethod.GET)
    public String querry(){
        List<User> querry = userdao.querry();
        System.out.println(querry);

        //userdao.querry();
        return "index";

    }


}
