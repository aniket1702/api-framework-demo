package com.apitest.httpmethods.post;

import com.apitest.base.RequestResponseSpecification;
import com.apitest.endpoints.Endpoints;
import com.apitest.payloads.Payload;
import com.apitest.report.ExtentLogger;
import com.apitest.utils.commons.VerifyResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class POST_StudentDetails {

    @Test(testName = "Create student details")
    public void createStudentDetails()
    {
        Response response= RestAssured
                .given()
                    .spec(RequestResponseSpecification.requestBuilder())
                .when()
                    .body(Payload.setValues())
                    .post(Endpoints.CREATE_STUDENTS)
                .then()
                    .spec(RequestResponseSpecification.responseBuilder())
                    .extract().response();
    
        ExtentLogger.logResponse(response.getHeaders().asList(),response.asPrettyString());
        VerifyResponse.statusCode(response,201);
        VerifyResponse.verifyJsonKey(response,"name");
        //ExtentLogger.info("<pre>"+ JsonWriter.formatJson(response.asPrettyString())+"</pre>");
        

    }

}
