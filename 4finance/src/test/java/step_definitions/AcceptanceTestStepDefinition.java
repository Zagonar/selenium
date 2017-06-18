package step_definitions;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import org.junit.Assert;
import page_objects.CartPageObject;
import page_objects.HomePageObject;
import page_objects.ItemSelectionPageObject;
import utilities.DataUtils;


public class AcceptanceTestStepDefinition implements En {

    private DataUtils dataUtils;

    public AcceptanceTestStepDefinition(DataUtils dataUtils) {

        this.dataUtils = dataUtils;


        Given("^I navigate to \"([^\"]*)\"$", (String host) -> {
            dataUtils.driver.navigate().to(host);
        });


        And("^I go to item selection's page$", () -> {
            try {
                HomePageObject homePageObject = new HomePageObject(dataUtils);
                homePageObject.goToItemsSelectionPage();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
        });


        When("^I add two random prioducts to the bag$", () -> {
            ItemSelectionPageObject itemSelectionPageObject = new ItemSelectionPageObject(dataUtils);
            try {
                itemSelectionPageObject.addTwoItemsToBag();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        And("^I navigate to the bag$", () -> {
            CartPageObject cartPageObject = new CartPageObject(dataUtils);
            cartPageObject.navigateToBag();
        });


        And("^I add one more instance of a product$", () -> {
            CartPageObject cartPageObject = new CartPageObject(dataUtils);
            try {
                cartPageObject.addOneItem();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        Then("^The final price must be correct$", () -> {
            CartPageObject cartPageObject = new CartPageObject(dataUtils);
            cartPageObject.storeTotalPrice();
            Assert.assertEquals(cartPageObject.sumPrices(), dataUtils.totalPrice, 0);
        });

    }
}
