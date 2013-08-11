/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.clusterapp.presentation;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import org.os890.cdi.ext.scope.api.scope.conversation.ViewAccessScoped;
import org.waastad.clusterapp.qualifier.Current;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
@Named
@ViewAccessScoped
public class ViewBean implements Serializable {
    
    @Inject @Current SessionController sessionController;

    private static final long serialVersionUID = -3537022616965685764L;
    private String viewBeanName;
    
    @PostConstruct
    public void init(){
        System.out.println("ViewBean postconstruct....");
    }
    
    public void test(ActionEvent event){
        System.out.println("ViewBean ActionEvent....setting viewBeanName: " + sessionController.getName());
        setViewBeanName(sessionController.getName());
    }

    public String getViewBeanName() {
        return viewBeanName;
    }

    public void setViewBeanName(String viewBeanName) {
        this.viewBeanName = viewBeanName;
    }
}
