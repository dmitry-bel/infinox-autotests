package cuboid_tests.transactions_tab;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import cuboid_tests.Utils;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class SearchByOffice {

    @Test
    void searchByOffice(){
        String dateFrom = "13/07/2021";
        String dateTo = "23/07/2021";

        // log in and set needed date range
        Utils.login();
        Utils.setDateRange(dateFrom, dateTo);

        // choose Philippines office
        $(byCssSelector("div.office button")).shouldBe(visible).click();
        $(byCssSelector("div.office li:nth-child(15)")).click();
        Utils.clickUpdateButton();
        $$(byCssSelector("td.office")).filterBy(text("Philippines")).shouldHave(CollectionCondition.size(5));

        // need add class for office td



















    Selenide.sleep(5000);

    }
}
