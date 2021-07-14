package cuboid_tests.transactions_tab;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import cuboid_tests.Utils;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class SearchByPsp {

    @Test
    void searchByPsp() {
        String neededDate = "06/07/2021";

        // log in admin
        Utils.login();

        // set up needed date
        $(byId("dateFromInput")).clear();
        $(byId("dateFromInput")).setValue(neededDate).pressEnter();
        $(byId("dateToInput")).clear();
        $(byId("dateToInput")).setValue(neededDate).pressEnter();
        $(byId("showButton")).shouldBe(visible).click();

        // set up PSP
        $(byCssSelector("button.dropdown-toggle")).shouldBe(visible).click();


        // get list of displayed dates
        ElementsCollection result = $$(byClassName("created-date"));
        result.shouldHave(CollectionCondition.size(50));

        // how to make an array of strings???
    }
}
