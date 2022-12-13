package Steps;

import Base.BaseStep;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.UUID;

public class RegisterStep extends BaseStep {

    WebDriver driver= createDriverAndGoToURL();
    WebDriverWait wait = new WebDriverWait(driver, 5);
    private static WebDriver createDriverAndGoToURL(){

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String Url = "https://engine.lv/";
        driver.get(Url);
        driver.manage().window().maximize();
        return driver;
    }

    private void writeByXpath(String text , String xpath){
        WebElement webElement=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        webElement.sendKeys(text);
    }

    private void clickByXpath(String xpath){
        WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));

        webElement.click();
    }
    private void clickBySelector(String cssSelector){
        WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(cssSelector)));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));

        webElement.click();
    }
    private void sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {}
    }
    private void closeTab(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.close();
    }

    private void pageDown(){
        WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("body")));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);
    }

    @Given("^Cliking all main page buttons$")
    public void cliking_all_main_page_buttons() throws Throwable {
        clickByXpath("//*[@id=\"cookie_action_close_header\"]");

        WebElement element = driver.findElement(By.cssSelector("#esg-grid-1-1 > article > div > div:nth-child(2) > span:nth-child(1)"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        sleep(2000);

        for(int i=0;i<10;i++) {
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_UP);
        }

        clickBySelector("#esg-grid-1-1 > article > div > div:nth-child(2) > span:nth-child(1)");

        clickBySelector("#esg-grid-1-1 > article > div > div:nth-child(3) > span:nth-child(1)");

        clickBySelector("#esg-grid-1-1 > article > div > div:nth-child(4) > span:nth-child(1)");

        clickBySelector("#esg-grid-1-1 > article > div > div:nth-child(5) > span:nth-child(1)");

        clickBySelector("#esg-grid-1-1 > article > div > div:nth-child(6) > span:nth-child(1)");
    }

    @When("^Clicking Rietumu Bank$")
    public void clicking_Rietumu_Bank() throws Throwable {
        WebElement element = driver.findElement(By.id("eg-1-post-id-232"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        sleep(400);
        element.click();
        driver.switchTo().defaultContent();
    }

    @Then("^Check Rietumu Bank portfolio$")
    public void check_Rietumu_Bank_portfolio() throws Throwable {
        for(int i=0;i<10;i++){
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);
        }

        WebElement phoneframe=wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#about > div > div:nth-child(2) > div > div:nth-child(2) > div:nth-child(1) > div > div > div.wpb_raw_code.wpb_content_element.wpb_raw_html > div > iframe")));
        driver.switchTo().frame(phoneframe);

        clickBySelector("#marvel-prototype-resize-root > div._16grcoSOC8Y0tFMpcfPK3a > div > div > div > div > div._3NB23hS7s6TDVxFJWREyso.position-absolute.pinAll > div");
        for(int i=0;i<30;i++)
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_RIGHT);

        driver.switchTo().defaultContent();

        for(int i=0;i<23;i++)
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);

        WebElement videoframe=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//iframe[contains(@title,'Rietumu Bank Authentication Demo')]")));
        driver.switchTo().frame(videoframe);

        clickByXpath("//button[contains(@class,'ytp-large-play-button ytp-button')]");

        driver.switchTo().defaultContent();

        closeTab();
    }


    @Given("^Open Services$")
    public void openServices() {
        clickByXpath("//a[contains(text(),'Services')]");
    }

    @Then("^Press IT Audit$")
    public void pressITAudit() {
        Actions ac = new Actions(driver);
        WebElement phoneframe=wait.until(ExpectedConditions.presenceOfElementLocated(By.id("eg-6-post-id-2310")));
        sleep(1000);
        ac.moveToElement(phoneframe).perform();

        clickBySelector("#eg-6-post-id-2310 > div > div.esg-entry-cover > div.esg-tc.eec > div.esg-top.eg-post-2310.eg-serv_fin_02-element-11-a");
    }

    @When("^IT Audit opened make your order$")
    public void itAuditOpenedMakeYourOrder() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);

        for(int i=0;i<15;i++)
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_UP);

        clickByXpath("//button[contains(text(),'Make Your Order!')]");
        closeTab();
    }

    @Given("^Open Clients$")
    public void openClients() {
        clickByXpath("//a[contains(text(),'Clients')]");
    }

    @Given("^Open References$")
    public void openReferences() {
        clickByXpath("//a[contains(text(),'References')]");
    }

    @Given("^Open IT Experts$")
    public void openITExperts() {
        clickByXpath("//a[contains(text(),'IT Experts')]");
    }

    @Given("^Open Contacts$")
    public void openContacts() {
        clickByXpath("//a[contains(text(),'Contacts')]");
        closeTab();
    }


    @Given("^Press Facebook link$")
    public void pressFacebookLink() {
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL, Keys.END);

        clickBySelector("#footer > div > div.row.uk-scrollspy-init-inview.uk-scrollspy-inview.uk-animation-fade > div.col-md-12.uk-scrollspy-init-inview.uk-scrollspy-inview.uk-animation-fade > div > div > div > div.footer-copy > div > ul > li:nth-child(1) > a");

        sleep(1000);

        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.close();
        driver.switchTo().window(tabs2.get(0));
    }

    @Given("^Press Instagram link$")
    public void pressInstagramLink() {
        clickBySelector("#footer > div > div.row.uk-scrollspy-init-inview.uk-scrollspy-inview.uk-animation-fade > div.col-md-12.uk-scrollspy-init-inview.uk-scrollspy-inview.uk-animation-fade > div > div > div > div.footer-copy > div > ul > li:nth-child(2) > a");

        sleep(1000);

        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());

        driver.switchTo().window(tabs2.get(1));
        driver.close();
        driver.switchTo().window(tabs2.get(0));
    }

    @Given("^Press Linkedin link$")
    public void pressLinkedinLink() {
        clickBySelector("#footer > div > div.row.uk-scrollspy-init-inview.uk-scrollspy-inview.uk-animation-fade > div.col-md-12.uk-scrollspy-init-inview.uk-scrollspy-inview.uk-animation-fade > div > div > div > div.footer-copy > div > ul > li:nth-child(3) > a");
        sleep(1000);
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.close();
        driver.switchTo().window(tabs2.get(0));

        closeTab();
    }

    @Given("^Open Services footer$")
    public void openServicesFooter() {
        clickByXpath("//*[@id=\"cookie_action_close_header\"]");

        sleep(1000);
        pageDown();
        clickBySelector("#menu-mega-menu-1 > li.menu-item.menu-item-type-post_type.menu-item-object-page.menu-item-1388 > a");
    }

    @Given("^Open Clients footer$")
    public void openClientsFooter() {
        sleep(1000);
        pageDown();
        clickBySelector("#menu-mega-menu-1 > li.menu-item.menu-item-type-post_type.menu-item-object-page.menu-item-1364 > a");
    }

    @Given("^Open References footer$")
    public void openReferencesFooter() {
        sleep(1000);
        pageDown();
        clickBySelector("#menu-mega-menu-1 > li.menu-item.menu-item-type-post_type.menu-item-object-page.menu-item-1362 > a");
    }

    @Given("^Open IT Experts footer$")
    public void openITExpertsFooter() {
        sleep(1000);
        pageDown();
        clickBySelector("#menu-mega-menu-1 > li.menu-item.menu-item-type-post_type.menu-item-object-page.menu-item-3203 > a");
    }

    @Given("^Open Contacts footer$")
    public void openContactsFooter() {
        sleep(1000);
        pageDown();
        clickBySelector("#menu-mega-menu-1 > li.menu-item.menu-item-type-post_type.menu-item-object-page.menu-item-3181 > a");

        closeTab();
    }

    @Given("^Fill all forms$")
    public void fillAllForms() {
        sleep(4000);

        writeByXpath("test" , "//*[@id=\"wpcf7-f10-p1338-o1\"]/form/p[1]/label/span/input");

        writeByXpath("test@mail.com" , "//*[@id=\"wpcf7-f10-p1338-o1\"]/form/p[2]/label/span/input");

        writeByXpath("test" , "//*[@id=\"wpcf7-f10-p1338-o1\"]/form/p[3]/label/span/input");

        for(int i=0;i<10;i++)
            driver.findElement(By.cssSelector("body")).sendKeys(Keys.ARROW_DOWN);

        writeByXpath("test" , "//*[@id=\"wpcf7-f10-p1338-o1\"]/form/p[4]/label/span/textarea");

    }

    @Given("^Press send$")
    public void pressSend() {

        clickByXpath("//input[contains(@value,'Send')]");
        closeTab();
    }

    @Given("^Open Contact$")
    public void openContact() {
        clickByXpath("//a[contains(text(),'Contacts')]");
    }
}
