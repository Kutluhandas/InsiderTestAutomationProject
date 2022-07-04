package commons;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseCommons extends DriverManager {

    protected String baseUrl = "https://useinsider.com/";
    protected final WebDriverWait wait;
    protected final Actions action;

    public BaseCommons() {
        this.wait = new WebDriverWait(driver , 10);
        this.action = new Actions(driver);
    }

    protected WebElement findBy(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    protected void click(By locator){
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        findBy(locator).click();
    }

    protected void hoverOver(By locator){
        action.moveToElement(findBy(locator)).perform();
    }

    protected String getTitle(){
        return driver.getTitle();
    }

    protected String getText(By locator) {
        return findBy(locator).getText();
    }

    protected Boolean contains(By locator, String text) {
        return getText(locator).contains(text);
    }

    private List<WebElement> selectRequestOne(By locator){return driver.findElements(locator);}

    protected void clickInList(By locator, int i){
        selectRequestOne(locator).get(i).click();
    }

    protected JavascriptExecutor javascriptExecutor(RemoteWebDriver driver) {
        return driver;
    }

    public void clickElementWithJS(RemoteWebDriver driver, By locator) {
        javascriptExecutor(driver).executeScript("arguments[0].click();", findBy(locator));
    }

    public void scroll(int lenght){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+lenght+")");
    }

    public String getTextViaAttribute(By locator) {
        return findBy(locator).getAttribute("innerHTML");
    }

    public List<WebElement> listForChecking(By locator){
        return driver.findElements(locator);
    }

    protected void selection(By locator, String text) {
        Select select = new Select(findBy(locator));
        select.selectByVisibleText(text);
    }

    /*
    This function was created instead of an assertion, as one of the position names may cause an error in the project.
    If there is an error when using this, an error message is received and the project continues to work.
     */
    public void checkingSameFieldsInAds(By locator, String textOfChecking) {
        for(WebElement el : listForChecking(locator)){
            Boolean booleanOfLocator = el.getAttribute("innerHTML").contains(textOfChecking);
            if(!booleanOfLocator){
                System.out.println("Does not contain the expected text=>"+ textOfChecking +"");
            }
        }
    }
}
