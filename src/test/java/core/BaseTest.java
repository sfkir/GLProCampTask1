package core;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeAll;

import java.util.logging.Logger;

import static helpers.Constants.*;
import static io.restassured.RestAssured.baseURI;

public class BaseTest {

    private static Logger Log = Logger.getLogger(BaseTest.class.getName());

    static String baseURI = "https://gorest.co.in/public-api";

    private final static RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri(baseURI)
            .build()
            .header(AUTHORIZATION, BEARER_TOKEN.concat(TOKEN))
            .contentType(ContentType.JSON)
            .relaxedHTTPSValidation();

    @BeforeAll
    public static void before() {
        Log.info("---Before All - setting request spec");
        baseURI = "https://gorest.co.in/public-api";
        RestAssured.requestSpecification = requestSpecification;
    }

}
