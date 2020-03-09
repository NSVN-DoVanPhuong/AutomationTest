package kif002;

import java.io.File;
import org.junit.jupiter.api.*;
import org.apache.commons.io.FileUtils;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.*;

import common.TestRoot;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario1Case1 extends TestRoot {

    @BeforeEach
    public void setUp() throws Exception {
        screenshotPath = "images/kif002/Scenario1Case1";
        this.init();
    }

    @Test
    public void test() throws Exception {
        //login申請者
        // login("020905", "Jinjikoi5", "image1", screenshotFile);
        login("020905", "Jinjikoi5");

        driver.get(domain+"nts.uk.at.web/view/kmw/005/a/index.xhtml");
        WaitPageLoad();
        screenShot();
        //create data KDW001
        driver.get(domain+"nts.uk.at.web/view/kdw/001/b/index.xhtml");
        WaitPageLoad();
        driver.findElement(By.id("ccg001-btn-search-drawer")).click();
        Thread.sleep(1000);
        screenShot();
        // WaitElementLoad(By.xpath("//label[contains(.,'参照可能な社員すべて')]"));
        // driver.findElements(By.xpath("//label[contains(.,'参照可能な社員すべて')]")).get(0).click();
        WaitElementLoad(By.xpath("//i[contains(@class,'ccg001-icon-btn-big icon-26-onlyemployee')]"));
        driver.findElements(By.xpath("//i[contains(@class,'ccg001-icon-btn-big icon-26-onlyemployee')]")).get(0).click();//de tam
        WaitPageLoad();
        driver.findElement(By.id("button22")).click();
        WaitElementLoad(By.xpath("//span[contains(.,'日別作成（打刻反映）')]"));
        driver.findElements(By.xpath("//span[contains(.,'日別作成（打刻反映）')]")).get(0).click();
        WaitElementLoad(By.xpath("//span[contains(.,'日別計算')]"));
        driver.findElements(By.xpath("//span[contains(.,'日別計算')]")).get(0).click();
        screenShot();
        WaitElementLoad(By.id("button6"));
        driver.findElement(By.id("button6")).click();
        Thread.sleep(1000);
        WaitElementLoad(By.id("button113"));
        driver.findElement(By.id("button113")).click();
        Thread.sleep(1000);
        WebDriverWait _wait300 = new WebDriverWait(driver, 3000000);
        driver.switchTo().frame("window_1");
        _wait300 = new WebDriverWait(driver, 3000000);
        _wait300.until(d -> (false == d.findElement(By.className("danger")).isEnabled()));
        screenShot();
        this.uploadTestLink(602, 149);
     
    }

    public void login(String id, String pass, String nameImage, File screenshotFile) throws Exception {
        driver.get(domain + "nts.uk.com.web/view/ccg/007/d/index.xhtml");
        WaitPageLoad();
        driver.findElement(By.id("company-code-select")).click();
        WaitElementLoad(By.xpath("//li[@data-value='0001']"));
        driver.findElement(By.xpath("//li[@data-value='0001']")).click();
        driver.findElement(By.id("employee-code-inp")).clear();
        driver.findElement(By.id("employee-code-inp")).sendKeys(id);
        driver.findElement(By.id("password-input")).clear();
        driver.findElement(By.id("password-input")).sendKeys(pass);
        screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile, new File(screenshotPath + "/" + nameImage + ".png"));
        driver.findElement(By.id("login-btn")).click();
        WaitPageLoad();
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