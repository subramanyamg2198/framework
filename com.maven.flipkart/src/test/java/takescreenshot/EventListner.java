 package takescreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.genericlib.Base;

public class EventListner implements ITestListener
{
public void onTestFailure(ITestResult r)
{
	Date d=new Date();
	String date=d.toString().replaceAll(":", "_");
	String methodName=r.getMethod().getMethodName();
	
	EventFiringWebDriver fire=new EventFiringWebDriver(Base.listnerdriver);
	
	File src=fire.getScreenshotAs(OutputType.FILE);
	
	File dest=new File("C:\\Users\\subbu\\Desktop\\google"+date+".png");
	
	try {
		FileUtils.copyFile(src, dest);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
}

public void onTestStart(ITestResult result) {
	// TODO Auto-generated method stub
	
}

public void onTestSuccess(ITestResult result) {
	// TODO Auto-generated method stub
	
}

public void onTestSkipped(ITestResult result) {
	// TODO Auto-generated method stub
	
}

public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// TODO Auto-generated method stub
	
}

public void onStart(ITestContext context) {
	// TODO Auto-generated method stub
	
}

public void onFinish(ITestContext context) {
	// TODO Auto-generated method stub
	
}
}
