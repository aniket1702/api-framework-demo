package com.apitest.utils.commons;

import com.apitest.loggers.FrameworkLogger;
import com.apitest.loggers.enums.LogType;
import com.apitest.report.ExtentLogger;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class VerifyResponse {
    private VerifyResponse(){

    }

    public static void statusCode(Response response,int expectedStatusCode)
    {
        int actualStatusCode=response.getStatusCode();
        String ACTUAL_STATUS_CODE="ACTUAL STATUS CODE";
        String EXPECTED_STATUS_CODE="EXPECTED STATUS CODE";
        
        try
        {
            if(response.getBody()!=null)
            {
                Assert.assertEquals(actualStatusCode,expectedStatusCode);
                if(actualStatusCode==expectedStatusCode)
                {
                    Map<String,Integer> map=new HashMap<>();
                    map.put(ACTUAL_STATUS_CODE,actualStatusCode);
                    map.put(EXPECTED_STATUS_CODE,expectedStatusCode);
                    
                    ExtentLogger.pass(map);
                    FrameworkLogger.log(LogType.PASS,ACTUAL_STATUS_CODE+actualStatusCode+EXPECTED_STATUS_CODE+expectedStatusCode);
                }
                else
                {
                    ExtentLogger.fail(ACTUAL_STATUS_CODE+actualStatusCode+EXPECTED_STATUS_CODE+expectedStatusCode);
                    FrameworkLogger.log(LogType.FAIL,ACTUAL_STATUS_CODE+actualStatusCode+EXPECTED_STATUS_CODE+expectedStatusCode);
                }
            }
        }
        catch (AssertionError | Exception error)
        {
            ExtentLogger.fail(error.getMessage());
            FrameworkLogger.log(LogType.FAIL, error.getMessage());
        }


    }

    public static void verifyJsonKey(Response response,String keyParam)
    {
        if(response.getBody()!=null){

            try
            {
                List<String> responseList=new ArrayList<>();
                responseList.addAll(response.jsonPath().get(keyParam));
               
                
                ExtentLogger.pass(responseList);
                FrameworkLogger.log(LogType.PASS, keyParam+":: "+response.jsonPath().get(keyParam));
            }
            catch (AssertionError | Exception error)
            {
                ExtentLogger.fail(error.fillInStackTrace().toString());
                FrameworkLogger.log(LogType.FAIL,error.fillInStackTrace().toString());
            }
        }
        else{
            ExtentLogger.fail(keyParam+" is not present");
            FrameworkLogger.log(LogType.FAIL,keyParam+" is not present");
        }
    }
    
    public static void getResponseLength(Response response)
    {
        if(response.getBody()!=null)
        {
            try
            {
                JsonPath jsonPath=new JsonPath(response.asString());
                int jsonSize=jsonPath.getInt("student.size()");
                ExtentLogger.pass("Length of Json Array/Object: "+jsonSize);
            }
            catch (Exception exception)
            {
                ExtentLogger.fail(exception.fillInStackTrace().toString());
            }
        }
    }
}
