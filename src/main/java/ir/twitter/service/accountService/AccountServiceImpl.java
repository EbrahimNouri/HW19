package ir.twitter.service.accountService;

import ir.twitter.connection.SessionFactoryProvider;
import ir.twitter.entity.Account;
import ir.twitter.repository.accountRepository.AccountRepositoryImpl;
import org.hibernate.Session;

import java.util.Optional;

public class AccountServiceImpl implements AccountService{

    AccountRepositoryImpl accountRepository = new AccountRepositoryImpl();

    @Override
    public void addAccount(Account account) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()){
            session.beginTransaction();
            try {
                accountRepository.save(session, account);
                session.getTransaction().commit();
            }catch (Exception e){
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public void changeUsername(Long id, String username) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()){
            session.beginTransaction();
            try {
                Account account = accountRepository.find(session, id).orElseThrow();
                account.setUserName(username);
                accountRepository.update(session, account);
                session.getTransaction().commit();
            }catch (Exception e){
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public void changePassword(Long id, String password) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()){
            session.beginTransaction();
            try {
                Account account = accountRepository.find(session, id).orElseThrow();
                account.setPassword(password);
                accountRepository.update(session, account);
                session.getTransaction().commit();
            }catch (Exception e){
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public void changeEmail(Long id, String email) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()){
            session.beginTransaction();
            try {
                Account account = accountRepository.find(session, id).orElseThrow();
                account.setEmail(email);
                accountRepository.update(session, account);
                session.getTransaction().commit();
            }catch (Exception e){
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public void updateAll(Account account) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()){
            session.beginTransaction();
            try {
                accountRepository.update(session, account);
                session.getTransaction().commit();
            }catch (Exception e){
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public void removeAccount(Account account) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()){
            session.beginTransaction();
            try {
                accountRepository.delete(session, account);
                session.getTransaction().commit();
            }catch (Exception e){
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public Optional<Account> showAccount(Long id) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()){
                return accountRepository.find(session, id);
            }catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean checkAccount(String username, String password) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()){
            return accountRepository.isExist(session, username, password);
        }
    }
}
