package demo.wrappers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Wrappers {
    private WebDriver driver;
    private WebDriverWait wait;
    private Duration timeOut;
    public Wrappers(WebDriver driver,Duration timeOut){
        this.driver=driver;
        this.timeOut=timeOut;
        wait = new WebDriverWait(driver, timeOut);
    }
    public boolean advanceSendKeys(By locator,String keysToSend){
        try{
            WebElement elem = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            elem.clear();
            elem.sendKeys(keysToSend);
            elem.sendKeys(Keys.ENTER);
            return true;
        }
        catch(Exception e){
            System.out.println("Element is not Present");
            return false;
        }
    }
    public boolean advanceClick(By locator){
        try{
            WebElement elem = wait.until(ExpectedConditions.elementToBeClickable(locator));
            elem.click();
            return true;
        }
        catch(Exception e){
            System.out.println("Element is not clickable or not present");
            return false;
        }
    }
    public void advancedWait(By locator){
        try{

            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        }
        catch(Exception ex){
            System.out.println("error "+ex);
        }

    }
}
