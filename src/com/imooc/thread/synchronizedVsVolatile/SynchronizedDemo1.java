package com.imooc.thread.synchronizedVsVolatile;

public class SynchronizedDemo1 {

	// �������
	private boolean ready = false;
	private int result = 0;
	private int number = 1;

	// д����
	public synchronized void write() {
		ready = true;// 1
		number = 2;// 2
	}

	// ������
	public synchronized void read() {
		if (ready) {// 3
			result = number * 3;// 4
		}
		System.out.println("result=" + result);
	}

	// �ڲ��߳���
	private class ReadWriteThread extends Thread {
		// ���ݹ��췽�������flag�����������߳�ִ�ж���������д����
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
		// �����߳� ִ��д����
		synDemo.new ReadWriteThread(true).start();
		// �����߳� ִ�ж�����
		synDemo.new ReadWriteThread(false).start();
	}
	// �����������6
}
