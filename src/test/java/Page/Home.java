package Page;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.Zip;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;

public class Home {
    private WebDriver driver;

    @BeforeTest
    public void LaunchHomePage(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.get("https://magento.softwaretestingboard.com/");
    }

//    @Test
//    public void CreateAccount(){
//        WebElement NewAccount = driver.findElement(By.cssSelector("a[href='https://magento.softwaretestingboard.com/customer/account/create/']\n"));
//        NewAccount.click();
//        WebElement FirstName = driver.findElement(By.id("firstname"));
//        FirstName.sendKeys("Rahul");
//        WebElement LastName = driver.findElement(By.id("lastname"));
//        LastName.sendKeys("Sharma");
//        WebElement Email = driver.findElement(By.id("email_address"));
//        Email.sendKeys("rahulsharma9336@gmail.com");
//        WebElement Password = driver.findElement(By.id("password"));
//        Password.sendKeys("Rahul@123");
//        WebElement ConfirmPassword = driver.findElement(By.id("password-confirmation"));
//        ConfirmPassword.sendKeys("Rahul@123");
//        WebElement CreateButton = driver.findElement(By.cssSelector(".action.submit.primary"));
//        CreateButton.click();
//    }
    @Test(priority = 1)
    public void Pagetitle(){
        String pageTitle = driver.getTitle();
        System.out.println("The Page Title is :"+pageTitle);
    }

    @Test(priority = 2)
    public void SignIn(){
        WebElement signIn = driver.findElement(By.cssSelector("a[href='https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/']\n"));
        signIn.click();
        WebElement Username = driver.findElement(By.id("email"));
        Username.sendKeys("rahulsharma9336@gmail.com");
        WebElement password = driver.findElement(By.id("pass"));
        password.sendKeys("Rahul@123");
        WebElement SignInButton = driver.findElement(By.cssSelector(".action.login.primary"));
        SignInButton.click();
    }

    @Test(priority = 3)
    public void VisitMyAccount(){
        WebElement dropDownClick = driver.findElement(By.cssSelector("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.customer-welcome > span > button"));
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(dropDownClick));
        dropDownClick.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        //My Account
        WebElement MyAccount = driver.findElement(By.cssSelector("a[href='https://magento.softwaretestingboard.com/customer/account/']\n"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        MyAccount.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        //Editing Address
        WebElement EditAddress = driver.findElement(By.cssSelector("[data-ui-id='default-shipping-edit-link']\n"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        EditAddress.click();

//        driver.navigate().refresh();

        //Adding Phone Number
        WebElement PhoneNumber = driver.findElement(By.id("telephone"));
        PhoneNumber.clear();
        PhoneNumber.sendKeys("7275009001");

        //Adding Address in the Street form
        WebElement Street1 = driver.findElement(By.id("street_1"));
        Street1.clear();
        Street1.sendKeys("Shree PG , Near V Mart Mall");
        WebElement Street2 = driver.findElement(By.id("street_2"));
        Street2.clear();
        Street2.sendKeys("Bhangel Market");
        WebElement Street3 = driver.findElement(By.id("street_3"));
        Street3.clear();
        Street3.sendKeys("Sector-102 ");

        //Adding City
        WebElement City = driver.findElement(By.id("city"));
        City.clear();
        City.sendKeys("Noida");

        //Selecting Country
        By dropdownSelector2 = By.id("country");
        WebElement dropdownElement2 = driver.findElement(dropdownSelector2);
        Select select2 = new Select(dropdownElement2);
        select2.selectByValue("IN");

        //Selecting Region nd State
        By dropdownSelector1 = By.id("region_id");
        WebElement dropdownElement1 = driver.findElement(dropdownSelector1);
        Select select1 = new Select(dropdownElement1);
        select1.selectByValue("566");

        //Adding Zip/Postal Code
        WebElement Zip = driver.findElement(By.id("zip"));
        Zip.clear();
        Zip.sendKeys("202304");

        WebElement SubmitButton = driver.findElement(By.cssSelector(".action.save.primary"));
        SubmitButton.click();

        WebElement ChangeBillingAddress = driver.findElement(By.cssSelector("a.action.edit[href='https://magento.softwaretestingboard.com/customer/address/edit/id/25926/']\n"));
        ChangeBillingAddress.click();

        WebElement ChangeCity = driver.findElement(By.cssSelector("input[value='Noida']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ChangeCity.clear();
        ChangeCity.sendKeys("Varanasi");

        WebElement ChangeZip = driver.findElement(By.cssSelector("input[value='202304']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ChangeZip.clear();
        ChangeZip.sendKeys("231225");

        WebElement ReSubmit = driver.findElement(By.cssSelector(".action.save.primary"));
        ReSubmit.click();

    }


    @Test(priority = 4)
    public void Wishlist(){
        //Clicking on the logo to navigate to the main page of the Website to view the Product Items
        WebElement ClickOnLogo = driver.findElement(By.cssSelector("img[src='https://magento.softwaretestingboard.com/pub/static/version1695896754/frontend/Magento/luma/en_US/images/logo.svg']\n"));
        ClickOnLogo.click();

        //Scrolling down the page to view the Required Products , so that we can Wishlist them
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1700)");

        //Hovering the cursor to the Product Item , so that the Wishlist Option is Visible
        WebElement elementToHover1 = driver.findElement(By.cssSelector("img[alt='Argus All-Weather Tank']\n"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(elementToHover1).perform();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Adding First Item to Wishlist
        WebElement AddtoWishlist_1 = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[3]/div[3]/div/div/ol/li[3]/div/div/div[3]/div/div[2]/a[1]"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        AddtoWishlist_1.click();


        //Navigating back to the Product Page
        driver.navigate().back();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        //Hovering on the Second Product Item
        WebElement elementToHover2 = driver.findElement(By.cssSelector("img[alt='Hero Hoodie']\n"));
        Actions actions2 = new Actions(driver);
        actions2.moveToElement(elementToHover2).perform();

        //Adding Second Product Item to the Wishlist
        WebElement AddtoWishlist_2 = driver.findElement(By.xpath("//li[4]//div[1]//div[1]//div[3]//div[1]//div[2]//a[1]"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        AddtoWishlist_2.click();

        //Navigating again back to the main page of the Product Item
        driver.navigate().back();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Hovering on the Third Product Item
        WebElement elementToHover3 = driver.findElement(By.cssSelector("img[alt='Radiant Tee']\n"));
        Actions actions3 = new Actions(driver);
        actions3.moveToElement(elementToHover3).perform();

        //Adding Third Item to the Wishlist
        WebElement AddtoWishlist_3 = driver.findElement(By.xpath("//li[1]//div[1]//div[1]//div[4]//div[1]//div[2]//a[1]"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        AddtoWishlist_3.click();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Scrolling the page to view the Required Product Item
//        JavascriptExecutor js1 = (JavascriptExecutor) driver;
//        js1.executeScript("window.scrollBy(0,1200)");

        //Again Hovering on the First Product Item Added to the Cart
//        WebElement elementToHover4 = driver.findElement(By.cssSelector("img[alt='Argus All-Weather Tank']\n"));
//        Actions actions4 = new Actions(driver);
//        actions4.moveToElement(elementToHover4).perform();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Removing the First Added Product Item from the Wishlist
        WebElement RemoveFirstItemAdded = driver.findElement(By.cssSelector(".product-item:nth-of-type(3)>div>.product-item-details>.product-item-actions>.actions-secondary>.btn-remove.action.delete"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        RemoveFirstItemAdded.click();

//        //Scrolling Down to View the Required Product Items
        JavascriptExecutor js2 = (JavascriptExecutor) driver;
        js2.executeScript("window.scrollBy(0,1100)");
//
//        //Hovering on the Product Items Which is to be Added to the Cart
//        WebElement elementToHover5 = driver.findElement(By.cssSelector("img[alt='Fusion Backpack']\n"));
//        Actions actions5 = new Actions(driver);
//        actions5.moveToElement(elementToHover5).perform();

//        //Adding to the Cart Which is lastly Wish listed in the Wishlist
        WebElement ToCart = driver.findElement(By.cssSelector("body > div:nth-child(5) > main:nth-child(3) > div:nth-child(3) > div:nth-child(3) > div:nth-child(3) > div:nth-child(2) > ol:nth-child(2) > li:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > button:nth-child(1) > span:nth-child(1)"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        ToCart.click();

        JavascriptExecutor js3 = (JavascriptExecutor) driver;
        js3.executeScript("window.scrollBy(0,350)");

        WebElement ItemSize = driver.findElement(By.id("option-label-size-143-item-169"));
        ItemSize.click();

        WebElement ItemColor = driver.findElement(By.xpath("//div[@class='swatch-attribute-options clearfix']/div[@class='swatch-option color'][1]\n"));
        ItemColor.click();

        WebElement AddToCart = driver.findElement(By.id("product-addtocart-button"));
        AddToCart.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test(priority = 5)
    public void AddToCompare(){

        WebElement ClickOnLogo = driver.findElement(By.cssSelector("img[src='https://magento.softwaretestingboard.com/pub/static/version1695896754/frontend/Magento/luma/en_US/images/logo.svg']\n"));
        ClickOnLogo.click();

        //Scrolling down the page to View the Product Items
        JavascriptExecutor js3 = (JavascriptExecutor) driver;
        js3.executeScript("window.scrollBy(0,1700)");

        //Hovering the cursor to the Product Item , so that the Wishlist Option is Visible
        WebElement elementToHover1 = driver.findElement(By.cssSelector("body > div:nth-child(5) > main:nth-child(3) > div:nth-child(4) > div:nth-child(1) > div:nth-child(6) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > ol:nth-child(1) > li:nth-child(3) > div:nth-child(1) > div:nth-child(2) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > form:nth-child(1) > button:nth-child(4) > span:nth-child(1)"));
        Actions actions1 = new Actions(driver);
        actions1.moveToElement(elementToHover1).perform();

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        //Clicking Item 1
        WebElement ClickOnItem1 = driver.findElement(By.cssSelector("img.product-image-photo[alt='Breathe-Easy Tank']"));
        ClickOnItem1.click();

        //Scrolling the Page
        JavascriptExecutor js4 = (JavascriptExecutor) driver;
        js4.executeScript("window.scrollBy(0,450)");

        //Adding Product Item 1 to the Compare List
        WebElement AddToCompare_1 = driver.findElement(By.cssSelector("a.action.tocompare"));
        AddToCompare_1.click();

        //Navigating Back 2 times
        driver.navigate().back();
        driver.navigate().back();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
        JavascriptExecutor js5 = (JavascriptExecutor) driver;
        js5.executeScript("window.scrollBy(0,250)");

        //Hovering on the Product Item 2
        WebElement elementToHover2 = driver.findElement(By.cssSelector("img[alt='Radiant Tee']\n"));
        Actions actions2 = new Actions(driver);
        actions2.moveToElement(elementToHover2).perform();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Clicking on the Product Item 2
        WebElement ClickOnItem2 = driver.findElement(By.cssSelector("img.product-image-photo[src='https://magento.softwaretestingboard.com/pub/media/catalog/product/cache/7c4c1ed835fbbf2269f24539582c6d44/w/s/ws12-orange_main_2.jpg']\n"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        ClickOnItem2.click();

        JavascriptExecutor js6 = (JavascriptExecutor) driver;
        js6.executeScript("window.scrollBy(0,550)");

        //Adding Second Product Item to Compare List
        WebElement AddToCompare_2 = driver.findElement(By.cssSelector("a.action.tocompare"));
        AddToCompare_2.click();

        //Clicking on the Compare Product List to open it
        WebElement CompareProducts = driver.findElement(By.cssSelector("a.action.compare"));
        CompareProducts.click();

        //Adding the Product item into the Cart having Max Reviews
        WebElement OpenItem_With_MaxReview = driver.findElement(By.xpath("//tbody/tr/td[1]/div[3]/div[1]/form[1]/button[1]/span[1]"));
        OpenItem_With_MaxReview.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        JavascriptExecutor js7 = (JavascriptExecutor) driver;
        js7.executeScript("window.scrollBy(0,1000)");

        //Selecting Size
        WebElement ItemSize = driver.findElement(By.id("option-label-size-143-item-169"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ItemSize.click();

        //Selecting Color
        WebElement ItemColor = driver.findElement(By.xpath("//div[@class='swatch-attribute-options clearfix']/div[@class='swatch-option color'][1]\n"));
        ItemColor.click();

        //Adding to the Cart
        WebElement AddToCart = driver.findElement(By.id("product-addtocart-button"));
        AddToCart.click();

        driver.navigate().back();

        //Removing Product from Compare list
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        WebElement RemoveItemFromCompareList1 = driver.findElement(By.xpath("//thead//td[1]//a[1]"));
        RemoveItemFromCompareList1.click();


        WebElement ConfirmRemove1 = driver.findElement(By.cssSelector(".action-primary.action-accept"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ConfirmRemove1.click();

        WebElement RemoveItemFromCompareList2 = driver.findElement(By.xpath("//thead//td[1]//a[1]"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        RemoveItemFromCompareList2.click();

        WebElement ConfirmRemove2 = driver.findElement(By.cssSelector(".action-primary.action-accept"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ConfirmRemove2.click();
    }

    @Test(priority = 6)
    public void Cart() throws InterruptedException {
        //Naviagting to the Cart
        WebElement VisitTheCart = driver.findElement(By.xpath("//a[@class='action showcart']"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        VisitTheCart.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Clicking on the Visit and Edit cart section of the Cart
        WebElement VisitAndEditCart = driver.findElement(By.cssSelector("#minicart-content-wrapper > div.block-content > div:nth-child(7) > div > a"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        VisitAndEditCart.click();

        //Printing the Size of the Cart
        WebElement SizeOfCart = driver.findElement(By.cssSelector("span.counter-label"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String Size = SizeOfCart.getText();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println("The Size of the Cart is :" + Size);

        //Printing the Total Order Amount
        WebElement PrintOrderTotal = driver.findElement(By.cssSelector(".grand.totals"));
        String OrderTotal = PrintOrderTotal.getText();
        System.out.println("The total Product Order is :" + OrderTotal);

        //Procceding the Checkout
        WebElement ProceedToCheckout = driver.findElement(By.cssSelector("button[data-role='proceed-to-checkout'][title='Proceed to Checkout'].action.primary.checkout"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        ProceedToCheckout.click();

        //Clicking the Next Button to move to the Place order Section
        WebElement NextButtonClick = driver.findElement(By.cssSelector("button[data-role='opc-continue'][type='submit'].button.action.continue.primary"));
        Thread.sleep(5);
        NextButtonClick.click();

        //Placing the Order
        WebElement PlaceOrder = driver.findElement(By.cssSelector(".action.primary.checkout"));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        PlaceOrder.click();

        //Printing the Order Number of the Product Being Placed
        WebElement PrintOrderNumber = driver.findElement(By.cssSelector("a.order-number"));
        String OrderNumber = PrintOrderNumber.getText();
        System.out.println("The total Product Order is :" + OrderNumber);
    }

    @AfterTest
    public void QuitBrowser(){
        driver.quit();
    }

}
