package mypack;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Test1
{
	public static void main(String[] args) throws Exception
	{
		//Register voices library(KevinVoiceDirectory is default library in freeTTS jar)
		System.setProperty("freetts.voices",
				"com.sun.speech.freetts.en.us.cmu_us_kal.KevinVoiceDirectory");
		//Get all voices
		VoiceManager vm=VoiceManager.getInstance();
		Voice[] vs=vm.getVoices();
		//Display each voice details
		for(Voice v:vs)
		{
			System.out.println(v.getName()+":"+v.getDescription());
		}
		System.out.println("executed");
	}
}




