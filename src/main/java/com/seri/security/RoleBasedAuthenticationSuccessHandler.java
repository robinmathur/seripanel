package com.seri.security;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.seri.web.model.User;

public class RoleBasedAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private Map<String, String> roleUrlMap;
 
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
 
        if (authentication.getPrincipal() instanceof UserDetails) {
            User userDetails = (User) authentication.getPrincipal();
            String role = userDetails.getDefaultRole() != null ?  userDetails.getDefaultRole().getRoleName().toString() : "DEFAULT";
            String redirectTo = request.getContextPath() + (roleUrlMap.get(role) != null ? roleUrlMap.get(role) : roleUrlMap.get("DEFAULT"));
            response.sendRedirect(redirectTo);
        }
    }
 
    public void setRoleUrlMap(Map<String, String> roleUrlMap) {
        this.roleUrlMap = roleUrlMap;
    }
}