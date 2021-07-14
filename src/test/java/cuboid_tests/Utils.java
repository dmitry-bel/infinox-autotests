package cuboid_tests;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selenide.element;
import static com.codeborne.selenide.Selenide.open;


public class Utils {

    public static void login() {
        // log in admin
        open("https://testing.cuboidlogic.com/reconciliationui/#/login");
        element(byId("username")).setValue("dmytro.bilotserkivskyi@ardas.biz");
        element(byId("password")).setValue("qweqwe");
        element(byId("loginButton")).click();
    }
}
