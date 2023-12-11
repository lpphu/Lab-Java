package tdtu.edu.Lab09.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.Lab09.Entity.ProductEntity;
import tdtu.edu.Lab09.Repository.ProductRepository;
import tdtu.edu.Lab09.Service.IProdcutService;

import java.util.List;
import java.util.Optional;

@Service
public class ProdcutService implements IProdcutService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public ProductEntity getOne(Long id) {
        Optional<ProductEntity> list = productRepository.findById(id);
        return list.get();
    }

    @Override
    public List<ProductEntity> getAll() {

        return productRepository.findAll();
    }

    @Override
    public ProductEntity save(ProductEntity product) {
        productRepository.save(product);
        return product;
    }

    @Override
    public ProductEntity delete(Long id) {
        ProductEntity pr = getOne(id);
        productRepository.deleteById(id);
        return pr;
    }
}
