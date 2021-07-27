package cuboid_tests.transactions_tab;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import cuboid_tests.Utils;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchByIntegrationType {
    
    @Test
    void searchByIntegrationType(){
        String neededDate = "08/07/2021";

        // log in admin
        Utils.login();

        // search transactions by Praxis Integration Type
        Utils.setDateRange(neededDate, neededDate);
        $(byCssSelector("div.integration-type button")).click();
        $(byText("Praxis")).click();
        Utils.clickUpdateButton();

        // check that displayed 3 Praxis transactions
        ElementsCollection allPraxis = $$(byCssSelector("td.integration-type"));
        allPraxis.filterBy(text("Praxis")).shouldHave(CollectionCondition.size(3));

        // search transactions by Non-Praxis Integration Type
        $(byCssSelector("div.integration-type button")).click();
        $(byText("Non-Praxis")).click();
        Utils.clickUpdateButton();

        // check that displayed 42 Non-Praxis transactions
        ElementsCollection allNonPraxis = $$(byCssSelector("td.integration-type"));
        allNonPraxis.filterBy(text("Non-Praxis")).shouldHave(CollectionCondition.size(42));
    }
}
