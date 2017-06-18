package page_objects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.DataUtils;

public class HomePageObject {

    private static final String ACCESSIORIES = "ta-menu-accessoriesmen"; //class
    private static final String GIOELLI = "//*[@id=\"js-accessoriesmen\"]/div[1]/div/div[1]/div[2]/div[9]/a"; //xpath

    private DataUtils dataUtils;

    public HomePageObject(DataUtils dataUtils) {
        this.dataUtils = dataUtils;
        PageFactory.initElements(dataUtils.driver, this);
    }

    @FindBy(how = How.CLASS_NAME, using = ACCESSIORIES)
    WebElement accessories;

    @FindBy(how = How.XPATH, using = GIOELLI)
    WebElement gioielli;

    private void clickOnAccessories() {
        JavascriptExecutor jse = (JavascriptExecutor) dataUtils.driver;
        jse.executeScript("arguments[0].scrollIntoView(true)", accessories);
        accessories.click();
    }

    private void clickOnOcchialiDaSole() {
        JavascriptExecutor jse = (JavascriptExecutor) dataUtils.driver;
        jse.executeScript("arguments[0].scrollIntoView(true)", gioielli);
        gioielli.click();
    }

    public void goToItemsSelectionPage() throws InterruptedException {
        clickOnAccessories();
        Thread.sleep(500);
        clickOnOcchialiDaSole();
        Thread.sleep(500);
    }

}
