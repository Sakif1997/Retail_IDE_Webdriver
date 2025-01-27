package TestCases;
import org.junit.Test; 
import org.junit.Before;
import org.junit.After;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class RetailAutoCarLoanTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void LogIN() {
    driver.get("http://10.11.200.14:9040/eocas/logIn.do");
    driver.manage().window().setSize(new Dimension(1382, 744));
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).sendKeys("k.rm");
    driver.findElement(By.id("password")).sendKeys("123456");
    driver.findElement(By.linkText("Sign In")).click();
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.findElement(By.linkText("Sign In")).click();
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.findElement(By.id("CFC")).click();
  }
  @Test
  public void NewApplicationGenerationSimplified() {
    driver.get("http://10.11.200.14:9040/eocas/goProjectsHome.do");
    driver.findElement(By.linkText("New Application")).click();
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.findElement(By.xpath("//button[contains(text(),\'De-Dup Check\')]")).click();
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.findElement(By.name("checkedFlagCode")).click();
    {
      WebElement dropdown = driver.findElement(By.name("checkedFlagCode"));
      dropdown.findElement(By.xpath("//option[. = 'YES']")).click();
    }
    driver.findElement(By.id("exeShowHideBtn")).click();
    driver.findElement(By.xpath("//button[contains(text(),\'Back\')]")).click();
    driver.findElement(By.name("customerName")).click();
    vars.put("randomApplicantFullName", js.executeScript("var firstNames = [   \"Abdul\",   \"Rafiqul\",   \"Hasan\",   \"Nazmul\",   \"Sohail\",   \"Farhana\",   \"Shamima\",   \"Mitu\",   \"Sadia\",   \"Jannatul\" ]; var lastNames = [   \"Rahman\",   \"Chowdhury\",   \"Khan\",   \"Ahmed\",   \"Hossain\",   \"Molla\",   \"Miah\",   \"Sarker\",   \"Ferdous\",   \"Kabir\" ];  var randomFirstName = firstNames[Math.floor(Math.random() * firstNames.length)]; var randomLastName = lastNames[Math.floor(Math.random() * lastNames.length)];  var fullName = randomFirstName + \" \" + randomLastName; return fullName;"));
    driver.findElement(By.name("customerName")).sendKeys(vars.get("randomApplicantFullName").toString());
   // vars.put("vars.get("randomApplicantFullName").toString()", driver.findElement(By.name("customerName")).getAttribute("value"));
    vars.put("randomApplicantFullName", driver.findElement(By.name("customerName")).getAttribute("value"));

    driver.findElement(By.name("basicAliasName")).click();
    driver.findElement(By.name("basicCustType")).click();
    {
      WebElement dropdown = driver.findElement(By.name("basicCustType"));
      dropdown.findElement(By.xpath("//option[. = 'BUSINESSMAN']")).click();
    }
    driver.findElement(By.name("basicCustCategory")).click();
    {
      WebElement dropdown = driver.findElement(By.name("basicCustCategory"));
      dropdown.findElement(By.xpath("//option[. = 'Employed']")).click();
    }
    driver.findElement(By.name("basicCustCategoryNew")).click();
    {
      WebElement dropdown = driver.findElement(By.name("basicCustCategoryNew"));
      dropdown.findElement(By.xpath("//option[. = 'Payroll']")).click();
    }
    driver.findElement(By.id("branchInfoSearch")).click();
    driver.findElement(By.xpath("//td[contains(text(),\'Banani\')]")).click();
    driver.findElement(By.id("basicAlternativeRM")).click();
    driver.findElement(By.name("assesmentTypeCode")).click();
    {
      WebElement dropdown = driver.findElement(By.name("assesmentTypeCode"));
      dropdown.findElement(By.xpath("//option[. = 'SIMPLIFIED ASSESSMENT']")).click();
    }
    driver.findElement(By.id("appIdGenerate")).click();
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
  @Test
  public void FacilityInfoAutoCarLoan() {
    driver.get("http://10.11.200.14:9040/eocas/loanInfoTabRetailApplication.do");
    driver.findElement(By.name("loanProduct")).click();
    {
      WebElement dropdown = driver.findElement(By.name("loanProduct"));
      dropdown.findElement(By.xpath("//option[. = 'UNSECURED']")).click();
    }
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.findElement(By.id("loanType")).click();
    {
      WebElement dropdown = driver.findElement(By.id("loanType"));
      dropdown.findElement(By.xpath("//option[. = 'EBL Car Loan(0711)']")).click();
    }
    driver.findElement(By.id("loanAmount")).click();
    driver.findElement(By.id("loanAmount")).sendKeys("350000");
    driver.findElement(By.id("loanTenor")).click();
    driver.findElement(By.id("loanTenor")).sendKeys("60");
    driver.findElement(By.id("loanTenor")).sendKeys(Keys.ENTER);
    driver.findElement(By.name("loanRepaymentDate")).click();
    driver.findElement(By.name("loanCampaign")).click();
    driver.findElement(By.name("loanPurpose")).click();
    driver.findElement(By.name("loanProposalType")).click();
    {
      WebElement dropdown = driver.findElement(By.name("loanProposalType"));
      dropdown.findElement(By.xpath("//option[. = 'NEW']")).click();
    }
    driver.findElement(By.cssSelector("#\\32 > .row-fluid:nth-child(4)")).click();
    driver.findElement(By.id("loanInterestRate")).sendKeys("9");
    driver.findElement(By.name("loanDisburseAcc")).click();
    driver.findElement(By.name("loanStartFrom")).click();
    //vars.put("randomLoanStartDate", js.executeScript("var daysFromNow = 30; var currentDate = new Date(); var futureDate = new Date(); futureDate.setDate(currentDate.getDate() + daysFromNow); var randomTimestamp = currentDate.getTime() + Math.random() * (futureDate.getTime() - currentDate.getTime()); var randomDate = new Date(randomTimestamp); var day = String(randomDate.getDate()).padStart(2, \'0\'); var month = String(randomDate.getMonth() + 1).padStart(2, \'0\');var year = randomDate.getFullYear(); return \`arguments[0]/arguments[1]/arguments[2]\`;", vars.get("day"),vars.get("month"),vars.get("year")));
    vars.put("randomLoanStartDate", js.executeScript(
    	    "var daysFromNow = 30;" +
    	    "var currentDate = new Date();" +
    	    "var futureDate = new Date();" +
    	    "futureDate.setDate(currentDate.getDate() + daysFromNow);" +
    	    "var randomTimestamp = currentDate.getTime() + Math.random() * (futureDate.getTime() - currentDate.getTime());" +
    	    "var randomDate = new Date(randomTimestamp);" +
    	    "var day = String(randomDate.getDate()).padStart(2, '0');" +
    	    "var month = String(randomDate.getMonth() + 1).padStart(2, '0');" +
    	    "var year = randomDate.getFullYear();" +
    	    "return day + '/' + month + '/' + year;"
    	));
    driver.findElement(By.name("loanStartFrom")).sendKeys(vars.get("randomLoanStartDate").toString());
    driver.findElement(By.name("loanCurrentDate")).click();
    driver.findElement(By.cssSelector(".row-fluid:nth-child(10) .btn-add")).click();
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    assertThat(driver.findElement(By.cssSelector("b:nth-child(2)")).getText(), is("Execution Completed Successfully...!!!"));
  }
  @Test
  public void vDetails() {
    driver.get("http://10.11.200.14:9040/eocas/vehicleInfoRetailApplication.do");
    driver.findElement(By.name("modalVehicleBrand")).click();
    driver.findElement(By.name("modalVehicleBrand")).sendKeys("Hero Hunda");
    driver.findElement(By.name("modalVehicleModel")).click();
    driver.findElement(By.name("modalVehicleModel")).sendKeys("Apache RTR 2025");
    driver.findElement(By.name("modalVehicleManufacturingYear")).click();
    driver.findElement(By.name("modalVehicleManufacturingYear")).sendKeys("2025");
    driver.findElement(By.id("modalVehicleStatus")).click();
    {
      WebElement dropdown = driver.findElement(By.id("modalVehicleStatus"));
      dropdown.findElement(By.xpath("//option[. = 'NEW']")).click();
    }
    driver.findElement(By.name("modalVehicleEngineNo")).click();
    driver.findElement(By.name("modalVehicleEngineNo")).sendKeys("ENG756464654655");
    driver.findElement(By.name("modalVehicleChassisNo")).click();
    driver.findElement(By.name("modalVehicleChassisNo")).sendKeys("Chassis123456789");
    driver.findElement(By.name("modalVehicleEngineDisplacement")).click();
    driver.findElement(By.name("modalVehicleEngineDisplacement")).sendKeys("4");
    driver.findElement(By.name("modalVehicleVendor")).click();
    driver.findElement(By.name("modalVehicleVendor")).sendKeys("Testing Vendor Motors Limited");
    driver.findElement(By.id("modalVehicleQuotationDate")).click();
    driver.findElement(By.id("modalVehicleQuotationDate")).sendKeys("07/01/2025");
    driver.findElement(By.name("modalVehicleVehicleValue")).sendKeys("250000");
    driver.findElement(By.name("modalVehicleContactPerson")).click();
    driver.findElement(By.name("modalVehicleContactPerson")).sendKeys("Test Contact Person.--456");
    driver.findElement(By.name("modalVehicleVendorSellerAddress")).click();
    driver.findElement(By.name("modalVehicleVendorSellerAddress")).sendKeys("Test Test Test Test Test Test TEst Test Test Test TEst Vendor/Seller Address");
    driver.findElement(By.name("modalVehicleVendorSellerTelephone")).click();
    driver.findElement(By.name("modalVehicleVendorSellerTelephone")).sendKeys("01748963214");
    driver.findElement(By.name("modalVehicleVendorSellerMobile")).click();
    driver.findElement(By.name("modalVehicleVendorSellerMobile")).sendKeys("01617456497");
    driver.findElement(By.name("modalVehicleVehicleRegistrationNo")).click();
    driver.findElement(By.name("modalVehicleVehicleRegistrationNo")).sendKeys("DH_Metro-15/74789");
    driver.findElement(By.id("modalVehicleVehicleRegistrationDate")).click();
    driver.findElement(By.id("modalVehicleVehicleRegistrationDate")).sendKeys("06/01/2025");
    driver.findElement(By.id("modalVehicleValuationCompany")).click();
    {
      WebElement dropdown = driver.findElement(By.id("modalVehicleValuationCompany"));
      dropdown.findElement(By.xpath("//option[. = 'M/s. Bhuiyan Associates Survey & Developers Ltd']")).click();
    }
    driver.findElement(By.name("modalVehicleMarketValue")).click();
    driver.findElement(By.name("modalVehicleMarketValue")).sendKeys("300000");
    driver.findElement(By.name("modalVehicleForcedSaleValue")).click();
    driver.findElement(By.name("modalVehicleForcedSaleValue")).sendKeys("310000");
    driver.findElement(By.id("modalVehicleValuationReportDate")).click();
    driver.findElement(By.id("modalVehicleValuationReportDate")).sendKeys("29/01/2025");
    driver.findElement(By.id("modalVehicleFitnessCertificateValidity")).click();
    driver.findElement(By.id("modalVehicleFitnessCertificateValidity")).sendKeys("31/01/2025");
    driver.findElement(By.id("modalVehicleTaxTokenValidity")).click();
    driver.findElement(By.id("modalVehicleTaxTokenValidity")).sendKeys("21/12/2026");
    driver.findElement(By.id("addBtnV")).click();
    assertThat(driver.findElement(By.xpath("//div[@id=\'messageDiv\']/b")).getText(), is("Vehicle data add Successful"));
    driver.findElement(By.cssSelector(".lbl-08:nth-child(9) img")).click();
    {
      String value = driver.findElement(By.name("modalVehicleBrand")).getAttribute("value");
      assertThat(value, is("Hero Hunda"));
    }
    {
      String value = driver.findElement(By.name("modalVehicleModel")).getAttribute("value");
      assertThat(value, is("Apache RTR 2025"));
    }
    {
      String value = driver.findElement(By.name("modalVehicleManufacturingYear")).getAttribute("value");
      assertThat(value, is("2025"));
    }
    {
      WebElement element = driver.findElement(By.id("modalVehicleStatus"));
      String value = element.getAttribute("value");
      String locator = String.format("option[@value='%s']", value);
      String selectedText = element.findElement(By.xpath(locator)).getText();
      assertThat(selectedText, is("NEW"));
    }
    {
      String value = driver.findElement(By.name("modalVehicleEngineNo")).getAttribute("value");
      assertThat(value, is("ENG756464654655"));
    }
    {
      String value = driver.findElement(By.name("modalVehicleChassisNo")).getAttribute("value");
      assertThat(value, is("Chassis123456789"));
    }
    {
      String value = driver.findElement(By.name("modalVehicleEngineDisplacement")).getAttribute("value");
      assertThat(value, is("4"));
    }
    {
      String value = driver.findElement(By.name("modalVehicleVendor")).getAttribute("value");
      assertThat(value, is("Testing Vendor Motors Limited"));
    }
    {
      String value = driver.findElement(By.id("modalVehicleQuotationDate")).getAttribute("value");
      assertThat(value, is("07/01/2025"));
    }
    driver.findElement(By.cssSelector(".row-fluid:nth-child(8) > .span3:nth-child(2)")).click();
    {
      String value = driver.findElement(By.name("modalVehicleVehicleValue")).getAttribute("value");
      assertThat(value, is("250,000.00"));
    }
    {
      String value = driver.findElement(By.name("modalVehicleContactPerson")).getAttribute("value");
      assertThat(value, is("Test Contact Person.--456"));
    }
    {
      String value = driver.findElement(By.name("modalVehicleVendorSellerAddress")).getAttribute("value");
      assertThat(value, is("Test Test Test Test Test Test TEst Test Test Test TEst Vendor/Seller Address"));
    }
    {
      String value = driver.findElement(By.name("modalVehicleVendorSellerTelephone")).getAttribute("value");
      assertThat(value, is("01748963214"));
    }
    {
      String value = driver.findElement(By.name("modalVehicleVendorSellerMobile")).getAttribute("value");
      assertThat(value, is("01617456497"));
    }
    {
      String value = driver.findElement(By.name("modalVehicleVehicleRegistrationNo")).getAttribute("value");
      assertThat(value, is("DH_Metro-15/74789"));
    }
    {
      String value = driver.findElement(By.id("modalVehicleVehicleRegistrationDate")).getAttribute("value");
      assertThat(value, is("06/01/2025"));
    }
    driver.findElement(By.cssSelector(".row-fluid:nth-child(5) > .span3:nth-child(4)")).click();
    {
      WebElement element = driver.findElement(By.id("modalVehicleValuationCompany"));
      String value = element.getAttribute("value");
      String locator = String.format("option[@value='%s']", value);
      String selectedText = element.findElement(By.xpath(locator)).getText();
      assertThat(selectedText, is("M/s. Bhuiyan Associates Survey & Developers Ltd"));
    }
    {
      String value = driver.findElement(By.name("modalVehicleMarketValue")).getAttribute("value");
      assertThat(value, is("300,000.00"));
    }
    driver.findElement(By.name("modalVehicleForcedSaleValue")).click();
    {
      String value = driver.findElement(By.name("modalVehicleForcedSaleValue")).getAttribute("value");
      assertThat(value, is("310,000.00"));
    }
    {
      String value = driver.findElement(By.id("modalVehicleValuationReportDate")).getAttribute("value");
      assertThat(value, is("29/01/2025"));
    }
    driver.findElement(By.cssSelector(".row-fluid:nth-child(7) > .span3:nth-child(4)")).click();
    {
      String value = driver.findElement(By.id("modalVehicleFitnessCertificateValidity")).getAttribute("value");
      assertThat(value, is("31/01/2025"));
    }
    driver.findElement(By.cssSelector(".row-fluid:nth-child(11) > .span3:nth-child(3) > .control-label")).click();
    {
      String value = driver.findElement(By.id("modalVehicleTaxTokenValidity")).getAttribute("value");
      assertThat(value, is("21/12/2026"));
    }
  }
  @Test
  public void ApplicantInfo() {
    driver.get("http://10.11.200.14:9040/eocas/customerInfoTabRetailApplication.do");
    driver.findElement(By.name("custInfoNickName")).click();
    vars.put("randomNickName", js.executeScript("var nicknames = [   \"Raju\",   \"Mitu\",   \"Shuvo\",   \"Pintu\",   \"Nipa\",   \"Sima\",   \"Rita\",   \"Babu\",   \"Titu\",   \"Jitu\",   \"Jony\",   \"Audry\",   \"Nuha\",   \"Shurjo\",   \"Birag\",   \"Ripu\",   \"Nilu\" ];  var randomNickname = nicknames[Math.floor(Math.random() * nicknames.length)]; return randomNickname;"));
    driver.findElement(By.name("custInfoNickName")).sendKeys(vars.get("randomNickName").toString());
    driver.findElement(By.name("custInfoFatherName")).click();
    vars.put("randomFathersName", js.executeScript("var firstNames = [   \"Abdul\",   \"Mohammad\",   \"Ghulam\",   \"Rafiqul\",   \"Kamal\",   \"Harun\",   \"Jalal\",   \"Nazrul\",   \"Shafiq\",   \"Abul\",   \"Touhidul\" ]; var lastNames = [   \"Rahman\",   \"Chowdhury\",   \"Hossain\",   \"Khan\",   \"Ahmed\",   \"Siddiqui\",   \"Molla\",   \"Miah\",   \"Uddin\",   \"Kabir\",   \"Fayez\" ];  var randomFirstName = firstNames[Math.floor(Math.random() * firstNames.length)]; var randomLastName = lastNames[Math.floor(Math.random() * lastNames.length)];  var fullName = randomFirstName + \" \" + randomLastName; return fullName;"));
    driver.findElement(By.name("custInfoFatherName")).sendKeys(vars.get("randomFathersName").toString());
    driver.findElement(By.name("custInfoFatherProfession")).click();
    driver.findElement(By.name("custInfoFatherContactNo")).click();
    vars.put("randomPhoneNum", js.executeScript("var prefixes = [\"013\", \"015\", \"016\", \"017\", \"018\", \"019\"];  var prefix = prefixes[Math.floor(Math.random() * prefixes.length)];  var remainingDigits = \"\"; for (var i = 0; i < 8; i++) {   remainingDigits += Math.floor(Math.random() * 10); }  var phoneNumber = prefix + remainingDigits; return phoneNumber;"));
    driver.findElement(By.name("custInfoFatherContactNo")).sendKeys(vars.get("randomPhoneNum").toString());
    driver.findElement(By.name("custInfoMotherName")).click();
    vars.put("randomMothersName", js.executeScript("var firstNames = [   \"Fatema\",   \"Rokeya\",   \"Sharifa\",   \"Hamida\",   \"Ayesha\",   \"Jahanara\",   \"Nurjahan\",   \"Rashida\",   \"Shamsunnahar\",   \"Firoza\" ]; var lastNames = [   \"Begum\",   \"Rahman\",   \"Chowdhury\",   \"Ahmed\",   \"Hossain\",   \"Siddiqui\",   \"Molla\",   \"Miah\",   \"Kabir\",   \"Uddin\" ];  var randomFirstName = firstNames[Math.floor(Math.random() * firstNames.length)]; var randomLastName = lastNames[Math.floor(Math.random() * lastNames.length)];  var fullName = randomFirstName + \" \" + randomLastName; return fullName;"));
    driver.findElement(By.name("custInfoMotherName")).sendKeys(vars.get("randomMothersName").toString());
    driver.findElement(By.name("custInfoMotherProfession")).click();
    driver.findElement(By.name("custInfoMotherContactNo")).click();
    vars.put("randomPhonNum", js.executeScript("var prefixes = [\"013\", \"015\", \"016\", \"017\", \"018\", \"019\"];  var prefix = prefixes[Math.floor(Math.random() * prefixes.length)];  var remainingDigits = \"\"; for (var i = 0; i < 8; i++) {   remainingDigits += Math.floor(Math.random() * 10); }  var phoneNumber = prefix + remainingDigits; return phoneNumber;"));
    driver.findElement(By.name("custInfoMotherContactNo")).sendKeys(vars.get("randomPhonNum").toString());
    driver.findElement(By.name("custInfoGender")).click();
    {
      WebElement dropdown = driver.findElement(By.name("custInfoGender"));
      dropdown.findElement(By.xpath("//option[. = 'Male']")).click();
    }
    driver.findElement(By.name("custInfoResidentStatus")).click();
    driver.findElement(By.name("custInfoCurrentResidence")).click();
    vars.put("randomAddress", js.executeScript("var districts = [   \"Dhaka\" ]; var areas = [   \"Gulshan\",   \"Banani\",   \"Dhanmondi\",   \"Motijheel\",   \"Agargaon\",   \"Khilgaon\",   \"Banasree\",   \"Rampura\",   \"Uttara\",   \"Badda\",   \"Motijheel\",   \"Paltan\" ]; var roads = [   \"Road-5\",   \"Road-12\",   \"Road-7A\",   \"Street-3\",   \"Lane-4\",   \"Sector-10\",   \"Block-B\",   \"Avenue-2\" ]; var houseNumber = \"House-\" + Math.floor(Math.random() * 100 + 1);  var district = districts[Math.floor(Math.random() * districts.length)]; var area = areas[Math.floor(Math.random() * areas.length)]; var road = roads[Math.floor(Math.random() * roads.length)];  var address = houseNumber + \", \" + road + \", \" + area + \", \" + district + \", Bangladesh\"; return address;"));
    driver.findElement(By.name("custInfoCurrentResidence")).sendKeys(vars.get("randomAddress").toString());
    driver.findElement(By.name("custInfoPermanentResidence")).click();
    vars.put("randomAddress", js.executeScript("var districts = [   \"Dhaka\" ]; var areas = [   \"Gulshan\",   \"Banani\",   \"Dhanmondi\",   \"Motijheel\",   \"Agargaon\",   \"Khilgaon\",   \"Banasree\",   \"Rampura\",   \"Uttara\",   \"Badda\",   \"Motijheel\",   \"Paltan\" ]; var roads = [   \"Road-5\",   \"Road-12\",   \"Road-7A\",   \"Street-3\",   \"Lane-4\",   \"Sector-10\",   \"Block-B\",   \"Avenue-2\" ]; var houseNumber = \"House-\" + Math.floor(Math.random() * 100 + 1);  var district = districts[Math.floor(Math.random() * districts.length)]; var area = areas[Math.floor(Math.random() * areas.length)]; var road = roads[Math.floor(Math.random() * roads.length)];  var address = houseNumber + \", \" + road + \", \" + area + \", \" + district + \", Bangladesh\"; return address;"));
    driver.findElement(By.name("custInfoPermanentResidence")).sendKeys(vars.get("randomAddress").toString());
    driver.findElement(By.name("custInfoContactNo")).click();
    vars.put("randomPhonNum", js.executeScript("var prefixes = [\"013\", \"015\", \"016\", \"017\", \"018\", \"019\"];  var prefix = prefixes[Math.floor(Math.random() * prefixes.length)];  var remainingDigits = \"\"; for (var i = 0; i < 8; i++) {   remainingDigits += Math.floor(Math.random() * 10); }  var phoneNumber = prefix + remainingDigits; return phoneNumber;"));
    driver.findElement(By.name("custInfoContactNo")).sendKeys(vars.get("randomPhonNum").toString());
    driver.findElement(By.name("custInfoOptionalContactNo1")).click();
    vars.put("randomPhonNum", js.executeScript("var prefixes = [\"013\", \"015\", \"016\", \"017\", \"018\", \"019\"];  var prefix = prefixes[Math.floor(Math.random() * prefixes.length)];  var remainingDigits = \"\"; for (var i = 0; i < 8; i++) {   remainingDigits += Math.floor(Math.random() * 10); }  var phoneNumber = prefix + remainingDigits; return phoneNumber;"));
    driver.findElement(By.name("custInfoOptionalContactNo1")).sendKeys(vars.get("randomPhonNum").toString());
    driver.findElement(By.name("custInfoOptionalContactNo2")).click();
    vars.put("randomPhonNum", js.executeScript("var prefixes = [\"013\", \"015\", \"016\", \"017\", \"018\", \"019\"];  var prefix = prefixes[Math.floor(Math.random() * prefixes.length)];  var remainingDigits = \"\"; for (var i = 0; i < 8; i++) {   remainingDigits += Math.floor(Math.random() * 10); }  var phoneNumber = prefix + remainingDigits; return phoneNumber;"));
    driver.findElement(By.name("custInfoOptionalContactNo2")).sendKeys(vars.get("randomPhonNum").toString());
    driver.findElement(By.name("custInfoFaxNo")).click();
    driver.findElement(By.name("custInfoFaxNo")).sendKeys("FX-41236");
    driver.findElement(By.name("custInfoDateOfBirth")).click();
    //vars.put("dob20", js.executeScript("var desiredAge = 20;  var currentDate = new Date(); currentDate.setFullYear(currentDate.getFullYear() - desiredAge);  var day = String(currentDate.getDate()).padStart(2, \'0\');  var month = String(currentDate.getMonth() + 1).padStart(2, \'0\'); var year = currentDate.getFullYear();  return \`arguments[0]/arguments[1]/arguments[2]\`;", vars.get("day"),vars.get("month"),vars.get("year")));
    vars.put("dob20", js.executeScript(
    	    "var desiredAge = 20;" +
    	    "var currentDate = new Date();" +
    	    "currentDate.setFullYear(currentDate.getFullYear() - desiredAge);" +
    	    "var day = String(currentDate.getDate()).padStart(2, '0');" +
    	    "var month = String(currentDate.getMonth() + 1).padStart(2, '0');" +
    	    "var year = currentDate.getFullYear();" +
    	    "return day + '/' + month + '/' + year;"
    	));
    driver.findElement(By.name("custInfoDateOfBirth")).sendKeys(vars.get("dob20").toString());
    driver.findElement(By.name("custInfoDateOfBirth")).click();
    driver.findElement(By.linkText("7")).click();
    driver.findElement(By.name("custInfoNidPassport")).click();
    vars.put("randomNID", js.executeScript("return Math.floor(Math.random() * 10**16).toString().padStart(17, \'0\');"));
    driver.findElement(By.name("custInfoNidPassport")).sendKeys(vars.get("randomNID").toString());
    driver.findElement(By.name("custInfoPassportNo")).click();
    vars.put("randomPassNo", js.executeScript("return String.fromCharCode(65 + Math.floor(Math.random() * 26)) + Math.floor(10000000 + Math.random() * 90000000).toString();"));
    driver.findElement(By.name("custInfoPassportNo")).sendKeys(vars.get("randomPassNo").toString());
    driver.findElement(By.name("custInfoValidity")).click();
    driver.findElement(By.name("custInfoValidity")).sendKeys("31/12/2030");
    driver.findElement(By.name("custInfoBirthCertificateNo")).click();
    vars.put("randomBirthCerNo", js.executeScript("return Math.floor(Math.random() * 10**16).toString().padStart(17, \'0\');"));
    driver.findElement(By.name("custInfoBirthCertificateNo")).sendKeys(vars.get("randomBirthCerNo").toString());
    driver.findElement(By.name("custInfoDrivingLicenseNo")).click();
    driver.findElement(By.name("custInfoDrivingLicenseNo")).sendKeys("DRV1236987");
    driver.findElement(By.name("custInfoEtinNo")).click();
    vars.put("randomETIN", js.executeScript("return Math.floor(100000000000 + Math.random() * 900000000000).toString();"));
    driver.findElement(By.name("custInfoEtinNo")).sendKeys(vars.get("randomETIN").toString());
    driver.findElement(By.name("custInfoMaritalStatus")).click();
    vars.put("optionsCount", js.executeScript("return document.querySelector(\'select[name=\"custInfoMaritalStatus\"]\').options.length;"));
    vars.put("randomIndex", js.executeScript("return Math.floor(Math.random() * arguments[0]);", vars.get("optionsCount")));
    {
      WebElement dropdown = driver.findElement(By.name("custInfoMaritalStatus"));
      //dropdown.findElement(By.cssSelector("*:nth-child(vars.get("randomIndex").toString())")).click();
      int randomIndex = Integer.parseInt(vars.get("randomIndex").toString());
      dropdown.findElement(By.cssSelector("*:nth-child(" + randomIndex + ")")).click();
    }
    vars.put("selectedOption", js.executeScript("return document.querySelector(\'select[name=\"custInfoMaritalStatus\"]\').options[arguments[0]].text;", vars.get("randomIndex")));
    if ((Boolean) js.executeScript("return (arguments[0] == \'MARRIED\')", vars.get("selectedOption"))) {
      {
        List<WebElement> elements = driver.findElements(By.name("custInfoSpouseName"));
        assert(elements.size() > 0);
      }
      driver.findElement(By.name("custInfoSpouseName")).click();
      driver.findElement(By.name("custInfoSpouseName")).sendKeys("Afsana Rahaman");
    }
    driver.findElement(By.name("custDtlYear")).click();
    driver.findElement(By.name("custDtlYear")).sendKeys("5");
    driver.findElement(By.name("custDtlMonth")).click();
    driver.findElement(By.name("custDtlMonth")).sendKeys("11");
    driver.findElement(By.name("custInfoEducationLevel")).click();
    driver.findElement(By.name("custInfoLastEducation")).click();
    driver.findElement(By.name("custInfoInstitutionName")).click();
    vars.put("randomInstituteName", js.executeScript("var universities = [     \"University of Dhaka\",      \"Bangladesh University of Engineering and Technology (BUET)\",      \"Rajshahi University\",      \"Chittagong University of Engineering and Technology (CUET)\",      \"Khulna University of Engineering and Technology (KUET)\",      \"Jahangirnagar University\",      \"North South University\",      \"BRAC University\",      \"Independent University, Bangladesh (IUB)\",      \"East West University\",      \"American International University-Bangladesh (AIUB)\",      \"University of Science and Technology Chittagong (USTC)\",      \"Shahjalal University of Science and Technology (SUST)\"   ];   var randomUniversity = universities[Math.floor(Math.random() * universities.length)];   return randomUniversity;"));
    System.out.println(vars.get("randomInstituteName").toString());
    driver.findElement(By.name("custInfoInstitutionName")).sendKeys(vars.get("randomInstituteName").toString());
    driver.findElement(By.name("custInfoParentSpouseMobileNo")).click();
    vars.put("randomPhonNum", js.executeScript("var prefixes = [\"013\", \"015\", \"016\", \"017\", \"018\", \"019\"];  var prefix = prefixes[Math.floor(Math.random() * prefixes.length)];  var remainingDigits = \"\"; for (var i = 0; i < 8; i++) {   remainingDigits += Math.floor(Math.random() * 10); }  var phoneNumber = prefix + remainingDigits; return phoneNumber;"));
    driver.findElement(By.name("custInfoParentSpouseMobileNo")).sendKeys(vars.get("randomPhonNum").toString());
    driver.findElement(By.name("custInfoParentSpouseTelNo")).click();
    driver.findElement(By.name("custInfoGuardianConNo")).click();
    vars.put("randomPhonNum", js.executeScript("var prefixes = [\"013\", \"015\", \"016\", \"017\", \"018\", \"019\"];  var prefix = prefixes[Math.floor(Math.random() * prefixes.length)];  var remainingDigits = \"\"; for (var i = 0; i < 8; i++) {   remainingDigits += Math.floor(Math.random() * 10); }  var phoneNumber = prefix + remainingDigits; return phoneNumber;"));
    driver.findElement(By.name("custInfoGuardianConNo")).sendKeys(vars.get("randomPhonNum").toString());
    driver.findElement(By.name("custDtlNoOfChild")).click();
    driver.findElement(By.name("custInfoNoofDependent")).click();
    driver.findElement(By.name("custInfoEmergencyContactPerson")).click();
    vars.put("randomEmergencyContactName", js.executeScript("var firstNames = [   \"James\",   \"Olivia\",   \"Liam\",   \"Emma\",   \"Noah\",   \"Sophia\",   \"Mason\",   \"Isabella\",   \"Ethan\",   \"Mia\",   \"Lucas\",   \"Amelia\",   \"Ava\",   \"Charlotte\",   \"Elijah\" ]; var lastNames = [   \"Smith\",   \"Johnson\",   \"Brown\",   \"Taylor\",   \"Anderson\",   \"Thomas\",   \"Jackson\",   \"White\",   \"Harris\",   \"Martin\",   \"Garcia\",   \"Clark\",   \"Lewis\",   \"Walker\",   \"Robinson\" ];  var randomFirstName = firstNames[Math.floor(Math.random() * firstNames.length)]; var randomLastName = lastNames[Math.floor(Math.random() * lastNames.length)];  var fullName = randomFirstName + \" \" + randomLastName; return fullName;"));
    driver.findElement(By.name("custInfoEmergencyContactPerson")).sendKeys(vars.get("randomEmergencyContactName").toString());
    driver.findElement(By.name("custInfoEmergencyContactNo")).click();
    vars.put("randomPhonNum", js.executeScript("var prefixes = [\"013\", \"015\", \"016\", \"017\", \"018\", \"019\"];  var prefix = prefixes[Math.floor(Math.random() * prefixes.length)];  var remainingDigits = \"\"; for (var i = 0; i < 8; i++) {   remainingDigits += Math.floor(Math.random() * 10); }  var phoneNumber = prefix + remainingDigits; return phoneNumber;"));
    driver.findElement(By.name("custInfoEmergencyContactNo")).sendKeys(vars.get("randomPhonNum").toString());
    driver.findElement(By.name("custInfoRelationshipWithEmergencyContact")).click();
    driver.findElement(By.cssSelector(".row-fluid:nth-child(26) .btn-add")).click();
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    assertThat(driver.findElement(By.cssSelector("b:nth-child(2)")).getText(), is("Execution Completed Successfully...!!!"));
  }
  @Test
  public void ProfessionInfo() {
    driver.get("http://10.11.200.14:9040/eocas/customerProfileTabRetailApplication.do");
    driver.findElement(By.name("custProfileEmploymentType")).click();
    driver.findElement(By.name("custProfileProfession")).click();
    driver.findElement(By.name("custProfileCurrentEmployer")).click();
    driver.findElement(By.name("custProfileBusinessNature")).click();
    vars.put("randomBusinessNature", js.executeScript("var businessNatures = [   \"Retail\",   \"Manufacturing\",   \"IT Services\",   \"Healthcare\",   \"Finance\",   \"Education\",   \"Construction\",   \"Agriculture\",   \"Transportation\",   \"Hospitality\" ]; var randomIndex = Math.floor(Math.random() * businessNatures.length); return businessNatures[randomIndex];"));
    driver.findElement(By.name("custProfileBusinessNature")).sendKeys(vars.get("randomBusinessNature").toString());
    driver.findElement(By.name("custProfileIndustryType")).click();
    vars.put("randomIndustryType", js.executeScript("var industryTypes = [   \"Technology\",   \"Healthcare\",   \"Finance\",   \"Education\",   \"Manufacturing\",   \"Retail\",   \"Construction\",   \"Transportation\",   \"Hospitality\",   \"Agriculture\" ]; var randomIndex = Math.floor(Math.random() * industryTypes.length); return industryTypes[randomIndex];"));
    driver.findElement(By.name("custProfileIndustryType")).sendKeys(vars.get("randomIndustryType").toString());
    driver.findElement(By.id("custProfileJointDate")).click();
    //vars.put("doj", js.executeScript("var jobAge = 20;  var currentDate = new Date(); currentDate.setFullYear(currentDate.getFullYear() - jobAge);  var day = String(currentDate.getDate()).padStart(2, \'0\');  var month = String(currentDate.getMonth() + 1).padStart(2, \'0\'); var year = currentDate.getFullYear();  return \`arguments[0]/arguments[1]/arguments[2]\`;", vars.get("day"),vars.get("month"),vars.get("year")));
    vars.put("doj", js.executeScript(
    	    "var jobAge = 20;" +
    	    "var currentDate = new Date();" +
    	    "currentDate.setFullYear(currentDate.getFullYear() - jobAge);" +
    	    "var day = String(currentDate.getDate()).padStart(2, '0');" +
    	    "var month = String(currentDate.getMonth() + 1).padStart(2, '0');" +
    	    "var year = currentDate.getFullYear();" +
    	    "return day + '/' + month + '/' + year;"
    	));

    driver.findElement(By.id("custProfileJointDate")).sendKeys(vars.get("doj").toString());
    driver.findElement(By.cssSelector(".ui-datepicker-year")).click();
    driver.findElement(By.linkText("7")).click();
    driver.findElement(By.id("designationLabel")).click();
    driver.findElement(By.name("custProfileCurrentDesignation")).click();
    vars.put("randomDesignation", js.executeScript("var designations = [   \"Manager\",   \"Software Engineer\",   \"Data Analyst\",   \"Team Leader\",   \"Project Coordinator\",   \"HR Specialist\",   \"Sales Executive\",   \"Marketing Manager\",   \"Business Consultant\",   \"System Administrator\" ]; var randomIndex = Math.floor(Math.random() * designations.length); return designations[randomIndex];"));
    driver.findElement(By.name("custProfileCurrentDesignation")).sendKeys(vars.get("randomDesignation").toString());
    driver.findElement(By.id("officeAddressLabel")).click();
    driver.findElement(By.name("custProfileOfficeAddress")).click();
    vars.put("randomAddress", js.executeScript("var districts = [   \"Dhaka\" ]; var areas = [   \"Gulshan\",   \"Banani\",   \"Dhanmondi\",   \"Motijheel\",   \"Agargaon\",   \"Khilgaon\",   \"Banasree\",   \"Rampura\",   \"Uttara\",   \"Badda\",   \"Motijheel\",   \"Paltan\" ]; var roads = [   \"Road-5\",   \"Road-12\",   \"Road-7A\",   \"Street-3\",   \"Lane-4\",   \"Sector-10\",   \"Block-B\",   \"Avenue-2\" ]; var houseNumber = \"House-\" + Math.floor(Math.random() * 100 + 1);  var district = districts[Math.floor(Math.random() * districts.length)]; var area = areas[Math.floor(Math.random() * areas.length)]; var road = roads[Math.floor(Math.random() * roads.length)];  var address = houseNumber + \", \" + road + \", \" + area + \", \" + district + \", Bangladesh\"; return address;"));
    driver.findElement(By.name("custProfileOfficeAddress")).sendKeys(vars.get("randomAddress").toString());
    driver.findElement(By.id("departmentLabel")).click();
    driver.findElement(By.name("departmentName")).click();
    vars.put("randomDepartment", js.executeScript("var departments = [   \"Human Resources\",   \"Finance\",   \"IT\",   \"Marketing\",   \"Sales\",   \"Operations\",   \"Legal\",   \"Research and Development\",   \"Customer Support\",   \"Procurement\" ]; var randomIndex = Math.floor(Math.random() * departments.length); return departments[randomIndex];"));
    driver.findElement(By.name("departmentName")).sendKeys(vars.get("randomDepartment").toString());
    driver.findElement(By.xpath("//div[@id=\'4\']/div[2]/div/div[4]/div")).click();
    driver.findElement(By.name("custProfileOfficeContactNo")).click();
    vars.put("randomPhonNum", js.executeScript("var prefixes = [\"013\", \"015\", \"016\", \"017\", \"018\", \"019\"];  var prefix = prefixes[Math.floor(Math.random() * prefixes.length)];  var remainingDigits = \"\"; for (var i = 0; i < 8; i++) {   remainingDigits += Math.floor(Math.random() * 10); }  var phoneNumber = prefix + remainingDigits; return phoneNumber;"));
    driver.findElement(By.name("custProfileOfficeContactNo")).sendKeys(vars.get("randomPhonNum").toString());
    driver.findElement(By.name("custProfileEmail")).click();
    vars.put("randomEmail", js.executeScript("return \'user\' + Math.random().toString(36).substring(2, 8) + \'@example.com\';"));
    driver.findElement(By.name("custProfileEmail")).sendKeys(vars.get("randomEmail").toString());
    driver.findElement(By.name("custProfileApplicantJobStatus")).click();
    {
      WebElement dropdown = driver.findElement(By.name("custProfileApplicantJobStatus"));
      dropdown.findElement(By.xpath("//option[. = 'CONTRACTUAL']")).click();
    }
    driver.findElement(By.name("custProfileContactType")).click();
    {
      WebElement dropdown = driver.findElement(By.name("custProfileContactType"));
      dropdown.findElement(By.xpath("//option[. = 'OPEN ENDED']")).click();
    }
    driver.findElement(By.id("custProfileContactExpiryDate")).click();
    vars.put("randomFuturedate", js.executeScript("var currentDate = new Date(); var tenYearsLater = new Date(currentDate.setFullYear(currentDate.getFullYear() + 10));   var randomDay = Math.floor(Math.random() * (tenYearsLater.getDate() - 1) + 1);  var randomMonth = Math.floor(Math.random() * 12);  var randomYear = tenYearsLater.getFullYear();   var expiryDate = (randomDay < 10 ? \'0\' : \'\') + randomDay + \'/\' + (randomMonth + 1 < 10 ? \'0\' : \'\') + (randomMonth + 1) + \'/\' + randomYear; return expiryDate;"));
    driver.findElement(By.id("custProfileContactExpiryDate")).sendKeys(vars.get("randomFuturedate").toString());
    driver.findElement(By.name("custProfileEmployerCategory")).click();
    {
      WebElement dropdown = driver.findElement(By.name("custProfileEmployerCategory"));
      dropdown.findElement(By.xpath("//option[. = 'CATEGORY B']")).click();
    }
    driver.findElement(By.name("custProfilePayrollCategory")).click();
    {
      WebElement dropdown = driver.findElement(By.name("custProfilePayrollCategory"));
      dropdown.findElement(By.xpath("//option[. = 'CATEGORY B']")).click();
    }
    driver.findElement(By.name("custProfileBankingStatus")).click();
    {
      WebElement dropdown = driver.findElement(By.name("custProfileBankingStatus"));
      dropdown.findElement(By.xpath("//option[. = 'Category B']")).click();
    }
    driver.findElement(By.name("custProfileTotalStaff")).click();
    driver.findElement(By.name("custProfileTotalStaff")).sendKeys("120");
    driver.findElement(By.cssSelector(".row-fluid > .row-fluid:nth-child(2) > .span6")).click();
    driver.findElement(By.name("custProfileServiceGap")).click();
    driver.findElement(By.name("custProfileServiceGap")).sendKeys("2");
    driver.findElement(By.name("custProfileSpouseOccupation")).click();
    {
      WebElement dropdown = driver.findElement(By.name("custProfileSpouseOccupation"));
      dropdown.findElement(By.xpath("//option[. = 'DOCTOR']")).click();
    }
    driver.findElement(By.cssSelector(".scheduler-border > .row-fluid:nth-child(3) > .span6:nth-child(1)")).click();
    driver.findElement(By.cssSelector(".scheduler-border > .row-fluid:nth-child(2) > .span6:nth-child(2)")).click();
    driver.findElement(By.name("custProfileSpouseDesignation")).click();
    vars.put("randomSpouseDesignation", js.executeScript("var designations = [   \"Manager\",   \"Software Engineer\",   \"Data Analyst\",   \"Team Leader\",   \"Project Coordinator\",   \"HR Specialist\",   \"Sales Executive\",   \"Marketing Manager\",   \"Business Consultant\",   \"System Administrator\" ]; var randomIndex = Math.floor(Math.random() * designations.length); return designations[randomIndex];"));
    driver.findElement(By.name("custProfileSpouseDesignation")).sendKeys(vars.get("randomSpouseDesignation").toString());
    driver.findElement(By.cssSelector(".scheduler-border > .row-fluid:nth-child(4) .control-label")).click();
    driver.findElement(By.name("custProfileSpouseCompanyName")).click();
    vars.put("randomSpouseCompany", js.executeScript("var companies = [   \"Grameenphone Ltd.\",   \"BRAC Ltd.\",   \"Aarong Ltd.\",   \"Robi Axiata Limited\",   \"Banglalink Digital Communications Ltd.\",   \"United Group\",   \"Bashundhara Group\",   \"Square Pharmaceuticals Ltd.\",   \"PRAN-RFL Group\",   \"City Group\" ]; var randomCompany = companies[Math.floor(Math.random() * companies.length)]; return randomCompany;"));
    driver.findElement(By.name("custProfileSpouseCompanyName")).sendKeys(vars.get("randomSpouseCompany").toString());
    driver.findElement(By.cssSelector(".scheduler-border > .row-fluid:nth-child(5) > .span6:nth-child(1)")).click();
    driver.findElement(By.name("custProfileSpouseOfficeAddress")).click();
    vars.put("randomSpouseAddress", js.executeScript("var districts = [   \"Dhaka\" ]; var areas = [   \"Gulshan\",   \"Banani\",   \"Dhanmondi\",   \"Motijheel\",   \"Agargaon\",   \"Khilgaon\",   \"Banasree\",   \"Rampura\",   \"Uttara\",   \"Badda\",   \"Motijheel\",   \"Paltan\" ]; var roads = [   \"Road-5\",   \"Road-12\",   \"Road-7A\",   \"Street-3\",   \"Lane-4\",   \"Sector-10\",   \"Block-B\",   \"Avenue-2\" ]; var houseNumber = \"House-\" + Math.floor(Math.random() * 100 + 1);  var district = districts[Math.floor(Math.random() * districts.length)]; var area = areas[Math.floor(Math.random() * areas.length)]; var road = roads[Math.floor(Math.random() * roads.length)];  var address = houseNumber + \", \" + road + \", \" + area + \", \" + district + \", Bangladesh\"; return address;"));
    driver.findElement(By.name("custProfileSpouseOfficeAddress")).sendKeys(vars.get("randomSpouseAddress").toString());
    driver.findElement(By.name("custProfileSpouseContactNo")).click();
    vars.put("randomPhonNum", js.executeScript("var prefixes = [\"013\", \"015\", \"016\", \"017\", \"018\", \"019\"];  var prefix = prefixes[Math.floor(Math.random() * prefixes.length)];  var remainingDigits = \"\"; for (var i = 0; i < 8; i++) {   remainingDigits += Math.floor(Math.random() * 10); }  var phoneNumber = prefix + remainingDigits; return phoneNumber;"));
    driver.findElement(By.name("custProfileSpouseContactNo")).sendKeys(vars.get("randomPhonNum").toString());
    driver.findElement(By.cssSelector(".row-fluid:nth-child(3) > .span12 > .btn-add")).click();
  }
  @Test
  public void CoApplicantInfo() {
    driver.get("http://10.11.200.14:9040/eocas/coApplicantTabRetailApplication.do");
    driver.findElement(By.id("coApplicantRelationship")).click();
    {
      WebElement dropdown = driver.findElement(By.id("coApplicantRelationship"));
      dropdown.findElement(By.xpath("//option[. = 'Brother']")).click();
    }
    driver.findElement(By.name("coApplicantFullName")).click();
    vars.put("randomFullName", js.executeScript("var firstNames = [   \"Abdul\",   \"Rafiqul\",   \"Hasan\",   \"Nazmul\",   \"Sohail\",   \"Farhana\",   \"Shamima\",   \"Mitu\",   \"Sadia\",   \"Jannatul\" ]; var lastNames = [   \"Rahman\",   \"Chowdhury\",   \"Khan\",   \"Ahmed\",   \"Hossain\",   \"Molla\",   \"Miah\",   \"Sarker\",   \"Ferdous\",   \"Kabir\" ];  var randomFirstName = firstNames[Math.floor(Math.random() * firstNames.length)]; var randomLastName = lastNames[Math.floor(Math.random() * lastNames.length)];  var fullName = randomFirstName + \" \" + randomLastName; return fullName;"));
    driver.findElement(By.name("coApplicantFullName")).sendKeys(vars.get("randomFullName").toString());
    driver.findElement(By.name("coApplicantProfession")).click();
    {
      WebElement dropdown = driver.findElement(By.name("coApplicantProfession"));
      dropdown.findElement(By.xpath("//option[. = 'DOCTOR']")).click();
    }
    driver.findElement(By.name("coApplicantFatherName")).click();
    vars.put("randomFatherName", js.executeScript("var firstNames = [   \"Abdul\",   \"Mohammad\",   \"Ghulam\",   \"Rafiqul\",   \"Kamal\",   \"Harun\",   \"Jalal\",   \"Nazrul\",   \"Shafiq\",   \"Abul\",   \"Touhidul\" ]; var lastNames = [   \"Rahman\",   \"Chowdhury\",   \"Hossain\",   \"Khan\",   \"Ahmed\",   \"Siddiqui\",   \"Molla\",   \"Miah\",   \"Uddin\",   \"Kabir\",   \"Fayez\" ];  var randomFirstName = firstNames[Math.floor(Math.random() * firstNames.length)]; var randomLastName = lastNames[Math.floor(Math.random() * lastNames.length)];  var fullName = randomFirstName + \" \" + randomLastName; return fullName;"));
    driver.findElement(By.name("coApplicantFatherName")).sendKeys(vars.get("randomFatherName").toString());
    driver.findElement(By.name("coApplicantFatherProfession")).click();
    {
      WebElement dropdown = driver.findElement(By.name("coApplicantFatherProfession"));
      dropdown.findElement(By.xpath("//option[. = 'TEACHER']")).click();
    }
    driver.findElement(By.id("coApplicantFatherContactNo")).click();
    vars.put("randomPhonNumber", js.executeScript("var prefixes = [\"013\", \"015\", \"016\", \"017\", \"018\", \"019\"];  var prefix = prefixes[Math.floor(Math.random() * prefixes.length)];  var remainingDigits = \"\"; for (var i = 0; i < 8; i++) {   remainingDigits += Math.floor(Math.random() * 10); }  var phoneNumber = prefix + remainingDigits; return phoneNumber;"));
    driver.findElement(By.id("coApplicantFatherContactNo")).sendKeys(vars.get("randomPhonNumber").toString());
    driver.findElement(By.name("coApplicantMotherName")).click();
    vars.put("randomMotherName", js.executeScript("var firstNames = [   \"Fatema\",   \"Rokeya\",   \"Sharifa\",   \"Hamida\",   \"Ayesha\",   \"Jahanara\",   \"Nurjahan\",   \"Rashida\",   \"Shamsunnahar\",   \"Firoza\" ]; var lastNames = [   \"Begum\",   \"Rahman\",   \"Chowdhury\",   \"Ahmed\",   \"Hossain\",   \"Siddiqui\",   \"Molla\",   \"Miah\",   \"Kabir\",   \"Uddin\" ];  var randomFirstName = firstNames[Math.floor(Math.random() * firstNames.length)]; var randomLastName = lastNames[Math.floor(Math.random() * lastNames.length)];  var fullName = randomFirstName + \" \" + randomLastName; return fullName;"));
    driver.findElement(By.name("coApplicantMotherName")).sendKeys(vars.get("randomMotherName").toString());
    driver.findElement(By.name("coApplicantMotherProfession")).click();
    {
      WebElement dropdown = driver.findElement(By.name("coApplicantMotherProfession"));
      dropdown.findElement(By.xpath("//option[. = 'ENGINEER']")).click();
    }
    driver.findElement(By.id("coApplicantMotherContactNo")).click();
    vars.put("randomPhoneNumber", js.executeScript("var prefixes = [\"013\", \"015\", \"016\", \"017\", \"018\", \"019\"];  var prefix = prefixes[Math.floor(Math.random() * prefixes.length)];  var remainingDigits = \"\"; for (var i = 0; i < 8; i++) {   remainingDigits += Math.floor(Math.random() * 10); }  var phoneNumber = prefix + remainingDigits; return phoneNumber;"));
    driver.findElement(By.id("coApplicantMotherContactNo")).sendKeys(vars.get("randomPhoneNumber").toString());
    driver.findElement(By.id("coApplicantGender")).click();
    {
      WebElement dropdown = driver.findElement(By.id("coApplicantGender"));
      dropdown.findElement(By.xpath("//option[. = 'Female']")).click();
    }
    driver.findElement(By.id("coApplicantMaritalStatus")).click();
    {
      WebElement dropdown = driver.findElement(By.id("coApplicantMaritalStatus"));
      dropdown.findElement(By.xpath("//option[. = 'MARRIED']")).click();
    }
    driver.findElement(By.id("coApplicantSpouseName")).click();
    vars.put("randomSpouseName", js.executeScript("var firstNames = [   \"Fatema\",   \"Rokeya\",   \"Sharifa\",   \"Hamida\",   \"Ayesha\",   \"Jahanara\",   \"Nurjahan\",   \"Rashida\",   \"Shamsunnahar\",   \"Firoza\" ]; var lastNames = [   \"Begum\",   \"Rahman\",   \"Chowdhury\",   \"Ahmed\",   \"Hossain\",   \"Siddiqui\",   \"Molla\",   \"Miah\",   \"Kabir\",   \"Uddin\" ];  var randomFirstName = firstNames[Math.floor(Math.random() * firstNames.length)]; var randomLastName = lastNames[Math.floor(Math.random() * lastNames.length)];  var fullName = randomFirstName + \" \" + randomLastName; return fullName;"));
    driver.findElement(By.id("coApplicantSpouseName")).sendKeys(vars.get("randomSpouseName").toString());
    {
      String value = driver.findElement(By.id("coApplicantSpouseName")).getAttribute("value");
      //assertThat(value, is("vars.get("randomSpouseName").toString()"));
      assertThat(value, is(vars.get("randomSpouseName").toString()));

    }
    driver.findElement(By.name("coApplicantSpouseProfession")).click();
    {
      WebElement dropdown = driver.findElement(By.name("coApplicantSpouseProfession"));
      dropdown.findElement(By.xpath("//option[. = 'OFFICER']")).click();
    }
    driver.findElement(By.id("coApplicantSpouseWorkAddress")).click();
    driver.findElement(By.cssSelector("#\\31 6 > .row-fluid:nth-child(19) > .span3:nth-child(1) > .control-label")).click();
    driver.findElement(By.id("coApplicantSpouseWorkAddress")).click();
    vars.put("randomAddress", js.executeScript("var districts = [   \"Dhaka\" ]; var areas = [   \"Gulshan\",   \"Banani\",   \"Dhanmondi\",   \"Motijheel\",   \"Agargaon\",   \"Khilgaon\",   \"Banasree\",   \"Rampura\",   \"Uttara\",   \"Badda\",   \"Motijheel\",   \"Paltan\" ]; var roads = [   \"Road-5\",   \"Road-12\",   \"Road-7A\",   \"Street-3\",   \"Lane-4\",   \"Sector-10\",   \"Block-B\",   \"Avenue-2\" ]; var houseNumber = \"House-\" + Math.floor(Math.random() * 100 + 1);  var district = districts[Math.floor(Math.random() * districts.length)]; var area = areas[Math.floor(Math.random() * areas.length)]; var road = roads[Math.floor(Math.random() * roads.length)];  var address = houseNumber + \", \" + road + \", \" + area + \", \" + district + \", Bangladesh\"; return address;"));
    driver.findElement(By.id("coApplicantSpouseWorkAddress")).sendKeys(vars.get("randomAddress").toString());
    driver.findElement(By.id("coApplicantSpouseContactNo")).click();
    vars.put("randomPhonNumber", js.executeScript("var prefixes = [\"013\", \"015\", \"016\", \"017\", \"018\", \"019\"];  var prefix = prefixes[Math.floor(Math.random() * prefixes.length)];  var remainingDigits = \"\"; for (var i = 0; i < 8; i++) {   remainingDigits += Math.floor(Math.random() * 10); }  var phoneNumber = prefix + remainingDigits; return phoneNumber;"));
    driver.findElement(By.id("coApplicantSpouseContactNo")).sendKeys(vars.get("randomPhonNumber").toString());
    driver.findElement(By.id("coApplicantDateOfBirth")).click();
    driver.findElement(By.id("coApplicantDateOfBirth")).sendKeys("31/12/1997");
    driver.findElement(By.id("coApplicantDateOfBirth")).click();
    driver.findElement(By.linkText("31")).click();
    driver.findElement(By.name("coApplicantNidNo")).click();
    vars.put("randomNID", js.executeScript("return Math.floor(Math.random() * 10**16).toString().padStart(17, \'0\');"));
    driver.findElement(By.name("coApplicantNidNo")).sendKeys(vars.get("randomNID").toString());
    driver.findElement(By.name("coApplicantEducationLevel")).click();
    {
      WebElement dropdown = driver.findElement(By.name("coApplicantEducationLevel"));
      dropdown.findElement(By.xpath("//option[. = 'HSC']")).click();
    }
    driver.findElement(By.name("coApplicantNameofDegree")).click();
    {
      WebElement dropdown = driver.findElement(By.name("coApplicantNameofDegree"));
      dropdown.findElement(By.xpath("//option[. = 'BACHELOR OF BUSINESS PROGRAMME']")).click();
    }
    driver.findElement(By.name("coApplicantNoofDependent")).click();
    driver.findElement(By.name("coApplicantNoofDependent")).sendKeys("2");
    driver.findElement(By.name("coApplicantContactNo")).click();
    vars.put("randomPhoneNumber", js.executeScript("var prefixes = [\"013\", \"015\", \"016\", \"017\", \"018\", \"019\"];  var prefix = prefixes[Math.floor(Math.random() * prefixes.length)];  var remainingDigits = \"\"; for (var i = 0; i < 8; i++) {   remainingDigits += Math.floor(Math.random() * 10); }  var phoneNumber = prefix + remainingDigits; return phoneNumber;"));
    driver.findElement(By.name("coApplicantContactNo")).sendKeys(vars.get("randomPhoneNumber").toString());
    driver.findElement(By.name("coApplicantTelephoneNo")).click();
    vars.put("randomPhoneNumber", js.executeScript("var prefixes = [\"013\", \"015\", \"016\", \"017\", \"018\", \"019\"];  var prefix = prefixes[Math.floor(Math.random() * prefixes.length)];  var remainingDigits = \"\"; for (var i = 0; i < 8; i++) {   remainingDigits += Math.floor(Math.random() * 10); }  var phoneNumber = prefix + remainingDigits; return phoneNumber;"));
    driver.findElement(By.name("coApplicantTelephoneNo")).sendKeys(vars.get("randomPhoneNumber").toString());
    driver.findElement(By.name("coApplicantTinNo")).click();
    vars.put("randomTIN", js.executeScript("return Math.floor(100000000000 + Math.random() * 900000000000).toString();"));
    driver.findElement(By.name("coApplicantTinNo")).sendKeys(vars.get("randomTIN").toString());
    driver.findElement(By.name("coApplicantNationality")).click();
    {
      WebElement dropdown = driver.findElement(By.name("coApplicantNationality"));
      dropdown.findElement(By.xpath("//option[. = 'BANGLADESH']")).click();
    }
    driver.findElement(By.name("coApplicantGrossMonthlyIncome")).click();
    driver.findElement(By.name("coApplicantGrossMonthlyIncome")).sendKeys("100000");
    driver.findElement(By.name("coApplicantNetMonthlyIncome")).click();
    driver.findElement(By.name("coApplicantNetMonthlyIncome")).sendKeys("20000");
    driver.findElement(By.cssSelector(".span3:nth-child(4) #no")).click();
    driver.findElement(By.id("coApplicantRetirementDate")).click();
    driver.findElement(By.id("coApplicantRetirementDate")).sendKeys("31/12/2030");
    driver.findElement(By.id("coApplicantResidentialStatus")).click();
    {
      WebElement dropdown = driver.findElement(By.id("coApplicantResidentialStatus"));
      dropdown.findElement(By.xpath("//option[. = 'OWNED']")).click();
    }
    driver.findElement(By.id("coApplicantPresentAddress")).click();
    driver.findElement(By.cssSelector("#\\31 6 > .row-fluid:nth-child(15) > .span3:nth-child(3) > .control-label")).click();
    driver.findElement(By.id("coApplicantPresentAddress")).click();
    vars.put("randomAddress", js.executeScript("var districts = [   \"Dhaka\" ]; var areas = [   \"Gulshan\",   \"Banani\",   \"Dhanmondi\",   \"Motijheel\",   \"Agargaon\",   \"Khilgaon\",   \"Banasree\",   \"Rampura\",   \"Uttara\",   \"Badda\",   \"Motijheel\",   \"Paltan\" ]; var roads = [   \"Road-5\",   \"Road-12\",   \"Road-7A\",   \"Street-3\",   \"Lane-4\",   \"Sector-10\",   \"Block-B\",   \"Avenue-2\" ]; var houseNumber = \"House-\" + Math.floor(Math.random() * 100 + 1);  var district = districts[Math.floor(Math.random() * districts.length)]; var area = areas[Math.floor(Math.random() * areas.length)]; var road = roads[Math.floor(Math.random() * roads.length)];  var address = houseNumber + \", \" + road + \", \" + area + \", \" + district + \", Bangladesh\"; return address;"));
    driver.findElement(By.id("coApplicantPresentAddress")).sendKeys(vars.get("randomAddress").toString());
    driver.findElement(By.name("coApplicantNoofYearsAddress")).click();
    driver.findElement(By.name("coApplicantNoofYearsAddress")).sendKeys("2");
    driver.findElement(By.name("coApplicantNoofMontsAddress")).click();
    driver.findElement(By.name("coApplicantNoofMontsAddress")).sendKeys("1");
    driver.findElement(By.cssSelector("#\\31 6 > .row-fluid:nth-child(17) > .span3:nth-child(3) > .control-label")).click();
    driver.findElement(By.id("coApplicantPermanentAddress")).click();
    vars.put("randomAddress", js.executeScript("var districts = [   \"Dhaka\" ]; var areas = [   \"Gulshan\",   \"Banani\",   \"Dhanmondi\",   \"Motijheel\",   \"Agargaon\",   \"Khilgaon\",   \"Banasree\",   \"Rampura\",   \"Uttara\",   \"Badda\",   \"Motijheel\",   \"Paltan\" ]; var roads = [   \"Road-5\",   \"Road-12\",   \"Road-7A\",   \"Street-3\",   \"Lane-4\",   \"Sector-10\",   \"Block-B\",   \"Avenue-2\" ]; var houseNumber = \"House-\" + Math.floor(Math.random() * 100 + 1);  var district = districts[Math.floor(Math.random() * districts.length)]; var area = areas[Math.floor(Math.random() * areas.length)]; var road = roads[Math.floor(Math.random() * roads.length)];  var address = houseNumber + \", \" + road + \", \" + area + \", \" + district + \", Bangladesh\"; return address;"));
    driver.findElement(By.id("coApplicantPermanentAddress")).sendKeys(vars.get("randomAddress").toString());
    driver.findElement(By.cssSelector("#\\31 6 > .row-fluid:nth-child(18) > .span3:nth-child(3)")).click();
    driver.findElement(By.id("coApplicantWorkAddress")).click();
    vars.put("randomAddress", js.executeScript("var districts = [   \"Dhaka\" ]; var areas = [   \"Gulshan\",   \"Banani\",   \"Dhanmondi\",   \"Motijheel\",   \"Agargaon\",   \"Khilgaon\",   \"Banasree\",   \"Rampura\",   \"Uttara\",   \"Badda\",   \"Motijheel\",   \"Paltan\" ]; var roads = [   \"Road-5\",   \"Road-12\",   \"Road-7A\",   \"Street-3\",   \"Lane-4\",   \"Sector-10\",   \"Block-B\",   \"Avenue-2\" ]; var houseNumber = \"House-\" + Math.floor(Math.random() * 100 + 1);  var district = districts[Math.floor(Math.random() * districts.length)]; var area = areas[Math.floor(Math.random() * areas.length)]; var road = roads[Math.floor(Math.random() * roads.length)];  var address = houseNumber + \", \" + road + \", \" + area + \", \" + district + \", Bangladesh\"; return address;"));
    driver.findElement(By.id("coApplicantWorkAddress")).sendKeys(vars.get("randomAddress").toString());
    driver.findElement(By.id("coApplicantTelephoneHome")).click();
    vars.put("randomPhoneNumber", js.executeScript("var prefixes = [\"013\", \"015\", \"016\", \"017\", \"018\", \"019\"];  var prefix = prefixes[Math.floor(Math.random() * prefixes.length)];  var remainingDigits = \"\"; for (var i = 0; i < 8; i++) {   remainingDigits += Math.floor(Math.random() * 10); }  var phoneNumber = prefix + remainingDigits; return phoneNumber;"));
    driver.findElement(By.id("coApplicantTelephoneHome")).sendKeys(vars.get("randomPhoneNumber").toString());
    driver.findElement(By.id("coApplicantTelephoneWork")).click();
    vars.put("randomPhoneNumber", js.executeScript("var prefixes = [\"013\", \"015\", \"016\", \"017\", \"018\", \"019\"];  var prefix = prefixes[Math.floor(Math.random() * prefixes.length)];  var remainingDigits = \"\"; for (var i = 0; i < 8; i++) {   remainingDigits += Math.floor(Math.random() * 10); }  var phoneNumber = prefix + remainingDigits; return phoneNumber;"));
    driver.findElement(By.id("coApplicantTelephoneWork")).sendKeys(vars.get("randomPhoneNumber").toString());
    driver.findElement(By.id("coApplicantFax")).click();
    driver.findElement(By.id("coApplicantFax")).sendKeys("02533324");
    driver.findElement(By.id("coApplicantEmail")).click();
    vars.put("randomEmail", js.executeScript("return \'user\' + Math.random().toString(36).substring(2, 8) + \'@example.com\';"));
    driver.findElement(By.id("coApplicantEmail")).sendKeys(vars.get("randomEmail").toString());
    driver.findElement(By.id("coApplicantEmergencyContactPerson")).click();
    vars.put("randomName", js.executeScript("var nicknames = [   \"Raju\",   \"Mitu\",   \"Shuvo\",   \"Pintu\",   \"Nipa\",   \"Sima\",   \"Rita\",   \"Babu\",   \"Titu\",   \"Jitu\",   \"Jony\",   \"Audry\",   \"Nuha\",   \"Shurjo\",   \"Birag\",   \"Ripu\",   \"Nilu\" ];  var randomNickname = nicknames[Math.floor(Math.random() * nicknames.length)]; return randomNickname;"));
    driver.findElement(By.id("coApplicantEmergencyContactPerson")).sendKeys(vars.get("randomName").toString());
    driver.findElement(By.id("coApplicantEmergencyContactNo")).click();
    vars.put("randomPhoneNumber", js.executeScript("var prefixes = [\"013\", \"015\", \"016\", \"017\", \"018\", \"019\"];  var prefix = prefixes[Math.floor(Math.random() * prefixes.length)];  var remainingDigits = \"\"; for (var i = 0; i < 8; i++) {   remainingDigits += Math.floor(Math.random() * 10); }  var phoneNumber = prefix + remainingDigits; return phoneNumber;"));
    driver.findElement(By.id("coApplicantEmergencyContactNo")).sendKeys(vars.get("randomPhoneNumber").toString());
    driver.findElement(By.name("coApplicantRelationshipWithEmergencyContact")).click();
    {
      WebElement dropdown = driver.findElement(By.name("coApplicantRelationshipWithEmergencyContact"));
      dropdown.findElement(By.xpath("//option[. = 'Father']")).click();
    }
    driver.findElement(By.id("addBtnCA")).click();
    driver.findElement(By.cssSelector(".row-fluid:nth-child(28) .lbl-08:nth-child(11) img")).click();
  }
  @Test
  public void Guarantor() {
    driver.get("http://10.11.200.14:9040/eocas/guarantorTabRetailApplication.do");
    Integer times = 2;
    for(int i = 0; i < times; i++) {
      driver.findElement(By.id("guarantorRelationship")).click();
      {
        WebElement dropdown = driver.findElement(By.id("guarantorRelationship"));
        dropdown.findElement(By.xpath("//option[. = 'Brother']")).click();
      }
      driver.findElement(By.id("guarantorName")).click();
      vars.put("randomName", js.executeScript("var firstNames = [   \"Abdul\",   \"Mohammad\",   \"Ghulam\",   \"Rafiqul\",   \"Kamal\",   \"Harun\",   \"Jalal\",   \"Nazrul\",   \"Shafiq\",   \"Abul\",   \"Touhidul\" ]; var lastNames = [   \"Rahman\",   \"Chowdhury\",   \"Hossain\",   \"Khan\",   \"Ahmed\",   \"Siddiqui\",   \"Molla\",   \"Miah\",   \"Uddin\",   \"Kabir\",   \"Fayez\" ];  var randomFirstName = firstNames[Math.floor(Math.random() * firstNames.length)]; var randomLastName = lastNames[Math.floor(Math.random() * lastNames.length)];  var fullName = randomFirstName + \" \" + randomLastName; return fullName;"));
      driver.findElement(By.id("guarantorName")).sendKeys(vars.get("randomName").toString());
      driver.findElement(By.name("guarantorFatherName")).click();
      vars.put("randomFatherName", js.executeScript("var firstNames = [   \"Abdul\",   \"Mohammad\",   \"Ghulam\",   \"Rafiqul\",   \"Kamal\",   \"Harun\",   \"Jalal\",   \"Nazrul\",   \"Shafiq\",   \"Abul\",   \"Touhidul\" ]; var lastNames = [   \"Rahman\",   \"Chowdhury\",   \"Hossain\",   \"Khan\",   \"Ahmed\",   \"Siddiqui\",   \"Molla\",   \"Miah\",   \"Uddin\",   \"Kabir\",   \"Fayez\" ];  var randomFirstName = firstNames[Math.floor(Math.random() * firstNames.length)]; var randomLastName = lastNames[Math.floor(Math.random() * lastNames.length)];  var fullName = randomFirstName + \" \" + randomLastName; return fullName;"));
      driver.findElement(By.name("guarantorFatherName")).sendKeys(vars.get("randomFatherName").toString());
      driver.findElement(By.name("guarantorMotherName")).click();
      vars.put("randomWomanName", js.executeScript("var firstNames = [   \"Fatema\",   \"Rokeya\",   \"Sharifa\",   \"Hamida\",   \"Ayesha\",   \"Jahanara\",   \"Nurjahan\",   \"Rashida\",   \"Shamsunnahar\",   \"Firoza\" ]; var lastNames = [   \"Begum\",   \"Rahman\",   \"Chowdhury\",   \"Ahmed\",   \"Hossain\",   \"Siddiqui\",   \"Molla\",   \"Miah\",   \"Kabir\",   \"Uddin\" ];  var randomFirstName = firstNames[Math.floor(Math.random() * firstNames.length)]; var randomLastName = lastNames[Math.floor(Math.random() * lastNames.length)];  var fullName = randomFirstName + \" \" + randomLastName; return fullName;"));
      driver.findElement(By.name("guarantorMotherName")).sendKeys(vars.get("randomWomanName").toString());
      driver.findElement(By.id("guarantorGender")).click();
      {
        WebElement dropdown = driver.findElement(By.id("guarantorGender"));
        dropdown.findElement(By.xpath("//option[. = 'Male']")).click();
      }
      driver.findElement(By.id("guarantorMaritalStatus")).click();
      {
        WebElement dropdown = driver.findElement(By.id("guarantorMaritalStatus"));
        dropdown.findElement(By.xpath("//option[. = 'MARRIED']")).click();
      }
      driver.findElement(By.id("guarantorMaritalStatus")).click();
      driver.findElement(By.xpath("//div[@id=\'5\']/div[11]/div[2]")).click();
      driver.findElement(By.id("guarantorSpouseName")).click();
      driver.findElement(By.id("guarantorSpouseName")).sendKeys("nazia ");
      driver.findElement(By.id("guarantorSpouseConNo")).click();
      vars.put("randomPhoneNum", js.executeScript("var prefixes = [\"013\", \"015\", \"016\", \"017\", \"018\", \"019\"];  var prefix = prefixes[Math.floor(Math.random() * prefixes.length)];  var remainingDigits = \"\"; for (var i = 0; i < 8; i++) {   remainingDigits += Math.floor(Math.random() * 10); }  var phoneNumber = prefix + remainingDigits; return phoneNumber;"));
      driver.findElement(By.id("guarantorSpouseConNo")).sendKeys(vars.get("randomPhoneNum").toString());
      driver.findElement(By.id("guarantorDateOfBirth")).click();
      driver.findElement(By.id("guarantorDateOfBirth")).sendKeys("31/12/1990");
      driver.findElement(By.id("guarantorDateOfBirth")).click();
      driver.findElement(By.linkText("31")).click();
      driver.findElement(By.id("guarantorProfessionCode")).click();
      {
        WebElement dropdown = driver.findElement(By.id("guarantorProfessionCode"));
        dropdown.findElement(By.xpath("//option[. = 'DOCTOR']")).click();
      }
      driver.findElement(By.cssSelector(".row-fluid:nth-child(2) > .span3:nth-child(4) > .fa")).click();
      driver.findElement(By.cssSelector("#guarantorDesigListModal tr:nth-child(5) > td:nth-child(3)")).click();
      driver.findElement(By.id("guarantorCompany")).click();
      driver.findElement(By.id("guar_company_name_label")).click();
      driver.findElement(By.id("guarantorCompany")).click();
      vars.put("randomComapny", js.executeScript("var companies = [   \"Grameenphone Ltd.\",   \"BRAC Ltd.\",   \"Aarong Ltd.\",   \"Robi Axiata Limited\",   \"Banglalink Digital Communications Ltd.\",   \"United Group\",   \"Bashundhara Group\",   \"Square Pharmaceuticals Ltd.\",   \"PRAN-RFL Group\",   \"City Group\" ]; var randomCompany = companies[Math.floor(Math.random() * companies.length)]; return randomCompany;"));
      driver.findElement(By.id("guarantorCompany")).sendKeys(vars.get("randomComapny").toString());
      driver.findElement(By.xpath("//div[@id=\'5\']/div[4]/div[3]/label")).click();
      driver.findElement(By.name("guarantorExperience")).click();
      driver.findElement(By.name("guarantorExperience")).sendKeys("12");
      driver.findElement(By.xpath("//div[@id=\'5\']/div[4]/div[4]")).click();
      driver.findElement(By.name("guarantorTotalServiceLength")).click();
      driver.findElement(By.name("guarantorTotalServiceLength")).sendKeys("12");
      driver.findElement(By.id("guar_office_address_label")).click();
      driver.findElement(By.xpath("//div[@id=\'5\']/div[6]/div[4]")).click();
      driver.findElement(By.id("guarantorOfficeAddress")).click();
      vars.put("randomAddress", js.executeScript("var districts = [   \"Dhaka\" ]; var areas = [   \"Gulshan\",   \"Banani\",   \"Dhanmondi\",   \"Motijheel\",   \"Agargaon\",   \"Khilgaon\",   \"Banasree\",   \"Rampura\",   \"Uttara\",   \"Badda\",   \"Motijheel\",   \"Paltan\" ]; var roads = [   \"Road-5\",   \"Road-12\",   \"Road-7A\",   \"Street-3\",   \"Lane-4\",   \"Sector-10\",   \"Block-B\",   \"Avenue-2\" ]; var houseNumber = \"House-\" + Math.floor(Math.random() * 100 + 1);  var district = districts[Math.floor(Math.random() * districts.length)]; var area = areas[Math.floor(Math.random() * areas.length)]; var road = roads[Math.floor(Math.random() * roads.length)];  var address = houseNumber + \", \" + road + \", \" + area + \", \" + district + \", Bangladesh\"; return address;"));
      driver.findElement(By.id("guarantorOfficeAddress")).sendKeys(vars.get("randomAddress").toString());
      driver.findElement(By.name("guarantorMonthlyIncome")).click();
      driver.findElement(By.name("guarantorMonthlyIncome")).sendKeys("200000");
      driver.findElement(By.name("guarantorTinNo")).click();
      vars.put("randomTIN", js.executeScript("return Math.floor(100000000000 + Math.random() * 900000000000).toString();"));
      driver.findElement(By.name("guarantorTinNo")).sendKeys(vars.get("randomTIN").toString());
      driver.findElement(By.id("guarantorResidencialStatus")).click();
      {
        WebElement dropdown = driver.findElement(By.id("guarantorResidencialStatus"));
        dropdown.findElement(By.xpath("//option[. = 'PARENTS OWNED']")).click();
      }
      driver.findElement(By.xpath("//div[@id=\'5\']/div[10]/div[3]")).click();
      driver.findElement(By.id("guarantorCurrentResidence")).click();
      vars.put("randomAddress", js.executeScript("var districts = [   \"Dhaka\" ]; var areas = [   \"Gulshan\",   \"Banani\",   \"Dhanmondi\",   \"Motijheel\",   \"Agargaon\",   \"Khilgaon\",   \"Banasree\",   \"Rampura\",   \"Uttara\",   \"Badda\",   \"Motijheel\",   \"Paltan\" ]; var roads = [   \"Road-5\",   \"Road-12\",   \"Road-7A\",   \"Street-3\",   \"Lane-4\",   \"Sector-10\",   \"Block-B\",   \"Avenue-2\" ]; var houseNumber = \"House-\" + Math.floor(Math.random() * 100 + 1);  var district = districts[Math.floor(Math.random() * districts.length)]; var area = areas[Math.floor(Math.random() * areas.length)]; var road = roads[Math.floor(Math.random() * roads.length)];  var address = houseNumber + \", \" + road + \", \" + area + \", \" + district + \", Bangladesh\"; return address;"));
      driver.findElement(By.id("guarantorCurrentResidence")).sendKeys(vars.get("randomAddress").toString());
      driver.findElement(By.xpath("//div[@id=\'5\']/div[11]/div[3]/label")).click();
      driver.findElement(By.id("guarantorPermanentResidence")).click();
      vars.put("randomAddress", js.executeScript("var districts = [   \"Dhaka\" ]; var areas = [   \"Gulshan\",   \"Banani\",   \"Dhanmondi\",   \"Motijheel\",   \"Agargaon\",   \"Khilgaon\",   \"Banasree\",   \"Rampura\",   \"Uttara\",   \"Badda\",   \"Motijheel\",   \"Paltan\" ]; var roads = [   \"Road-5\",   \"Road-12\",   \"Road-7A\",   \"Street-3\",   \"Lane-4\",   \"Sector-10\",   \"Block-B\",   \"Avenue-2\" ]; var houseNumber = \"House-\" + Math.floor(Math.random() * 100 + 1);  var district = districts[Math.floor(Math.random() * districts.length)]; var area = areas[Math.floor(Math.random() * areas.length)]; var road = roads[Math.floor(Math.random() * roads.length)];  var address = houseNumber + \", \" + road + \", \" + area + \", \" + district + \", Bangladesh\"; return address;"));
      driver.findElement(By.id("guarantorPermanentResidence")).sendKeys(vars.get("randomAddress").toString());
      driver.findElement(By.name("guarantorNidPassportNo")).click();
      vars.put("randomNID", js.executeScript("return Math.floor(Math.random() * 10**16).toString().padStart(17, \'0\');"));
      driver.findElement(By.name("guarantorNidPassportNo")).sendKeys(vars.get("randomNID").toString());
      driver.findElement(By.name("guarantorPassportNo")).click();
      vars.put("randomPassNo", js.executeScript("return String.fromCharCode(65 + Math.floor(Math.random() * 26)) + Math.floor(10000000 + Math.random() * 90000000).toString();"));
      driver.findElement(By.name("guarantorPassportNo")).sendKeys(vars.get("randomPassNo").toString());
      driver.findElement(By.name("guarantorValidity")).click();
      driver.findElement(By.name("guarantorValidity")).sendKeys("31/12/2029");
      driver.findElement(By.id("guarantorContactNo")).click();
      driver.findElement(By.cssSelector("#\\35 > .row-fluid:nth-child(12)")).click();
      vars.put("randomPhoneNum", js.executeScript("var prefixes = [\"013\", \"015\", \"016\", \"017\", \"018\", \"019\"];  var prefix = prefixes[Math.floor(Math.random() * prefixes.length)];  var remainingDigits = \"\"; for (var i = 0; i < 8; i++) {   remainingDigits += Math.floor(Math.random() * 10); }  var phoneNumber = prefix + remainingDigits; return phoneNumber;"));
      driver.findElement(By.id("guarantorContactNo")).sendKeys(vars.get("randomPhoneNum").toString());
      driver.findElement(By.id("guarantorOptMobiNo1")).click();
      vars.put("randomPhoneNum", js.executeScript("var prefixes = [\"013\", \"015\", \"016\", \"017\", \"018\", \"019\"];  var prefix = prefixes[Math.floor(Math.random() * prefixes.length)];  var remainingDigits = \"\"; for (var i = 0; i < 8; i++) {   remainingDigits += Math.floor(Math.random() * 10); }  var phoneNumber = prefix + remainingDigits; return phoneNumber;"));
      driver.findElement(By.id("guarantorOptMobiNo1")).sendKeys(vars.get("randomPhoneNum").toString());
      driver.findElement(By.id("guarantorOptMobiNo2")).click();
      vars.put("randomPhoneNum", js.executeScript("var prefixes = [\"013\", \"015\", \"016\", \"017\", \"018\", \"019\"];  var prefix = prefixes[Math.floor(Math.random() * prefixes.length)];  var remainingDigits = \"\"; for (var i = 0; i < 8; i++) {   remainingDigits += Math.floor(Math.random() * 10); }  var phoneNumber = prefix + remainingDigits; return phoneNumber;"));
      driver.findElement(By.id("guarantorOptMobiNo2")).sendKeys(vars.get("randomPhoneNum").toString());
      driver.findElement(By.name("guarantorFax")).click();
      driver.findElement(By.name("guarantorFax")).sendKeys("97865765");
      driver.findElement(By.name("guarantorEmail")).click();
      vars.put("randomEmail", js.executeScript("return \'user\' + Math.random().toString(36).substring(2, 8) + \'@example.com\';"));
      driver.findElement(By.name("guarantorEmail")).sendKeys(vars.get("randomEmail").toString());
      driver.findElement(By.name("guarantorBirthCertificateNo")).click();
      vars.put("randomBirthCerNo", js.executeScript("return Math.floor(Math.random() * 10**16).toString().padStart(17, \'0\');"));
      driver.findElement(By.name("guarantorBirthCertificateNo")).sendKeys(vars.get("randomBirthCerNo").toString());
      driver.findElement(By.name("guarantorDrivingLicenseNo")).click();
      //vars.put("randomDriveLicense", js.executeScript("const generateLicense = () => {     const stateCode = String.fromCharCode(65 + Math.random() * 26) +                        String.fromCharCode(65 + Math.random() * 26);     const randomDigits = Math.floor(10000000 + Math.random() * 90000000);     return \`arguments[0]-arguments[1]\`; };  console.log(generateLicense());", vars.get("stateCode"),vars.get("randomDigits")));
      vars.put("randomDriveLicense", js.executeScript(
    		    "const generateLicense = () => { " +
    		    "    const stateCode = String.fromCharCode(65 + Math.random() * 26) + String.fromCharCode(65 + Math.random() * 26); " +
    		    "    const randomDigits = Math.floor(10000000 + Math.random() * 90000000); " +
    		    "    return stateCode + '-' + randomDigits; " +
    		    "}; " +
    		    "return generateLicense();"
    		));

      driver.findElement(By.name("guarantorDrivingLicenseNo")).sendKeys(vars.get("randomDriveLicense").toString());
      driver.findElement(By.id("addBtnG")).click();
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
  @Test
  public void Reference() {
    driver.get("http://10.11.200.14:9040/eocas/referenceTabRetailApplication.do");
    Integer times = 2;
    for(int i = 0; i < times; i++) {
      driver.findElement(By.name("referenceRelationship")).click();
      {
        WebElement dropdown = driver.findElement(By.name("referenceRelationship"));
        dropdown.findElement(By.xpath("//option[. = 'Business Friend']")).click();
      }
      driver.findElement(By.name("referenceName")).click();
      vars.put("randomName", js.executeScript("var firstNames = [   \"Abdul\",   \"Rafiqul\",   \"Hasan\",   \"Nazmul\",   \"Sohail\",   \"Farhana\",   \"Shamima\",   \"Mitu\",   \"Sadia\",   \"Jannatul\" ]; var lastNames = [   \"Rahman\",   \"Chowdhury\",   \"Khan\",   \"Ahmed\",   \"Hossain\",   \"Molla\",   \"Miah\",   \"Sarker\",   \"Ferdous\",   \"Kabir\" ];  var randomFirstName = firstNames[Math.floor(Math.random() * firstNames.length)]; var randomLastName = lastNames[Math.floor(Math.random() * lastNames.length)];  var fullName = randomFirstName + \" \" + randomLastName; return fullName;"));
      driver.findElement(By.name("referenceName")).sendKeys(vars.get("randomName").toString());
      driver.findElement(By.name("referenceGender")).click();
      {
        WebElement dropdown = driver.findElement(By.name("referenceGender"));
        dropdown.findElement(By.xpath("//option[. = 'Male']")).click();
      }
      driver.findElement(By.name("referenceContactNo")).click();
      driver.findElement(By.cssSelector("#\\32 5 > .row-fluid:nth-child(5)")).click();
      vars.put("randomPhoneNum", js.executeScript("var prefixes = [\"013\", \"015\", \"016\", \"017\", \"018\", \"019\"];  var prefix = prefixes[Math.floor(Math.random() * prefixes.length)];  var remainingDigits = \"\"; for (var i = 0; i < 8; i++) {   remainingDigits += Math.floor(Math.random() * 10); }  var phoneNumber = prefix + remainingDigits; return phoneNumber;"));
      driver.findElement(By.name("referenceContactNo")).sendKeys(vars.get("randomPhoneNum").toString());
      driver.findElement(By.name("referenceOptMobiNo1")).click();
      vars.put("randomPhoneNum", js.executeScript("var prefixes = [\"013\", \"015\", \"016\", \"017\", \"018\", \"019\"];  var prefix = prefixes[Math.floor(Math.random() * prefixes.length)];  var remainingDigits = \"\"; for (var i = 0; i < 8; i++) {   remainingDigits += Math.floor(Math.random() * 10); }  var phoneNumber = prefix + remainingDigits; return phoneNumber;"));
      driver.findElement(By.name("referenceOptMobiNo1")).sendKeys(vars.get("randomPhoneNum").toString());
      driver.findElement(By.name("referenceOptMobiNo2")).click();
      vars.put("randomPhoneNum", js.executeScript("var prefixes = [\"013\", \"015\", \"016\", \"017\", \"018\", \"019\"];  var prefix = prefixes[Math.floor(Math.random() * prefixes.length)];  var remainingDigits = \"\"; for (var i = 0; i < 8; i++) {   remainingDigits += Math.floor(Math.random() * 10); }  var phoneNumber = prefix + remainingDigits; return phoneNumber;"));
      driver.findElement(By.name("referenceOptMobiNo2")).sendKeys(vars.get("randomPhoneNum").toString());
      driver.findElement(By.name("referenceResidencialStatus")).click();
      {
        WebElement dropdown = driver.findElement(By.name("referenceResidencialStatus"));
        dropdown.findElement(By.xpath("//option[. = 'PERMANENT']")).click();
      }
      driver.findElement(By.name("referenceCurrentResidence")).click();
      driver.findElement(By.cssSelector("#\\32 5 > .row-fluid:nth-child(2) > .span3:nth-child(3) > .control-label")).click();
      driver.findElement(By.name("referenceCurrentResidence")).click();
      vars.put("randomAddress", js.executeScript("var districts = [   \"Dhaka\" ]; var areas = [   \"Gulshan\",   \"Banani\",   \"Dhanmondi\",   \"Motijheel\",   \"Agargaon\",   \"Khilgaon\",   \"Banasree\",   \"Rampura\",   \"Uttara\",   \"Badda\",   \"Motijheel\",   \"Paltan\" ]; var roads = [   \"Road-5\",   \"Road-12\",   \"Road-7A\",   \"Street-3\",   \"Lane-4\",   \"Sector-10\",   \"Block-B\",   \"Avenue-2\" ]; var houseNumber = \"House-\" + Math.floor(Math.random() * 100 + 1);  var district = districts[Math.floor(Math.random() * districts.length)]; var area = areas[Math.floor(Math.random() * areas.length)]; var road = roads[Math.floor(Math.random() * roads.length)];  var address = houseNumber + \", \" + road + \", \" + area + \", \" + district + \", Bangladesh\"; return address;"));
      driver.findElement(By.name("referenceCurrentResidence")).sendKeys(vars.get("randomAddress").toString());
      driver.findElement(By.cssSelector("#\\32 5 > .row-fluid:nth-child(3) > .span3:nth-child(3) > .control-label")).click();
      driver.findElement(By.name("referencePermanentResidence")).click();
      {
        WebElement element = driver.findElement(By.name("referencePermanentResidence"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).clickAndHold().perform();
      }
      {
        WebElement element = driver.findElement(By.cssSelector("#\\32 5 > .row-fluid:nth-child(4) > .span3:nth-child(4)"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).perform();
      }
      {
        WebElement element = driver.findElement(By.cssSelector("#\\32 5 > .row-fluid:nth-child(4) > .span3:nth-child(4)"));
        Actions builder = new Actions(driver);
        builder.moveToElement(element).release().perform();
      }
      driver.findElement(By.name("referencePermanentResidence")).click();
      vars.put("randomAddress", js.executeScript("var districts = [   \"Dhaka\" ]; var areas = [   \"Gulshan\",   \"Banani\",   \"Dhanmondi\",   \"Motijheel\",   \"Agargaon\",   \"Khilgaon\",   \"Banasree\",   \"Rampura\",   \"Uttara\",   \"Badda\",   \"Motijheel\",   \"Paltan\" ]; var roads = [   \"Road-5\",   \"Road-12\",   \"Road-7A\",   \"Street-3\",   \"Lane-4\",   \"Sector-10\",   \"Block-B\",   \"Avenue-2\" ]; var houseNumber = \"House-\" + Math.floor(Math.random() * 100 + 1);  var district = districts[Math.floor(Math.random() * districts.length)]; var area = areas[Math.floor(Math.random() * areas.length)]; var road = roads[Math.floor(Math.random() * roads.length)];  var address = houseNumber + \", \" + road + \", \" + area + \", \" + district + \", Bangladesh\"; return address;"));
      driver.findElement(By.name("referencePermanentResidence")).sendKeys(vars.get("randomAddress").toString());
      driver.findElement(By.name("referenceProfession")).click();
      {
        WebElement dropdown = driver.findElement(By.name("referenceProfession"));
        dropdown.findElement(By.xpath("//option[. = 'JOURNALIST']")).click();
      }
      driver.findElement(By.name("referenceNatureOrDesignation")).click();
      driver.findElement(By.cssSelector("#\\32 5 > .row-fluid:nth-child(5) > .span3:nth-child(3) > .control-label")).click();
      driver.findElement(By.name("referenceNatureOrDesignation")).click();
      vars.put("randomBusniessNature", js.executeScript("var businessNatures = [   \"Retail\",   \"Wholesale\",   \"Manufacturing\",   \"IT Services\",   \"Consultancy\",   \"Transportation\",   \"Healthcare\",   \"Education\",   \"Construction\",   \"Finance\",   \"Hospitality\",   \"E-commerce\",   \"Real Estate\",   \"Agriculture\",   \"Telecommunication\" ];  var randomBusinessNature = businessNatures[Math.floor(Math.random() * businessNatures.length)]; return randomBusinessNature;"));
      driver.findElement(By.name("referenceNatureOrDesignation")).sendKeys(vars.get("randomBusniessNature").toString());
      driver.findElement(By.id("ref_company_name_label")).click();
      driver.findElement(By.name("referenceCompanyName")).click();
      vars.put("randomCompanyName", js.executeScript("var companies = [   \"Grameenphone Ltd.\",   \"BRAC Ltd.\",   \"Aarong Ltd.\",   \"Robi Axiata Limited\",   \"Banglalink Digital Communications Ltd.\",   \"United Group\",   \"Bashundhara Group\",   \"Square Pharmaceuticals Ltd.\",   \"PRAN-RFL Group\",   \"City Group\" ]; var randomCompany = companies[Math.floor(Math.random() * companies.length)]; return randomCompany;"));
      driver.findElement(By.name("referenceCompanyName")).sendKeys(vars.get("randomCompanyName").toString());
      driver.findElement(By.name("referenceExperience")).click();
      driver.findElement(By.name("referenceExperience")).sendKeys("12");
      driver.findElement(By.cssSelector("#\\32 5 > .row-fluid:nth-child(8)")).click();
      driver.findElement(By.id("ref_office_address_label")).click();
      driver.findElement(By.name("referenceOfficeAddress")).click();
      vars.put("randomAddress", js.executeScript("var districts = [   \"Dhaka\" ]; var areas = [   \"Gulshan\",   \"Banani\",   \"Dhanmondi\",   \"Motijheel\",   \"Agargaon\",   \"Khilgaon\",   \"Banasree\",   \"Rampura\",   \"Uttara\",   \"Badda\",   \"Motijheel\",   \"Paltan\" ]; var roads = [   \"Road-5\",   \"Road-12\",   \"Road-7A\",   \"Street-3\",   \"Lane-4\",   \"Sector-10\",   \"Block-B\",   \"Avenue-2\" ]; var houseNumber = \"House-\" + Math.floor(Math.random() * 100 + 1);  var district = districts[Math.floor(Math.random() * districts.length)]; var area = areas[Math.floor(Math.random() * areas.length)]; var road = roads[Math.floor(Math.random() * roads.length)];  var address = houseNumber + \", \" + road + \", \" + area + \", \" + district + \", Bangladesh\"; return address;"));
      driver.findElement(By.name("referenceOfficeAddress")).sendKeys(vars.get("randomAddress").toString());
      driver.findElement(By.id("addBtnR")).click();
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    driver.findElement(By.xpath("//button[@onclick=\'submitReferenceInfo(event)\']")).click();
  }
  @Test
  public void AccountInformation() {
    driver.get("http://10.11.200.14:9040/eocas/financialInfoTabEightRetailApplication.do");
    Integer times = 2;
    for(int i = 0; i < times; i++) {
      driver.findElement(By.id("acPerAcHoldCode")).click();
      {
        WebElement dropdown = driver.findElement(By.id("acPerAcHoldCode"));
        dropdown.findElement(By.xpath("//option[. = 'ENTERPRISE/APPLICANT']")).click();
      }
      driver.findElement(By.id("acPerAcTypeCode")).click();
      {
        WebElement dropdown = driver.findElement(By.id("acPerAcTypeCode"));
        dropdown.findElement(By.xpath("//option[. = 'SAVINGS ACCOUNT']")).click();
      }
      driver.findElement(By.id("acInfoRelationshipYear")).click();
      driver.findElement(By.id("acInfoRelationshipYear")).sendKeys("2");
      driver.findElement(By.id("acPerAcNo")).click();
      driver.findElement(By.id("acPerAcNo")).sendKeys("874563477586");
      driver.findElement(By.id("acInfoCifNo")).click();
      driver.findElement(By.id("getAcPerRelTypeCode")).click();
      try {
        Thread.sleep(6000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      {
        WebElement dropdown = driver.findElement(By.id("getAcPerRelTypeCode"));
        //dropdown.findElement(By.xpath("//option[. = 'vars.get("randomApplicantFullName").toString()']")).click();
        String randomApplicantFullName = vars.get("randomApplicantFullName").toString();
        dropdown.findElement(By.xpath("//option[. = '" + randomApplicantFullName + "']")).click();

      }
      driver.findElement(By.name("acPerFinOrgCode")).click();
      {
        WebElement dropdown = driver.findElement(By.name("acPerFinOrgCode"));
        dropdown.findElement(By.xpath("//option[. = 'BENGAL COMMERCIAL BANK PLC.']")).click();
      }
      driver.findElement(By.id("acBranchInfoSearch")).click();
      driver.findElement(By.xpath("//div[@id=\'acBranchInfoModal\']/div[2]/div/div[2]/table/tbody/tr[5]/td[3]")).click();
      driver.findElement(By.id("acInfoAcTitle")).click();
      vars.put("randomName", js.executeScript("var nicknames = [   \"Raju\",   \"Mitu\",   \"Shuvo\",   \"Pintu\",   \"Nipa\",   \"Sima\",   \"Rita\",   \"Babu\",   \"Titu\",   \"Jitu\",   \"Jony\",   \"Audry\",   \"Nuha\",   \"Shurjo\",   \"Birag\",   \"Ripu\",   \"Nilu\" ];  var randomNickname = nicknames[Math.floor(Math.random() * nicknames.length)]; return randomNickname;"));
      driver.findElement(By.id("acInfoAcTitle")).sendKeys(vars.get("randomName").toString());
      driver.findElement(By.cssSelector(".row-fluid:nth-child(2) > .span4 > .btn-add")).click();
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
  @Test
  public void SecurityRegisteredMortgage() {
    driver.get("http://10.11.200.14:9040/eocas/securityNewTabRetailApplication.do");
    driver.findElement(By.id("getSecurityTypeList")).click();
    {
      WebElement dropdown = driver.findElement(By.id("getSecurityTypeList"));
      dropdown.findElement(By.xpath("//option[. = 'COLLATERAL']")).click();
    }
    driver.findElement(By.id("getPropertyTypeList")).click();
    {
      WebElement dropdown = driver.findElement(By.id("getPropertyTypeList"));
      dropdown.findElement(By.xpath("//option[. = 'Registered Mortgage']")).click();
    }
    driver.findElement(By.id("setSchedulePropertyVal")).click();
    {
      WebElement dropdown = driver.findElement(By.id("setSchedulePropertyVal"));
      dropdown.findElement(By.xpath("//option[. = 'Land & Building']")).click();
    }
    driver.findElement(By.id("secuDeedPresentMortgage")).click();
    {
      WebElement dropdown = driver.findElement(By.id("secuDeedPresentMortgage"));
      dropdown.findElement(By.xpath("//option[. = 'TPA']")).click();
    }
    driver.findElement(By.name("propertyOwner")).click();
    driver.findElement(By.name("propertyOwner")).sendKeys("Nishat Sharmin");
    driver.findElement(By.name("securityDivision")).click();
    {
      WebElement dropdown = driver.findElement(By.name("securityDivision"));
      dropdown.findElement(By.xpath("//option[. = 'CHATTAGRAM']")).click();
    }
    driver.findElement(By.name("secuLocationRelType")).click();
    {
      WebElement dropdown = driver.findElement(By.name("secuLocationRelType"));
      dropdown.findElement(By.xpath("//option[. = 'Brother In Law']")).click();
    }
    driver.findElement(By.name("securityDistrictcode")).click();
    {
      WebElement dropdown = driver.findElement(By.name("securityDistrictcode"));
      dropdown.findElement(By.xpath("//option[. = 'Barishal']")).click();
    }
    driver.findElement(By.name("securityStationcode")).click();
    {
      WebElement dropdown = driver.findElement(By.name("securityStationcode"));
      dropdown.findElement(By.xpath("//option[. = 'Muladi']")).click();
    }
    driver.findElement(By.name("securitySubregistryoffice")).click();
    driver.findElement(By.name("securitySubregistryoffice")).sendKeys("Dhaka");
    driver.findElement(By.name("securityMouzaname")).click();
    driver.findElement(By.name("securityMouzaname")).sendKeys("12");
    driver.findElement(By.name("secuLocationLandSize")).click();
    driver.findElement(By.name("secuLocationLandSize")).sendKeys("12000");
    driver.findElement(By.name("securityOnnorth")).click();
    driver.findElement(By.name("securityOnnorth")).sendKeys("12");
    driver.findElement(By.name("securityOnsouth")).click();
    driver.findElement(By.name("securityOnsouth")).sendKeys("12");
    driver.findElement(By.name("securityOneast")).click();
    driver.findElement(By.name("securityOneast")).sendKeys("12");
    driver.findElement(By.name("securityOnwest")).sendKeys("12");
    driver.findElement(By.id("secuLandType")).click();
    {
      WebElement dropdown = driver.findElement(By.id("secuLandType"));
      dropdown.findElement(By.xpath("//option[. = 'LEASEHOLD']")).click();
    }
    driver.findElement(By.name("secuBuildingType")).click();
    {
      WebElement dropdown = driver.findElement(By.name("secuBuildingType"));
      dropdown.findElement(By.xpath("//option[. = 'COMMERCIAL']")).click();
    }
    driver.findElement(By.name("secuFloorNo")).click();
    driver.findElement(By.name("secuFloorNo")).sendKeys("10");
    driver.findElement(By.name("secuContructCompleteYear")).click();
    driver.findElement(By.name("secuContructCompleteYear")).sendKeys("2029");
    driver.findElement(By.name("secuBuildingName")).click();
    driver.findElement(By.name("secuBuildingName")).click();
    driver.findElement(By.name("secuBuildingName")).sendKeys("An-Noor Villa");
    driver.findElement(By.name("secuPlanApprovalAuth")).click();
    driver.findElement(By.name("secuPlanApprovalAuth")).sendKeys("Demox Builders");
    driver.findElement(By.name("secuContructBy")).click();
    {
      WebElement dropdown = driver.findElement(By.name("secuContructBy"));
      dropdown.findElement(By.xpath("//option[. = 'INDIVIDUAL']")).click();
    }
    driver.findElement(By.name("securityPlotno")).click();
    driver.findElement(By.name("securityPlotno")).sendKeys("23423");
    driver.findElement(By.name("securitySectorsectionno")).click();
    driver.findElement(By.name("securitySectorsectionno")).sendKeys("2");
    driver.findElement(By.name("securityRoadno")).click();
    driver.findElement(By.name("securityRoadno")).sendKeys("15");
    driver.findElement(By.name("securityBlockno")).click();
    driver.findElement(By.name("securityBlockno")).click();
    driver.findElement(By.name("securityBlockno")).sendKeys("A");
    driver.findElement(By.name("secuLeasingAuthority")).click();
    driver.findElement(By.name("secuLeasingAuthority")).sendKeys("Bhuiyan Traders");
    driver.findElement(By.name("securityAuthorityname")).click();
    {
      WebElement dropdown = driver.findElement(By.name("securityAuthorityname"));
      dropdown.findElement(By.xpath("//option[. = 'TRANSFER']")).click();
    }
    driver.findElement(By.name("securityReferenceno")).click();
    driver.findElement(By.name("securityReferenceno")).sendKeys("3453534");
    driver.findElement(By.name("securityReferencedate")).click();
    driver.findElement(By.name("securityReferencedate")).sendKeys("10/01/2025");
    driver.findElement(By.name("securityExecutiondate")).click();
    driver.findElement(By.name("securityExecutiondate")).sendKeys("10/01/2026");
    driver.findElement(By.cssSelector(".widget:nth-child(13) > .row-fluid:nth-child(2) > .span3:nth-child(1) > .control-label")).click();
    driver.findElement(By.name("securitySubregistryofficename")).click();
    driver.findElement(By.name("securitySubregistryofficename")).sendKeys("Sub Registry Office Name");
    driver.findElement(By.name("securitySecuritytypeofdeed")).click();
    {
      WebElement dropdown = driver.findElement(By.name("securitySecuritytypeofdeed"));
      dropdown.findElement(By.xpath("//option[. = 'BAYA DEED']")).click();
    }
    driver.findElement(By.name("securitySrotokenno")).click();
    driver.findElement(By.name("securitySrotokenno")).sendKeys("654654");
    driver.findElement(By.name("securityDeedsubmittdocumenttype")).click();
    {
      WebElement dropdown = driver.findElement(By.name("securityDeedsubmittdocumenttype"));
      dropdown.findElement(By.xpath("//option[. = 'CERTIFIED COPY']")).click();
    }
    driver.findElement(By.name("secuDeedNature")).click();
    driver.findElement(By.cssSelector(".widget:nth-child(13) > .row-fluid:nth-child(4) > .span3:nth-child(1)")).click();
    driver.findElement(By.name("secuDeedNature")).click();
    driver.findElement(By.name("secuDeedNature")).sendKeys("Nature of Deed");
    driver.findElement(By.name("securityDeedNumber")).click();
    driver.findElement(By.name("securityDeedNumber")).sendKeys("65465465465");
    driver.findElement(By.name("secuDeedRegDate")).click();
    driver.findElement(By.name("secuDeedRegDate")).sendKeys("17/01/2024");
    driver.findElement(By.name("securityTpaExecutionDate")).click();
    driver.findElement(By.name("securityTpaExecutionDate")).sendKeys("22/01/2025");
    driver.findElement(By.name("securityExpirydate")).click();
    driver.findElement(By.name("securityExpirydate")).sendKeys("22/01/2026");
    driver.findElement(By.id("securityConstructionstatus")).click();
    driver.findElement(By.id("securityConstructionstatus")).sendKeys("50");
    driver.findElement(By.id("securityHandoverstatus")).click();
    {
      WebElement dropdown = driver.findElement(By.id("securityHandoverstatus"));
      dropdown.findElement(By.xpath("//option[. = 'YET TO HANDEDOVER']")).click();
    }
    driver.findElement(By.id("secuExpectedHandedoverDate")).click();
    driver.findElement(By.id("secuExpectedHandedoverDate")).sendKeys("01/02/2026");
    driver.findElement(By.id("securityCurrentoccupancystatus")).click();
    {
      WebElement dropdown = driver.findElement(By.id("securityCurrentoccupancystatus"));
      dropdown.findElement(By.xpath("//option[. = 'Owner']")).click();
    }
    driver.findElement(By.id("securitySaledeedstatus")).click();
    {
      WebElement dropdown = driver.findElement(By.id("securitySaledeedstatus"));
      dropdown.findElement(By.xpath("//option[. = 'EXECUTED']")).click();
    }
    driver.findElement(By.id("securityMortgagestatus")).click();
    {
      WebElement dropdown = driver.findElement(By.id("securityMortgagestatus"));
      dropdown.findElement(By.xpath("//option[. = 'EXECUTED']")).click();
    }
    driver.findElement(By.id("securityRegisteredipastatus")).click();
    {
      WebElement dropdown = driver.findElement(By.id("securityRegisteredipastatus"));
      dropdown.findElement(By.xpath("//option[. = 'EXECUTED']")).click();
    }
    driver.findElement(By.name("securityTkobankname")).click();
    driver.findElement(By.cssSelector(".regismortgageHideShow:nth-child(7) > .row-fluid:nth-child(2) > .span3:nth-child(1) > .control-label")).click();
    driver.findElement(By.name("securityTkobankname")).click();
    driver.findElement(By.name("securityTkobankname")).sendKeys("Test Takeover Bank Name");
    driver.findElement(By.id("securityTkodate")).click();
    driver.findElement(By.id("securityTkodate")).sendKeys("07/01/2031");
    driver.findElement(By.name("securityTkoorginalmoneypmtamt")).click();
    driver.findElement(By.name("securityTkoorginalmoneypmtamt")).sendKeys("100000");
    driver.findElement(By.name("secuEncumCertificate")).click();
    {
      WebElement dropdown = driver.findElement(By.name("secuEncumCertificate"));
      dropdown.findElement(By.xpath("//option[. = 'SUBMITTED']")).click();
    }
    driver.findElement(By.name("securityTkonoliabilitycertificate")).click();
    {
      WebElement dropdown = driver.findElement(By.name("securityTkonoliabilitycertificate"));
      dropdown.findElement(By.xpath("//option[. = 'SUBMITTED']")).click();
    }
    driver.findElement(By.id("secuSecuritizationstatus")).click();
    {
      WebElement dropdown = driver.findElement(By.id("secuSecuritizationstatus"));
      dropdown.findElement(By.xpath("//option[. = 'EXECUTED']")).click();
    }
    driver.findElement(By.name("securityTkopayorderrcptcopy")).click();
    {
      WebElement dropdown = driver.findElement(By.name("securityTkopayorderrcptcopy"));
      dropdown.findElement(By.xpath("//option[. = 'SUBMITTED']")).click();
    }
    driver.findElement(By.name("securityTkodocrecptstatus")).click();
    {
      WebElement dropdown = driver.findElement(By.name("securityTkodocrecptstatus"));
      dropdown.findElement(By.xpath("//option[. = 'RECEIVED']")).click();
    }
    driver.findElement(By.cssSelector(".row-fluid:nth-child(13) > .span4 > .btn-add")).click();
    assertThat(driver.findElement(By.cssSelector("b:nth-child(2)")).getText(), is("Execution Completed Successfully !"));
    driver.findElement(By.xpath("//img[@alt=\'Modify\']")).click();
    {
      WebElement element = driver.findElement(By.id("getSecurityTypeList"));
      String value = element.getAttribute("value");
      String locator = String.format("option[@value='%s']", value);
      String selectedText = element.findElement(By.xpath(locator)).getText();
      assertThat(selectedText, is("COLLATERAL"));
    }
    {
      WebElement element = driver.findElement(By.id("getPropertyTypeList"));
      String value = element.getAttribute("value");
      String locator = String.format("option[@value='%s']", value);
      String selectedText = element.findElement(By.xpath(locator)).getText();
      assertThat(selectedText, is("Registered Mortgage"));
    }
    {
      WebElement element = driver.findElement(By.id("setSchedulePropertyVal"));
      String value = element.getAttribute("value");
      String locator = String.format("option[@value='%s']", value);
      String selectedText = element.findElement(By.xpath(locator)).getText();
      assertThat(selectedText, is("Land & Building"));
    }
    {
      WebElement element = driver.findElement(By.id("secuDeedPresentMortgage"));
      String value = element.getAttribute("value");
      String locator = String.format("option[@value='%s']", value);
      String selectedText = element.findElement(By.xpath(locator)).getText();
      assertThat(selectedText, is("TPA"));
    }
    {
      String value = driver.findElement(By.name("propertyOwner")).getAttribute("value");
      assertThat(value, is("Nishat Sharmin"));
    }
    {
      WebElement element = driver.findElement(By.name("securityDivision"));
      String value = element.getAttribute("value");
      String locator = String.format("option[@value='%s']", value);
      String selectedText = element.findElement(By.xpath(locator)).getText();
      assertThat(selectedText, is("CHATTAGRAM"));
    }
    {
      WebElement element = driver.findElement(By.name("secuLocationRelType"));
      String value = element.getAttribute("value");
      String locator = String.format("option[@value='%s']", value);
      String selectedText = element.findElement(By.xpath(locator)).getText();
      assertThat(selectedText, is("Brother In Law"));
    }
    {
      WebElement element = driver.findElement(By.name("securityDistrictcode"));
      String value = element.getAttribute("value");
      String locator = String.format("option[@value='%s']", value);
      String selectedText = element.findElement(By.xpath(locator)).getText();
      assertThat(selectedText, is("Barishal"));
    }
    {
      WebElement element = driver.findElement(By.name("securityStationcode"));
      String value = element.getAttribute("value");
      String locator = String.format("option[@value='%s']", value);
      String selectedText = element.findElement(By.xpath(locator)).getText();
      assertThat(selectedText, is("Muladi"));
    }
    {
      String value = driver.findElement(By.name("securitySubregistryoffice")).getAttribute("value");
      assertThat(value, is("Dhaka"));
    }
    {
      String value = driver.findElement(By.name("securityMouzaname")).getAttribute("value");
      assertThat(value, is("12"));
    }
    {
      String value = driver.findElement(By.name("secuLocationLandSize")).getAttribute("value");
      assertThat(value, is("12000"));
    }
    {
      String value = driver.findElement(By.name("securityOnnorth")).getAttribute("value");
      assertThat(value, is("12"));
    }
    {
      String value = driver.findElement(By.name("securityOnsouth")).getAttribute("value");
      assertThat(value, is("12"));
    }
    {
      String value = driver.findElement(By.name("securityOneast")).getAttribute("value");
      assertThat(value, is("12"));
    }
    {
      String value = driver.findElement(By.name("securityOnwest")).getAttribute("value");
      assertThat(value, is("12"));
    }
    {
      WebElement element = driver.findElement(By.id("secuLandType"));
      String value = element.getAttribute("value");
      String locator = String.format("option[@value='%s']", value);
      String selectedText = element.findElement(By.xpath(locator)).getText();
      assertThat(selectedText, is("LEASEHOLD"));
    }
    {
      WebElement element = driver.findElement(By.name("secuBuildingType"));
      String value = element.getAttribute("value");
      String locator = String.format("option[@value='%s']", value);
      String selectedText = element.findElement(By.xpath(locator)).getText();
      assertThat(selectedText, is("COMMERCIAL"));
    }
    {
      String value = driver.findElement(By.name("secuFloorNo")).getAttribute("value");
      assertThat(value, is("10"));
    }
    {
      String value = driver.findElement(By.name("secuContructCompleteYear")).getAttribute("value");
      assertThat(value, is("2029"));
    }
    {
      String value = driver.findElement(By.name("secuBuildingName")).getAttribute("value");
      assertThat(value, is("An-Noor Villa"));
    }
    {
      String value = driver.findElement(By.name("secuPlanApprovalAuth")).getAttribute("value");
      assertThat(value, is("Demox Builders"));
    }
    {
      WebElement element = driver.findElement(By.name("secuContructBy"));
      String value = element.getAttribute("value");
      String locator = String.format("option[@value='%s']", value);
      String selectedText = element.findElement(By.xpath(locator)).getText();
      assertThat(selectedText, is("INDIVIDUAL"));
    }
    {
      String value = driver.findElement(By.name("securityPlotno")).getAttribute("value");
      assertThat(value, is("23423"));
    }
    {
      String value = driver.findElement(By.name("securitySectorsectionno")).getAttribute("value");
      assertThat(value, is("2"));
    }
    {
      String value = driver.findElement(By.name("securityRoadno")).getAttribute("value");
      assertThat(value, is("15"));
    }
    {
      String value = driver.findElement(By.name("securityBlockno")).getAttribute("value");
      assertThat(value, is("A"));
    }
    {
      String value = driver.findElement(By.name("secuLeasingAuthority")).getAttribute("value");
      assertThat(value, is("Bhuiyan Traders"));
    }
    {
      WebElement element = driver.findElement(By.name("securityAuthorityname"));
      String value = element.getAttribute("value");
      String locator = String.format("option[@value='%s']", value);
      String selectedText = element.findElement(By.xpath(locator)).getText();
      assertThat(selectedText, is("TRANSFER"));
    }
    {
      String value = driver.findElement(By.name("securityReferenceno")).getAttribute("value");
      assertThat(value, is("3453534"));
    }
    {
      String value = driver.findElement(By.name("securityReferencedate")).getAttribute("value");
      assertThat(value, is("10/01/2025"));
    }
    {
      String value = driver.findElement(By.name("securityExecutiondate")).getAttribute("value");
      assertThat(value, is("10/01/2026"));
    }
    {
      String value = driver.findElement(By.name("securitySubregistryofficename")).getAttribute("value");
      assertThat(value, is("Sub Registry Office Name"));
    }
    {
      WebElement element = driver.findElement(By.name("securitySecuritytypeofdeed"));
      String value = element.getAttribute("value");
      String locator = String.format("option[@value='%s']", value);
      String selectedText = element.findElement(By.xpath(locator)).getText();
      assertThat(selectedText, is("BAYA DEED"));
    }
    {
      String value = driver.findElement(By.name("securitySrotokenno")).getAttribute("value");
      assertThat(value, is("654654"));
    }
    {
      WebElement element = driver.findElement(By.name("securityDeedsubmittdocumenttype"));
      String value = element.getAttribute("value");
      String locator = String.format("option[@value='%s']", value);
      String selectedText = element.findElement(By.xpath(locator)).getText();
      assertThat(selectedText, is("CERTIFIED COPY"));
    }
    {
      String value = driver.findElement(By.name("secuDeedNature")).getAttribute("value");
      assertThat(value, is("Nature of Deed"));
    }
    {
      String value = driver.findElement(By.name("securityDeedNumber")).getAttribute("value");
      assertThat(value, is("65465465465"));
    }
    {
      String value = driver.findElement(By.name("secuDeedRegDate")).getAttribute("value");
      assertThat(value, is("17/01/2024"));
    }
    {
      String value = driver.findElement(By.name("securityTpaExecutionDate")).getAttribute("value");
      assertThat(value, is("22/01/2025"));
    }
    {
      String value = driver.findElement(By.name("securityExpirydate")).getAttribute("value");
      assertThat(value, is("22/01/2026"));
    }
    {
      String value = driver.findElement(By.id("securityConstructionstatus")).getAttribute("value");
      assertThat(value, is("50"));
    }
    {
      WebElement element = driver.findElement(By.id("securityHandoverstatus"));
      String value = element.getAttribute("value");
      String locator = String.format("option[@value='%s']", value);
      String selectedText = element.findElement(By.xpath(locator)).getText();
      assertThat(selectedText, is("YET TO HANDEDOVER"));
    }
    {
      String value = driver.findElement(By.id("secuExpectedHandedoverDate")).getAttribute("value");
      assertThat(value, is("01/02/2026"));
    }
    {
      WebElement element = driver.findElement(By.id("securityCurrentoccupancystatus"));
      String value = element.getAttribute("value");
      String locator = String.format("option[@value='%s']", value);
      String selectedText = element.findElement(By.xpath(locator)).getText();
      assertThat(selectedText, is("Owner"));
    }
    {
      WebElement element = driver.findElement(By.id("securitySaledeedstatus"));
      String value = element.getAttribute("value");
      String locator = String.format("option[@value='%s']", value);
      String selectedText = element.findElement(By.xpath(locator)).getText();
      assertThat(selectedText, is("EXECUTED"));
    }
    {
      WebElement element = driver.findElement(By.id("securityMortgagestatus"));
      String value = element.getAttribute("value");
      String locator = String.format("option[@value='%s']", value);
      String selectedText = element.findElement(By.xpath(locator)).getText();
      assertThat(selectedText, is("EXECUTED"));
    }
    {
      WebElement element = driver.findElement(By.id("securityRegisteredipastatus"));
      String value = element.getAttribute("value");
      String locator = String.format("option[@value='%s']", value);
      String selectedText = element.findElement(By.xpath(locator)).getText();
      assertThat(selectedText, is("EXECUTED"));
    }
    {
      String value = driver.findElement(By.name("securityTkobankname")).getAttribute("value");
      assertThat(value, is("Test Takeover Bank Name"));
    }
    {
      String value = driver.findElement(By.id("securityTkodate")).getAttribute("value");
      assertThat(value, is("07/01/2031"));
    }
    {
      String value = driver.findElement(By.name("securityTkoorginalmoneypmtamt")).getAttribute("value");
      assertThat(value, is("100000"));
    }
    {
      WebElement element = driver.findElement(By.name("secuEncumCertificate"));
      String value = element.getAttribute("value");
      String locator = String.format("option[@value='%s']", value);
      String selectedText = element.findElement(By.xpath(locator)).getText();
      assertThat(selectedText, is("SUBMITTED"));
    }
    {
      WebElement element = driver.findElement(By.name("securityTkonoliabilitycertificate"));
      String value = element.getAttribute("value");
      String locator = String.format("option[@value='%s']", value);
      String selectedText = element.findElement(By.xpath(locator)).getText();
      assertThat(selectedText, is("SUBMITTED"));
    }
    {
      WebElement element = driver.findElement(By.id("secuSecuritizationstatus"));
      String value = element.getAttribute("value");
      String locator = String.format("option[@value='%s']", value);
      String selectedText = element.findElement(By.xpath(locator)).getText();
      assertThat(selectedText, is("EXECUTED"));
    }
    {
      WebElement element = driver.findElement(By.name("securityTkopayorderrcptcopy"));
      String value = element.getAttribute("value");
      String locator = String.format("option[@value='%s']", value);
      String selectedText = element.findElement(By.xpath(locator)).getText();
      assertThat(selectedText, is("SUBMITTED"));
    }
    {
      WebElement element = driver.findElement(By.name("securityTkodocrecptstatus"));
      String value = element.getAttribute("value");
      String locator = String.format("option[@value='%s']", value);
      String selectedText = element.findElement(By.xpath(locator)).getText();
      assertThat(selectedText, is("RECEIVED"));
    }
  }
  @Test
  public void SellerDeveloperInfo() {
    driver.get("http://10.11.200.14:9040/eocas/sellerDevTabOneRetailApplication.do");
    driver.findElement(By.cssSelector("#sdfirst .row-fluid:nth-child(2) > .span3:nth-child(1) > .control-label")).click();
    driver.findElement(By.name("devOfcAddress")).click();
    driver.findElement(By.name("devOfcAddress")).sendKeys("Office Address");
    driver.findElement(By.id("finIncomeRelationType")).click();
    {
      WebElement dropdown = driver.findElement(By.id("finIncomeRelationType"));
      dropdown.findElement(By.xpath("//option[. = 'YES']")).click();
    }
    driver.findElement(By.name("devAuthRep")).click();
    driver.findElement(By.name("devAuthRep")).sendKeys("Shoikot Molla");
    driver.findElement(By.cssSelector("#sdfirst .row-fluid:nth-child(5) > .span3:nth-child(1) > .control-label")).click();
    driver.findElement(By.name("devPrjDesc")).click();
    driver.findElement(By.name("devPrjDesc")).sendKeys("Project Description");
    driver.findElement(By.id("devVerifyPropDocSts")).click();
    {
      WebElement dropdown = driver.findElement(By.id("devVerifyPropDocSts"));
      dropdown.findElement(By.xpath("//option[. = 'YES']")).click();
    }
    driver.findElement(By.name("devOrgmnRcp")).click();
    {
      WebElement dropdown = driver.findElement(By.name("devOrgmnRcp"));
      dropdown.findElement(By.xpath("//option[. = 'YES']")).click();
    }
    driver.findElement(By.name("devName")).click();
    {
      WebElement dropdown = driver.findElement(By.name("devName"));
      dropdown.findElement(By.xpath("//option[. = 'Biswash Builders Ltd.']")).click();
    }
    driver.findElement(By.name("devRegAddress")).click();
    driver.findElement(By.name("devRegAddress")).sendKeys("Registered Address");
    driver.findElement(By.name("devEblCat")).click();
    {
      WebElement dropdown = driver.findElement(By.name("devEblCat"));
      dropdown.findElement(By.xpath("//option[. = 'Category A']")).click();
    }
    driver.findElement(By.cssSelector("#sdfirst .row-fluid:nth-child(4) > .span3:nth-child(3) > .control-label")).click();
    driver.findElement(By.name("devPrjName")).click();
    driver.findElement(By.name("devPrjName")).sendKeys("Project Name");
    driver.findElement(By.id("devVerifySts")).click();
    {
      WebElement dropdown = driver.findElement(By.id("devVerifySts"));
      dropdown.findElement(By.xpath("//option[. = 'YES']")).click();
    }
    driver.findElement(By.name("devPayOrderRcv")).click();
    {
      WebElement dropdown = driver.findElement(By.name("devPayOrderRcv"));
      dropdown.findElement(By.xpath("//option[. = 'YES']")).click();
    }
    driver.findElement(By.id("addBtnDevDiv")).click();
    driver.findElement(By.cssSelector("#sdfirst .row-fluid:nth-child(2) > .span3:nth-child(1) > .control-label")).click();
    driver.findElement(By.name("devOfcAddress")).click();
    driver.findElement(By.name("devOfcAddress")).sendKeys(" Office Address");
    driver.findElement(By.id("addBtnDevDiv")).click();
    driver.findElement(By.id("ui-id-2")).click();
    driver.findElement(By.name("sellerName")).click();
    driver.findElement(By.name("sellerName")).sendKeys("Nishat Sharmin");
    driver.findElement(By.name("sellerAcNo")).click();
    driver.findElement(By.name("sellerNID")).click();
    driver.findElement(By.name("sellerNID")).sendKeys("65464654635");
    driver.findElement(By.name("sellerAcNo")).click();
    driver.findElement(By.name("sellerNID")).click();
    driver.findElement(By.name("sellerNID")).sendKeys("65464654635654654");
    driver.findElement(By.name("sellerAcNo")).click();
    driver.findElement(By.name("sellerAcNo")).sendKeys("451676");
    driver.findElement(By.name("sellerACName")).click();
    driver.findElement(By.name("sellerACName")).sendKeys("Sharmin Akter");
    driver.findElement(By.name("sellerBankName")).click();
    driver.findElement(By.name("sellerBankName")).sendKeys("Nobin bank");
    driver.findElement(By.cssSelector(".row-fluid > .row-fluid > .row-fluid:nth-child(1) > .span3:nth-child(3) > .control-label")).click();
    driver.findElement(By.name("sellerPresentAddress")).click();
    driver.findElement(By.name("sellerPresentAddress")).sendKeys("Present Address");
    driver.findElement(By.cssSelector(".row-fluid > .row-fluid > .row-fluid:nth-child(2) > .span3:nth-child(3) > .control-label")).click();
    driver.findElement(By.name("sellerPermanentAddress")).click();
    driver.findElement(By.name("sellerPermanentAddress")).sendKeys("Permanent Address");
    driver.findElement(By.name("sellerVerifySts")).click();
    {
      WebElement dropdown = driver.findElement(By.name("sellerVerifySts"));
      dropdown.findElement(By.xpath("//option[. = 'YES']")).click();
    }
    driver.findElement(By.name("sellerOrgDocSts")).click();
    {
      WebElement dropdown = driver.findElement(By.name("sellerOrgDocSts"));
      dropdown.findElement(By.xpath("//option[. = 'YES']")).click();
    }
    driver.findElement(By.name("sellerRcvSts")).click();
    {
      WebElement dropdown = driver.findElement(By.name("sellerRcvSts"));
      dropdown.findElement(By.xpath("//option[. = 'YES']")).click();
    }
    driver.findElement(By.name("sellerAckLetter")).click();
    {
      WebElement dropdown = driver.findElement(By.name("sellerAckLetter"));
      dropdown.findElement(By.xpath("//option[. = 'YES']")).click();
    }
    driver.findElement(By.id("addBtnSellerDiv")).click();
    {
      WebElement element = driver.findElement(By.id("addBtnSellerDiv"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element).perform();
    }
    {
      WebElement element = driver.findElement(By.tagName("body"));
      Actions builder = new Actions(driver);
      builder.moveToElement(element, 0, 0).perform();
    }
  }
}
