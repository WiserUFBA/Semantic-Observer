package br.dcc.ufba.wiser.smartufba.observer;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

    static BundleContext bc;

    @Override
    public void start(BundleContext bc) throws Exception {
        System.out.println("Starting the bundle Semantic Observer for IoT");
        Activator.bc = bc;
    }

    @Override
     public void stop(BundleContext bc) throws Exception {
        
    	System.out.println("Stopping the bundle Semantic Observer for IoT");
    	Activator.bc = null;
    }
}