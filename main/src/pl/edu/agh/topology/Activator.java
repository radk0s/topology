package pl.edu.agh.topology;

import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;
import pl.edu.agh.topology.api.TopologyService;

import java.util.Properties;

public class Activator extends DependencyActivatorBase {
    @Override
    public void init(BundleContext bundleContext, DependencyManager dependencyManager) throws Exception {
        Properties props = new Properties();

        dependencyManager.add(createComponent()
                .setInterface(Object.class.getName(), props)
                .setImplementation(OtherComponent.class)
                .add(createServiceDependency()
                        .setService(TopologyService.class,"(topologyType=thorus)")));
    }
}
