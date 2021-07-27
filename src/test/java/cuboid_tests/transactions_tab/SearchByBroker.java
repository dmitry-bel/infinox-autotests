package cuboid_tests.transactions_tab;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import cuboid_tests.Utils;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchByBroker {

    @Test
    void searchByBroker(){
        String dateFrom = "15/07/2021";
        String dateTo = "22/07/2021";

        // log in cuboid and set needed date range
        Utils.login();
        Utils.setDateRange(dateFrom, dateTo);

        // choose FSC Broker option
        $(byCssSelector("div.broker button")).shouldBe(visible).click();
        $(byCssSelector("div.broker li:nth-child(2)")).shouldBe(visible).click();
        Utils.clickUpdateButton();
        $$(byCssSelector("td.broker")).filterBy(text("FSC")).shouldHave(CollectionCondition.size(45));

        // choose SCB Broker option
        $(byCssSelector("div.broker button")).shouldBe(visible).click();
        $(byCssSelector("div.broker li:nth-child(3)")).shouldBe(visible).click();
        Utils.clickUpdateButton();
        $$(byCssSelector("td.broker")).filterBy(text("SCB")).shouldHave(CollectionCondition.size(45));

        // choose FCA Broker option
        $(byCssSelector("div.broker button")).shouldBe(visible).click();
        $(byCssSelector("div.broker li:nth-child(4)")).shouldBe(visible).click();
        Utils.clickUpdateButton();
        $$(byCssSelector("td.broker")).filterBy(text("FCA")).shouldHave(CollectionCondition.size(6));


        Selenide.sleep(5000);
    }









}
