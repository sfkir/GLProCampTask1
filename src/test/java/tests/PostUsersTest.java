package tests;

import core.BaseTest;
import helpers.FakeDataProvider;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static factory.UserFactory.userExist;
import static factory.UserFactory.validBody;
import static helpers.Constants.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertTrue;

public class PostUsersTest extends BaseTest {

    @Test
    public void createNewUserTest() {

        int id = given()
                .body(validBody().toString())
                .log()
                .all()
                .when()
                .post(PATH_USERS)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(CODE, equalTo(HttpStatus.SC_CREATED)).extract().path("data.id");

        assertTrue("User was successfully created", userExist(id));
    }

    @Test
    public void createNewUserBlankTest() {

        given()
                .body("{}")
                .log()
                .all()
                .when()
                .post(PATH_USERS)
                .then()
                .body(CODE, equalTo(HttpStatus.SC_BAD_REQUEST));
    }
}
