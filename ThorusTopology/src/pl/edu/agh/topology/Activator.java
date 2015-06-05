package pl.edu.agh.topology;

import java.util.Properties;
import pl.edu.agh.topology.api.TopologyService;
import org.apache.felix.dm.Component;
import org.apache.felix.dm.DependencyActivatorBase;
import org.apache.felix.dm.DependencyManager;
import org.osgi.framework.BundleContext;

/**
 * Created by Archie on 20.08.2014.
 */
public class Activator extends DependencyActivatorBase {
    @Override
    public void init(BundleContext bundleContext, DependencyManager dependencyManager) throws Exception {
        Properties properties = new Properties();
        properties.put("topologyType", "thorus");


        Component component = createComponent().setInterface(TopologyService.class.getName(), properties)
                .setImplementation(ThorusTopology.class);
        dependencyManager.add(component);
        bundleContext.registerService(ThorusTopology.class.getName(), component.getService(), properties);

    }


}
