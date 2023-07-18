package com.testAutoPhonez;

import static org.testng.Assert.assertEquals;

import java.util.Random;

import javax.swing.JList.DropLocation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class autoTestPhoneZ extends baseSetup {
	
	@Test (priority = 0)
	public void signUp() throws Exception {
		driver.navigate().to("http://localhost:8080/");
		driver.findElement(By.xpath("//div[@class='col-8 navbar-cover__info']//a[1]")).click();
		driver.findElement(By.xpath("//button[@id='signUp']")).click();
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("test");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("auto");
		// Khởi tạo đối tượng Random
        Random random = new Random();

        // Tạo số ngẫu nhiên từ 1 đến 10
        int randomNumber = random.nextInt(10) + 1;
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("autotest"+randomNumber+"@gmail.com");
		driver.findElement(By.xpath("//input[@id='password2']")).sendKeys("123456");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@id='register']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@href='login']")).click();
		WebElement textLoginDriver = driver.findElement(By.xpath("//h1[normalize-space()='Login Account']"));
		assertEquals(textLoginDriver.getText(), "Login Account");
	}
	
	@Test (priority = 1)
	public void login() throws Exception {
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("buithitrong123456@gmail.com");
		driver.findElement(By.xpath("//input[@id='password1']")).sendKeys("123456");
		driver.findElement(By.xpath("//input[@id='login']")).click();
	}
	
	@Test (priority = 2)
	public void orderProduct() {
		driver.findElement(By.xpath("//li[@class='header-tile__item'][normalize-space()='Products']")).click();
		driver.findElement(By.xpath("//body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/div[1]/form[1]/div[1]/button[1]")).click();
		driver.findElement(By.xpath("//a[@href='/cart']")).click();
		//click vào checkout để thanh toán
		driver.findElement(By.xpath("//a[contains(text(),'go to')]")).click();
		//kiểm tra xem đã đến trang thanh toán để điền thông tin chưa
		WebElement billElement = driver.findElement(By.xpath("//h5[normalize-space()='Billing details']"));
		assertEquals(billElement.getText(), "Billing details");
		driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("test");
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("auto");
		driver.findElement(By.xpath("//input[@id='address']")).sendKeys("Go vap");
		driver.findElement(By.xpath("//input[@id='town_city']")).sendKeys("Ho Chi Minh");
		driver.findElement(By.xpath("//input[@id='phoneNumber']")).sendKeys("0123456789");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("testauto@gmail.com");
		driver.findElement(By.xpath("//button[contains(text(),'Pay')]")).click();
		WebElement headerbill = driver.findElement(By.xpath("//h1[normalize-space()='Receipt']"));
		assertEquals(headerbill.getText(), "Receipt");
		System.out.println("Thanh toán thành công");
		
	}
//	@Test (priority = 3)
//	public void logOut() throws Exception {
//		driver.findElement(By.xpath("//div[@class='col-8 navbar-cover__info']//a[1]")).click();
//		Thread.sleep(2000);
//	}
	
	
}
