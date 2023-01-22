package com.apitest.httpmethods.get;

import com.apitest.base.RequestResponseSpecification;
import com.apitest.endpoints.Endpoints;
import com.apitest.report.ExtentLogger;
import com.apitest.utils.commons.VerifyResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class GET_StudentDetails {

    @Test(testName = "Get All student details")
    public void getStudentDetails() {
        Response response= RestAssured
                .given()
                    .spec(RequestResponseSpecification.requestBuilder())
                    .get(Endpoints.READ_STUDENTS_DETAILS)
                .then()
                .spec(RequestResponseSpecification.responseBuilder())
                    .extract()
                    .response();
    
        ExtentLogger.logResponse(response.getHeaders().asList(),response.asPrettyString());
        VerifyResponse.getResponseLength(response);
        VerifyResponse.statusCode(response,200);
        VerifyResponse.verifyJsonKey(response,"address.street");
     
       
    }


}
