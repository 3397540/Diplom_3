package site.nomoreparties.stellarburgers.utils;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import site.nomoreparties.stellarburgers.dto.ExtendedUser;

import static io.restassured.RestAssured.given;

public class HTTPRequestRequestClient extends HTTPRequestConfig {

    @Step("Send POST request to \"{endpoint}\" without auth")
    public Response sendPostRequest(String endpoint, Object body) {
        return given()
                .config(config)
                .spec(requestSpec())
                .body(body)
                .post(endpoint)
                .thenReturn();
    }

    @Step("Send DELETE request to \"{endpoint}\" with auth token")
    public Response sendDeleteWAuthRequest(String endpoint, String token) {
        return given()
                .config(config)
                .spec(requestSpec())
                .auth().oauth2(token)
                .delete(endpoint)
                .thenReturn();
    }

    @Step("Deserialize response as ExtendedUser object and add password")
    public ExtendedUser deserializeResponseAsExtendedUserObject(Response response, String password) {
        ExtendedUser extendedUser = response
                .then()
                .extract()
                .body().as(ExtendedUser.class);
        extendedUser.setUserPassword(password);
        return extendedUser;
    }
}
