import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTest {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\enaak\\Downloads\\chromedriver102\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.ca/");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("camera");
        driver.findElement(By.id("nav-search-submit-button")).click();
        System.out.println("Test successfully done");
        driver.quit();

    }


}
