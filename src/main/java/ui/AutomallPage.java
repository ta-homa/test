package ui;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.SelenideElement;


public class AutomallPage {
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

}
