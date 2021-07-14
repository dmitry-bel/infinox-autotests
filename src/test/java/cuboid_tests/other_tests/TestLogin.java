package cuboid_tests.other_tests;

import cuboid_tests.Utils;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;


public class TestLogin {

    @Test
    void tryToLogin() {
        // log in cuboid and check that displayed Transactions tab
        Utils.login();
        $(byId("transactionsLink"));
    }
}
