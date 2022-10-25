package ir.twitter.repository.accountRepository;

import ir.twitter.entity.Account;
import org.hibernate.Session;

import java.util.List;
import java.util.Optional;

public class AccountRepositoryImpl implements AccountRepository {
    public void save(Session session, Account account) {
        session.save(account);
    }

    @Override
    public Optional<Account> find(Session session, Account account) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Account>> findAll(Session session, Account account) {
        return Optional.ofNullable(session.createQuery("from Account ", Account.class).getResultList());
    }

    public Optional<Account> find(Session session, Long id) {
        return Optional.ofNullable(session.find(Account.class, id));
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

    @Override
    public void delete(Session session, Account account) {
        String hql = "delete from Account a where a.id =:id";

        session.createQuery(hql).setParameter("id", account.getId()).executeUpdate();
    }

@Override
    public void delete(Session session, Long id) {

        String hql = "delete from Account a where a.id =:id";

        session.createQuery(hql).setParameter("id", id).executeUpdate();
    }


}
