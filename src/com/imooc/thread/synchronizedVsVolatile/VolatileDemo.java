package com.imooc.thread.synchronizedVsVolatile;

public class VolatileDemo {

//	�߳̿ɼ�
	private volatile int number=0;
	
	public int getNumber(){
		return this.number;
	}
	
	public void increase(){
		this.number++;//��䲻��ԭ���ԣ���3����1�Ȼ�ȡnumber��2number��1����number��ֵ
	}
	
	public static void main(String[] args) {
		final VolatileDemo volDemo=new VolatileDemo();
		for(int i=0;i<500;i++){
			new Thread(new Runnable(){

				@Override
				public void run() {
					volDemo.increase();
				}
				
			}).start();
		}
//		����������߳��������У����߳̾��ó�cpu��Դ��
//		ֱ�����е����̶߳��������ˣ����߳��ټ�������ִ��
		while(Thread.activeCount()>1){
			Thread.yield();
		}
		System.out.println("number="+volDemo.getNumber());
	}
//	�������ʱ����500
}
