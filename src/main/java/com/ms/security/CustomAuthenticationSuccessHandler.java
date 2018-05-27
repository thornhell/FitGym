package com.ms.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    Logger logger = LogManager.getLogger(SecurityConfig.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws
            IOException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        boolean isAdmin = false;
        boolean isManager = false;
        boolean isStaff = false;
        boolean isInstructor = false;
        boolean isMember = false;

        Collection<? extends GrantedAuthority> auths = auth.getAuthorities();
        for (GrantedAuthority authorities : auths) {
            if (authorities.getAuthority().equals("ROLE_ADMIN")) {
                isAdmin = true;
            } else if (authorities.getAuthority().equals("ROLE_MANAGEMENT")) {
                isManager = true;
            } else if (authorities.getAuthority().equals("ROLE_STAFF")) {
                isStaff = true;
            } else if (authorities.getAuthority().equals("ROLE_INSTRUCTOR")) {
                isInstructor = true;
            } else {
                //if (grantedAuthorityIterator.next().getAuthority().equalsIgnoreCase("ROLE_USER")) {
                isMember = true;
            }
        }
        if (isAdmin) {
            logger.debug("Zalogowano użytkownika z rolą ADMIN");
            // logger.debug("\n\n" + grantedAuthorityIterator + "\n\n\n");
            response.sendRedirect("/admin/adminpage");
        } else if (isManager) {
            logger.debug("Zalogowano użytkownika z rolą MANAGEMENT");
            response.sendRedirect("/management/managementpage");
        } else if (isStaff) {
            logger.debug("Zalogowano użytkownika z rolą STAFF");
            response.sendRedirect("/staff/staffpage");
        } else if (isInstructor) {
            logger.debug("Zalogowano użytkownika z rolą INSTRUCTOR");
            response.sendRedirect("/instructor/instructorpage");
        } else {
            logger.debug("Zalogowano użytkownika z rolą MEMBER");
            response.sendRedirect("/member/memberpage/");
        }
    }
}
