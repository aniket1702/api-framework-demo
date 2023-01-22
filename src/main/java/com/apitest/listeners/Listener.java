package com.apitest.listeners;

import com.apitest.loggers.FrameworkLogger;
import com.apitest.loggers.LogManager;
import com.apitest.loggers.enums.LogType;
import com.apitest.report.ExtentLogger;
import com.apitest.report.ExtentReport;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.testng.*;

import java.io.IOException;

public class Listener implements ITestListener, ISuiteListener {

    @Override
    public void onStart(ISuite suite)
    {
        try
        {
            ExtentReport.initReport();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
        LogManager.propertyConfigurator();
    }

    @Override
    public void onFinish(ISuite suite)
    {
        try
        {
            ExtentReport.flushReport();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }
       
    }

    @Override
    public void onTestStart(ITestResult result)
    {
        ExtentReport.createTest(result.getMethod().getConstructorOrMethod().getMethod());
        ExtentLogger.info(result.getMethod().getMethodName()+" is Started...");
        FrameworkLogger.log(LogType.PASS,result.getMethod().getMethodName()+" is Started...");
    }

    @Override
    public void onTestSuccess(ITestResult result)
    {
        ExtentLogger.pass(result.getMethod().getMethodName()+" is Passed...");
        FrameworkLogger.log(LogType.PASS,result.getMethod().getTestClass().getName()+" - "+ result.getMethod().getMethodName()+" is Passed...");
    }
    @Override
    public void onTestFailure(ITestResult result)
    {
        ExtentLogger.fail(result.getMethod().getMethodName()+" is Failed...");
        FrameworkLogger.log(LogType.FAIL,result.getMethod().getTestClass().getName()+" - "+ result.getMethod().getMethodName()+" is Failed...");
    }

    @Override
    public void onTestSkipped(ITestResult result)
    {
        ExtentLogger.skip(result.getMethod().getMethodName()+" is Skipped...");
        FrameworkLogger.log(LogType.SKIP,result.getMethod().getMethodName()+" is SKIPPED...");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // not implemented
        
    }

    /**
     * Invoked each time a test fails due to a timeout.
     *
     * @param result <code>ITestResult</code> containing information about the run
     *               test
     */
    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        onTestFailure(result);
    }

    /**
     * Invoked before running all the test methods belonging to the classes inside
     * the &lt;test&gt; tag and calling all their Configuration methods.
     *
     * @param context The test context
     */
    @Override
    public void onStart(ITestContext context) {
        
        FrameworkLogger.log(LogType.INFO,"======================== Start :-" + context.getSuite().getName() + "========================");
    }

    /**
     * Invoked after all the test methods belonging to the classes inside the
     * &lt;test&gt; tag have run and all their Configuration methods have been
     * called.
     *
     * @param context The test context
     */
    @Override
    public void onFinish(ITestContext context) {
        
        FrameworkLogger.log(LogType.INFO,"======================== Finish :- " + context.getSuite().getName() + "========================");
    }
}
