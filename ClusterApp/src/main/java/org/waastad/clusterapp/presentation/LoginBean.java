/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.clusterapp.presentation;

import java.io.IOException;
import java.security.Principal;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.event.Event;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import org.omnifaces.util.Faces;
import org.waastad.clusterapp.qualifier.Current;
import org.waastad.qualifier.DbLog;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
@Named
@RequestScoped
public class LoginBean {

    private String cookieUuid;
    private String username;
    private String password;
    private boolean rememberme;
    @Inject
    @Current
    private SessionController sessionController;
    @Inject
    @DbLog Event<String> log;

    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }

    @PostConstruct
    public void init() {
        System.out.println("LoginBean: POSTCONSTRUCT");
        checkCookie();
    }

    public void login() {
        try {
            HttpServletRequest request = Faces.getRequest();
            if (request.getUserPrincipal() == null) {
                System.out.println("Principal is null");
            } else {
                Principal principal = request.getUserPrincipal();
            }
            sessionController.setName(username);
            log.fire("LOGIN: The User is: " + username);
            Faces.redirect(Faces.getRequestBaseURL() + "/secure/home.xhtml", "faces-redirect=true");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void logout() {
        log.fire("LOGOUT: The User is: " + sessionController.getUserName());
        Faces.invalidateSession();
        log.fire("LOGOUT-After: The User is: " + sessionController.getUserName());
        try {
            Faces.redirect(Faces.getRequestBaseURL() + "/", "faces-redirect=true");
        } catch (IOException ex) {
            Logger.getLogger(LoginBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getCookieUuid() {
        return cookieUuid;
    }

    public void setCookieUuid(String cookieUuid) {
        this.cookieUuid = cookieUuid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isRememberme() {
        return rememberme;
    }

    public void setRememberme(boolean rememberme) {
        this.rememberme = rememberme;
    }

    private void checkCookie() {
        Object user = Faces.getSessionAttribute("user");
    }
}
