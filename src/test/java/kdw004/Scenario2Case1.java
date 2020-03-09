package kdw004;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import common.TestRoot;


public class Scenario2Case1 extends TestRoot {

    @BeforeEach
    public void setUp() throws Exception {
        screenshotPath = "images/kdw004/Scenario2Case1";
        this.init();
    }

    @Test
    public void test() throws Exception {
        // login申請者
        driver.get(domain + "nts.uk.com.web/view/ccg/007/d/index.xhtml");
        WaitPageLoad();
        driver.findElement(By.id("company-code-select")).click();
        WaitElementLoad(By.xpath("//li[@data-value='0001']"));
        driver.findElement(By.xpath("//li[@data-value='0001']")).click();
        driver.findElement(By.id("password-input")).clear();
        driver.findElement(By.id("password-input")).sendKeys("Jinjikoi5");
        driver.findElement(By.id("employee-code-inp")).clear();
        driver.findElement(By.id("employee-code-inp")).sendKeys("007102");
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(screenshotPath + "/image1.png"));
        driver.findElement(By.id("login-btn")).click();
        WaitPageLoad();

// 1.10 日別実績のエラー有無 - エラー有りの場合（□エラー一覧表示）
        // Setting screen cmm053
        driver.get(domain + "nts.uk.com.web/view/cmm/053/a/index.xhtml");
        WaitPageLoad();

        WaitElementLoad(By.id("A2_7"));
        driver.findElement(By.id("A2_7")).click();
        driver.findElement(By.id("A2_7")).sendKeys("017170");

        WaitElementLoad(By.id("A1_3"));
        driver.findElement(By.id("A1_3")).click();

        driver.get(domain + "nts.uk.com.web/view/cmm/053/a/index.xhtml");
        WaitPageLoad();

        // tacke a photo
        screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(screenshotPath + "/image2.png"));

         // login申請者
         driver.get(domain + "nts.uk.com.web/view/ccg/007/d/index.xhtml");
         WaitPageLoad();
         driver.findElement(By.id("company-code-select")).click();
         WaitElementLoad(By.xpath("//li[@data-value='0001']"));
         driver.findElement(By.xpath("//li[@data-value='0001']")).click();
         driver.findElement(By.id("password-input")).clear();
         driver.findElement(By.id("password-input")).sendKeys("Jinjikoi5");
         driver.findElement(By.id("employee-code-inp")).clear();
         driver.findElement(By.id("employee-code-inp")).sendKeys("004515");
         screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
         FileUtils.copyFile(screenshotFile, new File(screenshotPath + "/image1.png"));
         driver.findElement(By.id("login-btn")).click();
         WaitPageLoad();

        // Go to screen Kdw004a
        driver.get(domain + "nts.uk.at.web/view/kdw/004/a/index.xhtml");
        WaitPageLoad();
       
        // tacke a photo
        screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(screenshotPath + "/image3.png"));

        WaitPageLoad();
        this.uploadTestLink(856, 204);
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