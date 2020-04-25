package com.signinpage.using_listener_demo;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.goibibo.keywords.Keywords;

public class ListenerTest implements ITestListener{

	@Override
	public void onFinish(ITestContext arg0) {
		
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		
	}

	@Override
	public void onTestFailure(ITestResult Result) {
		//System.out.println("The name of the testcase failed is :"+Result.getName());
		System.out.println("Take Screenshot on Test Failed");
		Keywords.takeAScreenshot(Result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSkipped(ITestResult Result) {
		 System.out.println("The name of the testcase Skipped is :"+Result.getName());					
	}

	@Override
	public void onTestStart(ITestResult Result) {
		System.out.println(Result.getName()+" test case started");					
	}

	@Override
	public void onTestSuccess(ITestResult Result) {
		 System.out.println("The name of the testcase passed is :"+Result.getName());		
	}

}
