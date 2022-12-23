package ui.steps;

import io.qameta.allure.Step;
import org.junit.Assert;
import ui.AutomallPage;

import static org.hamcrest.CoreMatchers.containsString;

public class Steps extends AutomallPage {
    String result;

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
