package com.ms.controller;

import com.ms.model.FitGymUser;
import com.ms.repository.UserRepository;
import com.ms.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    private Boolean adminareaPanel = false;
    private Boolean adminareaUsers = false;
    private Boolean adminareaUsersAdd = false;
    private Boolean adminareaDb = false;

    Logger logger = LogManager.getLogger(IndexController.class);


    @RequestMapping(value = "/admin/adminpage")
    public String adminpage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        adminareaPanel = true;

        RuntimeMXBean runtimeMXBean = ManagementFactory.getRuntimeMXBean();

        long uptime = runtimeMXBean.getUptime();

        Date date = new Date(uptime);
        Date actualdate = new Date();
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        formatter.setTimeZone(TimeZone.getTimeZone("CEST"));

        String uptimedate = formatter.format(date);
        String nowdate = formatter.format(actualdate);

        model.addAttribute("nazwaUzytkownika", name);
        model.addAttribute("uptime", uptime);
        model.addAttribute("uptimedate", uptimedate);
        model.addAttribute("nowdate", nowdate);
        model.addAttribute("adminareaPanel", adminareaPanel);
        model.addAttribute("liczbaUzytkownikowFitgym", userService.allUserCount());

        logger.debug("Sukcesywnie zalogowano : " + name);
        return "/admin/adminpage";
    }

    @RequestMapping(value = "/admin/adminpage/userlist")
    public String adminpageUserlist(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        adminareaUsers = true;

        model.addAttribute("nazwaUzytkownika", name);
        model.addAttribute("adminareaUsers", adminareaUsers);
        model.addAttribute("osoba", userService.findByFitgymid(name));
        model.addAttribute("liczbaUzytkownikowFitgym", userService.allUserCount());
        model.addAttribute("liczbaAktywnychUzytkownikowFitgym", userService.allActiveUserCount());
        model.addAttribute("wszyscy", userService.allUsers());
        logger.debug("Otworzono /admin/adminpage/userlist");
        return "/admin/adminpage/userlist";
    }

    @RequestMapping(value = "/admin/adminpage/useradd")
    public String adminpageUseradd(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        adminareaUsersAdd = true;
        model.addAttribute("nazwaUzytkownika", name);
        model.addAttribute("adminareaUsersAdd", adminareaUsersAdd);
        model.addAttribute("fitgymuser", new FitGymUser());
        System.out.println("dziala");
        logger.debug("Otworzono /admin/adminpage/useradd");
        return "/admin/adminpage/useradd";
    }

    @RequestMapping(value = "/admin/adminpage/useraddaction", method = RequestMethod.POST)
    public String useraddaction(@ModelAttribute FitGymUser fitgymuser, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "/error/404";
        }
         userService.persist(fitgymuser);
        System.out.println("++++++++++++++++++++++++++++++++++++++++");
        return "/admin/adminpage";
    }

    @RequestMapping(value = "/admin/adminpage/dbadmin")
    public String adminpageDbadmin(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();


        adminareaDb = true;
        model.addAttribute("nazwaUzytkownika", name);
        model.addAttribute("adminareaDb", adminareaDb);


        logger.debug("Otworzono /admin/adminpage/dbadmin");
        return "/admin/adminpage/dbadmin";
    }


    @RequestMapping(value = "/management/managementpage")
    public String managementpage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        model.addAttribute("nazwaUzytkownika", name);

        logger.debug("Sukcesywnie zalogowano menedzera: " + name);
        return "/management/managementpage";
    }

    @RequestMapping(value = "/staff/staffpage")
    public String staffpage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        model.addAttribute("nazwaUzytkownika", name);

        logger.debug("Sukcesywnie zalogowano pracownika klubu: " + name);
        return "/staff/staffpage";
    }

    @RequestMapping(value = "/instructor/instructorpage")
    public String instructorpage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        model.addAttribute("nazwaUzytkownika", name);

        logger.debug("Sukcesywnie zalogowano instruktora: " + name);
        return "/instructor/instructorpage";
    }

    @RequestMapping(value = "/member/memberpage")
    public String memberpage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        model.addAttribute("nazwaUzytkownika", name);

        logger.debug("Sukcesywnie zalogowano użytkownika: " + name);
        return "/member/memberpage";
    }
}
