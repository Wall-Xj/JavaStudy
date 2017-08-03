package com.xj.composite;

import java.util.ArrayList;
import java.util.List;

public interface AbstructFile {
	void killVirus();
}


class TxtFile implements AbstructFile{

	private String name;
	
	public TxtFile(String name) {
		super();
		this.name = name;
	}


	@Override
	public void killVirus() {
		System.out.println("文本文件："+name+"开始杀毒");
		
	}
			
}

class ImageFile implements AbstructFile{

	private String name;
	
	public ImageFile(String name) {
		super();
		this.name = name;
	}


	@Override
	public void killVirus() {
		System.out.println("图片文件："+name+"开始杀毒");
		
	}
			
}

class VedioFile implements AbstructFile{

	private String name;
	
	public VedioFile(String name) {
		super();
		this.name = name;
	}


	@Override
	public void killVirus() {
		System.out.println("视频文件："+name+"开始杀毒");
		
	}
			
}

class Folder implements AbstructFile{

	private String name;
	
	private List<AbstructFile> list=new ArrayList<AbstructFile>();
	
	public Folder(String name) {
		super();
		this.name = name;
	}
	
	public void add(AbstructFile a){
		list.add(a);
	}

	public void remove(AbstructFile a){
		list.remove(a);
	}
	
	public AbstructFile getChild(int index){
		return list.get(index);
	}

	@Override
	public void killVirus() {
		System.out.println("文件夹："+name+"开始杀毒");
		for(AbstructFile file : list){
			file.killVirus();
		}
	}
			
}