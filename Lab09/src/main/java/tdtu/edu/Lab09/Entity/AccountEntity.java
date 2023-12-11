package tdtu.edu.Lab09.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "`account`")
public class AccountEntity {

    @Id
    @Column(name = "email")
    private String email;
    @Column(name = "pass")
    private String pass;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;

    @Column(name = "role")
    private String role;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))

    private Set<RoleEntity> likeRoles = new HashSet<>();

}
