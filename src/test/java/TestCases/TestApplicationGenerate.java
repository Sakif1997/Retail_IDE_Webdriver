package TestCases;




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
        FileInputStream file = new FileInputStream(new File("C:\\Users\\user\\eclipse-workspace\\EBL_Retail_IDE_TO_Seleium\\selenium_input_data.xlsx"));
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
        Thread.sleep(5000);

        driver.findElement(By.xpath("//button[contains(text(),'De-Dup Check')]")).click();
        Thread.sleep(5000);
        driver.findElement(By.name("checkedFlagCode")).click();
        driver.findElement(By.xpath("//option[. = 'YES']")).click();

        driver.findElement(By.id("exeShowHideBtn")).click();
        driver.findElement(By.xpath("//button[contains(text(),'Back')]")).click();

        // Read customer name and nickname from Excel
        String customerName = sheet.getRow(1).getCell(2).getStringCellValue();
        String nickName = sheet.getRow(1).getCell(3).getStringCellValue();

        driver.findElement(By.name("customerName")).sendKeys(customerName);
        driver.findElement(By.name("basicAliasName")).sendKeys(nickName);

        // Read customer type from Excel and select it
        String customerType = sheet.getRow(1).getCell(4).getStringCellValue();
        WebElement custTypeDropdown = driver.findElement(By.name("basicCustType"));
        custTypeDropdown.findElement(By.xpath("//option[. = '" + customerType + "']")).click();

        // Read customer category from Excel and select it
        String customerCategory = sheet.getRow(1).getCell(5).getStringCellValue();
        WebElement custCategoryDropdown = driver.findElement(By.name("basicCustCategory"));
        custCategoryDropdown.findElement(By.xpath("//option[. = '" + customerCategory + "']")).click();

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
        Thread.sleep(10000);
    }
}
