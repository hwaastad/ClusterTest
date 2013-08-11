/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.clusterapp.presentation;

import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import org.apache.myfaces.extensions.cdi.core.api.scope.conversation.ViewAccessScoped;
import org.omnifaces.util.Faces;
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
