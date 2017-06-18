package page_objects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.DataUtils;


public class ItemSelectionPageObject {

    private static final String ADD_TO_CART = "addToCart";
    private static final String ITEM = "ta-grid-";
    private static final String AVAILABIITY = "bg-highlight";

    private DataUtils dataUtils;

    public ItemSelectionPageObject(DataUtils dataUtils) {
        this.dataUtils = dataUtils;
        PageFactory.initElements(dataUtils.driver, this);
    }


    @FindBy(how = How.CLASS_NAME, using = AVAILABIITY)
    private WebElement availability;

    @FindBy(how = How.ID, using = ADD_TO_CART)
    private WebElement addToCartButton;



    public void addTwoItemsToBag() throws InterruptedException {
        int numberOfItemsInBag = 0;
        Integer itemGridIndex = 1;
        while (numberOfItemsInBag < 2) {
            WebElement item = dataUtils.driver.findElement(By.className(ITEM+itemGridIndex.toString()));
            item.click();
            Thread.sleep(500);
            if(!availability.getText().equalsIgnoreCase("Ultimo disponibile")) {
                addToCartButton.click();
                numberOfItemsInBag++;
                Thread.sleep(500);
            }
            itemGridIndex++;
            dataUtils.driver.navigate().back();
            Thread.sleep(500);
        }
    }
}
