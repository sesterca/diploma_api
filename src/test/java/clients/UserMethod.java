package clients;

import com.github.javafaker.Faker;
import models.User;

public class UserMethod {

    User user = new User();
    Faker faker = new Faker();

    public User createUserByModel(){
        user.setId(faker.number().numberBetween(1, 10000));
        user.setUsername(faker.cat().name());
        user.setFirstName(faker.name().firstName());
        user.setLastName(faker.name().lastName());
        user.setEmail(faker.internet().emailAddress());
        user.setPassword(faker.internet().password());
        user.setPhone(faker.phoneNumber().phoneNumber());
        user.setUserStatus(1);
        return user;
    }


}
