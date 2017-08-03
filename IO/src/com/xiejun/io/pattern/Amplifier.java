package com.xiejun.io.pattern;

public class Amplifier {

	private Voice voice;
	public Amplifier() {
		// TODO Auto-generated constructor stub
	}
	public Amplifier(Voice voice) {
		super();
		this.voice = voice;
	}
	public void say(){
		System.out.println(voice.getVoice()*1000);
	}

}
