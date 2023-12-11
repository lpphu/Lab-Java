package tdtu.edu.Lab09.Service;

import tdtu.edu.Lab09.Entity.AccountEntity;

public interface IAccountService {
    public AccountEntity getOne(String email, String pass);
    public  AccountEntity saveOne (AccountEntity account);
}
