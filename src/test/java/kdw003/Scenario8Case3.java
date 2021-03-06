package kdw003;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.*;
import common.TestRoot;

/**
 * @author ThuHT
 */

public class Scenario8Case3 extends TestRoot {

    @BeforeEach
    public void setUp() throws Exception {
        screenshotPath = "images/kdw003/Scenario8Case3";
        this.init();
    }

    @Test
    public void test() throws Exception {
        //login
        login("016209", "Jinjikoi5");
         //kmk012 change closure 1
         
         driver.get(domain+ "nts.uk.at.web/view/kmk/012/a/index.xhtml");
         WaitPageLoad();
         driver.findElement(By.id("inpMonth")).click();
         driver.findElement(By.id("inpMonth")).clear();
         WaitElementLoad(By.id("inpMonth"));
         driver.findElement(By.id("inpMonth")).sendKeys("2019/07");
         driver.findElement(By.xpath("//body")).click();
         WaitElementLoad(By.id("btn_save"));
         driver.findElement(By.id("btn_save")).click();

        // KDW003A 勤務報告書
        driver.get(domain + "nts.uk.at.web/view/kdw/003/a/index.xhtml");
        WaitPageLoad();
       
        driver.findElement(By.xpath("//li[contains(.,'乖離シート')]")).click();
        WaitPageLoad();
        setValueGrid(8, 2, "18:00");
        Thread.sleep(700);
        WebElement el1 = driver.findElement(By.xpath("//td[contains(.,'08/07')]"));
        if (!"true".equals(el1.findElements(By.xpath("following::td")).get(0).findElement(By.xpath("label/input")).getAttribute("checked")) ) {
            el1.findElements(By.xpath("following::td")).get(0).click();
            
        } 

        WaitElementLoad(By.xpath("//button[@class='proceed']"));
        driver.findElement(By.xpath("//button[@class='proceed']")).click();
        WaitPageLoad(); 
        screenShotFull();   

        this.uploadTestLink(765, 172);

    }

    public void setValueGrid(int rowNumber, int columnNumber, String value){
        if(value.isEmpty()){
            driver.findElements(By.xpath(".//*[@class=\"mgrid-free\"]/table/tbody/tr[" + rowNumber+ "]/td[" +columnNumber + "]")).get(0).click();
            driver.findElements(By.xpath(".//*[@class=\"mgrid-free\"]/table/tbody/tr[" + rowNumber+ "]/td[" +columnNumber + "]")).get(0).click();
            driver.findElements(By.xpath(".//*[@class=\"mgrid-free\"]/table/tbody/tr[" + rowNumber+ "]/td[" +columnNumber + "]"+"/.//input")).get(0).clear();
        }else{
            driver.findElements(By.xpath(".//*[@class=\"mgrid-free\"]/table/tbody/tr[" + rowNumber+ "]/td[" +columnNumber + "]")).get(0).click();
            driver.findElements(By.xpath(".//*[@class=\"mgrid-free\"]/table/tbody/tr[" + rowNumber+ "]/td[" +columnNumber + "]")).get(0).sendKeys(value);
        }
        driver.findElement(By.xpath("//body")).click();
    }


    @AfterEach
    public void tearDown() throws Exception {
        driver.quit();
        final String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}