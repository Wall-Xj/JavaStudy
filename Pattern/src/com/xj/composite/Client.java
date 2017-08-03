package com.xj.composite;
/**
 * 组合模式
 * @author WanYin
 *
 */
public class Client {
	public static void main(String[] args) {
		Folder f1;
		AbstructFile f2,f3,f4,f5;
		f1=new Folder("我的文件夹");
		f2=new TxtFile("das.txt");
		f3=new ImageFile("asd.jpg");
		
		f1.add(f2);
		f1.add(f3);
		
		Folder f11=new Folder("av");
		f4=new VedioFile("das.avi");
		f5=new VedioFile("ddds.avi");
		f11.add(f4);
		f11.add(f5);
		
		f1.add(f11);
		
		f1.killVirus();
	}
}
