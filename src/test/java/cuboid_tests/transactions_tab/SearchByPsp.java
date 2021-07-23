package cuboid_tests.transactions_tab;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import cuboid_tests.Utils;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class SearchByPsp {

    @Test
    void searchByPsp() {
        String neededDate = "06/07/2021";

        // log in admin
        Utils.login();

        // set up needed date and PSP
        Utils.setDateRange(neededDate, neededDate);

        $(byCssSelector("button.dropdown-toggle")).shouldBe(visible).click();
        $(byText("Bank - Wealthum")).shouldBe(visible).click();
        Utils.clickUpdateButton();

        // check that displayed correct value of transactions
        ElementsCollection result = $$(byClassName("created-date"));
        result.filter(text(neededDate)).shouldHave(CollectionCondition.size(6));
    }
}
