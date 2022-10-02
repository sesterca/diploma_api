package clients;

import clients.BaseSpec;
import clients.Endpoints;
import models.Pet;

import static io.restassured.RestAssured.given;

public class PetClient extends BaseSpec {

    public void createPet(Pet pet){
        given()
                .spec(baseSpec)
                .body(pet)
                .when()
                .post(Endpoints.PETS.getEndpoint())
                .then()
                .statusCode(200)
                .log().body();
    }

    public void changePet(Pet pet){

    }
}
