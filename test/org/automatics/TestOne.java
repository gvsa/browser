package org.automatics;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestOne {
	
	@Test
	public void scenario(){
		WebDriver w = new ChromeDriver();
		
		w.get("http://www.amazon.com");
		
		try {
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			System.out.println("error when trying to pause for 5 s!!!");
			e.printStackTrace();
		}
		
		w.close();
	}

}
