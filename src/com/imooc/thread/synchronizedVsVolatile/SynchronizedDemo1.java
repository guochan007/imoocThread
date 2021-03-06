package com.imooc.thread.synchronizedVsVolatile;

public class SynchronizedDemo1 {

	// 共享变量
	private boolean ready = false;
	private int result = 0;
	private int number = 1;

	// 写操作
	public synchronized void write() {
		ready = true;// 1
		number = 2;// 2
	}

	// 读操作
	public synchronized void read() {
		if (ready) {// 3
			result = number * 3;// 4
		}
		System.out.println("result=" + result);
	}

	// 内部线程类
	private class ReadWriteThread extends Thread {
		// 根据构造方法传入的flag参数，决定线程执行读操作还是写操作
		private boolean flag;

		public ReadWriteThread(boolean flag) {
			this.flag = flag;
		}

		@Override
		public void run() {
			if (flag) {
				write();
			} else {
				read();
			}
		}
	}

	public static void main(String[] args) {
		SynchronizedDemo1 synDemo = new SynchronizedDemo1();
		// 启动线程 执行写操作
		synDemo.new ReadWriteThread(true).start();
		// 启动线程 执行读操作
		synDemo.new ReadWriteThread(false).start();
	}
	// 结果几乎都是6
}
