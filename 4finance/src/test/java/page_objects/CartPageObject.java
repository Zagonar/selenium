package page_objects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.DataUtils;

import java.util.ArrayList;
import java.util.List;

public class CartPageObject {

    private static final String CART = "js-cart-badge";
    private static final String GO_TO_SHOPPING_BAG = "//*[@id=\"goToCheckOut\"]";
    private static final String PRICE = "price";
    private static final String PLUS = "plus";
    private static final String SUBTOTAL = "orderInfoSubtotal";

    private DataUtils dataUtils;

    public CartPageObject(DataUtils dataUtils) {
        this.dataUtils = dataUtils;
        PageFactory.initElements(dataUtils.driver, this);
    }


    @FindBy(how = How.CLASS_NAME, using = CART)
    private WebElement cart;

    @FindBy(how = How.XPATH, using = GO_TO_SHOPPING_BAG)
    private WebElement shoppingBag;

    @FindBy(how = How.ID, using = SUBTOTAL)
    WebElement subTotal;

    @FindAll({
            @FindBy(how = How.CLASS_NAME, using = PRICE)
    })
    private List<WebElement> prices;

    @FindAll({
            @FindBy(how = How.CLASS_NAME, using = PLUS)
    })
    private List<WebElement> plus;


    public void navigateToBag() {
        cart.click();
        shoppingBag.click();
    }


    private ArrayList<Double> storePrices() {
        int index = 0;
        ArrayList<Double> storedPrices = new ArrayList<>();
        while (index < 2) {
            Double price = stringPriceToDouble(prices.get(index).getText());
            storedPrices.add(index, price);
            index++;
        }
        return storedPrices;
    }


    public double sumPrices() {
        double sum = 0;
        ArrayList<Double> itemPrices = storePrices();
        for (Double price : itemPrices) {
            sum += price;
        }
        return sum;
    }


    public void addOneItem() throws InterruptedException {
        plus.get(0).click();
        Thread.sleep(1000);
    }


    public void storeTotalPrice() {
        dataUtils.totalPrice = stringPriceToDouble(subTotal.getText());
    }


    private Double stringPriceToDouble(String priceText) {
        StringBuilder stringBuilder = new StringBuilder(priceText);
        String integerPart = stringBuilder.substring(4,7);
        String decimalPart = stringBuilder.substring(8,10);
        return Double.parseDouble(integerPart) + Double.parseDouble(decimalPart)/100;
    }

}
