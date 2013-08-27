/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.clusterapp.ejb;

import javax.ejb.Remote;

/**
 *
 * @author Helge Waastad <helge.waastad@datametrix.no>
 */
@Remote
public interface BusinessBeanRemote {

    public String sayHello(String name);

    public void methodB();
}
