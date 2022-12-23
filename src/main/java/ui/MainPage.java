package ui;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement ;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class MainPage {
    //куки
    public SelenideElement cookiesBtn = $(byXpath("//*[@id='cookie-warning']/div/div/button"));
    //всплывающее окошко 30 сек
    private SelenideElement callCloseBtn = $(byXpath("/html/body/div[5]/div/div[5]"));
    //лого
    private SelenideElement logoSberLeasing = $(byClassName("img-fluid"));
    // кнопка Подобрать по параметрам
    private SelenideElement filterBtn = $(byLinkText("Подобрать по параметрам"));


    //закрыть всплывающее окно 30 сек
    @Step("Закрыть всплывающее окно")
    public void closeСall () {
        sleep(1000);
        callCloseBtn.shouldBe(visible).isDisplayed();
        callCloseBtn.click();
    }
    //закрыть куки
    @Step("Закрыть куки")
    public void closeCookies(){
        if (cookiesBtn.isDisplayed()) {
            cookiesBtn.click();
        }
    }
    // клик Подобрать по параметрам
    @Step("Клик по кнопке \"Подобрать по параметрам\"")
    public void findCar(){
        filterBtn.click();
    }

}
