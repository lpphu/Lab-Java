package tdtu.edu.Lab09.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tdtu.edu.Lab09.Entity.AccountEntity;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity, String> {
    public List<AccountEntity> findByEmailAndPass(String email, String pass);
    public List<AccountEntity> findByEmail(String email);
}
