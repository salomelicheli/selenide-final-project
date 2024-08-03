package ge.tbc.itacademy.steps.commonsteps;

import ge.tbc.itacademy.requestspecs.RequestSpecifications;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static ge.tbc.itacademy.data.ConstantData.PATH;

public class LanguageDetectApiSteps {
    private final RequestSpecification requestSpec;
    private static final Properties properties = new Properties();

    public LanguageDetectApiSteps() {
        requestSpec = RequestSpecifications.getRequestSpecForLanguageApi();
    }

    @Step("Load API key from properties file")
    public void getPropertie() {
        try {
            properties.load(new FileInputStream("src/main/resources/key.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Send language detection API request for text: {text}")
    public Response getLanguageResponse(String text) {
        String key = properties.getProperty("API.KEY");
        return RestAssured.given()
                .spec(requestSpec)
                .header("Authorization", "Token " + key)
                .body("{\"text\":\"" + text + "\"}")
                .post(PATH);
    }

    @Step("Check status code of API response")
    public void checkStatusCode(Response response) {
        response.then()
                .statusCode(200);
    }

    @Step("Extract language code from API response JSON")
    public String codeOfLanguage(String jsonString) {
        JSONObject jsonObj = new JSONObject(jsonString);
        JSONArray jsonArray = jsonObj.getJSONArray("languages");
        JSONObject languageObject = jsonArray.getJSONObject(0);
        return languageObject.keys().next();
    }
}
