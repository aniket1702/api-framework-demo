package com.apitest.httpmethods.get;

import com.apitest.base.RequestResponseSpecification;
import com.apitest.endpoints.Endpoints;
import com.apitest.report.ExtentLogger;
import com.apitest.utils.commons.VerifyResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GET_SingleStudentDetails {

    @Test(testName = "Get Single student details")
    public void getSingleStudentDetail() {
        Response response= RestAssured
                .given()
                    .spec(RequestResponseSpecification.requestBuilder())
                    .queryParam("id",6)
                .when()
                    .get(Endpoints.READ_STUDENTS_DETAILS)
                .then()
                    .spec(RequestResponseSpecification.responseBuilder())
                    .extract()
                    .response();
    
        ExtentLogger.logResponse(response.getHeaders().asList(), response.asString());
        VerifyResponse.getResponseLength(response);
        VerifyResponse.statusCode(response,200);
        VerifyResponse.verifyJsonKey(response,"address.street");
        //ExtentLogger.info("<pre>"+ JsonWriter.formatJson(response.asPrettyString())+"</pre>");
        
        
    }
}
