package interview;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.*;

public class Waits {

       // created reference variable for WebDriver
       WebDriver drv;
       @BeforeTest
       public void setup() throws InterruptedException {

   		String current_path =System.getProperty("user.dir");
   		System.setProperty("webdriver.chrome.driver",current_path+"\\Drivers\\chromedriver.exe");
              // initializing drv variable using FirefoxDriver
              drv=new ChromeDriver();
              // launching gmail.com on the browser
              drv.get("https://gmail.com");
              // maximized the browser window
              drv.manage().window().maximize();
              drv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       }

       @Test
       public void test() throws InterruptedException {

              // saving the GUI element reference into a "username" variable of WebElement type
              WebElement username = drv.findElement(By.id("Email"));

              // entering username
              username.sendKeys("shruti.shrivastava.in");

              // entering password
              drv.findElement(By.id("Passwd")).sendKeys("password");

              // clicking signin button
              drv.findElement(By.id("signIn")).click();

              // explicit wait - to wait for the compose button to be click-able
              WebDriverWait wait = new WebDriverWait(drv,30);

         wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'COMPOSE')]")));
              // click on the compose button as soon as the "compose" button is visible
       drv.findElement(By.xpath("//div[contains(text(),'COMPOSE')]")).click();
       }

       @AfterTest
       public void teardown() {
       // closes all the browser windows opened by web driver
   drv.quit();     
       }
} 