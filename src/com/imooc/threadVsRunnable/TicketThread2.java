package com.imooc.threadVsRunnable;

public class TicketThread2 {

	public static void main(String[] args) {

		// ����3���̣߳�ģ��3��������Ʊ
		MyThread1 mt1 = new MyThread1("����1");
		MyThread1 mt2 = new MyThread1("����2");
		MyThread1 mt3 = new MyThread1("����3");

		// �����߳�
		mt1.start();
		mt2.start();
		mt3.start();

//		�����һ������15��Ʊ��û�й���ticketCont
	}

}

class MyThread1 extends Thread {
	// һ��5��Ʊ
	private static int ticketCont = 5;
	// ���ڣ����̵߳�����
	private String name;

	public MyThread1(String name) {
		this.name = name;
	}

	@Override
	public void run() {
		while (ticketCont > 0) {
			// ��Ʊ����1��
			ticketCont--;
			System.out.println(name + "����1�ţ�ʣ��" + ticketCont + "��");
		}
	}

}