package demo;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;


// import io.github.bonigarcia.wdm.WebDriverManager;
import demo.wrappers.Wrappers;

public class TestCases {
    ChromeDriver driver;

    /*
     * TODO: Write your tests here with testng @Test annotation. 
     * Follow `testCase01` `testCase02`... format or what is provided in instructions
     */

     
    /*
     * Do not change the provided methods unless necessary, they will help in automation and assessment
     */
    @BeforeTest
    public void startBrowser()
    {
        System.setProperty("java.util.logging.config.file", "logging.properties");

        // NOT NEEDED FOR SELENIUM MANAGER
        // WebDriverManager.chromedriver().timeout(30).setup();

        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("--remote-allow-origins=*");

        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "build/chromedriver.log"); 

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
    }

    @AfterTest
    public void endTest()
    {
        driver.close();
        driver.quit();

    }
    @Test
    public void testCase01() throws InterruptedException{
        driver.get("https://www.flipkart.com/");
        Wrappers wrap = new Wrappers(driver, Duration.ofSeconds(30));
        // WebElement searchBar=driver.findElement(By.xpath("//input[@class='Pke_EE']"));
        // searchBar.clear();
        // searchBar.sendKeys("Washing Machine"+Keys.ENTER);
        wrap.advanceSendKeys(By.xpath("//input[@class='Pke_EE']"), "Washing Machine");
        // driver.findElement(By.xpath("//button[@class='MJG8Up']")).click();
        // WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        // wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[1]/div/div/span")));
        wrap.advanceClick(By.xpath("//div[@class='zg-M3Z']"));
        // driver.findElement(By.xpath("//div[@class='zg-M3Z']")).click();
        Thread.sleep(2000);
        List<WebElement>rating=driver.findElements(By.xpath("//div[@class='yKfJKb row']//div[2]//div[@class='XQDdHH']"));
        int countLessThanFour=0;
        for(WebElement ratingText:rating){
            String str=ratingText.getText();
            // String[] star=str.split(" ");
            // int number=Integer.parseInt(star[0]);
            double number = Double.parseDouble(str);
            if(number<=4.0){
                countLessThanFour++;
            }
            System.out.println(str+" star "+number);
        }
        System.out.println(countLessThanFour);
    }
    @Test
    public void testCase02() throws InterruptedException{
        driver.get("https://www.flipkart.com/");
        // WebElement searchBar=driver.findElement(By.xpath("//input[@class='Pke_EE']"));
        // searchBar.clear();
        // // Thread.sleep(2000);
        // searchBar.sendKeys("iphone"+Keys.ENTER);
        Wrappers wrap = new Wrappers(driver, Duration.ofSeconds(30));
        wrap.advanceSendKeys(By.xpath("//input[@class='Pke_EE']"), "iPhone");
        // driver.findElement(By.xpath("//button[@class='MJG8Up']")).click();
        wrap.advanceClick(By.xpath("//button[@class='MJG8Up']"));
        wrap.advancedWait(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[1]/div/div/span"));
        // WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        // wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[1]/div/div/span")));
        List<WebElement>dissCount=driver.findElements(By.xpath("//div[@class='UkUFwK']"));
        List<WebElement>tittle=driver.findElements(By.xpath("//div[@class='KzDlHZ']"));
        for(WebElement ele:dissCount){
            String str=ele.getText();
            StringBuilder s=new StringBuilder();
            int i=0;
            while(true){
                if(str.charAt(i)!='%'){
                    char ch=str.charAt(i);
                    s=s.append(Character.toString(ch));
                    i++;
                }
                else{
                    break;
                }
            }
            // String s=new StringBuilder();
            // str=str.substring(0,1);
            // System.out.println(str+" per "+s);
            int per=Integer.parseInt(s.toString());
            if(per>=17){
                System.out.println(tittle.get(i).getText()+" "+per);
            }
        }
    }
    @Test
    public void testCase03() throws InterruptedException{
        driver.get("https://www.flipkart.com/");
        Wrappers wrap = new Wrappers(driver, Duration.ofSeconds(30));
        wrap.advanceSendKeys(By.xpath("//input[@class='Pke_EE']"), "Coffee Mug");
        
        // WebElement searchBar=driver.findElement(By.xpath("//input[@class='Pke_EE']"));
        // searchBar.clear();
        // // Thread.sleep(2000);
        // searchBar.sendKeys("Coffee Mug"+Keys.ENTER);
        // driver.findElement(By.xpath("//button[@class='MJG8Up']")).click();
        wrap.advanceClick(By.xpath("//button[@class='MJG8Up']"));
        wrap.advancedWait(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[1]/div/div/span"));
        // WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(30));
        // wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"container\"]/div/div[3]/div[1]/div[2]/div[1]/div/div/span")));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        // js.executeScript("arguments[0].scrollIntoView();", "//div[@class='XqNaEv']");
        js.executeScript("window.scrollBy(0,100)", "");
        WebElement filter=driver.findElement(By.xpath("//div[@class='XqNaEv']"));
        filter.click();
        Thread.sleep(2000);
        List<WebElement>imgLink=driver.findElements(By.xpath("// *[@class='Y1HWO0']//img"));
        List<WebElement>view=driver.findElements(By.xpath("//*[@class='Wphh3N']"));
        HashMap<Integer,String>mp=new HashMap<>();
        for(WebElement x : view){
            // System.out.println(x.getAttribute("src"));
            StringBuilder s=new StringBuilder(x.getText());
            StringBuilder ans=new StringBuilder();
            int i=0;
            while(true){
                Character ch=s.charAt(i);
                if(ch==')'){
                    break;
                }
                if(Character.isDigit(ch)){
                    ans=ans.append(ch);
                }
                i++;
            }
            int count=Integer.parseInt(ans.toString());
            mp.put(count, imgLink.get(i).getText());
            // System.out.println(ans);
        }
        List<Map.Entry<Integer, String>> entryList = new ArrayList<>(mp.entrySet());

        // Sort the list by values
        entryList.sort(Map.Entry.comparingByKey());
        LinkedHashMap<Integer,String> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Integer,String> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        // Output the sorted map
        System.out.println("Sorted by keys: " + sortedMap);

        
    }

}