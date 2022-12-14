package ir.twitter.service.accountService;

import ir.twitter.utility.ApplicationContext;
import ir.twitter.utility.SessionFactoryProvider;
import ir.twitter.entity.Account;
import ir.twitter.repository.accountRepository.AccountRepositoryImpl;
import org.hibernate.Session;

import java.util.Optional;

public class AccountServiceImpl implements AccountService {


    @Override
    public void addAccount(Account account) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.beginTransaction();
            try {
                ApplicationContext.getAccountRepository().save(session, account);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public void changeUsername(Long id, String username) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.beginTransaction();
            try {
                Account account = ApplicationContext.getAccountRepository().find(session, id).orElseThrow();
                account.setUserName(username);
                ApplicationContext.getAccountRepository().update(session, account);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public void changePassword(Long id, String password) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.beginTransaction();
            try {
                Account account = ApplicationContext.getAccountRepository().find(session, id).orElseThrow();
                account.setPassword(password);
                ApplicationContext.getAccountRepository().update(session, account);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public void changeEmail(Long id, String email) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.beginTransaction();
            try {
                Account account = ApplicationContext.getAccountRepository().find(session, id).orElseThrow();
                account.setEmail(email);
                ApplicationContext.getAccountRepository().update(session, account);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public void updateAll(Account account) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.beginTransaction();
            try {
                ApplicationContext.getAccountRepository().update(session, account);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public void removeAccount(Account account) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            session.beginTransaction();
            try {
                ApplicationContext.getAccountRepository().delete(session, account);
                session.getTransaction().commit();
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw e;
            }
        }
    }

    @Override
    public Optional<Account> showAccount(Long id) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            return ApplicationContext.getAccountRepository().find(session, id);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public boolean checkAccount(String username, String password) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {
            return ApplicationContext.getAccountRepository().isExist(session, username, password);
        }
    }

    @Override
    public Optional<Account> findById(Long id) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {

            return Optional.of(ApplicationContext.getAccountRepository().findById(session, id).orElseThrow());
        }
    }

    @Override
    public Account findByUsername(String username) {
        try (Session session = SessionFactoryProvider.sessionFactory.openSession()) {

            return ApplicationContext.getAccountRepository().findByUsername(session, username).orElseThrow();
        }
    }
}