package tdtu.edu.Lab09.Entity;



import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
@Data
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "role_name")
    private String roleName;

    @ManyToMany(mappedBy = "likeRoles")
    @JsonManagedReference
    private Set<AccountEntity> likesUser;
}
