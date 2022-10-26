import ir.twitter.entity.Account;
import ir.twitter.service.accountService.AccountServiceImpl;
import ir.twitter.service.followerService.FollowerService;
import ir.twitter.service.followingService.FollowingServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {
    private static Account account1;
    private static Account account2;
    private static Account account3;
    private static Account account4;
    private final AccountServiceImpl ACCOUNT_SERVICE = new AccountServiceImpl();
    private final FollowingServiceImpl FOLLOWING_SERVICE = new FollowingServiceImpl();

    @BeforeAll
    static void beforeAllTest() {
        account1 = new Account(null, "ebrahim1", "ebi1@gmail.com", "123456789", null,
                null, null, null, null);
        account2 = new Account(null, "ebrahim2", "ebi2@gmail.com", "123456789", null,
                null, null, null, null);
        account3 = new Account(null, "ebrahim3", "ebi3@gmail.com", "123456789", null,
                null, null, null, null);
        account4 = new Account(null, "ebrahim4", "ebi4@gmail.com", "123456789", null,
                null, null, null, null);
    }

    @Test
    void addAccountTest() {
        ACCOUNT_SERVICE.addAccount(account2);
        assertNotNull(account1.getId());
    }

    @Test
    void changeUsername() {
        String oldUsername = account1.getUserName();
        ACCOUNT_SERVICE.addAccount(account1);
        long id = account1.getId();
        String newUsername = "newUsername";
        account1.setUserName(newUsername);
        ACCOUNT_SERVICE.changeUsername(id, newUsername);
        assertNotEquals(newUsername, oldUsername);
    }

    @Test
    void changePassword() {
        String oldPassword = account3.getPassword();
        ACCOUNT_SERVICE.addAccount(account3);
        long id = account3.getId();
        String newPassword = "newPassword";
        account3.setPassword(newPassword);
        ACCOUNT_SERVICE.changePassword(id, newPassword);
        assertNotEquals(newPassword, oldPassword);
    }

    @Test
    void changEmail() {
        String oldEmail = account4.getEmail();
        ACCOUNT_SERVICE.addAccount(account4);
        long id = account4.getId();
        String newEmail = "newEmail";
        account4.setEmail(newEmail);
        ACCOUNT_SERVICE.changePassword(id, newEmail);
        assertNotEquals(newEmail, oldEmail);
    }

    @Test
    void removeAccount() {
        ACCOUNT_SERVICE.removeAccount(account1);
        assertThrows(NoSuchElementException.class, () -> ACCOUNT_SERVICE.findById(account1.getId())
                , "No value present");
    }

    @BeforeEach
    void addFlower(){
        FOLLOWING_SERVICE.followSomeone(account1, account2);
    }
    void getFlowerOfAnAccount(){
        f
    }
}
