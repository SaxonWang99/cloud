package api ;

import java.util.concurrent.BlockingQueue ;
import java.util.concurrent.LinkedBlockingQueue ;
import java.util.concurrent.ConcurrentHashMap ;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;

public class StarbucksAPI {

    private static BlockingQueue<String> orderQueue = new LinkedBlockingQueue<String>();
    private static ConcurrentHashMap<String,Order> orders = new ConcurrentHashMap<String,Order>();

    public static void placeOrder(String order_id) {
        try { StarbucksAPI.orderQueue.put(order_id) ; } catch (Exception e) {}
        System.out.println( "Order Placed: " + order_id ) ;
    }

    public static void startOrderProcessor() {
        StarbucksOrders batchJob = new StarbucksOrders( orderQueue ) ;
        new Thread(batchJob).start();
    }

    public static void addOrder(String key, Order order) {
        StarbucksAPI.orders.put( key, order ) ;
    }

    public static Order getOrder(String key) {
        return StarbucksAPI.orders.get( key ) ;
    }

   public static void removeOrder(String key) {
        StarbucksAPI.orders.remove( key ) ;
        StarbucksAPI.orderQueue.remove( key ) ;
    }

}

/*

POST    /order
        Create a new order, and upon success, 
        receive a Location header specifying the new order’s URI.

GET     /order/{orderId}
        Request the current state of the order specified by the URI.

PUT     /order/{orderId}
        Update an order at the given URI with new information, 
        providing the full representation.

DELETE  /order/{orderId}
        Logically remove the order identified by the given URI.

*/