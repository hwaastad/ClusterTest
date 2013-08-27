/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.waastad.clusterapp.producers;

import java.io.Serializable;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.waastad.clusterapp.ejb.BusinessBean;
import org.waastad.clusterapp.ejb.BusinessBeanRemote;
import org.waastad.clusterapp.qualifier.BusinessQualifier;

/**
 *
 * @author Helge Waastad <helge.waastad@datametrix.no>
 */
//@SessionScoped
public class EJBProducer {

    private static final long serialVersionUID = 4687933969500695707L;
    @EJB
    @BusinessQualifier
    BusinessBeanRemote businessBean;

    @Produces
    @BusinessQualifier
    public BusinessBeanRemote getBusinessBean() {
        System.out.println("Producing Business EJB.....");
        try {
            final Context context = new InitialContext(new Properties(){{
                    put(Context.INITIAL_CONTEXT_FACTORY, "org.apache.openejb.client.RemoteInitialContextFactory");
                    put(Context.PROVIDER_URL, "http://localhost:8081/tomee/ejb");
                    put("java.naming.security.principal", "administrator@datametrix.no");
                    put("java.naming.security.credentials", "racing101");
                    put("openejb.authentication.realmName", "SmartGuestRealm");
                    put("openejb.ejbd.authenticate-with-request", "true");
                }});
            return (BusinessBeanRemote) context.lookup("BusinessBeanRemote");
            //return businessBean;
        } catch (NamingException ex) {
            Logger.getLogger(EJBProducer.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
//    @Produces
//    @BusinessQualifier
//    public BusinessBean produceBusinessBean() {
//        System.out.println("Producing BusinessBean");
//        return businessBean;
//    }
//    @Produces
//    @BusinessQualifier
//    @EJB
//    BusinessBean businessBean;
}
