package Steps;

import cucumber.api.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class EmailsStep {

    WebDriver driver= createDriverAndGoToURL();
    WebDriverWait wait = new WebDriverWait(driver, 20);

    private static WebDriver createDriverAndGoToURL(){

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String Url = "https://outlook.com/";

        driver.get(Url);
        driver.manage().window().maximize();
        return driver;
    }
    private void clickByXpath(String xpath){
        WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));

        webElement.click();
    }

    private void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {}
    }

    @Given("^Open Outlook$")
    public void openOutlook() {
        clickByXpath("/html/body/header/div/aside/div/nav/ul/li[2]/a");
    }

    @Given("^Fill login$")
    public void fillLogin() {
        WebElement webElement=wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("input")));
        webElement.sendKeys("EngineTestSelenium@outlook.com");

        clickByXpath("//*[@id=\"idSIButton9\"]");
    }

    @Given("^Fill password$")
    public void fillPassword() {
        sleep(2000);
        WebElement webElement2=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/form[1]/div/div/div[2]/div[1]/div/div/div/div/div/div[3]/div/div[2]/div/div[3]/div/div[2]/input")));
        webElement2.sendKeys("Ausekla3030!");
        clickByXpath("//*[@id=\"lightbox\"]/div[3]/div/div[2]/div/div[4]/div[2]/div/div/div/div");
        sleep(1000);
        clickByXpath("//*[@id=\"idBtn_Back\"]");
    }

    @Given("^Delete message$")
    public void deleteMessage() {
        clickByXpath("//span[contains(text(),'test')]");

        clickByXpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[1]/div/div/div/div/div/div[1]/div[3]/button/span");
    }
}
