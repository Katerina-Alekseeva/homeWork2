package ru.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class FirstTest {
    protected WebDriver chromeDriver;


    public  void before() {
        System.setProperty("webdriver.chrome.driver","C:\\tmp\\chromedriver.exe");
         //  System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_DRIVER"));
        chromeDriver = new ChromeDriver();
        chromeDriver.manage().window().maximize();
        chromeDriver.manage().timeouts().implicitlyWait( 30, TimeUnit.SECONDS);
        chromeDriver.manage().timeouts().setScriptTimeout(5000,
                TimeUnit.MILLISECONDS);

    }

    public void closeTest() {
           chromeDriver.close();
    }
}

