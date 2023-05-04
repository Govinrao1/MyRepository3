package mypack;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test5
{
	public static void main(String[] args) throws Exception
	{
		//Get text from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a line of text");
		String x=sc.nextLine();
		x=x.toLowerCase();
		sc.close();
		//Open browser and change settings to avoid notification related to microphone
		WebDriverManager.chromedriver().setup();
		ChromeOptions co=new ChromeOptions();
		co.addArguments("--use-fake-ui-for-media-stream"); //to avoid microphone notification
		ChromeDriver driver=new ChromeDriver(co);
		//Launch site
		driver.get("http://www.google.co.in"); //SUT
		driver.manage().window().maximize();
		Thread.sleep(5000);
		try
		{
			driver.switchTo().frame(0);
			driver.findElement(By.xpath("//button[text()='No thanks']")).click();
			Thread.sleep(5000);
			driver.switchTo().defaultContent();
		}
		catch(Exception ex)
		{
		}
		//Click on mic icon
		driver.findElement(By.xpath("//*[@aria-label='Search by voice']")).click();
		Thread.sleep(1000); //waiting for listening
		//generate voice
		System.setProperty("freetts.voices",
						"com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		VoiceManager vm=VoiceManager.getInstance();
		Voice v=vm.getVoice("kevin"); //or kevin16
		v.allocate();
		v.speak(x);
		v.deallocate();
		Thread.sleep(5000);
		//Validate title after search
		String y=driver.getTitle();
		y=y.toLowerCase();
		if(y.contains(x))  
		{
			System.out.println("Test passed");
		}
		else
		{
			System.out.println("Test failed bcz google did not understand voice correctly");
		}
		//close site
		driver.close();
	}
}
