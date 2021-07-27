package cuboid_tests.transactions_tab;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import cuboid_tests.Utils;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchByAccType {

    @Test
    void searchByAccType(){
        String dateFrom = "06/07/2021";
        String dateTo = "23/07/2021";

        // log in and set needed date range
        Utils.login();
        Utils.setDateRange(dateFrom, dateTo);

        // choose Regular account type
        $(byCssSelector("div.account-type button")).shouldBe(visible).click();
        $(byCssSelector("div.account-type li:nth-child(2)")).shouldBe(visible).click();
        Utils.clickUpdateButton();
        $$(byCssSelector("td.account-type")).filterBy(text("Regular")).shouldHave(CollectionCondition.size(100));

        // choose Brokeree account type
        $(byCssSelector("div.account-type button")).shouldBe(visible).click();
        $(byCssSelector("div.account-type li:nth-child(3)")).shouldBe(visible).click();
        Utils.clickUpdateButton();
        $$(byCssSelector("td.account-type")).filterBy(text("Brokeree")).shouldHave(CollectionCondition.size(3));

        // choose Wallet account type
        $(byCssSelector("div.account-type button")).shouldBe(visible).click();
        $(byCssSelector("div.account-type li:nth-child(5)")).shouldBe(visible).click();
        Utils.clickUpdateButton();
        $$(byCssSelector("td.account-type")).filterBy(text("Wallet")).shouldHave(CollectionCondition.size(78));
    }
}
