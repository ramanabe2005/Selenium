

package basicweb;

import static org.junit.Assert.*;
import basicweb.WaitTypes;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import basicweb.GeneraicMethods;
import com.gargoylesoftware.htmlunit.javascript.host.html.Option;

public class Screenshots2 {
	
	public static String getRandomString(int length){
		StringBuilder sb = new StringBuilder();
		String characters = "fdssakhfdsjhgfdshsfafdsjhdgfdshfsfdskasf";
		for(int i=0;i<length;i++)
		{
			int index = (int) Math.random() * characters.length();
			sb.append(characters.charAt(index));
		}
		return sb.toString();
	}
	
	public void takeScreenshot(WebDriver driver) throws IOException 
	
	
	{
		String fileName = getRandomString(10)+ ".png";
		String directory = "C:\\Users\\sony\\Desktop\\";
		
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File(directory+fileName));
	}
	

}
