package com.ms.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ErrorController {

    Logger logger = LogManager.getLogger(IndexController.class);

    @RequestMapping(value = "/error403")
    public String error403(HttpServletRequest request, HttpServletResponse response) {
        logger.debug("Błąd dostępu 403");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            logger.debug("Auth: " + authentication);
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "/error/403";
    }
}
