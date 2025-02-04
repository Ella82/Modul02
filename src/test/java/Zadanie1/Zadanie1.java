package Zadanie1;


import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class Zadanie1 {


    private WebDriver driver;

    String address;
    String city;
    String postalcode;
    String phone;



    @Given("User is on the My story page")

    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver_linux64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://prod-kurs.coderslab.pl/index.php");
    }

    @When("User is going to change address page")

    public void SingIn() throws InterruptedException {

        WebElement singIn = driver.findElement(By.xpath("//span[contains(@class,'hidden-sm-down')]"));
        singIn.click();


        WebElement email = driver.findElement(By.name("email"));
        email.click();
        email.sendKeys("d1727619@urhen.com");
        Thread.sleep(1200);

        WebElement password = driver.findElement(By.name("password"));
        password.click();
        password.sendKeys("ydj9h8");
        Thread.sleep(1200);

        WebElement ok = driver.findElement(By.xpath("//button[contains(@class,'btn btn-primary')]"));
        ok.click();
        Thread.sleep(1200);

        WebElement Address = driver.findElement(By.xpath("//*[@id=\"footer_account_list\"]/li[4]/a"));
        Address.click();
        Thread.sleep(1200);

        WebElement CreateNewAdres = driver.findElement(By.xpath("//*[@data-link-action='add-address']"));
        CreateNewAdres.click();
        Thread.sleep(1200);

    }


    @And("a keyword (.*) is entered in input alias field")
    public void enteredInInputAlias(String alias) throws InterruptedException {
        WebElement InputAlias = driver.findElement(By.name("alias"));
        InputAlias.clear();
        InputAlias.sendKeys(alias);
        Thread.sleep(1200);


    }

    @And("a keyword (.*) is entered in input First name field")
    public void enteredInInputFirstName(String FirstName) throws InterruptedException {
        //firstName=FirstName;
        WebElement InputFirstName = driver.findElement(By.name("firstname"));
        InputFirstName.clear();
        InputFirstName.sendKeys(FirstName);
        Thread.sleep(1200);


    }

    @And("a keyword (.*) is entered in input Last name field")
    public void enteredInInputLastName(String LastName) throws InterruptedException {
        WebElement InputLastName = driver.findElement(By.name("lastname"));
        InputLastName.clear();
        InputLastName.sendKeys(LastName);
        Thread.sleep(1200);
    }

    @And("a keyword (.*) is entered in input Company field")
    public void enteredInInputCompany(String Company) throws InterruptedException {
        WebElement InputCompany = driver.findElement(By.name("company"));
        InputCompany.clear();
        InputCompany.sendKeys(Company);
        Thread.sleep(1200);
    }

    @And("a keyword (.*) is entered in input Vat number field")
    public void enteredInInputVat(String Vat) throws InterruptedException {
        WebElement InputVat = driver.findElement(By.name("vat_number"));
        InputVat.clear();
        InputVat.sendKeys(Vat);
        Thread.sleep(1200);
    }

    @And("a keyword (.*) is entered in input Address field")
    public void enteredInInputAddress(String Address) throws InterruptedException {
        address = Address;
        WebElement InputAddress = driver.findElement(By.name("address1"));
        InputAddress.clear();
        InputAddress.sendKeys(Address);
        Thread.sleep(1200);
    }

    @And("a keyword (.*) is entered in input Address Complement field")
    public void enteredInInputAddressComplement(String AddressComplement) throws InterruptedException {
        WebElement InputAddressComplement = driver.findElement(By.name("address2"));
        InputAddressComplement.clear();
        InputAddressComplement.sendKeys(AddressComplement);
        Thread.sleep(1200);
    }



    @And("a keyword (.*) is entered in input City field")
    public void enteredInInputCity(String City) throws InterruptedException {
        city=City;
        WebElement InputCity = driver.findElement(By.name("city"));
        InputCity.clear();
        InputCity.sendKeys(City);
        Thread.sleep(1200);

    }


    @And("a keyword (.*) is entered in Postal Code field")
    public void enteredInInputPostalCode(String PostalCode) throws InterruptedException {
        postalcode = PostalCode;
        WebElement InputPostalCode = driver.findElement(By.name("postcode"));
        InputPostalCode.clear();
        InputPostalCode.sendKeys(PostalCode);
        Thread.sleep(1200);
    }




    @And("a keyword United Kingdom is selected")
    public void enteredisSelected() throws InterruptedException {
        WebElement ImputCountry = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/form/section/div[10]/div[1]/select/option[2]"));
        ImputCountry.click();
        Thread.sleep(1200);
    }

    @And("a keyword (.*) is entered in input Phone field")
    public void enteredInInputPhone(String Phone) throws InterruptedException {
        phone = Phone;
        WebElement InputPhone = driver.findElement(By.name("phone"));
        InputPhone.clear();
        InputPhone.sendKeys(Phone);
        Thread.sleep(1200);
    }


    @And("the save button is selected")
    public void enteredInInputPhone() throws InterruptedException {
        WebElement submitButtom = driver.findElement(By.xpath("//button[contains(@class,'btn btn-primary float-xs-right')]"));
        submitButtom.click();
        Thread.sleep(1200);
    }


    @Then("the address changed and checked")
    public void closeBrowser()
    {
        List<WebElement> potw = driver.findElements(By.xpath("//article"));
        WebElement ostatni = potw.get(potw.size()-1);
        String adres = ostatni.getText();

        Assert.assertTrue(adres.contains(address));
        Assert.assertTrue(adres.contains(city));
        Assert.assertTrue(adres.contains(postalcode));
        Assert.assertTrue(adres.contains(phone));

    }

}