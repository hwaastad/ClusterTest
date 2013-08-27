/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.clusterapp.presentation;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
public class SessionController implements Serializable {

    private static final long serialVersionUID = 457281355940188534L;
    private String name;
    
    private String userName;
    private boolean loggedIn = false;
    private boolean superAdmin;
    private boolean customerAdmin;

    /**
     * Creates a new instance of SessionController
     */
    
    @PostConstruct
    public void init(){
        System.out.println("INIT SessionController");
    }
    
    @PreDestroy
    public void destroy(){
        System.out.println("Destroy SessionController");
    }
    
    public SessionController() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public boolean isSuperAdmin() {
        return superAdmin;
    }

    public void setSuperAdmin(boolean superAdmin) {
        this.superAdmin = superAdmin;
    }

    public boolean isCustomerAdmin() {
        return customerAdmin;
    }

    public void setCustomerAdmin(boolean customerAdmin) {
        this.customerAdmin = customerAdmin;
    }
}
