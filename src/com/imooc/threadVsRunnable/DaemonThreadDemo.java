package com.imooc.threadVsRunnable;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class DaemonThreadDemo {
//daemon�ػ���  ������
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("�������߳�"+Thread.currentThread().getName());
		DaemonThread daemonThread=new DaemonThread();
		Thread thread=new Thread(daemonThread);
		thread.setDaemon(true);
		thread.start();
		
//		�ڿ���̨����
		Scanner sc=new Scanner(System.in);
		sc.next();
		System.out.println("�˳����߳�"+Thread.currentThread().getName());
	}

}

class DaemonThread implements Runnable{

	@Override
	public void run() {
		System.out.println("�����ػ��߳�"+Thread.currentThread().getName());
		try {
			writeToFile();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("�˳��ػ��߳�"+Thread.currentThread().getName());
	}
	
	private void writeToFile() throws Exception{
		File filename=new File("e:"+File.separator+"daemon.txt");
//		OutputStream os=new FileOutputStream(filename,true);
		OutputStream os=new FileOutputStream(filename);
		int count=0;
		while(count<999){
			os.write(("\r\nword"+count).getBytes());
			System.out.println("�ػ��߳�"+Thread.currentThread().getName()+"���ļ���д����word"+count++);
			Thread.sleep(1000);
		}
	}
	
}