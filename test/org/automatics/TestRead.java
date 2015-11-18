package org.automatics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestRead {

	@Test
	public void scenario() {
		WebDriver w = null;

		File f = new File("chrome.txt");
		FileInputStream fin;
		try {
			fin = new FileInputStream(f);
			ObjectInputStream ois = new ObjectInputStream(fin);
			w = (WebDriver) ois.readObject();
			System.out.println("object read.");
			w.get("http://www.yahoo.com");

			try {
				System.out.println("attempt - sleep 5s");
				Thread.sleep(5000L);
			} catch (InterruptedException e) {
				System.out.println("error when trying to pause for 5 s!!!");
				e.printStackTrace();
			}

			ois.close();
			fin.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// w.close();
	}

}
