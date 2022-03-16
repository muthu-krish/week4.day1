package week4day1;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Keys;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("oneplus 9 pro ",Keys.ENTER);
		String price = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> newWindow=new LinkedList<String>(windowHandles);
		driver.switchTo().window(newWindow.get(1));
		System.out.println(driver.findElement(By.xpath("(//span[@id='acrCustomerReviewText'])[1]")).getText());
		System.out.println(price);
		driver.findElement(By.xpath("(//img[@class='imgSwatch'])[1]")).click();
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		driver.switchTo().window(newWindow.get(1));
		String cart = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']")).getText();
		System.out.println("cart:"+cart);
		
		if(price.equals(cart)) {
			System.out.println("Price value is Correct");
		}
		else {
			System.out.println("Price Value is incorrect");
		}
	}

}
