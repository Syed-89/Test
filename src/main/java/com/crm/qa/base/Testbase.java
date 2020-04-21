package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.Testutil;
import com.crm.qa.util.WebEventListener;

public class Testbase {
	protected static WebDriver driver;
	protected static Properties pro;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public Testbase() {
		// TODO Auto-generated constructor stub
		pro= new Properties();
		try {
			FileInputStream ip= new FileInputStream("C:\\Users\\Syed Danish\\eclipse-workspace\\PomMaven\\src\\main\\java\\com\\crm\\qa\\configuration\\config.properties");
			pro.load(ip);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
		public static void initialization()
		{
			
			String browsername=pro.getProperty("Browser");
			if(browsername.equalsIgnoreCase("Chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
				driver=new ChromeDriver();
				
				
				
			}
			else
			{
				
				System.out.println("No browser found");
			}
			
			e_driver = new EventFiringWebDriver(driver);
			// Now create object of EventListerHandler to register it with EventFiringWebDriver
			eventListener = new WebEventListener();
			e_driver.register(eventListener);
			driver = e_driver;
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Testutil.Pageloadtimeout, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Testutil.implicitwait, TimeUnit.SECONDS);
			driver.get(pro.getProperty("url"));
			
			
		}
	}

