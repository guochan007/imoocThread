package com.imooc.threadVsRunnable;

public class TicketThread {

	public static void main(String[] args) {

		// ����3���̣߳�ģ��3��������Ʊ
		MyThread mt1 = new MyThread("����1");
		MyThread mt2 = new MyThread("����2");
		MyThread mt3 = new MyThread("����3");

		// �����߳�
		mt1.start();
		mt2.start();
		mt3.start();

//		�����һ������15��Ʊ��û�й���ticketCont
	}

}

class MyThread extends Thread {
	// һ��5��Ʊ
	private int ticketCont = 5;
	// ���ڣ����̵߳�����
	private String name;

	public MyThread(String name) {
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