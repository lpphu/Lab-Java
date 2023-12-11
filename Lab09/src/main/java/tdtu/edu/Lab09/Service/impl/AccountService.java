package tdtu.edu.Lab09.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tdtu.edu.Lab09.Entity.AccountEntity;
import tdtu.edu.Lab09.Repository.AccountRepository;
import tdtu.edu.Lab09.Service.IAccountService;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Override
    public AccountEntity getOne(String email, String pass) {
        return accountRepository.findByEmailAndPass(email,pass).get(0);

    }

    @Override
    public AccountEntity saveOne(AccountEntity account) {
        return accountRepository.save(account);
    }
}
