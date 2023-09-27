package files;

import java.io.FileInputStream;


import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;


public class login {

	
	@Test(priority = 1)
	public void Register() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo");
		driver.findElement(By.linkText("My Account")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Register")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("firstname")).sendKeys("Ranjith");
		Thread.sleep(3000);
		driver.findElement(By.name("lastname")).sendKeys("Kumar");
		Thread.sleep(3000);
		driver.findElement(By.name("email")).sendKeys("jogakin395@ipniel.com");
		Thread.sleep(3000);
		driver.findElement(By.name("telephone")).sendKeys("7428730894");
		Thread.sleep(3000);
		driver.findElement(By.name("password")).sendKeys("Pass1234");
		Thread.sleep(3000);
		driver.findElement(By.name("confirm")).sendKeys("Pass1234");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/fieldset[3]/div/div/label[1]/input")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/div/input[2]")).click();
		
		WebElement WarningCheck = driver.findElement(By.xpath("//*[@id=\"account-register\"]/div[1]"));
		
		if(WarningCheck.isDisplayed()) {
			System.out.println("You are already registered");
		}else {
			System.out.println("Registration Sucess");
		}
		Thread.sleep(5000);
		
	}
	
	@Test(priority = 2)
	public void CheckValidlogin() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.linkText("My Account")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Login")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("email")).sendKeys("jogakin395@ipniel.com");
		Thread.sleep(3000);
		driver.findElement(By.name("password")).sendKeys("Pass1234");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		Thread.sleep(3000);
	
	}
	
	
	@Test(priority = 3)
	public void checkInvalidlogin() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.linkText("My Account")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Login")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("email")).sendKeys("jogakin395@ipniel.com");
		Thread.sleep(3000);
		driver.findElement(By.name("password")).sendKeys("Pass123456");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();
		Thread.sleep(5000);
		WebElement checkWarning = driver.findElement(By.xpath("//*[@id=\"account-login\"]/div[1]"));
		
		if(checkWarning.isDisplayed()) {
			System.out.println("Check the Email or Password");
		}else {
			System.out.println("Login Successful");
		}
	
	}
	
	@Test(priority = 4)
	public void checkingSearchButton() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		Thread.sleep(3000);
		driver.findElement(By.name("search")).sendKeys("laptop");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"search\"]/span/button")).click();
		
	}
	
	@Test(priority = 5)
	public void checkSelectCateogory() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.name("search")).sendKeys("laptop");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"search\"]/span")).click();
		Thread.sleep(3000);
		Select drpCateogory = new Select(driver.findElement(By.name("category_id")));
		Thread.sleep(3000);
		drpCateogory.selectByValue("18");

	}
	

	@Test(priority = 6)
	public void checkMultiLogin() throws IOException, InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.saucedemo.com/");
		FileInputStream fis = new FileInputStream("C:\\Users\\RANJITH KUMAR\\eclipse-workspace\\project\\ExcelData\\Project.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int rowcount = sheet.getLastRowNum();
		int colcount = sheet.getRow(1).getLastCellNum();
		System.out.println("rowcount : "+rowcount+" colcount :"+colcount);
		for(int i=1; i<=rowcount; i++) {
			XSSFRow celldata = sheet.getRow(i);
			String user = celldata.getCell(0).getStringCellValue();
			String pass = celldata.getCell(1).getStringCellValue();
			
			driver.findElement(By.xpath("//*[@id=\"user-name\"]")).clear(); 
			driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys(user); 
			driver.findElement(By.xpath("//*[@id=\"password\"]")).clear();
			driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(pass);
			System.out.println(i+"."+user+" | "+pass);
			Thread.sleep(5000);
			driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
			Thread.sleep(5000);
			driver.navigate().back();
			Thread.sleep(5000);
		}
	
		}
	
	@Test(priority = 7)
	public void checkViewPort() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Phones & PDAs")).click();
		Thread.sleep(10000);
		WebElement list = driver.findElement(By.id("list-view"));
		WebElement Grid = driver.findElement(By.id("grid-view"));
		if(Grid.isDisplayed()){
			Thread.sleep(3000);
			list.click();
			System.out.println("list clicked");
		}else {
			Thread.sleep(3000);
			Grid.click();
			System.out.println("Grid clicked");
		}
	
	}
	
	@Test(priority = 8)
	public void checkProductDetails() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Phones & PDAs")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("HTC Touch HD")).click();
	
	}
	
	@Test(priority = 9)
	public void checkPlaceOrder() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Phones & PDAs")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("iPhone")).click();
		Thread.sleep(3000);
		driver.findElement(By.name("quantity")).clear();
		driver.findElement(By.name("quantity")).sendKeys("3");
		Thread.sleep(3000);
		driver.findElement(By.id("button-cart")).click();
		
	}
	
	@Test(priority = 10)
	public void removeOrder() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Phones & PDAs")).click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(3000);
		driver.findElement(By.linkText("iPhone")).click();
		Thread.sleep(3000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,250)", "");
		Thread.sleep(3000);
		driver.findElement(By.name("quantity")).clear();
		driver.findElement(By.name("quantity")).sendKeys("3");
		Thread.sleep(3000);
		driver.findElement(By.id("button-cart")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[4]/a/span")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr/td[4]/div/span/button[2]")).click();
		
		}
}
