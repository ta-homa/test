package ui;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static org.hamcrest.CoreMatchers.containsString;

import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import java.util.List;

public class AutomallPage {
    //город
    @FindBy(how = How.XPATH,using = "//*[@id='filter-city']/input")
    private SelenideElement filterCity;
    //марка
    @FindBy(how = How.XPATH,using = "//*[@id='filter-mark']/input")
    private SelenideElement filterMark;
    //модель
    @FindBy(how = How.XPATH,using = "//*[@id='filter-model']/input")
    private SelenideElement filterModel;
    //чекбоксы горизонтального меню
    //чекбокс город
    @FindBys({
            @FindBy(how = How.XPATH,using = "//*[@id='marketplace-horizontal-filter']/div/div[1]/div[1]/div[2]/div"),
    })
    private List<SelenideElement> horizontalCheckBoxTown;
    //чекбокс марка
    @FindBys({
            @FindBy(how = How.XPATH,using = "//*[@id='marketplace-horizontal-filter']/div/div[1]/div[2]/div[2]/div"),
    })
    private List<SelenideElement> horizontalCheckBoxMark;
    //чекбокс модель
    @FindBys({
            @FindBy(how = How.XPATH,using = "//*[@id='marketplace-horizontal-filter']/div/div[1]/div[3]/div[2]/div"),
    })
    private List<SelenideElement> horizontalCheckBoxModel;
    //чекбокс Только авто со скидкой
    @FindBy(how = How.XPATH,using = "//*[@id='marketplace-horizontal-filter']/div/div[2]/div/div/div")
    private SelenideElement saleCheckBox;
    //цвет
    @FindBy(how = How.XPATH,using = "//*[@id='marketplace-horizontal-filter']/div/div[3]/div[3]/div[3]/div[2]/label/input")
    private SelenideElement colorFilter;
    //цвет чекбоксы
    @FindBys({
            @FindBy(how = How.XPATH, using = "//*[@id='marketplace-horizontal-filter']/div/div[3]/div[3]/div[3]/div[2]/div/div"),
    })
    private List<SelenideElement> colorCheckBox;
    //кнопка Показать все предложения
    @FindBy(how = How.XPATH,using = "//*[@id='marketplace-horizontal-filter']/div/div[4]/a")
    private SelenideElement findCarBtn;
    //Смотреть предложения
    @FindBy (how = How.XPATH,using = "/html/body/div[1]/div[2]/div/main/div[3]/a/div[2]/div[2]/div")
    private SelenideElement getFindCarBtn;
    //из списка
    @FindBy(how = How.XPATH,using = "/html/body/div[1]/div[2]/div[1]/h1")
    private SelenideElement markShouldBe;
    //из тачки
    @FindBy(how = How.XPATH,using = "//*[@id='offers-list']/div[2]/div[2]/div[1]/div[2]/a/div[1]/div[1]/div/div/div")
    private SelenideElement markResult;

    public void checkParam(String town, String mark, String model,String privod,
                           String korobka,String kuzov, String toplivo,String color) throws Exception {
        String result;
        SelenideElement element;
        //город
        filterCity.click();
        filterCity.setValue(town);
        horizontalCheckBoxTown.get(0).click();
        //марка
        filterMark.click();
        filterMark.setValue(mark);
        horizontalCheckBoxMark.get(0).click();
        //модель
        filterModel.click();
        filterModel.setValue(model);
        horizontalCheckBoxModel.get(0).click();
        sleep(1000);
        //Товары со скидкой
        if (saleCheckBox.isDisplayed() && saleCheckBox.isEnabled())
            saleCheckBox.click();

        //Привод
        for (int i = 1; i <= 3; i++) {
            element = $(byXpath("//*[@id='marketplace-horizontal-filter']/div/div[3]/div[1]/div[2]/div[2]/div[" + i + "]"));
            result = element.getText();
            if (result.contains(privod)) {
                element.click();
                break;
            }else if( i == 3) throw new Exception("Неверный параметр");

        }
        sleep(1000);
        // Коробка передач
        for (int i = 1; i <= 2; i++) {
            element = $(byXpath("//*[@id='marketplace-horizontal-filter']/div/div[3]/div[1]/div[3]/div[2]/div[" + i + "]"));
            result = element.getText();
            if (result.contains(korobka)) {
                element.click();
                break;
            }else  if( i == 2) throw new Exception("Неверный параметр");
        }
        sleep(1000);
        //Тип кузова
        for (int i = 1; i <= 19; i++) {
            element = $(byXpath("//*[@id='marketplace-horizontal-filter']/div/div[3]/div[2]/div/div[2]/div[" + i + "]"));
            result = element.getText();
            if (result.contains(kuzov)) {
                element.click();
                break;
            }else if( i == 19) throw new Exception("Неверный параметр");
        }
        sleep(1000);
        //Тип топлива
        for (int i = 1; i <= 5; i++) {
            element = $(byXpath("//*[@id=\"marketplace-horizontal-filter\"]/div/div[3]/div[3]/div[2]/div[2]/div[" + i + "]"));
            result = element.getText();
            if (result.contains(toplivo)) {
                element.click();
                break;
            }else if( i == 5) throw new Exception("Неверный параметр");
        }
        sleep(1000);
        //цвет
        colorFilter.click();
        colorFilter.setValue(color);
        colorCheckBox.get(0).click();
        sleep(1000);
        //показать все предложения
        findCarBtn.click();
        sleep(1000);
    }
    //
    public void getMarka(){
        getFindCarBtn.click();
        Assert.assertThat(markShouldBe.getText(), containsString(markResult.getText()));
    }

}
