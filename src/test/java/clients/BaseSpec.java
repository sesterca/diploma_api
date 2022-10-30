package clients;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class BaseSpec {

    String baseUri = "https://petstore.swagger.io/";

    public static RequestSpecification baseSpec = with()
            .baseUri(baseURI)
            .basePath("/v2")
            .header("apiKey","special-key")
            .contentType(ContentType.JSON)
            .log().uri()
            .log().body();
}
