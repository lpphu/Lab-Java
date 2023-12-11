package tdtu.edu.Lab09.Service;

import tdtu.edu.Lab09.Entity.OrderEntity;
import tdtu.edu.Lab09.Entity.ProductEntity;

import java.util.List;

public interface IOrderService {


    public OrderEntity getOne(Long id);
    public List<OrderEntity> getAll();
    public  OrderEntity save(OrderEntity order);

    public OrderEntity delete(Long id);

}
