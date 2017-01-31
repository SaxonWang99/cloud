
package hello;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import com.oreilly.springdata.jpa.core.Customer;

public interface OrderRepository extends PagingAndSortingRepository<Order, Long> {

	List<Order> findByCustomer(Customer customer);
}
