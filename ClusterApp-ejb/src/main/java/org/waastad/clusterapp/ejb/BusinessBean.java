/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.clusterapp.ejb;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;

/**
 *
 * @author Helge Waastad <helge.waastad@waastad.org>
 */
@Stateless
@LocalBean
public class BusinessBean {

    public String sayHello(String name) {
        return "Hello " + name;
    }
}
