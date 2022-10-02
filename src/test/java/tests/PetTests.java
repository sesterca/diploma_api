package tests;

import clients.Endpoints;
import clients.PetClient;
import io.qameta.allure.restassured.AllureRestAssured;
import models.Pet;
import models.PetCategory;
import models.PetStatus;
import models.Tag;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static clients.BaseSpec.baseSpec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class PetTests{

    public PetClient petClient;
    Pet cat;

    @Test
    @DisplayName("Создание питомца")
    public void createPet(){
        cat = new Pet();
        PetCategory category = new PetCategory();
        category.setId(1);
        category.setName("cats");
        cat.setId(100);
        cat.setName("Murka");
        cat.setCategory(category);
        cat.setTag(new Tag());

        step("Создание питомца", () -> {
            petClient = new PetClient();
            petClient.createPet(cat);
        });
    }

    @ParameterizedTest
    @DisplayName("Получение списка питомцев")
    @EnumSource(PetStatus.class)
    public void getPetsList(PetStatus status){
        step("Получение списка питомцев", () -> {
            given()
                    .filter(new AllureRestAssured())
                    .spec(baseSpec)
                    .formParam("status", status.getStatus())
                    .when()
                    .get(Endpoints.GET_PETS.getEndpoint())
                    .then()
                    .log().body()
                    .statusCode(200)
                    .body(is(notNullValue()));
        });
    }
}
