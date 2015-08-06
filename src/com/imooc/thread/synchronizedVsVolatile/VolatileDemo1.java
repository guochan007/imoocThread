package com.imooc.thread.synchronizedVsVolatile;

public class VolatileDemo1 {

//	�߳̿ɼ�
	private volatile int number=0;
	
	public int getNumber(){
		return this.number;
	}
	
	public void increase(){
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.number++;//��䲻��ԭ���ԣ���3����1�Ȼ�ȡnumber��2number��1����number��ֵ
	}
	
	public static void main(String[] args) {
		final VolatileDemo1 volDemo=new VolatileDemo1();
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
//	�������ʱ��С��500
}
