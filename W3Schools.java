package week4day1;

import java.time.Duration;

import org.openqa.selenium.Alert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class W3Schools {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		WebElement frame = driver.findElement(By.xpath("//div[@id='iframewrapper']/iframe"));

		driver.switchTo().frame(frame);
		
		WebElement clickme = driver.findElement(By.xpath("//button[text()='Try it']"));
		clickme.click();
		
		Alert alert = driver.switchTo().alert();
		
		String alertMessage = alert.getText();
		System.out.println(alertMessage);
		alert.accept();
		String text = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		System.out.println("Print the text:" +text);
	}

}
