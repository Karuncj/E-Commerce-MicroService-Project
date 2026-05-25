package  com.order.Order_service.Repo;

import com.order.Order_service.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}