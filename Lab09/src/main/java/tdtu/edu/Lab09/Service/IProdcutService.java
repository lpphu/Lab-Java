package tdtu.edu.Lab09.Service;

import tdtu.edu.Lab09.Entity.ProductEntity;

import java.util.List;

public interface IProdcutService {

    public ProductEntity getOne(Long id);
    public List<ProductEntity> getAll();
    public  ProductEntity save(ProductEntity product);

    public ProductEntity delete(Long id);

}
