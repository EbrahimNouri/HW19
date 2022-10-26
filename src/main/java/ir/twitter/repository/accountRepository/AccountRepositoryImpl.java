package ir.twitter.repository.accountRepository;

import ir.twitter.entity.Account;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class AccountRepositoryImpl implements AccountRepository {
    public void save(Session session, Account account) {
        session.save(account);
    }

    public Optional<Account> find(Session session, Account account) {
        return Optional.empty();
    }

    public Optional<List<Account>> findAll(Session session, Account account) {
        return Optional.ofNullable(session.createQuery("from Account ", Account.class).getResultList());
    }

    public Optional<Account> find(Session session, Long id) {
        return Optional.ofNullable(session.find(Account.class, id));
    }

    @Override
    public Optional<List<Account>> findAll(Session session, Long aLong) {
        return Optional.empty();
    }

    public List findAll(Session session) {
        return session.createQuery("from Account a, Account.class").stream().toList();
    }

    @Override
    public void update(Session session, Account Account) {

        String hql = " update Account a set a.email =:newEmail ," +
                " a.userName =:newUser , a.password =:newPassword  where a.id =:id ";
        session.createQuery(hql).setParameter("newUser", Account.getUserName())
                .setParameter("newPassword", Account.getPassword())
                .setParameter("newEmail", Account.getEmail()).setParameter("id", Account.getId())
                .executeUpdate();
    }
    public void delete(Session session, Account account) {
        session.delete(account);
    }

    @Override
    public void delete(Session session, Long id) {

        String hql = "delete from Account a where a.id =:id";

        session.createQuery(hql).setParameter("id", id).executeUpdate();
    }

    @Override
    public boolean isExist(Session session, String username, String password) {
        return session.createQuery("from Account a where a.userName = :un and a.password = :pw", Account.class)
                .setParameter("un", username).setParameter("pw", password).getSingleResult().getUserName() != null;
    }

    @Override
    public Optional<Account> findById(Session session, Long id) {
        return Optional.ofNullable(session.find(Account.class, id));
    }
}
