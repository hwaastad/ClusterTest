/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.clusterapp.ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
@Stateless
@LocalBean
public class BusinessBean {

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public String sayHello(String name) {
        methodB();
        return "Hello " + name;
    }
    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void methodB(){
        System.out.println("MethodB");
    }
}
