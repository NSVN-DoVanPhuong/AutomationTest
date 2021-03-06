package kaf005;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.List;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.*;

import common.TestRoot;

public class Scenario4Case1 extends TestRoot {

    @BeforeEach
    public void setUp() throws Exception {
        screenshotPath = "images/kaf005/Scenario4Case1";
        this.init();
    }

    @Test
    public void test() throws Exception {
        //login申請者
        Path sampleFile = Paths.get("sprtest.html");
        Calendar inputdate = Calendar.getInstance();
        inputdate.add(Calendar.DATE, 1);

        driver.get(sampleFile.toUri().toString() + "?domain=" + domain);
        driver.findElement(By.xpath("//input[@name='menu']")).clear();
        driver.findElement(By.xpath("//input[@name='menu']")).sendKeys("1");
        driver.findElement(By.xpath("//input[@name='loginemployeeCode']")).clear();
        driver.findElement(By.xpath("//input[@name='loginemployeeCode']")).sendKeys("025497");
        driver.findElement(By.xpath("//input[@name='employeeCode']")).clear();
        driver.findElement(By.xpath("//input[@name='employeeCode']")).sendKeys("025497");
        driver.findElement(By.xpath("//input[@name='starttime']")).clear();
        driver.findElement(By.xpath("//input[@name='starttime']")).sendKeys("360");
        driver.findElement(By.xpath("//input[@name='endtime']")).clear();
        driver.findElement(By.xpath("//input[@name='endtime']")).sendKeys("1020");
        driver.findElement(By.xpath("//input[@name='date']")).clear();
        driver.findElement(By.xpath("//input[@name='date']")).sendKeys(df1.format(inputdate.getTime()));
        driver.findElement(By.xpath("//input[@name='reason']")).clear();
        driver.findElement(By.xpath("//input[@name='reason']")).sendKeys("autotest");
        screenShot();
        driver.findElement(By.xpath("//input[@id='run01']")).click();
        WaitPageLoad();

        //残業申請
        driver.findElement(By.xpath("//button[@tabindex='14']")).click();
        WaitPageLoad();
        screenShot();
        driver.findElement(By.xpath("//button[@tabindex='1']")).click();
        WaitElementLoad(By.xpath("//button[@class='large']"));
        screenShot();
        driver.findElement(By.xpath("//button[@class='large']")).click();
        WaitPageLoad();
        driver.switchTo().frame("window_1");
        driver.findElements(By.xpath("//button")).get(1).click();
        WaitPageLoad();
        driver.findElements(By.xpath("//div[contains(@class,'ui-icon-caret-1-s')]")).get(1).click();
        driver.findElement(By.xpath("//li[text()='ログアウト']")).click();
        WaitPageLoad();

        //login承認者
        login("015310", "Jinjikoi5");

        //承認
        driver.get(domain + "nts.uk.at.web/view/cmm/045/a/index.xhtml?a=1");
        WaitPageLoad();
        driver.findElement(By.xpath("//input[contains(@id,'endInput')]")).clear();
        driver.findElement(By.xpath("//input[contains(@id,'endInput')]")).sendKeys(df1.format(inputdate.getTime()));
        WaitElementLoad(By.xpath("//button[@tabindex='6']"));
        driver.findElement(By.xpath("//button[@tabindex='6']")).click();
        WaitPageLoad();
        List<WebElement> listEl = driver.findElements(By.xpath("//td[contains(.,'025445')]"));
        WebElement el = listEl.get(listEl.size() - 1);
        el.findElements(By.xpath("preceding-sibling::td")).get(0).click();
        new Actions(driver).moveToElement(el).perform();
        screenShot();
        WaitElementLoad(By.xpath("//button[@tabindex='1']"));
        driver.findElement(By.xpath("//button[@tabindex='1']")).click();
        _wait.until(d -> "承認しました。".equals(d.findElement(By.xpath("//div[@class='text']")).getText()));
        screenShot();
        driver.findElement(By.xpath("//button[@class='large']")).click();
        WaitElementLoad(By.xpath("//div[contains(@class,'ui-icon-caret-1-s')]"));
        driver.findElements(By.xpath("//div[contains(@class,'ui-icon-caret-1-s')]")).get(1).click();
        driver.findElement(By.xpath("//li[text()='ログアウト']")).click();
        WaitPageLoad();

        //login申請者
        login("025445", "Jinjikoi5");

        driver.get(domain + "nts.uk.at.web/view/cmm/045/a/index.xhtml?a=0");
        WaitPageLoad();
        driver.findElements(By.xpath("//input[contains(@id,'endInput')]")).get(2).clear();
        driver.findElements(By.xpath("//input[contains(@id,'endInput')]")).get(2).sendKeys(df1.format(inputdate.getTime()));
        WaitElementLoad(By.xpath("//button[@tabindex='6']"));
        driver.findElement(By.xpath("//button[@tabindex='6']")).click();
        WaitPageLoad();
        List<WebElement> listEl2 = driver.findElements(By.xpath("//td[contains(.,'025445')]"));
        WebElement el2 = listEl2.get(listEl2.size() - 1);
        new Actions(driver).moveToElement(el2).perform();
        screenShot();
        driver.get(domain + "nts.uk.at.web/view/kdw/003/a/index.xhtml");
        WaitPageLoad();
        driver.findElements(By.xpath("//input[contains(@id,'startInput')]")).get(3).clear();
        driver.findElements(By.xpath("//input[contains(@id,'startInput')]")).get(3).sendKeys(df1.format(inputdate.getTime()));
        driver.findElements(By.xpath("//input[contains(@id,'endInput')]")).get(3).clear();
        driver.findElements(By.xpath("//input[contains(@id,'endInput')]")).get(3).sendKeys(df1.format(inputdate.getTime()));
        driver.findElement(By.id("btnExtraction")).click();
        WaitPageLoad();
        screenShot();
        //js.executeScript("$('.mgrid-free').scrollTop($('.mgrid-free')[1].scrollHeight)");

        this.uploadTestLink(194, 47);
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