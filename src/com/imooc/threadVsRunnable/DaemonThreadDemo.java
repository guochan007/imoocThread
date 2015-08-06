package com.imooc.threadVsRunnable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class DaemonThreadDemo {
//daemon守护神  读第门
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("进入主线程"+Thread.currentThread().getName());
		DaemonThread daemonThread=new DaemonThread();
		Thread thread=new Thread(daemonThread);
		thread.setDaemon(true);
		thread.start();
		
//		在控制台输入
		Scanner sc=new Scanner(System.in);
		sc.next();
		System.out.println("退出主线程"+Thread.currentThread().getName());
	}

}

class DaemonThread implements Runnable{

	@Override
	public void run() {
		System.out.println("进入守护线程"+Thread.currentThread().getName());
		try {
			writeToFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("退出守护线程"+Thread.currentThread().getName());
	}
	
	private void writeToFile() throws Exception{
		File filename=new File("e:"+File.separator+"daemon.txt");
//		OutputStream os=new FileOutputStream(filename,true);
		OutputStream os=new FileOutputStream(filename);
		int count=0;
		while(count<999){
			os.write(("\r\nword"+count).getBytes());
			System.out.println("守护线程"+Thread.currentThread().getName()+"向文件中写入了word"+count++);
			Thread.sleep(1000);
		}
	}
	
}