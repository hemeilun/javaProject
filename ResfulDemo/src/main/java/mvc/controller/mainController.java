package mvc.controller;

import domain.User;
import mvc.dao.impl.userdaoimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class mainController {

    @Autowired
    @Qualifier("userdaoimpl")
    private userdaoimpl userdao;

    @RequestMapping(value = "/querry",method = RequestMethod.GET)
    public ModelAndView querry(){
        List<User> querry = userdao.querry();

        ModelAndView mav = new ModelAndView();
        //向请求域共享数据
        mav.addObject("querryList", querry);
        //设置视图，实现页面跳转
        mav.setViewName("userShow");

        return mav;

    }


}
