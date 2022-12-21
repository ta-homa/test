package api;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserRequests {

    public Response createUser(User user) {
        Response response =
                given()
                        //   .log().all()
                        .header("Content-type", "application/json")
                        .body(user)
                        .when()
                        .post("/user");
        return response;
    }

    public Response updateUser (User user){
        Response response =
                given()
                        //   .log().all()
                        .header("Content-type", "application/json")
                        .body(user)
                        .when()
                        .post("");
        return response;
    }

    public  Response getUserByUserName(User user){
        Response response =
                given()
                        //   .log().all()
                        .header("Content-type", "application/json")
                        .body(user)
                        .when()
                        .post("");
        return response;
    }

    public Response deleteUser(User user){
        Response response =
                given()
                        //   .log().all()
                        .header("Content-type", "application/json")
                        .body(user)
                        .when()
                        .delete("")
                        .then()
                        .extract().response();
        return response;
    }
}
