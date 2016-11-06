package api ;

import org.json.* ;
import org.restlet.representation.* ;
import org.restlet.ext.json.* ;
import org.restlet.resource.* ;
import org.restlet.ext.jackson.* ;

import java.io.IOException ;

public class StarbucksResource extends ServerResource {

    @Get
    public Representation get_action() throws JSONException {

        String order_id = getAttribute("order_id") ;
        Order order = StarbucksAPI.getOrder( order_id ) ;

        if ( order_id == null || order_id.equals("") ) {

            setStatus( org.restlet.data.Status.CLIENT_ERROR_NOT_FOUND ) ;
            api.Status status = new api.Status() ;
            status.status = "error" ;
            status.message = "Order not found." ;

            return new JacksonRepresentation<api.Status>(status) ;
        }
        else {
            Order existing_order = StarbucksAPI.getOrder( order_id ) ;
            if ( order_id == null || order_id.equals("")  || existing_order == null ) {
                setStatus( org.restlet.data.Status.CLIENT_ERROR_NOT_FOUND ) ;
                api.Status status = new api.Status() ;
                status.status = "error" ;
                status.message = "Order not found." ;
                return new JacksonRepresentation<api.Status>(status) ;
            }                
            else
                return new JacksonRepresentation<Order>(order) ;
        }
    }


    @Post
    public Representation post_action (Representation rep) throws IOException {

        JacksonRepresentation<Order> orderRep = new JacksonRepresentation<Order> ( rep, Order.class ) ;

        Order order = orderRep.getObject() ;
        order.status = "placed" ;
        order.message = "Order has been placed." ;
        order.links.put ("get-status", getReference()+"/order/"+order.id ) ;
        order.links.put ("put-update", getReference()+"/order/"+order.id ) ;
        order.links.put ("delete-cancel", getReference()+"/order/"+order.id ) ;        
        order.links.put ("post-pay", getReference()+"/order/"+order.id+"/pay" ) ;
        StarbucksAPI.addOrder( order.id, order ) ;
        StarbucksAPI.placeOrder( order.id ) ;

        return new JacksonRepresentation<Order>(order) ;
    }


   @Put
    public Representation put_action (Representation rep) throws IOException {

        JacksonRepresentation<Order> orderRep = new JacksonRepresentation<Order> ( rep, Order.class ) ;
        Order order = orderRep.getObject() ;

        String order_id = getAttribute("order_id") ;
        Order existing_order = StarbucksAPI.getOrder( order_id ) ;

        if ( order_id == null || order_id.equals("")  || existing_order == null ) {

            setStatus( org.restlet.data.Status.CLIENT_ERROR_NOT_FOUND ) ;
            api.Status status = new api.Status() ;
            status.status = "error" ;
            status.message = "Order not found." ;

            return new JacksonRepresentation<api.Status>(status) ;

        }                
        else if ( existing_order != null && !existing_order.status.equals("placed") ) {

            setStatus( org.restlet.data.Status.CLIENT_ERROR_PRECONDITION_FAILED ) ;
            api.Status status = new api.Status() ;
            status.status = "error" ;
            status.message = "Order Update Rejected." ;

            return new JacksonRepresentation<api.Status>(status) ;
        }
        else {

            order.id = order_id ;
            order.status = "placed" ;
            order.message = "Order has been placed." ;
            order.links.put ("get-status", getReference()+"/order/"+order.id ) ;
            order.links.put ("put-update", getReference()+"/order/"+order.id ) ;
            order.links.put ("delete-cancel", getReference()+"/order/"+order.id ) ;        
            order.links.put ("post-pay", getReference()+"/order/"+order.id+"/pay" ) ;
            StarbucksAPI.addOrder( order.id, order ) ;  

            return new JacksonRepresentation<Order>(order) ;        
        }
    }

    @Delete
    public Representation delete_action (Representation rep) throws IOException {

        String order_id = getAttribute("order_id") ;
        Order existing_order = StarbucksAPI.getOrder( order_id ) ;
        if ( order_id == null || order_id.equals("")  || existing_order == null ) {

            setStatus( org.restlet.data.Status.CLIENT_ERROR_NOT_FOUND ) ;
            api.Status status = new api.Status() ;
            status.status = "error" ;
            status.message = "Order not found." ;

            return new JacksonRepresentation<api.Status>(status) ;

        }        
        else if ( !existing_order.status.equals("placed") ) {

            setStatus( org.restlet.data.Status.CLIENT_ERROR_PRECONDITION_FAILED ) ;
            api.Status status = new api.Status() ;
            status.status = "error" ;
            status.message = "Order Cancelling Rejected." ;

            return new JacksonRepresentation<api.Status>(status) ;
        }
        else {

            StarbucksAPI.removeOrder( order_id ) ;
            return null ;    
        }

    }

}


