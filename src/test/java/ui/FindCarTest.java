package ui;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Before;
import org.junit.Test;
import ui.steps.Steps;

import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class FindCarTest extends Steps{
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
        //mainPage.closeСall();
    }

    @Test
    public void test() throws Exception{
        mainPage.findCar();
        currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        automallPage = open(currentUrl,AutomallPage.class);
        selectCity("Москва");
        selectMark("Lada");
        selectModel("Vesta Sport");
        selectDrive("передний");
        selectTransmission("механика");
        selectBodyType("седан");
        selectFuelType("бензин");
        selectColor("белый");
        showAllOffersBtnClick();
        viewOffersBtnClick();
        markShouldBSame();
   }

}
