package mypack;

import java.util.Scanner;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Test2
{
	public static void main(String[] args) throws Exception
	{
		//Get text from keyboard
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter some text");
		String x=sc.nextLine();
		sc.close();
		//Register voices library
		System.setProperty("freetts.voices",
				"com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		//choose an voice type and generate
		VoiceManager vm=VoiceManager.getInstance();
		Voice v1=vm.getVoice("kevin16");
		v1.allocate();
		v1.speak(x);
		v1.deallocate();
		Voice v2=vm.getVoice("kevin");
		v2.allocate();
		v2.speak(x);
		v2.deallocate();
	}
}


