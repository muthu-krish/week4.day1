package week4day1;

import java.time.Duration;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Mergecontact {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(12));
		WebElement username =  driver.findElement(By.xpath("//input[@id='username']"));

		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("demoSalesManager");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("crmsfa");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		 driver.findElement(By.xpath("//a[contains(text(),'CRM')]")).click();
		 driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
		 driver.findElement(By.xpath("//a[contains(text(),'Merge Contacts')]")).click();
		       
		 System.out.println(driver.getTitle());
		 
		 driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();    
		 Set<String> windowHandles = driver.getWindowHandles();
		 List<String> newWindow=new LinkedList<String>(windowHandles);
		 
			driver.switchTo().window(newWindow.get(1));
			driver.findElement(By.xpath("(//a[@class='linktext'])[1]")).click();
			driver.switchTo().window(newWindow.get(0));
		        
			 driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
				Set<String> windowHandles2 = driver.getWindowHandles();
				List<String> newWindow2=new ArrayList<String>(windowHandles2);
				driver.switchTo().window(newWindow2.get(1));
				driver.findElement(By.xpath("(//a[@class='linktext'])[4]")).click();
				driver.switchTo().window(newWindow2.get(0)); 
				
         driver.findElement(By.xpath("//a[text()='Merge']")).click();
         Alert alert=driver.switchTo().alert();
         alert.accept();
         System.out.println(driver.getTitle());

	}

}
