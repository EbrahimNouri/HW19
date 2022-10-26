package ir.twitter.service.accountService;

import ir.twitter.entity.Account;

import java.util.Optional;

public interface AccountService {

    void addAccount(Account account);
    void changeUsername(Long id , String username);
    void changePassword(Long id , String password);
    void changeEmail(Long id , String email);
    void updateAll(Account account);
    void removeAccount(Account account);
    Optional<Account> showAccount(Long id);
    boolean checkAccount(String username, String password);

    Optional<Account> findById(Long id);


}
