package clients;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class BaseSpec {

    public static RequestSpecification baseSpec = with()
            .baseUri("https://petstore.swagger.io/")
            .basePath("/v2")
            .header("apiKey","special-key")
            .contentType(ContentType.JSON)
            .log().uri()
            .log().body();
}
