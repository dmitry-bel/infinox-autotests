package cuboid_tests.hvt_tab;

import cuboid_tests.Utils;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.$;


public class CreateTr {

    @Test
    void createDeposit() {
        Random rd = new Random();
        Integer randomUsd = rd.nextInt(10000);
        String randomUsdStr = Integer.toString(randomUsd);
        String accountNumber = "6311715";

        //// log in admin
        Utils.login();

        // open High Value tab and make a transaction
        $(byId("highValueLink")).click();
        $(byId("createTransactionButton")).click();
        $(byId("accountNumber")).setValue(accountNumber);
        $(byId("executedAmount")).setValue(randomUsdStr);
        $(byClassName("btn-success")).click();
        $(byId("createAndApplyTransactionsButton")).click();
        $(byId("delete")).click();

        // check that last transaction in list has needed transaction sum
        $(byClassName("deposit-sum")).shouldHave(text(randomUsdStr));
    }
}








