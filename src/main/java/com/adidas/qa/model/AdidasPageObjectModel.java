package com.adidas.qa.model;


import com.adidas.qa.TestProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.concurrent.TimeUnit;

/**
 * Created by dmontero on 15/12/17.
 */
public class AdidasPageObjectModel {

    public static WebDriver driver;
    public String title;


    public AdidasPageObjectModel(){
        switch(System.getProperty("browser")+""){

            case "FF":
                FirefoxProfile profile = new FirefoxProfile();

                profile.setPreference("intl.accept_languages","en");
                driver=new FirefoxDriver();
                break;
            case "chrome":
                ChromeOptions options = new ChromeOptions();

                options.addArguments("–lang= en");
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/chromedriver"
                        +(System.getProperty("os.name").toLowerCase().contains("windows")?".exe":""));
                driver=new ChromeDriver();
                break;
            default:
                ChromeOptions optionsdef = new ChromeOptions();
                optionsdef.addArguments("–lang= en");
                System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/chromedriver"
                        +(System.getProperty("os.name").toLowerCase().contains("windows")?".exe":""));
                driver=new ChromeDriver();
                break;

        }
        driver.manage().deleteCookieNamed("adidas.fi");
        driver.manage().deleteCookieNamed("adidas.co.uk");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get(TestProperties.base_url);
        driver.findElement(By.cssSelector("#truste-consent-button > img")).click();


        title=driver.getTitle();

    }

    public void selectLanguageLocator(String language){
        driver.findElement(By.cssSelector(TestProperties.language_locator.replace("#lang",language))).click();
    }

    public void quit(){
        driver.manage().deleteCookieNamed("adidas.fi");
        driver.manage().deleteCookieNamed("adidas.co.uk");
        driver.quit();
    }

    public void clickMenLocator(){
        driver.findElement(By.cssSelector(TestProperties.men_locator)).click();
    }

    public String getLocation(){
        return driver.getCurrentUrl();
    }

    public void clickWomenLocator() {
        driver.findElement(By.cssSelector(TestProperties.women_locator)).click();
    }

    public void clickKidsLocator() {
        driver.findElement(By.cssSelector(TestProperties.kids_locator)).click();
    }

    public void clickCustomiseLocator() {
        driver.findElement(By.cssSelector(TestProperties.customise_locator)).click();
    }
}
