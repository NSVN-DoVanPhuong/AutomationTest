package kdw003;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.*;

import common.TestRoot;

public class Scenario2Case5 extends TestRoot {

    @BeforeEach
    public void setUp() throws Exception {
        screenshotPath = "images/kdw003/Scenario2Case5";
        this.init();
    }

    @Test
    public void test() throws Exception {
        //login申請者
        login("008491", "Jinjikoi5");
        //16
        driver.get(domain+"nts.uk.at.web/view/kdw/003/a/index.xhtml");
        WaitPageLoad();
        driver.findElements(By.xpath("//li[contains(.,'乖離シート')]")).get(0).click();
        setValueGrid(3,2,"1905");
        WaitPageLoad();
        setValueGrid(3,9,"");
        WaitPageLoad();
        setValueGrid(3,10,"");
        WaitPageLoad();
        screenShot();
        driver.findElements(By.xpath("//button[contains(.,'確定')]")).get(0).click();;
        WaitPageLoad();
        driver.findElements(By.xpath("//button[contains(.,'閉じる')]")).get(1).click();;
        Thread.sleep(1000);
        driver.findElements(By.xpath("//button[contains(.,'エラー参照')]")).get(0).click();
        WaitPageLoad();
        driver.switchTo().frame("window_1");
        screenShot();
        driver.findElement(By.id("dialogClose")).click();
        WaitPageLoad();
        if(driver.findElements(By.xpath("//td[contains(.,'夕休憩未取得(他)理由（選択）')]")).size()==0){
            driver.get(domain+"nts.uk.at.web/view/kdw/006/a/index.xhtml");
            WaitPageLoad();
            driver.findElement(By.id("DAILY")).click();
            WaitPageLoad();
            driver.findElement(By.id("button7")).click();
            WaitPageLoad();
            driver.findElements(By.xpath("//td[contains(.,'0000000130')]")).get(2).click();
            WaitPageLoad();
            driver.findElement(By.id("A_SEL_002")).click();
            WaitElementLoad(By.xpath("//li[@data-value='2']"));
            driver.findElement(By.xpath("//li[@data-value='2']")).click();
            Thread.sleep(1000);
            driver.findElements(By.xpath("//input[contains(@id,'swap-list2-search-area-input')]")).get(0).click();
            driver.findElements(By.xpath("//input[contains(@id,'swap-list2-search-area-input')]")).get(0).sendKeys("241");
            driver.findElements(By.xpath("//button[contains(@id,'swap-list2-search-area-btn')]")).get(0).click();
            driver.findElements(By.xpath("//td[contains(.,'241')]")).get(2).click();
            Thread.sleep(1000);
            driver.findElements(By.xpath("//i[contains(@class,'icon-next')]")).get(0).click();
            Thread.sleep(1000);
            driver.findElements(By.xpath("//td[contains(.,'241')]")).get(2).click();
            Thread.sleep(1000);
            driver.findElement(By.id("up-down-up")).click();
            Thread.sleep(1000);
            driver.findElement(By.id("up-down-up")).click();
            Thread.sleep(1000);
            driver.findElements(By.xpath("//button[contains(.,'登録')]")).get(0).click();
            WaitPageLoad();
            driver.get(domain+"nts.uk.at.web/view/kdw/003/a/index.xhtml");
            WaitPageLoad();
            driver.switchTo().frame("window_1");
            driver.findElement(By.id("dialogClose")).click();
            WaitPageLoad();
            driver.findElements(By.xpath("//li[contains(.,'乖離シート')]")).get(0).click();
            WaitPageLoad();
        }
        //17
        selectItemKdw003_2("本人", "12/02(月)").click();
        selectItemKdw003_2("夕休憩未取得(他)理由（選択）", "12/02(月)").click();
        WaitPageLoad();
        driver.switchTo().frame("window_2");
        driver.findElements(By.xpath("//td[contains(.,'乖離理由1')]")).get(1).click();
        driver.findElement(By.id("save")).click();
        WaitPageLoad();
        WaitElementLoad(By.xpath("//button[contains(.,'確定')]"));
        driver.findElements(By.xpath("//button[contains(.,'確定')]")).get(0).click();;
        WaitPageLoad();
        screenShot();
        driver.findElements(By.xpath("//button[contains(.,'閉じる')]")).get(1).click();
        //18
        setValueGrid(4,2,"1905");
        WaitPageLoad();
        WaitElementLoad(By.xpath("//button[contains(.,'確定')]"));
        driver.findElements(By.xpath("//button[contains(.,'確定')]")).get(0).click();;
        WaitPageLoad();  
        screenShot();
        driver.findElements(By.xpath("//button[contains(.,'閉じる')]")).get(1).click();
        Thread.sleep(1000);
        //19
        selectItemKdw003_2("本人", "12/03(火)").click();
        WaitElementLoad(By.xpath("//button[contains(.,'確定')]"));
        driver.findElements(By.xpath("//button[contains(.,'確定')]")).get(0).click();;
        WaitPageLoad();
        screenShot();
        driver.findElements(By.xpath("//button[contains(.,'閉じる')]")).get(1).click();
         this.uploadTestLink(727, 162);
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
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}