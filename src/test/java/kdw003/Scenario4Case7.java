package kdw003;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.*;
import common.TestRoot;

public class Scenario4Case7 extends TestRoot {

    String inpMonth = "inpMonth";// id
    String btnsave = "btn_save";// id

    @BeforeEach
    public void setUp() throws Exception {
        screenshotPath = "images/kdw003/Scenario4Case7";
        this.init();
    }

    @Test
    public void test() throws Exception {

        //login 017893/Jinjikoi5
        login("017893", "Jinjikoi5");

        // //change closure 1
        driver.get(domain+ "nts.uk.at.web/view/kmk/012/a/index.xhtml");
        WaitPageLoad(); 
        WaitElementLoad(By.xpath("//td[contains(.,'10日締め')]"));
        driver.findElement(By.xpath("//td[contains(.,'10日締め')]")).click();
        driver.findElement(By.id(inpMonth)).click();
        driver.findElement(By.id(inpMonth)).clear();
        driver.findElement(By.id(inpMonth)).sendKeys("2019/11");
        driver.findElement(By.xpath("//body")).click();
        driver.findElement(By.id(btnsave)).click();


        // click box KDW006C
        driver.get(domain + "nts.uk.at.web/view/kdw/006/c/index.xhtml");
        WaitPageLoad();
        WebElement a = driver.findElement(By.xpath("//*[@id='checkBox121']"));
        WaitElementLoad(By.xpath("//*[@id='checkBox121']/label/span[1]"));
        if (a.getAttribute("class").indexOf("checked") == -1) {
            driver.findElement(By.xpath("//*[@id='checkBox121']/label/span[1]")).click();
            driver.findElement(By.id("register-button")).click();
        } else {
            driver.findElement(By.id("register-button")).click();
        }
        driver.findElement(By.xpath("//body")).click();

        // click checkbox KDW006D
        driver.get(domain + "nts.uk.at.web/view/kdw/006/d/index.xhtml");
        WaitPageLoad();
        WaitElementLoad(By.xpath("//*[@id='single-list']/tbody/tr[4]"));
        driver.findElement(By.xpath("//*[@id='single-list']/tbody/tr[4]")).click();
        WebElement b = driver.findElement(By.xpath("//*[@id='grid2']/tbody/tr[8]/td[3]/div/div/label"));
        if (!b.findElement(By.xpath("./input")).isSelected()) {
            b.click();
            driver.findElement(By.id("register-button")).click();
        } else {
            driver.findElement(By.id("register-button")).click();
        }
        driver.findElement(By.xpath("//body")).click();

        // go kdw003
        driver.get(domain+"nts.uk.at.web/view/kdw/003/a/index.xhtml");
        WaitPageLoad();

        // click error dialog
      
        // if (!driver.switchTo().frame("window_1").findElement(By.id("dialogClose")).isDisplayed()) {
        //     driver.findElement(By.id("ccg001-btn-search-drawer")).click();
        // } else {
        //     WaitElementLoad(By.id("dialogClose"));
        //     driver.findElement(By.id("dialogClose")).click();
        //     driver.findElement(By.id("ccg001-btn-search-drawer")).click();
        // }
        if (driver.findElements(By.xpath("//iframe[@name='window_1']")).size() !=0) {
                driver.switchTo().frame("window_1");
                WaitElementLoad(By.id("dialogClose"));
                driver.findElement(By.id("dialogClose")).click();
                driver.findElements(By.xpath("//button[contains(@class,'ntsDatePrevButton')]")).get(1).click();
            } else {
                driver.findElements(By.xpath("//button[contains(@class,'ntsDatePrevButton')]")).get(1).click();
            }
        WaitElementLoad(By.id("btnExtraction"));
        driver.findElement(By.id("btnExtraction")).click();
        WaitPageLoad();
        screenShotFull();

        

        this.uploadTestLink(837, 197);
    }

    @AfterEach
    public void tearDown() throws Exception {
       driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}