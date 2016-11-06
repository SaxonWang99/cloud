package api ;

import org.json.* ;
import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.resource.* ;
import org.restlet.ext.jackson.* ;

import java.io.IOException ;

public class PaymentResource extends ServerResource {

    @Post
    public Representation post_action (Representation rep) throws IOException {

        String order_id = getAttribute("order_id") ;
        Order order = StarbucksAPI.getOrder( order_id ) ;
        if ( order != null && !order.status.equals("placed") ) {
            setStatus( org.restlet.data.Status.CLIENT_ERROR_PRECONDITION_FAILED ) ;
            api.Status status = new api.Status() ;
            status.status = "error" ;
            status.message = "Order Payment Rejected" ;
            return new JacksonRepresentation<api.Status>(status) ;
        }
        else {
            order.id = order_id ;
            order.status = "paid" ;
            order.message = "Payment Accepted." ;
            order.links.clear() ;
            order.links.put ("get-status", getReference()+"/order/"+order.id ) ;
            StarbucksAPI.addOrder( order.id, order ) ; 
            return new JacksonRepresentation<Order>(order) ;           
        }

    }


}


