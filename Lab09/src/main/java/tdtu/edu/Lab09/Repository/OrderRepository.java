package tdtu.edu.Lab09.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tdtu.edu.Lab09.Entity.AccountEntity;
import tdtu.edu.Lab09.Entity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Long> {
}
