/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.clusterapp.ejb;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>I
 */
@Stateless
@LocalBean
public class BusinessBean implements BusinessBeanLocal, BusinessBeanRemote {
    
    @PostConstruct
    public void init(){
        System.out.println("INIT BusinessBean");
    }
    
    @PreDestroy
    public void destroy(){
        System.out.println("Destroy BusinessBean");
    } 

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    @Override
    public String sayHello(String name) {
        methodB();
        return "Hello " + name;
    }

    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    @Override
    public void methodB() {
        System.out.println("MethodB");
    }
}
