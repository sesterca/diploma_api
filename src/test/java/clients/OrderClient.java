package clients;

import io.qameta.allure.restassured.AllureRestAssured;
import models.Order;

import static io.restassured.RestAssured.given;

public class OrderClient {

    public void placeAnOrder(Order order){
        given()
                .filter(new AllureRestAssured())
                .spec(BaseSpec.baseSpec)
                .body(order)
                .when()
                .post(Endpoints.MAKE_ORDER.getEndpoint())
                .then()
                .statusCode(200)
                .log().body();
    }

    public void getAnOrder(Order order){
        given()
                .filter(new AllureRestAssured())
                .spec(BaseSpec.baseSpec)
                .when()
                .get(Endpoints.MAKE_ORDER.getEndpoint() + "/" + order.getId())
                .then()
                .statusCode(200);
    }

    public void deleteAnOrder(Order order){
        given()
                .filter(new AllureRestAssured())
                .spec(BaseSpec.baseSpec)
                .when()
                .delete(Endpoints.MAKE_ORDER.getEndpoint() + "/" + order.getId())
                .then()
                .statusCode(200);
    }
}
