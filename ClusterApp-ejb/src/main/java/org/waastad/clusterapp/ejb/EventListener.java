/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.clusterapp.ejb;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import org.waastad.qualifier.DbLog;

/**
 *
 * @author Helge Waastad <helge.waastad@datametrix.no>
 */
@Stateless
@Asynchronous
public class EventListener {
    
    public void processSyslog(@Observes @DbLog String message) {
        System.out.println("We Got Message: " + message);
    }
    
}
