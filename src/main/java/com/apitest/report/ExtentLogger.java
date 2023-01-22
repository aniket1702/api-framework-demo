package com.apitest.report;

import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.restassured.http.Header;

import java.util.List;
import java.util.Map;

public final class ExtentLogger {
    private ExtentLogger(){}
    
    public static void pass(String message)
    {
        ExtentReportManager.getExtentTest().pass(message);
    }
    
    public static void pass(List<String> message)
    {
        ExtentReportManager.getExtentTest().pass(MarkupHelper.createUnorderedList(message).getMarkup());
    }
    
    public static void pass(Map<String,Integer> message)
    {
        ExtentReportManager.getExtentTest().pass(MarkupHelper.createUnorderedList(message).getMarkup());
    }
    
    public static void fail(String message)
    {
        ExtentReportManager.getExtentTest().fail(message);
    }
    
    public static void skip(String message)
    {
        ExtentReportManager.getExtentTest().skip(message);
    }
    
    public static void info(String message)
    {
        ExtentReportManager.getExtentTest().info(message);
    }
    
    private static void logJson(String response)
    {
        ExtentReportManager.getExtentTest().info(MarkupHelper.createCodeBlock(response, CodeLanguage.JSON));
    }
    
    private static void logHeaders(List<Header> headersList)
    {
        String[][] arrayHeaders = headersList.stream().map(header -> new String[] {header.getName(), header.getValue()}).toArray(String[][] :: new);
        ExtentReportManager.getExtentTest().info(MarkupHelper.createTable(arrayHeaders));
    }
    
    public static void logResponse(List<Header> headersList,String response)
    {
        logHeaders(headersList);
        logJson(response);
    }
}
