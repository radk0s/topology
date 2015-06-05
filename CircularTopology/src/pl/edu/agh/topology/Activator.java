package pl.edu.agh.topology;

import org.apache.felix.dm.Component;
import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;
import pl.edu.agh.topology.api.TopologyService;

import java.util.Properties;

/**
 * Created by Archie on 20.08.2014.
 */
public class Activator extends DependencyActivatorBase {
    @Override
    public void init(BundleContext bundleContext, DependencyManager dependencyManager) throws Exception {
        Properties properties = new Properties();
        properties.put("topologyType", "circular");


        Component component = createComponent().setInterface(TopologyService.class.getName(), properties)
                .setImplementation(CircularTopology.class);
        dependencyManager.add(component);
        bundleContext.registerService(CircularTopology.class.getName(), component.getService(), properties);

    }


}
