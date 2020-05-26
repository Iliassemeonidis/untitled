package ru.idmt.document;

import com.codeborne.selenide.junit.ScreenShooter;
import com.codeborne.selenide.junit.TextReport;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.TestRule;

import java.io.File;
import java.util.Timer;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Configuration.browser;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class VolseProd {
    @Rule
    public TestRule report = new TextReport().onFailedTest(true).onSucceededTest(true);
    @Test
    public void userConectVolsProd() throws Exception {

        /* есть крутой критейрий поиска это byText , нет привезки к html разметкаим ,
         но проблема в том что не все элементы он находит потакому притирию поиска и прихолится использовать byXpath
        что не очень продуктивно, на случай если кто то что то поменяет на сраничку то тест может упасть */

        String url = "http://185.187.112.55/";
        browser = "firefox";
        open(url);
        $(byXpath("/html/body/div/div[3]/form/div[1]/input")).setValue("Boss11").pressEnter();
        $(byXpath("/html/body/div/div[3]/form/div[2]/input")).setValue("1");
        $(byText("Войти")).click();


        $(byText("Создать документ")).click();
        $(byText("ИСХОДЯЩИЕ ДОКУМЕНТЫ")).click();
        $(byText("Создать")).click();
        $(byText("Реквизиты")).click();

        // заполняем обязательные поля
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div[9]/div/div/div[1]/div[1]/div/div/div/div/button")).click();
        $(byXpath("//*[@id=\"query\"]")).setValue("Босс11");
        $(byText("Начальник 4")).click();
        String s = "Выбрать";
        //путь к кнопре выбрать
        String p = "html body.el-popup-parent--hidden div.el-dialog__wrapper div.el-dialog.user-list-dialogue-wrapper div.el-dialog__footer span.dialog-footer button.primary.default-margin-right.btn-def.fs-12";
        $$(p).findBy(text(s)).click();

        $(byXpath("//*[@id=\"dss_description\"]")).setValue("Test");
        //сохраняем
        $(byText("Контент")).click();

        // кнопка загрузить контент
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[2]/div[2]/div/div[1]/div/div[1]/div[2]/label")).click();
        // загружаем контент
         $("input").uploadFile(new File("test"));
        // сохраняем и отпраявлем на соглосования
        $(byXpath("/html/body/div[1]/div[3]/div/div[2]/div[2]/div[1]/div[2]/div/div/div[1]/div/div/div[1]/div[2]/ul/li/div")).click();




    }
}
