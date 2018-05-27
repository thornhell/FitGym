package com.ms.controller;

import com.ms.model.FitGymUser;
import com.ms.service.UserServiceImplementation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    UserServiceImplementation userServiceImplementation;

    Logger logger = LogManager.getLogger(IndexController.class);


    @RequestMapping(value = "/admin/adminpage")
    public String adminpage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        FitGymUser fitGymUser = userServiceImplementation.findUserByFirgymid(authentication.getName());
        logger.debug("Sukcesywnie zalogowano : " + fitGymUser.getUserimie()+" "+fitGymUser.getUsernazwisko());
        model.addAttribute("nazwaUzytkownika", fitGymUser.getUsernazwisko()+" "+fitGymUser.getUserimie());
        return "/admin/adminpage";
    }

    @RequestMapping(value = "/management/managementpage")
    public String managementpage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        FitGymUser fitGymUser = userServiceImplementation.findUserByFirgymid(authentication.getName());
        logger.debug("Sukcesywnie zalogowano : " + fitGymUser.getUserimie()+" "+fitGymUser.getUsernazwisko());
        model.addAttribute("nazwaUzytkownika", fitGymUser.getUsernazwisko()+" "+fitGymUser.getUserimie());
        return "/management/managementpage";
    }

    @RequestMapping(value = "/staff/staffpage")
    public String staffpage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        FitGymUser fitGymUser = userServiceImplementation.findUserByFirgymid(authentication.getName());
        logger.debug("Sukcesywnie zalogowano : " + fitGymUser.getUserimie()+" "+fitGymUser.getUsernazwisko());
        model.addAttribute("nazwaUzytkownika", fitGymUser.getUsernazwisko()+" "+fitGymUser.getUserimie());
        return "/staff/staffpage";
    }

    @RequestMapping(value = "/instructor/instructorpage")
    public String instructorpage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        FitGymUser fitGymUser = userServiceImplementation.findUserByFirgymid(authentication.getName());
        logger.debug("Sukcesywnie zalogowano : " + fitGymUser.getUserimie()+" "+fitGymUser.getUsernazwisko());
        model.addAttribute("nazwaUzytkownika", fitGymUser.getUsernazwisko()+" "+fitGymUser.getUserimie());
        return "/instructor/instructorpage";
    }

    @RequestMapping(value = "/member/memberpage")
    public String memberpage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        FitGymUser fitGymUser = userServiceImplementation.findUserByFirgymid(authentication.getName());
        logger.debug("Sukcesywnie zalogowano : " + fitGymUser.getUserimie()+" "+fitGymUser.getUsernazwisko());
        model.addAttribute("nazwaUzytkownika", fitGymUser.getUsernazwisko()+" "+fitGymUser.getUserimie());
        return "/member/memberpage";
    }
}
