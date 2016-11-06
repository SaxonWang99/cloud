package api ;

import org.restlet.*;
import org.restlet.data.Protocol;
import org.restlet.routing.Router;

public class StarbucksServer extends Application {

    public static void main(String[] args) throws Exception {
        Component server = new Component() ;
        server.getServers().add(Protocol.HTTP, 9090) ;
        server.getDefaultHost().attach(new StarbucksServer()) ;
        server.start() ;
        StarbucksAPI.startOrderProcessor() ;
    }

    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext()) ;
        router.attach("/v1/starbucks/order/{order_id}", StarbucksResource.class);        
        router.attach("/v1/starbucks/order/{order_id}/pay", PaymentResource.class);        
        router.attach("/v1/starbucks", StarbucksResource.class);        
        return router;
    }


}

