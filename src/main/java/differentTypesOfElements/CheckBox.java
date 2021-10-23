package differentTypesOfElements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckBox {

    private WebDriver driver;

    @BeforeTest
    public void setUp(){
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();

    }

    @Test
    public void selectCheckBox() {

        // navigate to URL
        driver.get("https://demoqa.com/checkbox");


        //Expand all check box

        driver.findElement(By.xpath("//button[@title='Expand all']")).click();

        // select desktop, react, public, wordFile

        selectCheckboxByName("desktop");

        selectCheckboxByName("react");

        selectCheckboxByName("public");

        selectCheckboxByName("wordFile");



        //Thread.sleep(10000);




    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    private void selectCheckboxByName(String checkBoxLabel){
        driver.findElement(By
                .xpath("//label[@for='tree-node-"+checkBoxLabel+"']/span[@class='rct-checkbox']"))
                .click();
    }

}
