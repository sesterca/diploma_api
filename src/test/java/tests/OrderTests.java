package tests;

import clients.*;

import models.Order;
import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class OrderTests{

    private UserClient userClient;
    private User user;
    private UserMethod userMethod;
    Order order;
    OrderClient orderClient;

    @BeforeEach
    public void setUp(){
        userClient = new UserClient();
        userMethod = new UserMethod();
        orderClient = new OrderClient();
    }

    @Test
    @DisplayName("Оформление заказа на питомца")
    public void orderPetTest(){

        step("Создание покупателя", () -> {
            user = userMethod.createUserByModel();
            userClient.createUser(user);
            userClient.loginUser(user);
        });

        step("Заказ питомца", () -> {
            order = new Order();
            order.setId(105);
            order.setPetId(9809680);
            order.setQuantity(1);
            orderClient.placeAnOrder(order);
        });
    }

    @Test
    @DisplayName("Проверка информации о заказе")
    public void getOrderInfo(){

        user = userMethod.createUserByModel();
        userClient.createUser(user);
        userClient.loginUser(user);

        step("Заказ питомца", () -> {
            Order order = new Order();
            order.setId(105);
            order.setPetId(9809680);
            order.setQuantity(1);
            orderClient = new OrderClient();
            orderClient.placeAnOrder(order);
        });

        step("Получение данных о заказе", () -> {
            orderClient.getAnOrder(order);
        });
    }
}
