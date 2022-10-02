package tests;

import clients.BaseSpec;
import clients.Endpoints;
import clients.UserClient;
import clients.UserMethod;
import models.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTests{

    private UserClient userClient;
    private User user;
    private UserMethod userMethod;
    ApiResponse response;

    @BeforeEach
    public void setUp(){
        userClient = new UserClient();
        userMethod = new UserMethod();
    }

    @AfterEach
    public void tearDown(){userClient.deleteUser(user);
    }

    @Test
    @DisplayName("Проверка создания пользователя")
    public void createNewUser(){
        step("Создание пользователя по модели", () -> {
            user = userMethod.createUserByModel();
            response = userClient.createUser(user);
        });

        step("Проверка сообщения ответа", () -> {
            assertThat(response.getMessage())
                    .isEqualTo("successful operation");
        });
    }

    @Test
    @DisplayName("Проверка авторизации пользователя")
    public void loginUser(){

        step("Создание пользователя", () -> {
            user = userMethod.createUserByModel();
            UserClient userClient = new UserClient();
            userClient.createUser(user);
        });

        step("Авторизация пользователя", () -> {
            userClient.loginUser(user);
        });
    }

    @Test
    @DisplayName("Проверка удаления пользователя")
    public void deleteUserTest(){

        step("Создание пользователя", () -> {
            user = userMethod.createUserByModel();
            userClient.createUser(user);
        });
        step("Удаление пользователя", () -> {
            userClient.deleteUser(user);
        });
        step("Проверка удаления пользователя", () -> {
            ApiResponse response = userClient.getUser(user);
            assertEquals(response.getMessage(), "User not found");
        });
    }

    @Test
    @DisplayName("Проверка статуса ответа при удалении несуществующего пользователя")
    public void deleteNotExistedUserTest(){
        step("Удаление несуществующего пользователя", () -> {
            given()
                    .spec(BaseSpec.baseSpec)
                    .when()
                    .delete(Endpoints.REFER_TO_USER.getEndpoint() + "cat")
                    .then()
                    .statusCode(404);
        });
    }
}
