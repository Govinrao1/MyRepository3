package mypack;

import com.sun.speech.freetts.Voice;
import com.sun.speech.freetts.VoiceManager;

public class Test3
{
	public static void main(String[] args) throws Exception
	{
		//Set voices library(mbrola is external voice library, need to get separately)
		System.setProperty("freetts.voices","de.dfki.lt.freetts.en.us.MbrolaVoiceDirectory");
		System.setProperty("mbrola.base","src\\test\\resources\\mbr301d");
		//Get all voices
		VoiceManager vm=VoiceManager.getInstance();
		Voice[] vs=vm.getVoices();
		//get details of each voice
		for(Voice v:vs)
		{
			System.out.println(v.getName()+":"+v.getDescription());
		}
	}
}
