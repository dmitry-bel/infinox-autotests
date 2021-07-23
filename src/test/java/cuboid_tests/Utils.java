package cuboid_tests;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.*;


public class Utils {

    public static void login() {
        // log in admin
        open("https://testing.cuboidlogic.com/reconciliationui/#/login");
        element(byId("username")).setValue("dmytro.bilotserkivskyi@ardas.biz");
        element(byId("password")).setValue("qweqwe123");
        element(byId("loginButton")).click();
    }

    public static void clickUpdateButton(){
        $(byId("showButton")).shouldBe(visible).click();
    }

    public static void setDateRange(String dateFrom, String dateTo){
        $(byId("dateFromInput")).clear();
        $(byId("dateFromInput")).setValue(dateFrom).pressEnter();
        $(byId("dateToInput")).clear();
        $(byId("dateToInput")).setValue(dateTo).pressEnter();
    }

    public static void setDateFrom(String dateFrom){
        $(byId("dateFromInput")).clear();
        $(byId("dateFromInput")).setValue(dateFrom).pressEnter();
    }

    public static void setDateTo(String dateTo){
        $(byId("dateToInput")).clear();
        $(byId("dateToInput")).setValue(dateTo).pressEnter();
    }

}
