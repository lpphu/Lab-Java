package tdtu.edu.Lab09.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tdtu.edu.Lab09.Entity.AccountEntity;
import tdtu.edu.Lab09.Entity.ProductEntity;
import tdtu.edu.Lab09.Service.IAccountService;
import tdtu.edu.Lab09.Service.IProdcutService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class MainControllerAPI {

    @Autowired
    private IAccountService accountService;

    @Autowired
    private IProdcutService prodcutService;

        @PostMapping("api/account/register")
        public AccountEntity register(@RequestBody AccountEntity model){

            return accountService.saveOne(model);
        }

    @PostMapping("api/account/login")
    public AccountEntity login(@RequestBody AccountEntity model){
            String email =  model.getEmail();
            String pass = model.getPass();

            return accountService.getOne(email, pass);
    }


    @GetMapping("api/products")
    public List<ProductEntity> getAllProduct(){
        return prodcutService.getAll();
    }


    @GetMapping("api/products/{code}")
    public ProductEntity GetOne(@PathVariable("id") long id){
        return prodcutService.getOne(id);
    }
}
