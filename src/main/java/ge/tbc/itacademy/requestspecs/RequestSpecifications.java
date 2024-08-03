package ge.tbc.itacademy.requestspecs;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import static ge.tbc.itacademy.data.ConstantData.BASE_URI;
import static ge.tbc.itacademy.data.ConstantData.PHONE_NUMBER_API;

public class RequestSpecifications {
    public static RequestSpecification getRequestSpecForLanguageApi() {
        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(ContentType.JSON)
                .build()
                .filter(new AllureRestAssured());
    }

    public static RequestSpecification getRequestSpecForNumberApi() {
        return new RequestSpecBuilder()
                .setBaseUri(PHONE_NUMBER_API)
                .setContentType(ContentType.JSON)
                .build()
                .filter(new AllureRestAssured());
    }
}
