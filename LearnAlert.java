package week4day1;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/Alert.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.xpath("//button[text()='Alert Box']")).click();
		
		Alert alert = driver.switchTo().alert();
		String alertMessage = 
				alert.getText();
		System.out.println(alertMessage); alert.accept();
		
		driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
		alert.dismiss();
		
		String text = driver.findElement(By.id("result")).getText();
		System.out.println(text);
		
		
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		alert.sendKeys("Muthu");
		alert.accept();
		
		
		driver.findElement(By.xpath("//button[text()='sweet Alert'])")).click();
		
		driver.findElement(By.xpath("//button[test()='OK']")).click();
		
		
	}

}
