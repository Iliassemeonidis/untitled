package ru.idmt.document;

//import net.lightbody.bmp.proxy.ProxyServer;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byName;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class Testing {
    @Test
    public void userCanSearch() throws Exception{
        // Открываем нужный сайт
        open("https://google.com/ncr");
        // набтраем в поисковике нужную нам иинф
        element(byName("q")).setValue("Selenide").pressEnter();
        // делаем колекцию элементов и убеждаемся что там будет 10 эл
        elements("#search .g").shouldHave(sizeGreaterThanOrEqual(10))
                // проверяем что перая записть так которая нам нужна
                .first().shouldHave(text("Selenide: concise UI tests in Java"))
                // находим и проваливаемся в нее
                .find(" .r>a").click();
        //убеждаемся что титл такой же как нам нужен
        Wait().until(titleIs("Selenide: concise UI tests in Java"));








    }
}
