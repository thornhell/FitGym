package com.ms.controller;

import com.ms.dao.UserDAO;
import com.ms.model.FitGymUser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

@Controller
public class UserController {

    @Autowired
    private SessionFactory sessionFactory;

//    @Autowired
//    private UserDAO userDAO;

    Logger logger = LogManager.getLogger(IndexController.class);


    @Transactional
    @RequestMapping(value = "/admin/adminpage")
    public String adminpage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
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

        logger.debug("Sukcesywnie zalogowano : " + name);
        return "/admin/adminpage";
    }

    @RequestMapping(value = "/management/managementpage")
    public String managementpage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        logger.debug("Sukcesywnie zalogowano menedzera: " + name);
        return "/management/managementpage";
    }


    @RequestMapping(value = "/staff/staffpage")
    public String staffpage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        logger.debug("Sukcesywnie zalogowano pracownika klubu: " + name);
        return "/staff/staffpage";
    }

    @RequestMapping(value = "/instructor/instructorpage")
    public String instructorpage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        logger.debug("Sukcesywnie zalogowano instruktora: " + name);
        return "/instructor/instructorpage";
    }

    @RequestMapping(value = "/member/memberpage")
    public String memberpage(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        logger.debug("Sukcesywnie zalogowano użytkownika: " + name);
        return "/member/memberpage";
    }
}
