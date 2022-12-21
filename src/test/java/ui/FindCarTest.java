package ui;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.Before;
import org.junit.Test;

import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class FindCarTest {
    String currentUrl;
    MainPage mainPage;
    AutomallPage automallPage;

    @Before
    public void initPage()  {
      open("https://www.google.ru/");
      $(byTitle("Поиск")).setValue("СберЛизинг").shouldBe(Condition.visible).pressEnter();
      $(byXpath("//*[@id='rso']/div[1]/div/div/div/div/div/div/div/div[1]/a/h3")).click();
        //  $(byText("https://ru.selenide.org")).shouldBe(Condition.visible).click();
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
        automallPage.checkParam("Москва","Lada","Vesta Sport","передний",
                "механика","седан", "бензин", "белый");
        automallPage.getMarka();
    }


}
