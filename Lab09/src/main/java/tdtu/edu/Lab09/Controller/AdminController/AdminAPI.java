package tdtu.edu.Lab09.Controller.AdminController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tdtu.edu.Lab09.Entity.OrderEntity;
import tdtu.edu.Lab09.Entity.ProductEntity;
import tdtu.edu.Lab09.Service.IProdcutService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AdminAPI {

    @Autowired
    private IProdcutService prodcutService;

    // products
    @PostMapping("api/products")
    public ProductEntity addNew(@RequestBody ProductEntity model){
        prodcutService.save(model);
        return  model;
    }

    @PutMapping("api/products/{id}")
    public ProductEntity putNew(@RequestBody ProductEntity model, @PathVariable("id") long id){
        model.setId(id);
        prodcutService.save(model);
        return  model;
    }

    @PatchMapping("api/products/{id}")
    public ProductEntity patchNew(@RequestBody ProductEntity model, @PathVariable("id") long id){
        model.setId(id);
        prodcutService.save(model);
        return  model;
    }

    @DeleteMapping("api/products/{id}")
    public ProductEntity deleteNew(@PathVariable("id") long id){
        ProductEntity pr = prodcutService.getOne(id);
        prodcutService.delete(id);
        return  pr;
    }





}
