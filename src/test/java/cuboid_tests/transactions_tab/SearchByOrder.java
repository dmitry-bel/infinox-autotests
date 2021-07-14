package cuboid_tests.transactions_tab;

import cuboid_tests.Utils;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.element;


public class SearchByOrder {

    @Test
    void searchByOrder() {
        String orderId = "346996";

        // log in admin
        Utils.login();

        // try to search transaction by order id
        element(byId("dateFromInput")).clear();
        element(byId("dateFromInput")).setValue("20/06/2021").pressEnter();

        element(byId("orderId")).setValue(orderId);
        element(byId("showButton")).shouldBe(visible).click();
        element(byId("transactionOrder")).shouldHave(text(orderId));
    }
}
