package clients;

import io.qameta.allure.restassured.AllureRestAssured;
import models.Pet;

import static io.restassured.RestAssured.given;

public class PetClient extends BaseSpec {

    public void createPet(Pet pet){
        given()
                .filter(new AllureRestAssured())
                .spec(baseSpec)
                .body(pet)
                .when()
                .post(Endpoints.PETS.getEndpoint())
                .then()
                .statusCode(200)
                .log().body();
    }
}
