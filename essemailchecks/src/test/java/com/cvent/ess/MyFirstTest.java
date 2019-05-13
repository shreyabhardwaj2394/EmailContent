package com.cvent.ess;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;
import java.io.File;

public class MyFirstTest {

    public WebDriver setDriver()  {
        File chromeDriver = new File("./src/main/resources/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", chromeDriver.getAbsolutePath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-extensions");
        options.addArguments("disable-infobars");
        // options.addArguments("auth-server-whitelist=" +
        // StringUtils.join(whiteListUrls, "*,"));
        return new ChromeDriver(options);
    }
    @Test
    public void startWebDriver(){
        WebDriver driver=setDriver();
        driver.get("https://twitter.com/stepin_forum");
        driver.close();
        driver.quit();
    }
}
