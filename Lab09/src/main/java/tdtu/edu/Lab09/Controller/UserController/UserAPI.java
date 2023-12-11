package tdtu.edu.Lab09.Controller.UserController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tdtu.edu.Lab09.Entity.OrderEntity;
import tdtu.edu.Lab09.Service.IOrderService;
import java.util.List;

@RestController
public class UserAPI {

    @Autowired
    private IOrderService orderService;

    // ORDER
    @GetMapping("api/orders")
    public List<OrderEntity> getAllOrder(){
        return  orderService.getAll();
    }

    @PostMapping("api/orders")
    public OrderEntity addNewOrder(@RequestBody OrderEntity model){
        return orderService.save(
                model
        );
    }


    @GetMapping("api/orders/{id}")
    public OrderEntity getOne(@PathVariable("id") long id){
        return  orderService.getOne(id);
    }

    @PutMapping("api/orders/{id}")
    public OrderEntity putOrder(@RequestBody OrderEntity model, @PathVariable("id") long id){
        model.setId(id);
        return orderService.save(model);
    }

    @DeleteMapping("api/orders/{id}")
    public OrderEntity deleteOrder(@PathVariable("id") long id){
        return orderService.delete(id);
    }

}
