package differentTypesOfElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RadioButton {

    private WebDriver driver;

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

    }

    @Test
    public void selectRadioButton() {
        // navigate to URL
        driver.get("https://demoqa.com/radio-button");


        selectRadioButtonByName("yes");
        Assert.assertEquals("You have selected Yes",
                driver.findElement(By.cssSelector(".mt-3")).getText());

        //Thread.sleep(5000);
        selectRadioButtonByName("impressive");
        Assert.assertEquals("You have selected Impressive",
                driver.findElement(By.cssSelector(".mt-3")).getText());
        //Thread.sleep(5000);


    }

    private void selectRadioButtonByName(String s) {
        WebElement radio = driver.findElement(By.xpath("//input[contains(@id,'"+s+"')]"));

        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", radio);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
