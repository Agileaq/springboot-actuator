package personal.arc.springboot.actuator.customize.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.AbstractEndpoint;
import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Arc on 27/7/2016.
 */
@Component
public class ListSpringEndPoints extends AbstractEndpoint<List<Endpoint>> {
    private List<Endpoint> endpoints;

    @Autowired
    public ListSpringEndPoints(List<Endpoint> endpoints) {
        super("listSpringEndpoints");
        this.endpoints = endpoints;
    }

    @Override
    public List<Endpoint> invoke() {
        return this.endpoints;
    }
}
