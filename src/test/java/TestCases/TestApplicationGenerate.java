package TestCases;




        import org.apache.poi.hssf.record.PageBreakRecord;
        import org.apache.poi.ss.usermodel.*;
        import org.apache.poi.xssf.usermodel.XSSFWorkbook;
        import org.junit.After;
        import org.junit.Before;
        import org.junit.Test;
        import org.openqa.selenium.*;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.Dimension;

        import java.io.File;
        import java.io.FileInputStream;
        import java.io.IOException;
        import java.util.HashMap;
        import java.util.Map;

        import static org.hamcrest.CoreMatchers.is;
        import static org.hamcrest.MatcherAssert.assertThat;

public class TestApplicationGenerate {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    private Workbook workbook;
    private Sheet sheet;

    @Before
    public void setUp() throws IOException {
        // Initialize WebDriver
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<>();

        // Load Excel file
        FileInputStream file = new FileInputStream(new File("E:\\Eclipse Files\\Retail_IDE_Webdriver\\selenium_input_data.xlsx"));
        workbook = new XSSFWorkbook(file);
        sheet = workbook.getSheetAt(0); // Assuming data is on the first sheet

        driver.get("http://10.11.200.14:9040/eocas/logIn.do");
        driver.manage().window().setSize(new Dimension(1382, 744));

        // Read username and password from Excel
        String username = sheet.getRow(1).getCell(0).getStringCellValue();
        String password = sheet.getRow(1).getCell(1).getStringCellValue();

        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
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
    @After
    public void tearDown() throws IOException {
        driver.quit();
        workbook.close();
    }

    @Test
    public void NewApplicationGenerationSimplified() throws InterruptedException {
        driver.get("http://10.11.200.14:9040/eocas/loadDashboardDataGridList.do");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[normalize-space()='New Application']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//button[contains(text(),'De-Dup Check')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("checkedFlagCode")).click();
        driver.findElement(By.xpath("//option[. = 'YES']")).click();

        driver.findElement(By.id("exeShowHideBtn")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();

        // Read customer name and nickname from Excel
        String customerName = sheet.getRow(1).getCell(2).getStringCellValue();
        String nickName = sheet.getRow(1).getCell(3).getStringCellValue();

        driver.findElement(By.name("customerName")).sendKeys(customerName);
        driver.findElement(By.name("basicAliasName")).sendKeys(nickName);

        Thread.sleep(2000);

        // Read customer type from Excel and select it
        String customerType = sheet.getRow(1).getCell(4).getStringCellValue();
        WebElement custTypeDropdown = driver.findElement(By.name("basicCustType"));
        custTypeDropdown.findElement(By.xpath("//option[. = '" + customerType + "']")).click();

        // Read customer category from Excel and select it
        String customerCategory = sheet.getRow(1).getCell(5).getStringCellValue();
        WebElement custCategoryDropdown = driver.findElement(By.name("basicCustCategory"));
        custCategoryDropdown.findElement(By.xpath("//option[. = '" + customerCategory + "']")).click();


        Thread.sleep(2000);

        // Read new customer category from Excel and select it
        String newCustomerCategory = sheet.getRow(1).getCell(6).getStringCellValue();
        WebElement newCustCategoryDropdown = driver.findElement(By.name("basicCustCategoryNew"));
        newCustCategoryDropdown.findElement(By.xpath("//option[. = '" + newCustomerCategory + "']")).click();

        driver.findElement(By.id("branchInfoSearch")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//td[contains(text(),'Banani')]")).click();

        // Read assessment type from Excel and select it
        String assessmentType = sheet.getRow(1).getCell(7).getStringCellValue();
        WebElement assessmentDropdown = driver.findElement(By.name("assesmentTypeCode"));
        assessmentDropdown.findElement(By.xpath("//option[. = '" + assessmentType + "']")).click();

        driver.findElement(By.id("appIdGenerate")).click();
        Thread.sleep(2000);
    }
    @Test
    public void FacilityInfoAutoCarLoan() throws InterruptedException{
        //new added

        driver.findElement(By.xpath("//td[normalize-space()='2']")).click();// change 2=1,2,3,4,5 ; Xl input
        Thread.sleep(2000);
        driver.findElement(By.linkText("Facility Info")).click();
        Thread.sleep(2000);





        driver.get("http://10.11.200.14:9040/eocas/loanInfoTabRetailApplication.do");

        //driver.findElement(By.name("loanProduct")).click();
        {
            WebElement dropdown = driver.findElement(By.name("loanProduct"));
            dropdown.findElement(By.xpath("//option[. = 'UNSECURED']")).click();//MIXED,UNSECURED, SECURED xl input needed for dropdown
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("loanType")).click();
        {
            WebElement dropdown = driver.findElement(By.id("loanType"));
            dropdown.findElement(By.xpath("//option[. = 'EBL Car Loan(0711)']")).click();/*EBL Car Loan(0711), EBL Category - B Executive Loan(0709),
             EBL Category - C Executive Loan(0710), EBL Fast Loan(0701), EBL JIBANDHARA LOAN(0715), EBL PARSELOAN(0729), EBL PROFESSIONAL LOAN(0736), EBL Two Wheeler(0749), Edu Loan - Secured(0724),
             LOAN AGAINST MONTHLY SALARY (LAMS)(0712), Special Cat-A Executive Loan(0714), Staff - Housing Loan(0704) */ //dropdown set for xl

        }
        driver.findElement(By.id("loanAmount")).clear();
        driver.findElement(By.id("loanAmount")).sendKeys("350000");// XL input
        Thread.sleep(2000);

        driver.findElement(By.id("loanTenor")).clear();
        driver.findElement(By.id("loanTenor")).sendKeys("60");// XL input
        driver.findElement(By.id("loanTenor")).sendKeys(Keys.ENTER);
        driver.findElement(By.name("loanRepaymentDate")).click();
        {
            WebElement dropdown = driver.findElement(By.name("loanRepaymentDate"));
            dropdown.findElement(By.xpath("//option[@value='5th']")).click();/* 5th, 15th, 25th*/ //dropdown set for xl

        }
       // driver.findElement(By.name("loanCampaign")).click();
        driver.findElement(By.name("loanPurpose")).click();
        driver.findElement(By.name("loanProposalType")).click();
        {
            WebElement dropdown = driver.findElement(By.name("loanProposalType"));
            dropdown.findElement(By.xpath("//option[. = 'NEW']")).click();//NEW, REWEWAL, ENHANCEMENT, REDUCTION, TOP-UP & TAKEOVER, ALT   xl Dropdown
        }
        driver.findElement(By.cssSelector("#\\32 > .row-fluid:nth-child(4)")).click();
        Thread.sleep(5000);


        driver.findElement(By.id("loanInterestRate")).sendKeys("9");
        //driver.findElement(By.name("loanDisburseAcc")).click();
        //driver.findElement(By.name("loanStartFrom")).click();
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
                        "return     day + '/' + month + '/' + year;"
        ));
        driver.findElement(By.name("loanStartFrom")).sendKeys(vars.get("randomLoanStartDate").toString());//EMi starting date input by xl
        Thread.sleep(5000);
        //driver.findElement(By.name("loanCurrentDate")).sendKeys("12/12/2025");;
        driver.findElement(By.xpath("//button[@onclick='submitLoanInfo(event)']")).click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertThat(driver.findElement(By.cssSelector("b:nth-child(2)")).getText(), is("Execution Completed Successfully...!!!"));
    }
}
