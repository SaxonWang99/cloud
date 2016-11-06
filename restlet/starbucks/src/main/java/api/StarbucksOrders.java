
package api ;

import java.util.concurrent.BlockingQueue;

public class StarbucksOrders implements Runnable {

	protected BlockingQueue<String> blockingQueue ;

	public StarbucksOrders(BlockingQueue<String> queue) {
		this.blockingQueue = queue;
	}

	@Override
	public void run() {
		while (true) {
			try {
				try { Thread.sleep(5000); } catch ( Exception e ) {}  
				String order_id = blockingQueue.take();
				Order order = StarbucksAPI.getOrder( order_id ) ;
        		if ( order != null && order.status.equals("paid") ) {
					System.out.println(Thread.currentThread().getName() + " Processed Order: " + order_id );
					order.status = "preparing" ;
					order.message = "Order preparations in progress." ;
					try { Thread.sleep(20000); } catch ( Exception e ) {}  
					order.status = "served" ;
					order.message = "Order served, wating for Customer pickup." ;					
					try { Thread.sleep(10000); } catch ( Exception e ) {}  
					order.status = "collected" ;
					order.message = "Order retrived by Customer." ;					
					//StarbucksAPI.addOrder( order.id, order ) ;
				}
				else {
					blockingQueue.put( order_id ) ;
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}