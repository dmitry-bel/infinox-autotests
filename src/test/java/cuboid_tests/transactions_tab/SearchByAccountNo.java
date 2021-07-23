package cuboid_tests.transactions_tab;

import cuboid_tests.Utils;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.*;


public class SearchByAccountNo {

    @Test
    void searchByAccountNo() {
        String dateFrom = "05/07/2021";
        String accountNumber = "1000000502";

        // log in admin
        Utils.login();

        // try to search transaction by order id
        Utils.setDateFrom(dateFrom);
        element(byId("accountNo")).setValue(accountNumber);
        Utils.clickUpdateButton();

        // check that displayed 1 transaction in list
        $(byId("transactionAccountNumber")).should(exist);
        element(byId("transactionAccountNumber")).shouldHave(text(accountNumber));
    }
}
