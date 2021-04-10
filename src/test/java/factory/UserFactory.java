package factory;

import model.UserModel;
import org.apache.http.HttpStatus;
import org.json.JSONObject;

import java.util.List;

import static helpers.Constants.*;
import static helpers.FakeDataProvider.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class UserFactory {
    public static JSONObject validBody() {
        JSONObject userJson = new JSONObject();
        userJson.accumulate("name", fakeName());
        userJson.accumulate("email", fakeEmail());
        userJson.accumulate("gender", gender());
        userJson.accumulate("status", status());
        return userJson;
    }

    public static List<UserModel> getUser() {
        List<UserModel> userModelList = given()
                .when()
                .get(PATH_USERS)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(CODE, equalTo(HttpStatus.SC_OK)).extract().jsonPath().getList("data", UserModel.class);
        return userModelList;
    }

    public static boolean userExist(int id) {
        given()
                .pathParam(ID, id)
                .when()
                .get(PATH_USERS_ID)
                .then()
                .statusCode(HttpStatus.SC_OK)
                .body(CODE, equalTo(HttpStatus.SC_OK));
        return true;
    }

    public static boolean userNotExist(int id) {
        given()
                .pathParam(ID, id)
                .when()
                .get(PATH_USERS_ID)
                .then()
                .body(CODE, equalTo(HttpStatus.SC_NOT_FOUND));
        return true;
    }
}
