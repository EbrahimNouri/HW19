package ir.twitter.repository.accountRepository;

import ir.twitter.repository.BaseRepository;
import ir.twitter.entity.Account;
import org.hibernate.Session;

import java.util.Optional;

public interface AccountRepository extends BaseRepository<Account, Long> {
    void delete(Session session, Long id);
    boolean isExist(Session session, String username, String password);
    Optional<Account> findById(Session session, Long id);
    Optional<Account> findByUsername(Session session, String username);

}
