package tdtu.edu.Lab09.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.Lab09.Entity.OrderEntity;
import tdtu.edu.Lab09.Entity.ProductEntity;
import tdtu.edu.Lab09.Repository.OrderRepository;
import tdtu.edu.Lab09.Service.IOrderService;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public OrderEntity getOne(Long id) {

        Optional<OrderEntity> list = orderRepository.findById(id);
        return list.get();
    }

    @Override
    public List<OrderEntity> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public OrderEntity save(OrderEntity order) {
        orderRepository.save(order);
        return order;
    }

    @Override
    public OrderEntity delete(Long id) {

        OrderEntity pr = getOne(id);
        orderRepository.deleteById(id);
        return pr;
    }
}
