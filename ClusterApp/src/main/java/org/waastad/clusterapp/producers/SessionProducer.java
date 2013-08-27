/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.clusterapp.producers;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.New;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import org.waastad.clusterapp.presentation.SessionController;
import org.waastad.clusterapp.qualifier.Current;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
public class SessionProducer {

    @Produces
    @SessionScoped
    @Named("sessionController")
    @Current
    SessionController getSessionController(@New SessionController sessionController) {
        System.out.println("Producing sessionController");
        return sessionController;
    }
    
//    @Produces
//    @Named("loginBean")
//    @RequestScoped
//    public LoginBean getLoginBean(@New LoginBean loginBean) {
//        System.out.println("Producing loginBean");
//        return loginBean;
//    }
}
