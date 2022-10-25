package ir.twitter.service.accountService;

import ir.twitter.entity.Account;

public interface AccountService {

    void addAccount(Account account);
    void updateAccount(Account account);
    void removeAccount(Account account);
    Account showAccount(Long id);


}
