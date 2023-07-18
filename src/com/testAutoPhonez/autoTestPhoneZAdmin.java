package com.testAutoPhonez;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By.ByXPath;
import org.testng.annotations.Test;


public class autoTestPhoneZAdmin extends baseSetup{
	@Test (priority = 0)
	public void loginAdmin() throws Exception {
		driver.navigate().to("http://localhost:8080/admin");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys("buithitrong123456@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='password1']")).sendKeys("123456");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='login']")).click();
        WebElement textWelcomElement = driver.findElement(By.xpath("//h1[normalize-space()='WELLCOME BACK, ADMIN']"));
        assertEquals(textWelcomElement.getText(), "WELLCOME BACK, ADMIN");
	}
	
	@Test (priority = 1)
	public void Add_Categories() throws Exception {
		driver.findElement(By.xpath("//a[@href='/admin/categories']")).click();
		WebElement textCategories = driver.findElement(By.xpath("//h1[normalize-space()='CATEGORIES, ADMIN']"));
		assertEquals(textCategories.getText(), "CATEGORIES, ADMIN");
		//chọn thêm loại
		driver.findElement(By.xpath("//a[normalize-space()='Add Category']")).click();
		//nhập loại cần thêm
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("abc");
		//xác nhận thêm
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(2000);
		//quay lại trang admin
		driver.findElement(By.xpath("//a[@href='/admin']")).click();
		//chọn quản lý sản phẩm
		driver.findElement(By.xpath("//a[@href='/admin/products']")).click();
		//chọn thêm sản phẩm
		driver.findElement(By.xpath("//a[@class='btn btn-primary product_page-btn_add_Product']")).click();
		//lấy thể element của thẻ select chọn loại
		WebElement element = driver.findElement(By.xpath("//select[@id='category']"));
		//khai báo đối tượng kiểu select cho 
		Select select = new Select(element);
		select.selectByVisibleText("abc");
		System.out.println("Thêm loại thành công");
	}
	
	@Test (priority = 2)
	public void Add_Product() throws Exception {
		//trở lại trang admin
		driver.findElement(By.xpath("//a[@href='/admin']")).click();
		//chọn quản lý sản phẩm
		driver.findElement(By.xpath("//a[@href='/admin/products']")).click();
		//chọn thêm sản phẩm
		driver.findElement(By.xpath("//a[@class='btn btn-primary product_page-btn_add_Product']")).click();
		//nhập thông tin sản phẩm
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("phone");
		WebElement quanlityElement = driver.findElement(By.xpath("//input[@id='quantity']"));
		quanlityElement.clear();
		quanlityElement.sendKeys("12");
		WebElement pricElement = driver.findElement(By.xpath("//input[@id='price']"));
		pricElement.clear();
		pricElement.sendKeys("1000000");
		driver.findElement(By.xpath("//input[@id='productImage']")).sendKeys("https://hc.com.vn/i/ecommerce/media/ckeditor_3087079.jpg");
		//xác nhận thêm sản phẩm
		driver.findElement(By.xpath("//button[normalize-space()='Submit']")).click();
		Thread.sleep(2000);
	}
	
}
