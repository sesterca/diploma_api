package clients;

import io.qameta.allure.restassured.AllureRestAssured;
import models.ApiResponse;
import models.User;

import static io.restassured.RestAssured.given;

public class UserClient extends BaseSpec {

    public ApiResponse createUser(User user){
        ApiResponse response = given()
                .filter(new AllureRestAssured())
                .spec(baseSpec)
                .body(user)
                .when()
                .post(Endpoints.CREATE_USER.getEndpoint())
                .then()
                .log().body()
                .statusCode(200)
                .extract().as(ApiResponse.class);
        return response;
    }

    public void changeUser(User user){
        given()
                .filter(new AllureRestAssured())
                .spec(baseSpec)
                .body(user)
                .when()
                .put(Endpoints.REFER_TO_USER.getEndpoint() + user.getUsername())
                .then()
                .statusCode(200);
    }

    public ApiResponse getUser(User user){
        ApiResponse response = given()
                .filter(new AllureRestAssured())
                .spec(baseSpec)
                .when()
                .get(Endpoints.REFER_TO_USER.getEndpoint() + user.getUsername())
                .then()
                .log().status()
                .log().body()
                .extract().as(ApiResponse.class);
        return response;
    }

    public void loginUser(User user){
        given()
                .filter(new AllureRestAssured())
                .spec(baseSpec)
                .formParam("username", user.getUsername())
                .formParam("password", user.getPassword())
                .when()
                .get(Endpoints.LOGIN_USER.getEndpoint())
                .then()
                .statusCode(200)
                .log().body();
    }

    public void logoutUser(User user){
        given()
                .filter(new AllureRestAssured())
                .spec(baseSpec)
                .when()
                .get(Endpoints.LOGOUT_USER.getEndpoint())
                .then()
                .statusCode(200);
    }

    public void deleteUser(User user){
        given()
                .filter(new AllureRestAssured())
                .spec(baseSpec)
                .when()
                .delete(Endpoints.REFER_TO_USER.getEndpoint() + user.getUsername())
                .then()
                .statusCode(200);
    }
}
