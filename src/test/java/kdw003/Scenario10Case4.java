package kdw003;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.openqa.selenium.*;
import common.TestRoot;

/**
 * @author ThuHT
 */

public class Scenario10Case4 extends TestRoot {

    @BeforeEach
    public void setUp() throws Exception {
        screenshotPath = "images/kdw003/Scenario10Case4";
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
        driver.findElement(By.id("inpMonth")).sendKeys("2019/08");
        driver.findElement(By.xpath("//body")).click();
        WaitElementLoad(By.id("btn_save"));
        driver.findElement(By.id("btn_save")).click();

        // KDW003A 勤務報告書
        driver.get(domain + "nts.uk.at.web/view/kdw/003/a/index.xhtml");
        // WaitPageLoad();
        final WebElement startDate = driver.findElement(By.id("daterangepicker"))
                .findElement(By.className("ntsStartDatePicker"));
        startDate.clear();
        startDate.sendKeys("2019/08/01");
        driver.findElement(By.xpath("//body")).click();
        Thread.sleep(1000);
        final WebElement endDate = driver.findElement(By.id("daterangepicker"))
                .findElement(By.className("ntsEndDatePicker"));
        endDate.clear();
        endDate.sendKeys("2019/08/31");
        driver.findElement(By.xpath("//body")).click();
        WaitElementLoad(By.xpath("//button[@id='btnExtraction']"));
        driver.findElement(By.xpath("//button[@id='btnExtraction']")).click();
        WaitElementLoad(By.xpath("//li[contains(.,'勤怠シート')]"));
        driver.findElement(By.xpath("//li[contains(.,'勤怠シート')]")).isSelected();
        WaitPageLoad(); 
        //click check toan bo
        js.executeScript("$('.mgrid-fixed:eq(1) tbody tr td.mcell .ntsCheckBox').click()");
        //scroll the grid
        js.executeScript("$('.mgrid-free').scrollTop(400)");  
        WaitElementLoad(By.xpath("//button[@class='proceed']"));
        driver.findElement(By.xpath("//button[@class='proceed']")).click();
        WaitElementLoad(By.xpath("//button[@class ='large']"));
        driver.findElement(By.xpath("//button[@class ='large']")).click();
        WaitPageLoad();
        screenShot();  
        //scroll browser xuong duoi
        //scrollTop(100): chinh toa do cach dau trang bao nhieu
        WaitPageLoad();
        js.executeScript("$('#contents-area').scrollTop(300)");
       
        Thread.sleep(1000);
        setValueGridFlexTable(3, "0.0");
        Thread.sleep(1000);
        setValueGridFlexTable(4, "0:30");        
        WaitElementLoad(By.xpath("//button[@class='proceed']"));
        driver.findElement(By.xpath("//button[@class='proceed']")).click();
        WaitPageLoad(); 
        screenShotFull();   

        this.uploadTestLink(815, 188);

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

    public void setValueGridFlexTable( int columnNumberFlex, String valueFlex){
        if(valueFlex.isEmpty()){ 
            driver.findElements(By.xpath(".//*[@id=\"flex-table\"]/tbody/tr/td[" +columnNumberFlex + "]")).get(0).click();
            driver.findElements(By.xpath(".//*[@id=\"flex-table\"]/tbody/tr/td[" +columnNumberFlex + "]"+"/.//input")).get(0).clear();
        }else{
            driver.findElements(By.xpath(".//*[@id=\"flex-table\"]/tbody/tr/td[" +columnNumberFlex + "]")).get(0).click();
            driver.findElements(By.xpath(".//*[@id=\"flex-table\"]/tbody/tr/td[" +columnNumberFlex + "]"+"/.//input")).get(0).clear();
            WaitElementLoad(By.xpath(".//*[@id=\"flex-table\"]/tbody/tr/td[3]/.//input"));
            driver.findElements(By.xpath(".//*[@id=\"flex-table\"]/tbody/tr/td[" +columnNumberFlex + "]"+"/.//input")).get(0).sendKeys(valueFlex);
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