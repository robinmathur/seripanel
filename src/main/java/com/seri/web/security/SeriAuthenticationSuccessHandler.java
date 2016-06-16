package com.seri.web.security;

import com.seri.web.model.User;
import com.seri.web.utils.GlobalFunUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by puneet on 07/04/16.
 */
public class SeriAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    GlobalFunUtils globalFunUtils = new GlobalFunUtils();
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        User  sessUser = globalFunUtils.getLoggedInUserDetail();
        if(sessUser.getRole().equals("ROLE_STUDENT"))
            httpServletResponse.sendRedirect(globalFunUtils.getSiteUrl(httpServletRequest)+"/student/dashboard");
        else if(sessUser.getRole().equals("ROLE_PARENT"))
            httpServletResponse.sendRedirect(globalFunUtils.getSiteUrl(httpServletRequest)+"/parents/dashboard");
        else if(sessUser.getRole().equals("ROLE_TEACHER"))
            httpServletResponse.sendRedirect(globalFunUtils.getSiteUrl(httpServletRequest)+"/teacher/dashboard");
        else
            httpServletResponse.sendRedirect(globalFunUtils.getSiteUrl(httpServletRequest)+"/adduser");
    }
}
