/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.clusterapp.presentation;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.event.Event;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;
import org.waastad.clusterapp.ejb.BusinessBean;
import org.waastad.clusterapp.ejb.BusinessBeanRemote;
import org.waastad.clusterapp.qualifier.BusinessQualifier;
import org.waastad.clusterapp.qualifier.Current;
import org.waastad.qualifier.DbLog;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
@Named
@ViewAccessScoped
public class ViewBean implements Serializable {

    @Inject
    @Current
    SessionController sessionController;
    @Inject
    @DbLog
    Event<String> log;
    @Inject
    @BusinessQualifier
    private BusinessBeanRemote businessBean;
    private static final long serialVersionUID = -3537022616965685764L;
    private String viewBeanName;

    @PostConstruct
    public void init() {
        System.out.println("ViewBean postconstruct....");
    }

    public void test(ActionEvent event) {
        System.out.println("ViewBean ActionEvent....setting viewBeanName: " + sessionController.getName());
        log.fire("ViewBean ActionEvent....setting viewBeanName: " + sessionController.getName());
        setViewBeanName(sessionController.getName());
        try {
            System.out.println("Return from BusinessBean: " + businessBean.sayHello(viewBeanName));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getViewBeanName() {
        return viewBeanName;
    }

    public void setViewBeanName(String viewBeanName) {
        this.viewBeanName = viewBeanName;
    }
}
