package tdtu.edu.Lab09.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "`order`")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "totalPrice")
    private int totalPrice;

    @ManyToOne
    @JoinColumn(name = "email")
    @JsonIgnore
    private AccountEntity account;

    @ManyToMany(mappedBy = "listOrder")
    @JsonIgnore
    Set<ProductEntity> listProduct;
}
