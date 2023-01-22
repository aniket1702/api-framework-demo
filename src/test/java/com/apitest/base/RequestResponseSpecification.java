package com.apitest.base;

import com.apitest.config.ConfigFactory;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class RequestResponseSpecification {
    protected RequestResponseSpecification(){}

    static RequestSpecification requestSpecification;
    static ResponseSpecification responseSpecification;


    @BeforeMethod
    public static RequestSpecification requestBuilder() {

        RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
        requestSpecBuilder.setBaseUri(ConfigFactory.getConfig().baseURI())
                .setContentType(ContentType.JSON)
                .log(LogDetail.PARAMS)
                .log(LogDetail.URI)
                .log(LogDetail.HEADERS)
                .log(LogDetail.COOKIES);

        requestSpecification = requestSpecBuilder.build();

        return requestSpecification;
    }

    @AfterMethod
    public static ResponseSpecification responseBuilder() {

        ResponseSpecBuilder responseSpecBuilder = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .log(LogDetail.BODY);

        responseSpecification = responseSpecBuilder.build();

        return responseSpecification;

    }

}
