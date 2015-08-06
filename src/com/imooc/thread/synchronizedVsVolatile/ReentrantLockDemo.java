package com.imooc.thread.synchronizedVsVolatile;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

	private Lock lock =new ReentrantLock();
	// �߳̿ɼ�
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
			this.number++;// ��䲻��ԭ���ԣ���3����1�Ȼ�ȡnumber��2number��1����number��ֵ
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
		// ����������߳��������У����߳̾��ó�cpu��Դ��
		// ֱ�����е����̶߳��������ˣ����߳��ټ�������ִ��
		while (Thread.activeCount() > 1) {
			Thread.yield();
		}
		System.out.println("number=" + volDemo.getNumber());
	}
	// ���500
}
