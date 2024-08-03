package ge.tbc.itacademy.steps.commonsteps;

import ge.tbc.itacademy.requestspecs.RequestSpecifications;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static ge.tbc.itacademy.data.ConstantData.NUMBER_PATH;

public class PhoneFormatDetectionApiSteps {
    private final RequestSpecification requestSpec;
    private static final Properties properties = new Properties();

    public PhoneFormatDetectionApiSteps() {
        this.requestSpec = RequestSpecifications.getRequestSpecForNumberApi();
    }

    @Step("Load API key from properties file")
    public void getPropertie() {
        try {
            properties.load(new FileInputStream("src/main/resources/key.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Send phone number format detection API request for number: {text}")
    public Response getNumberResponse(String number) {
        String key = properties.getProperty("LANGUAGE.API.KEY");
        return RestAssured.given()
                .spec(requestSpec)
                .queryParam("access_key", key)
                .queryParam("number", number)
                .get(NUMBER_PATH);
    }

    @Step("get result")
    public boolean getResult(Response response) {
        return response.jsonPath().getBoolean("valid");
    }
}
