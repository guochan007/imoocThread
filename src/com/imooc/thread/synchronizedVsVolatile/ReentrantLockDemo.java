package com.imooc.thread.synchronizedVsVolatile;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

	private Lock lock =new ReentrantLock();
	// 线程可见
	private int number = 0;

	public int getNumber() {
		return this.number;
	}

	public void increase() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		lock.lock();
		try {
			this.number++;// 这句不是原子性，分3步，1先获取number；2number加1；给number赋值
		} finally {
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		final ReentrantLockDemo volDemo = new ReentrantLockDemo();
		for (int i = 0; i < 500; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					volDemo.increase();
				}

			}).start();
		}
		// 如果还有子线程正在运行，主线程就让出cpu资源，
		// 直到所有的子线程都运行完了，主线程再继续往下执行
		while (Thread.activeCount() > 1) {
			Thread.yield();
		}
		System.out.println("number=" + volDemo.getNumber());
	}
	// 结果500
}
