package com.genericlib.demoblaze;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;

public class EventList implements ITestListener {

	public void onTestFailure(ITestResult result) {
		File src = ((TakesScreenshot)Base.driver).getScreenshotAs(OutputType.FILE);
		File dst=new File("Test Report/Screenshots/"+System.currentTimeMillis()+".png");
		String ss=dst.getAbsolutePath();
		try {
			FileUtils.copyFile(src, dst);
		} catch (IOException e) {
			e.printStackTrace();
		}
		Base.test.fail(result.getThrowable().toString(), MediaEntityBuilder.createScreenCaptureFromPath(ss).build());
	}
	
}
