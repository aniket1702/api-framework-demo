package com.apitest.httpmethods.delete;

import com.apitest.base.RequestResponseSpecification;
import com.apitest.endpoints.Endpoints;
import com.apitest.report.ExtentLogger;
import com.apitest.utils.commons.VerifyResponse;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class DELETE_StudentDetails {

    @Test(testName="Delete Student Details")
    public void deleteStudentdetails()
    {
        Response response= RestAssured
                .given()
                    .spec(RequestResponseSpecification.requestBuilder())
                    .pathParam("id",2)
                .when()
                    .delete(Endpoints.DELETE_STUDENT_DETAILS)
                .then()
                    .spec(RequestResponseSpecification.responseBuilder())
                    .extract().response();
    
        ExtentLogger.logResponse(response.getHeaders().asList(),response.asPrettyString());
        VerifyResponse.statusCode(response,200);
        
                
    }

}
