package com.lakefarm.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by cxd on 2017/2/6.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public ModelAndView getLoginView(ModelAndView view) {
        view.setView(new RedirectView("/login.html", false));
        return view;
    }
}
