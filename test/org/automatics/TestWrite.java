package org.automatics;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWrite {
	
	@Test
	public void scenario(){
		WebDriver w = new ChromeDriver();
		
		w.get("http://www.google.com");
		/*
		try {
			System.out.println("attempt - sleep 5s");
			Thread.sleep(5000L);
		} catch (InterruptedException e) {
			System.out.println("error when trying to pause for 5 s!!!");
			e.printStackTrace();
		}
		*/
		File f = new File("chrome.txt");
		FileOutputStream fout;
		try {
			fout = new FileOutputStream(f);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(w);
			System.out.println("object written.");
			oos.close();
			fout.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("end of write. keeping window open");
//		w.close();
	}

}
