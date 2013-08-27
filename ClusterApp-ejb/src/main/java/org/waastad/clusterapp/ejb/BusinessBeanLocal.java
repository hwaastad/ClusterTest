/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.clusterapp.ejb;

import javax.ejb.Local;

/**
 *
 * @author Helge Waastad <helge.waastad@datametrix.no>
 */
@Local
public interface BusinessBeanLocal {

    public String sayHello(String name);

    public void methodB();
}
