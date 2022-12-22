package ui;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static org.hamcrest.CoreMatchers.containsString;

public class FindCarTest {
    String currentUrl;
    MainPage mainPage;
    AutomallPage automallPage;

    @Before
    public void initPage()  {
      open("https://www.google.ru/");
      $(byTitle("Поиск")).setValue("СберЛизинг").shouldBe(Condition.visible).pressEnter();
      $(byXpath("//*[@class='LC20lb MBeuO DKV0Md']")).click();
        switchTo().window(1);
        currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        mainPage = open(currentUrl,MainPage.class);
        mainPage.closeCookies();
         //  mainPage.closeСall();

    }

    @Test
    public void test() throws Exception{
        mainPage.findCar();
        currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        automallPage = open(currentUrl,AutomallPage.class);
        automallPage.selectCity("Москва");
        automallPage.selectMark("Lada");
        automallPage.selectModel("Vesta Sport");
        automallPage.selectDrive("передний");
        automallPage.selectTransmission("механика");
        automallPage.selectBodyType("седан");
        automallPage.selectFuelType("бензин");
        automallPage.selectColor("белый");
        automallPage.showAllOffersBtnClick();
        automallPage.viewOffersBtnClick();
        automallPage.markShouldBSame();
   }

}
