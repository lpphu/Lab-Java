package tdtu.edu.Lab09.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "`product`")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private String price;
    @Column(name = "illustration")
    private String illustration;
    @Column(name = "description")
    private String description;



    @ManyToMany
    @JoinTable(
            name = "Order_Product",
            joinColumns = @JoinColumn(name = "code_product"),
            inverseJoinColumns = @JoinColumn(name = "id_order"))
    @JsonIgnore
    Set<OrderEntity> listOrder;

}
