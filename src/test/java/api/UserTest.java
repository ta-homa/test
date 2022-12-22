package api;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;


public class UserTest {
    User user = new User();
    User userError = new User();
    UserRequests userRequests = new UserRequests();
    Gson gson = new Gson();

    @Before
    public void before() {
        RestAssured.baseURI = "https://petstore.swagger.io/v2";
        user.setId(Long.valueOf(0));
        user.setUsername("gvgюgglkjudg" + new Random().nextInt(999));
        user.setFirstName("123");
        user.setLastName("123");
        user.setEmail("123");
        user.setPassword("123");
        user.setPhone("123");
        user.setUserStatus(0);
        userError.setUsername("@&" + new Random().nextInt(999));

    }

    @Test
    @DisplayName("Тест User")
    public void apiUserTest() {
        //создать
        Response response =  create(user);
        response.then().assertThat().statusCode(200)
                .and().body("message",notNullValue());
        //считать id
        JsonObject jsonObject = new JsonParser().parse(response.body().asString()).getAsJsonObject();
        String idString = jsonObject.get("message").getAsString();
        //id нового пользователя
        user.setId(Long.parseLong(idString));

        //изменить данные
        //только статус 200, при любом запросе 200 получается
        user.setEmail("321");
        response = update(user);
        response.then().assertThat().statusCode(200)
                        .and().body("message",equalTo(idString));

        //статус 200
       response = getUser(user);
        String jsonStr = gson.toJson(user);
        response.then().assertThat().statusCode(200);
        assertThat(response.body().asString(),equalTo(jsonStr));

        //удалить пользователя статус 200
        response = delete(user);
        response.then().assertThat().statusCode(200);
        //проверяем что пользователя нет
        response = getUser(user);
        response.then().assertThat().statusCode(404)
                .and().body("message",equalTo("User not found"));
    }


    @Step("Создать произвольного пользователя")
    public Response create(User user){
        return  userRequests.createUser(user);
    }
    @Step("Изменить данные созданного пользователя")
    public Response update(User user){
        return  userRequests.updateUser(user);
    }
    @Step("Получить информацию по пользователю")
    public Response getUser(User user){
        return userRequests.getUserByUserName(user);
    }
    @Step("Удалить пользователя")
    public Response delete(User user){
        return userRequests.deleteUser(user);
    }

}
