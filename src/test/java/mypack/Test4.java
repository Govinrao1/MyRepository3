package mypack;

import java.util.Scanner;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Test4
{
	public static void main(String[] args) throws Exception
	{
		//Get text from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter some text");
		String x=sc.nextLine();
		sc.close();
		//Set voices library
		System.setProperty("freetts.voices","de.dfki.lt.freetts.en.us.MbrolaVoiceDirectory");
		System.setProperty("mbrola.base","src\\test\\resources\\mbr301d");
		//generate voice
		VoiceManager vm=VoiceManager.getInstance();
		Voice v=vm.getVoice("mbrola_us1");
		v.allocate();
		v.speak(x);
		v.deallocate();
	}
}
