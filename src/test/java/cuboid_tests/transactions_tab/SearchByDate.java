package cuboid_tests.transactions_tab;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import cuboid_tests.Utils;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class SearchByDate {

    @Test
    void searchByDate() {
        String dateFrom = "30/06/2021";
        String dateTo = "01/07/2021";

        // log in admin
        Utils.login();

        // set up needed interval
        $(byId("dateFromInput")).clear();
        $(byId("dateFromInput")).setValue(dateFrom).pressEnter();
        $(byId("dateToInput")).clear();
        $(byId("dateToInput")).setValue(dateTo).pressEnter();
        $(byId("showButton")).shouldBe(visible).click();

        // get list of displayed dates
        ElementsCollection result = $$(byClassName("created-date"));
        result.shouldHave(CollectionCondition.size(50));
        result.filter(text("30/06/2021")).shouldHave(CollectionCondition.size(19));
        result.filter(text("01/07/2021")).shouldHave(CollectionCondition.size(31));
    }
}
