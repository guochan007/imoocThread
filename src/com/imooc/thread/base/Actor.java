package com.imooc.thread.base;

public class Actor extends Thread {
	
	public void run(){
		System.out.println(getName()+"��һ����Ա��");
		int count = 0;
		boolean keepRunning = true;
	
		while(keepRunning){
			System.out.println(getName()+"��̨�ݳ���"+ (++count));
			
			//50�κ����
			if(count == 50){
				keepRunning = false;
			}
//			����������������һ��
//			if(count%10== 0){
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
		}
		System.out.println(getName()+"���ݳ������ˣ�");
	}
	
	
	public static void main(String[] args){
		Thread actor = new Actor();
		actor.setName("Mr. Thread");
		
		actor.start();
		
		Thread actressThread = new Thread(new Actress(),"Ms. Runnable");
		actressThread.start();
	}

}

//����д���class������ֻ����һ��public
class Actress implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"��һ����Ա��");
		int count = 0;
		boolean keepRunning = true;
	
		while(keepRunning){
			System.out.println(Thread.currentThread().getName()+"��̨�ݳ���"+ (++count));
			
			if(count == 50){
				keepRunning = false;
			}
			
//			if(count%10== 0){
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
		}
		System.out.println(Thread.currentThread().getName()+"���ݳ������ˣ�");
		
	}
	
}
