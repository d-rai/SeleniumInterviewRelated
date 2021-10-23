package differentTypesOfElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;

public class TextBox {
    private WebDriver driver;

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

    }

    @Test
    public void fillForm() throws InterruptedException {
        // navigate to URL
        driver.get("https://demoqa.com/text-box");


        // Enter value in Text Box
        driver.findElement(By.id("userName")).sendKeys("testUser");


        driver.findElement(By.id("userEmail")).sendKeys("testUser@test.com");


        driver.findElement(By.id("currentAddress")).sendKeys("testUserAddress");

        driver.findElement(By.id("permanentAddress")).sendKeys("testUserPermanentAddress");

        driver.findElement(By.id("submit")).click();

        // verify texts entered successfully or not

        Assert.assertEquals("testUser", driver.findElement(By.id("name")).getText().split(":")[1]);
        Assert.assertEquals("testUser@test.com", driver.findElement(By.id("email")).getText().split(":")[1]);

        Assert.assertEquals("testUserAddress", driver.findElement(By.cssSelector("p[id='currentAddress']")).getText().split(":")[1]);
        Assert.assertEquals("testUserPermanentAddress", driver.findElement(By.cssSelector("p[id='permanentAddress']")).getText().split(":")[1]);

    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
