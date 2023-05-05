import com.fasterxml.jackson.annotation.JsonSubTypes;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Lenovo extends Util {

    WebDriver driver;
    JavascriptExecutor js;

    @Test(priority = 1)
    void browserOpen() {
        System.out.println("Open Web Browser....");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
        js = ((JavascriptExecutor) driver);
    }

    @Test(priority = 2)
    void selectComputer() {
        System.out.println("select particular computer Menu...");
        driver.findElement(By.linkText("Computers")).click();
    }

    @Test(priority = 3)
    void selectDesktop() {
        System.out.println("Select Desktops option...");
        driver.findElement(By.linkText("Desktops")).click();
    }

    //  @Test(priority = 4)

//    void scrollScreen(){
//        System.out.println("Scroll down screen half...");
//        js.executeScript("window.scrollTo(0,document.body,ScrollHeight)");
//    }

    @Test(priority = 4)
    void selectLenovoProduct() {
        System.out.println("select Lenovo Product...");
        driver.findElement(By.linkText("Lenovo IdeaCentre 600 All-in-One PC")).click();
    }
    //  @Test(priority = 6)

//    void scrollScreenDown(){
//        System.out.println("Scroll down screen half...");
//        js.executeScript("window.scrollTo(0,document.body,ScrollHeight)");
//    }

    @Test(priority = 5)
    void addToCart() {
        System.out.println("Add Product in the cart...");
        driver.findElement(By.id("add-to-cart-button-3")).click();
        WebElement cart = driver.findElement(By.id("add-to-cart-button-3"));
        Assert.assertTrue(cart.isDisplayed(), "Desktop successfully added on cart");
    }
    // @Test(priority = 6)

//    void clickOnCartLink(){
//        System.out.println("Click on cart link...");
//        //driver.findElement(By.linkText("shopping cart")).click();
//       // driver.findElement(By.linkText("shopping cart")).click();
//        //driver.findElement(By.xpath("//*[@id=\"bar-notification\"]/div/p/a")).click();
//        driver.findElement(By.linkText("shopping cart")).click();
//    }
//    @Test(priority = 7)
//    void updateQuantity() {
//        System.out.println("update Quantity....");
//       //driver.findElement(By.id("itemquantity11223")).sendKeys("3");
//        driver.findElement(By.className("qty-input")).sendKeys("3");
//    }

    @Test(priority = 6)
    void updateShoppingCart() {
        System.out.println("change order 1 to 3 quantity...");
        //driver.findElement(By.xpath("//*[@id=\"itemquantity11229\"]")).sendKeys("3");
        driver.findElement(By.xpath("//*[@id=\"topcartlink\"]/a/span[2]")).click();
        driver.findElement(By.id("updatecart")).click();

        driver.findElement(By.className("qty-input")).clear();
        driver.findElement(By.className("qty-input")).sendKeys("3");


    }

    @Test(priority = 7)
    void checkBox() {
        System.out.println("select check box for checkout...");
        // driver.findElement(By.id("termsofservice")).click();
        driver.findElement(By.xpath("//*[@id=\"termsofservice\"]")).click();

    }

    @Test(priority = 8)
    void checkOut1() {
        System.out.println("click on checkout button..");
        //driver.findElement(By.id("checkout")).click();
        //driver.findElement(By.className("button-1 checkout-button")).click();
        driver.findElement(By.xpath("//*[@id=\"checkout\"]")).click();

    }

    @Test(priority = 9)
    void checkOutAsGuest() {
        System.out.println("guest check out");
        //driver.findElement(By.className("button-1 checkout-as-guest-button")).click();
        driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/div[1]/div[3]/button[1]")).click();
    }

    @Test(priority = 10)
    void formInfo() throws InterruptedException {
        System.out.println("first Name");
        driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("abc");

        System.out.println("Last Name");
        driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("ABC");

        System.out.println("Email");
        driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("Abc123@gmail.com");

        System.out.println("Country");
        WebElement country = driver.findElement(By.id("BillingNewAddress_CountryId"));
        SelectValueFromDropDownMenu(country, "United Kingdom");

        System.out.println("City");
        driver.findElement(By.id("BillingNewAddress_City")).sendKeys("Watford");

        System.out.println("Address");
        driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("A1,abcd,asde");

        System.out.println("ZipCode");
        driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("WD123WE");

        System.out.println("Phone Number");
        driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("1234567890");

        System.out.println("Ckock on continue button");
        //driver.findElement(By.className("button-1 new-address-next-step-button")).click();
        driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button[4]")).click();

        //Thread.sleep(1500);
        Thread.sleep(1000);

    }

    @Test(priority = 11)
    void selectShoppingMethod() throws InterruptedException {
        System.out.println("Card or money order");
        driver.findElement(By.id("shippingoption_1")).click();

        Thread.sleep(1000);
    }

    @Test(priority = 12)
    void paymentMethod() throws InterruptedException {
        System.out.println("Payment Methods");
        //driver.findElement(By.className("button-1 payment-method-next-step-button")).click();
        driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button")).click();
//driver.findElement(By.className("button-1 payment-method-next-step-button")).click();
//        driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/button")).click();

        Thread.sleep(1000);
    }

    @Test(priority = 13)
    void paymentInfo() throws InterruptedException {
        System.out.println("select card");
        Thread.sleep(1000);
        WebElement card = driver.findElement(By.className("dropdownlists"));
        Thread.sleep(200);
        SelectValueFromDropDownMenu(card, "Discover");
        Thread.sleep(500);

        System.out.println("CardholderName");
        driver.findElement(By.id("CardholderName")).sendKeys("ABC");

        System.out.println("CardNumber");
        driver.findElement(By.id("CardNumber")).sendKeys("1234567890");

        System.out.println("ExpireMonth");
        WebElement element1 = driver.findElement(By.id("ExpireMonth"));
        SelectValueFromDropDownMenu(element1, "02");

        System.out.println("ExpireYear");
        WebElement element2 = driver.findElement(By.id("ExpireYear"));
        SelectValueFromDropDownMenu(element2, "2025");

        System.out.println("CardCode");
        driver.findElement(By.id("CardCode")).sendKeys("321");

        System.out.println("button-1 payment-info-next-step-button - Continue button");
        driver.findElement(By.className("button-1 payment-info-next-step-button")).click();

        Thread.sleep(1000);
    }

    @Test(priority = 14)
    void checkOut() throws InterruptedException {
        System.out.println("conform order");
        driver.findElement(By.className("button-1 confirm-order-next-step-button")).click();
        Thread.sleep(1000);
    }

    @Test(priority = 15)
    void toGoHomePage() throws InterruptedException {
        System.out.println("To go home page again click on continue button");
        driver.findElement(By.className("button-1 order-completed-continue-button")).click();
        Thread.sleep(1000);
    }

    @Test(priority = 16)
    void closeBrowser() {
        System.out.println("Close Browser....");

    }
}
