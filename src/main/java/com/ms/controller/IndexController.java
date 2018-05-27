package com.ms.controller;

import com.ms.service.UserServiceImplementation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    UserServiceImplementation userServiceImplementation;

    Logger logger = LogManager.getLogger(IndexController.class);

    private static final String INITIAL = "initial";
    private static final String OFERTA = "oferta";
    private static final String CENNIK = "cennik";
    private static final String ABOUT = "onas";
    private static final String GALLERY = "galeria";
    private static final String CONTACT = "kontakt";


    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("frag", INITIAL);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object name = authentication;
        logger.debug("Zalogowany user: " + name + ", do index");
        return "index";
    }

    @RequestMapping("/oferta")
    public String oferta(Model model) {
        model.addAttribute("frag", OFERTA);
        return "index";
    }

    @RequestMapping("/cennik")
    public String cennik(Model model) {
        model.addAttribute("frag", CENNIK);
        return "index";
    }

    @RequestMapping("/onas")
    public String about(Model model) {
        model.addAttribute("frag", ABOUT);
        return "index";
    }

    @RequestMapping("/galeria")
    public String gallery(Model model) {
        model.addAttribute("frag", GALLERY);
        return "index";
    }

    @RequestMapping("/kontakt")
    public String contact(Model model) {
        model.addAttribute("frag", CONTACT);
        return "index";
    }

}
