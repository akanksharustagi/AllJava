import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class HomeTest {
    WebDriver driver;
    @BeforeSuite
    public void setupBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\enaak\\Downloads\\chromedriver\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://www.cn.ca/en/");


        WebElement link= driver.findElement( By.id("ctl06__fb9f97148421aa_repMainNav_topLevelLink_1"));
        WebElement trucking= driver.findElement( By.id("ctl06__fb9f97148421aa_repMainNav_repSecondLevel_1_secondLevelLink_2"));
        WebElement express= driver.findElement(By.id("ctl06__fb9f97148421aa_repMainNav_repSecondLevel_1_repThirdLevel_2_thirdLevelLink_1"));
        WebElement jobaid= driver.findElement(By.id("ctl06__fb9f97148421aa_repMainNav_repSecondLevel_1_repThirdLevel_2_repFourthLevel_1_fourthLevelLink_0"));


        Actions actions = new Actions(driver);
        actions.moveToElement(link).pause(2000).moveToElement(trucking).pause(2000)
                .moveToElement(express).pause(2000).moveToElement(jobaid).pause(2000).click()
                .build().perform();
        actions.moveToElement(link, 50,0);
        WebElement search= driver.findElement(By.name("search"));
        actions.moveToElement(search).click().keyDown(Keys.SHIFT).sendKeys("aBcD").build().perform();
        Thread.sleep(5000);

    }
    @Test
    public void tc() {
        driver.findElement(By.xpath("//*[@id=\"btnJoinMeeting\"]")).click();
        System.out.println("Before "+ driver.getCurrentUrl());
        driver.findElement(By.xpath("//*[@id=\"btnJoinMeeting\"]")).click();
        System.out.println("After "+ driver.getCurrentUrl());
        System.out.println(driver.getTitle());
driver.findElement(By.xpath("//*[@id=\"join-confno\"]")).sendKeys("123456789");
    }

    @Test
    public void tc2(){
        driver.get("https://jqueryui.com/droppable/");
        driver.switchTo().frame(0);
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));

        Actions actions= new Actions(driver);
        actions.dragAndDrop(draggable,droppable).build().perform();

        }

        @AfterSuite
    public void tearDown() throws InterruptedException{
        driver.quit();
        }

}

