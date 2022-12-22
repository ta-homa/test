package ui;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.CoreMatchers.containsString;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.junit.Assert;


public class AutomallPage {
    String result;
    //город
    public SelenideElement filterCity = $(byXpath("//*[@id='filter-city']/input"));
    //марка
    public SelenideElement filterMark = $(byXpath("//*[@id='filter-mark']/input"));
    //модель
    public SelenideElement filterModel = $(byXpath("//*[@id='filter-model']/input"));
    //чекбоксы горизонтального меню
    //чекбокс город
    public SelenideElement filterCityCheckBox = $(byXpath("//*[@aria-labelledby='filter-city']/div/div"));
    //чекбокс марка
    public SelenideElement filterMarkCheckBox = $(byXpath("//*[@aria-labelledby='filter-mark']/div/div"));
    //чекбокс модель
    public SelenideElement filterModelCheckBox = $(byXpath("//*[@aria-labelledby='filter-model']/div/div"));
    //чекбокс Только авто со скидкой
    public SelenideElement saleCheckBox = $(byXpath("//*[@id='marketplace-horizontal-filter']/div/div[2]/div/div/div"));
    //цвет
    public SelenideElement filterColor = $(byXpath("//*[@aria-label='Цвет']/input"));
    //цвет чекбоксы
     public SelenideElement filterColorCheckBox(){
        return $(byXpath("//*[@id='marketplace-horizontal-filter']/div/div[3]/div[3]/div[3]/div[2]/div/div"));
    }
    //привод
    public SelenideElement driveCheckBox(Integer i){

        return $(byXpath("//*[@id='marketplace-horizontal-filter']/div/div[3]/div[1]/div[2]/div[2]/div[" + i + "]"));
    }
    //Коробка передач
    public SelenideElement transcmissionCheckBox(Integer i){
        return $(byXpath("//*[@id='marketplace-horizontal-filter']/div/div[3]/div[1]/div[3]/div[2]/div[" + i + "]"));
    }
    //Тип кузова
    ////*[@id="marketplace-horizontal-filter"]/div/div[3]/div[2]/div/div[1]
    public SelenideElement bodyTypeCheckBox(Integer i){
        return $(byXpath("//*[@id='marketplace-horizontal-filter']/div/div[3]/div[2]/div/div[2]/div[" + i + "]"));
    }
    //Тип топлива
    public SelenideElement fuelTypeCheckBox(Integer i){
        return $(byXpath("//*[@id='marketplace-horizontal-filter']/div/div[3]/div[3]/div[2]/div[2]/div[" + i + "]"));
    }
    //кнопка Показать все предложения
    public SelenideElement showAllOffersBtn = $(byXpath("//*[@class='sbl-btn sbl-btn_accent sbl-btn_medium sbl-filter-footer__find']"));
    //кнопка Смотреть предложения
    public SelenideElement viewOffersBtn = $(byXpath("//*[@class='sbl-btn sbl-btn_medium w-100 sbl-btn_detail']"));
    //текст из списка
    public SelenideElement markShouldBe = $(byXpath("//*[@class='d-flex align-items-start mb-30']/h1"));
    //текст из тачки
    public SelenideElement markResult = $(byXpath("//*[@class='car-card__item-mark']"));

    @Step("Выбрать город")
    public void selectCity(String city){
        //город
        filterCity.click();
        filterCity.setValue(city);
        filterCityCheckBox.click();
    }
    @Step("Выбрать марку")
    public void selectMark(String mark){
        //марка
        filterMark.click();
        filterMark.setValue(mark);
        filterMarkCheckBox.click();
    }
    @Step("Выбрать модель")
    public void selectModel(String model){
        //модель
        filterModel.click();
        filterModel.setValue(model);
        filterModelCheckBox.click();
    }
    @Step("Выбрать привод")
    public void selectDrive(String drive) throws Exception {
        for (int i = 1; i <= 3; i++) {
            result = driveCheckBox(i).getText();
            if (result.contains(drive)) {
                driveCheckBox(i).click();
                break;
            } else if (i == 3) throw new Exception("Неверный параметр");
        }
    }
    @Step("Выбрать коробку передач")
    public void selectTransmission(String transmission) throws Exception {
        // Коробка передач
        for (int i = 1; i <= 2; i++) {
            result = transcmissionCheckBox(i).getText();
            if (result.contains(transmission)) {
                transcmissionCheckBox(i).click();
                break;
            }else  if( i == 2) throw new Exception("Неверный параметр");
        }
    }
    @Step("Выбрать тип кузова")
    public void selectBodyType(String type) throws Exception {
        //Тип кузова
        for (int i = 1; i <= 19; i++) {
            result = bodyTypeCheckBox(i).getText();
            if (result.contains(type)) {
                bodyTypeCheckBox(i).click();
                break;
            }else if( i == 19) throw new Exception("Неверный параметр");
        }
    }
    @Step("Выбрать тип топлива")
    public void selectFuelType(String type) throws Exception {
        //Тип топлива
        for (int i = 1; i <= 5; i++) {
            result = fuelTypeCheckBox(i).getText();
            if (result.contains(type)) {
                fuelTypeCheckBox(i).click();
                break;
            }else if( i == 5) throw new Exception("Неверный параметр");
        }
    }
    @Step("Выбрать цвет")
    public void selectColor (String color){
        //цвет
        filterColor.click();
        filterColor.setValue(color);
        filterColorCheckBox().click();
    }
    @Step("Клик по кнопке \"Показать все предложения\"")
    public void showAllOffersBtnClick(){
        showAllOffersBtn.click();
    }
    @Step("Клик по кнопке \"Смотреть предложения\"")
    public void viewOffersBtnClick(){
        viewOffersBtn.click();
    }
    @Step("Проверить что выбранная марка автомобиля соответствует марке в общем списке")
    public void markShouldBSame(){
        Assert.assertThat(markShouldBe.getText(), containsString(markResult.getText()));
    }

}
