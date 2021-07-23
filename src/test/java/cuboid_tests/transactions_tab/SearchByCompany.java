package cuboid_tests.transactions_tab;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import cuboid_tests.Utils;
import org.junit.jupiter.api.Test;

import javax.swing.text.Element;

import java.util.Queue;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SearchByCompany {

    @Test
    void searchByCompany(){
        String dateFrom = "18/06/2021";
        String dateTo = "16/07/2021";

        // log in admin
        Utils.login();

        // check how much companies for filter
        Utils.setDateRange(dateFrom, dateTo);
        $(byCssSelector("div.company button")).shouldBe(visible).click();

//         why can`t change allDisplayedTr value
//        ElementsCollection allCompanies = $$(byCssSelector("div.company ul li"));
//        int companiesQuantity = allCompanies.size();
//
//        int allDisplayedTr = 0;
//        ElementsCollection allTransactions = $$("td.company");
//        for(int i=1; i<=companiesQuantity; i++){
//            String companyName = $(byCssSelector("div.company ul li:nth-child(" + i +")")).getText();
//            $(byCssSelector("div.company ul li:nth-child(" + i +")")).click();
//            Utils.clickUpdateButton();
//            allTransactions = $$("td.company");
//            allDisplayedTr = allTransactions.size();
//            allTransactions.filterBy(text(companyName)).shouldHave(CollectionCondition.size(allDisplayedTr));
//
//            $(byCssSelector("div.company button")).shouldBe(visible).click();
//            $(byCssSelector("div.company ul li:nth-child(" + i +")")).click();
//        }

            // choose Bitculture DT
            $(byCssSelector("div.company ul li:nth-child(1)")).shouldBe(visible).click();
            Utils.clickUpdateButton();
            $$("td.company").filter(text("Bitculture DT")).shouldHave(CollectionCondition.size(100));
            $(byCssSelector("div.company button")).shouldBe(visible).click();
            $(byCssSelector("div.company ul li:nth-child(1)")).shouldBe(visible).click();

            // choose Bitculture SAF
            $(byCssSelector("div.company ul li:nth-child(2)")).click();
            Utils.clickUpdateButton();
            $$("td.company").filter(text("Bitculture SAF")).shouldHave(CollectionCondition.size(56));
            $(byCssSelector("div.company button")).shouldBe(visible).click();
            $(byCssSelector("div.company ul li:nth-child(2)")).click();

            // choose The Brokers Capital
            $(byCssSelector("div.company ul li:nth-child(3)")).click();
            Utils.clickUpdateButton();
            $$("td.company").filter(text("The Brokers Capital")).shouldHave(CollectionCondition.size(2));
            $(byCssSelector("div.company button")).shouldBe(visible).click();
            $(byCssSelector("div.company ul li:nth-child(3)")).click();

            // choose Infinox
            $(byCssSelector("div.company ul li:nth-child(4)")).click();
            Utils.clickUpdateButton();
            $$("td.company").filter(text("Infinox")).shouldHave(CollectionCondition.size(100));
            $(byCssSelector("div.company button")).shouldBe(visible).click();
            $(byCssSelector("div.company ul li:nth-child(4)")).click();
    }
}
