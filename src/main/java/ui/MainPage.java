package ui;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement ;
import org.openqa.selenium.support.*;

import static com.codeborne.selenide.Condition.visible;

public class MainPage {
    //куки
    @FindBy(how = How.XPATH, using = "//*[@id='cookie-warning']/div/div/button")
    private SelenideElement cookiesBtn;
    //всплывающее окошко 30 сек
    @FindBy(how = How.XPATH,using = "/html/body/div[5]/div/div[5]")
    private SelenideElement callCloseBtn;
    //лого
    @FindBy(how = How.CLASS_NAME,using = "img-fluid")
    private SelenideElement logoSberLeasing;
    // кнопка Подобрать по параметрам
    @FindBy(how = How.LINK_TEXT,using = "Подобрать по параметрам")
    private SelenideElement filterBtn;


    //закрыть всплывающее окно 30 сек
    public void closeСall () {
        Configuration.timeout = 30000 ;
        callCloseBtn.shouldBe(visible).isDisplayed();
        callCloseBtn.click();
    }
    //закрыть куки
    public void closeCookies(){
        if (cookiesBtn.isDisplayed()) {
            cookiesBtn.click();
        }
    }
    // клик Подобрать по параметрам
    public void findCar(){
        filterBtn.click();
    }

}
