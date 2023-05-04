package mypack;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test6 
{
	public static void main(String[] args) throws Exception
	{
		//Get text from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter some text");
		String x=sc.nextLine();
		x=x.toLowerCase();
		sc.close();
		//Set voices library
		System.setProperty("freetts.voices","de.dfki.lt.freetts.en.us.MbrolaVoiceDirectory");
		System.setProperty("mbrola.base","src\\test\\resources\\mbr301d");
		//Launch site
		WebDriverManager.chromedriver().setup();
		ChromeOptions co=new ChromeOptions();
		//To avoid browser push notification related to microphone and speaker
		co.addArguments("--use-fake-ui-for-media-stream"); 
		ChromeDriver driver=new ChromeDriver(co);
		driver.get("http://www.google.co.in");
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
		Thread.sleep(1000);
		//generate voice
		VoiceManager vm=VoiceManager.getInstance();
		Voice v=vm.getVoice("mbrola_us1"); //lady voice
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
		//driver.close();
	}
}
