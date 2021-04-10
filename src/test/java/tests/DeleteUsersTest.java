package tests;

import core.BaseTest;
import model.UserModel;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;


import java.util.List;

import static factory.UserFactory.getUser;
import static factory.UserFactory.userNotExist;
import static helpers.Constants.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertTrue;


public class DeleteUsersTest extends BaseTest {

    @Test
    public void deleteUserTest() {

        List<UserModel> userModelList = getUser();
        int idUser = userModelList.get(0).getId();

        given()
                .pathParam(ID, idUser)
                .when()
                .delete(PATH_USERS_ID)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(CODE, equalTo(HttpStatus.SC_NO_CONTENT));

        assertTrue("User with id " + idUser + " was not deleted", userNotExist(idUser));
    }

    @Test
    public void deleteUserNotExistTest() {

        given()
                .pathParam(ID, INVALID_ID)
                .when()
                .delete(PATH_USERS_ID)
                .then()
                .body(CODE, equalTo(HttpStatus.SC_NOT_FOUND));
    }

}
