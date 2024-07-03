package com.ahq.listeners;

import com.ahq.internal.ExtentReportManager;
import com.ahq.internal.StringManipulation;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.qmetry.qaf.automation.step.TestStep;
import com.qmetry.qaf.automation.step.client.Scenario;
import com.qmetry.qaf.automation.ui.WebDriverTestBase;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebDriver;
import org.openqa.selenium.OutputType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.util.*;

import static com.qmetry.qaf.automation.core.ConfigurationManager.getBundle;


    public class TestListener implements ITestListener {

        private static final ThreadLocal<List<String>> threadedCompleteStepDescriptionList = new ThreadLocal<>();
        private static final ThreadLocal<List<String>> threadedTestCategories = new ThreadLocal<>();

        @Override
        public void onTestStart(ITestResult iTestResult) {
            Object instance = iTestResult.getInstance();
            if (instance instanceof Scenario) {
                assignParametersToBundleProperties(iTestResult.getParameters());
                Scenario scenario = (Scenario) instance;
                threadedCompleteStepDescriptionList.set(new ArrayList<>());
                for (TestStep step : scenario.getSteps()) {
                    threadedCompleteStepDescriptionList.get().add(step.getDescription());
                }
                try {
                    ExtentReportManager.createTest(iTestResult.getMethod().getMethodName());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }                Map<String, Object> metaData = scenario.getMetadata();
                // Iterate through the map
                threadedTestCategories.set(new ArrayList<>());
                for (Map.Entry<String, Object> entry : metaData.entrySet()) {
                    String key = entry.getKey();
                    String value = entry.getValue().toString();
                    // Check if the key contains "TestCaseId"
                    if (key.contains("TestCaseId")) {
                        threadedTestCategories.get().add(value);
                    }
                }
                StepListener.threadedExtentTestNodes.set(new ArrayList<>());
                StepListener.threadedExecutedTestSteps.set(new ArrayList<>());
            } else {
                System.out.println("The object is not an instance of a feature Scenario. Extent Report will not be created.");
            }
        }

        private void assignParametersToBundleProperties(Object[] parameters) {
            LinkedHashMap<String, Object> parameterMap;
            if (parameters != null && parameters.length > 0 && parameters[0] instanceof LinkedHashMap) {
                parameterMap = (LinkedHashMap<String, Object>) parameters[0];
                for (Map.Entry<String, Object> entry : parameterMap.entrySet()) {
                    getBundle().setProperty(entry.getKey(), entry.getValue());
                }
            }
        }

        @Override
        public void onTestSuccess(ITestResult iTestResult) {
            if (ExtentReportManager.getTest() != null) {
                logReportSteps();
                ExtentReportManager.getTest().pass(MarkupHelper.createLabel("Test Passed", ExtentColor.GREEN));
                logTestCategories();
            }
        }

        @Override
        public void onTestFailure(ITestResult iTestResult) {
            if (ExtentReportManager.getTest() != null) {
                logReportSteps();
                ExtentReportManager.getTest().fail(MarkupHelper.createLabel("Test Failed", ExtentColor.RED));
                QAFWebDriver driver = new WebDriverTestBase().getDriver();
                ExtentReportManager.getTest().addScreenCaptureFromBase64String(driver.getScreenshotAs(OutputType.BASE64));
                logTestCategories();
            }
        }

        @Override
        public void onTestSkipped(ITestResult iTestResult) {
            if (ExtentReportManager.getTest() != null) {
                logReportSteps();
                Throwable throwable = iTestResult.getThrowable();
                if (throwable != null) {
                    ExtentReportManager.getTest().skip(throwable);
                } else {
                    ExtentReportManager.getTest().skip(MarkupHelper.createLabel("Test Skipped", ExtentColor.ORANGE));
                }
                QAFWebDriver driver = new WebDriverTestBase().getDriver();
                ExtentReportManager.getTest().addScreenCaptureFromBase64String(driver.getScreenshotAs(OutputType.BASE64));
                logTestCategories();
            }
        }

        @Override
        public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        }

        @Override
        public void onStart(ITestContext iTestContext) {
            if (iTestContext.getName().toLowerCase().contains("smoke")) {
                System.out.println("Executing Smoke Test suite...");
                getBundle().setProperty("suite", "smoke");
            } else if (iTestContext.getName().toLowerCase().contains("regression")) {
                System.out.println("Executing Regression Test suite...");
                getBundle().setProperty("suite", "regression");
            } else {
                System.out.println("Executing Test suite...");
            }
        }

        @Override
        public void onFinish(ITestContext iTestContext) {
            try {
                ExtentReportManager.flushReports();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        private void logReportSteps() {
            if (!StepListener.threadedExecutedTestSteps.get().isEmpty()) {
                threadedCompleteStepDescriptionList.get().subList(0, StepListener.threadedExecutedTestSteps.get().size())
                        .clear();
            }
            if (!threadedCompleteStepDescriptionList.get().isEmpty()) {
                ExtentTest skippedNode = ExtentReportManager.getTest().createNode("Skipped Steps");
                for (String stepDescription : threadedCompleteStepDescriptionList.get()) {
                    skippedNode.skip(StringManipulation.cleanBDDActions(stepDescription));
                }
            }
            StepListener.threadedExecutedTestSteps.get().clear();
            threadedCompleteStepDescriptionList.get().clear();
        }

        private void logTestCategories() {
            if (!threadedTestCategories.get().isEmpty()) {
                for (String category : threadedTestCategories.get()) {
                    ExtentReportManager.getTest().assignCategory(category);
                }
            }
            threadedTestCategories.get().clear();
        }
    }