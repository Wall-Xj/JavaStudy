package com.xiejun.io.others;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectDemo01 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			read("e:/aaa/3.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}
	
	public static void read(String srcPath) throws FileNotFoundException, IOException, ClassNotFoundException{
		File src=new File(srcPath);
		ObjectInputStream ois=new ObjectInputStream(
				new BufferedInputStream(
						new FileInputStream(src)
						)
				);
		Object obj=ois.readObject();
		if(obj instanceof Emloyee){
			Emloyee emp=(Emloyee)obj;
			System.out.println(emp.getName());
			System.out.println(emp.getSalary());
		}
	}
	
	public static void seri(String destPath) throws FileNotFoundException, IOException{
		Emloyee emp=new Emloyee("Èø»ù",10000);
		File dest=new File(destPath);
		ObjectOutputStream oos=new ObjectOutputStream(
				new BufferedOutputStream(
						new FileOutputStream(dest)
						)
				);
		oos.writeObject(emp);
		oos.close();
	}

}
