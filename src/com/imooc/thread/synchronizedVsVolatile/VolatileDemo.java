package com.imooc.thread.synchronizedVsVolatile;

public class VolatileDemo {

//	线程可见
	private volatile int number=0;
	
	public int getNumber(){
		return this.number;
	}
	
	public void increase(){
		this.number++;//这句不是原子性，分3步，1先获取number；2number加1；给number赋值
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
//		如果还有子线程正在运行，主线程就让出cpu资源，
//		直到所有的子线程都运行完了，主线程再继续往下执行
		while(Thread.activeCount()>1){
			Thread.yield();
		}
		System.out.println("number="+volDemo.getNumber());
	}
//	结果多少时候是500
}
